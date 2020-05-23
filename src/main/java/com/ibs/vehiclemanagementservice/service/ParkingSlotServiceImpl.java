package com.ibs.vehiclemanagementservice.service;

import com.ibs.vehiclemanagementservice.model.ConfirmBooking;
import com.ibs.vehiclemanagementservice.model.EmployeeParkingSlotMap;
import com.ibs.vehiclemanagementservice.model.ParkingSlots;
import com.ibs.vehiclemanagementservice.model.ParkingZone;
import com.ibs.vehiclemanagementservice.repository.EmployeeParkingSlotMapRepo;
import com.ibs.vehiclemanagementservice.repository.ParkingSlotRepo;
import com.ibs.vehiclemanagementservice.security.CommonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class ParkingSlotServiceImpl implements ParkingSlotService {

    @Autowired
    private ParkingSlotRepo parkingSlotRepo;

    @Autowired
    private EmployeeParkingSlotMapRepo employeeParkingSlotMapRepo;

    @Override
    public List<ParkingZone> getAllSlots() {
        return parkingSlotRepo.findAll();
    }

    @Override
    public ParkingZone addSlot(ParkingZone parkingZone) {

        ParkingZone existingParkingZone = parkingSlotRepo.findByZoneID(parkingZone.getZoneID()).orElse(new ParkingZone());

        if (Objects.isNull(existingParkingZone.getParkingSlots())) {
            existingParkingZone.setParkingSlots(parkingZone.getParkingSlots());
            existingParkingZone.setZoneName(parkingZone.getZoneName());
            setSlotNumber(0, existingParkingZone.getParkingSlots());
        }
        else {
            List<ParkingSlots> parkingSlots = parkingZone.getParkingSlots();
            List<ParkingSlots> existingParkingSlots = existingParkingZone.getParkingSlots();
            setSlotNumber(existingParkingSlots.size(), parkingSlots);
            existingParkingSlots.addAll(parkingSlots);
            existingParkingZone.setParkingSlots(existingParkingSlots);
        }

        return parkingSlotRepo.save(existingParkingZone);
    }

    @Override
    public ParkingZone reserve(ConfirmBooking confirmBooking) {

        ParkingZone existingParkingZone = parkingSlotRepo.findByZoneID(confirmBooking.getZoneID()).orElse(new ParkingZone());
        existingParkingZone.getParkingSlots().stream().forEach(slot->{
            if(confirmBooking.getSlotID() == slot.getSlotID()){
                slot.setBooked(true);
                mapParkingSlotToEmployee(existingParkingZone, slot.getSlotID());
            }
        });
        return parkingSlotRepo.save(existingParkingZone);
    }

    @Override
    public List<EmployeeParkingSlotMap> reserveFeasibility() {

        Integer employeeId = CommonRequest.getUserId(SecurityContextHolder.getContext().getAuthentication());

        List<EmployeeParkingSlotMap> employeeParkingSlotMap = employeeParkingSlotMapRepo.findByEmployeeIdAndActive(employeeId, true);

        return employeeParkingSlotMap;
    }

    @Override
    public boolean flushParkingSlots() {

        List<ParkingZone> parkingZones = getAllSlots();
        List<EmployeeParkingSlotMap> employeeParkingSlotMaps = employeeParkingSlotMapRepo.findByActive(true);

        for(ParkingZone parkingZone: parkingZones){
            parkingZone.getParkingSlots().stream().forEach(parkingSlots -> parkingSlots.setBooked(false));
        }

        employeeParkingSlotMaps.stream().forEach(employeeParkingSlotMap -> employeeParkingSlotMap.setActive(false));

        Iterable<ParkingZone> newParkingZone = parkingZones;
        parkingSlotRepo.saveAll(newParkingZone);

        Iterable<EmployeeParkingSlotMap> newEmployeeParkingSlotMaps = employeeParkingSlotMaps;
        employeeParkingSlotMapRepo.saveAll(newEmployeeParkingSlotMaps);

        return true;
    }

    private void mapParkingSlotToEmployee(ParkingZone parkingZone, int slotID){
        EmployeeParkingSlotMap employeeParkingSlotMap = new EmployeeParkingSlotMap();
        employeeParkingSlotMap.setActive(true);
        employeeParkingSlotMap.setEmployeeId(CommonRequest.getUserId(SecurityContextHolder.getContext().getAuthentication()));
        employeeParkingSlotMap.setSlotId(slotID);
        employeeParkingSlotMap.setZoneId(parkingZone.getZoneID());
        employeeParkingSlotMapRepo.save(employeeParkingSlotMap);
    }

    private void setSlotNumber(int offset, List<ParkingSlots> parkingSlots)
    {
        AtomicInteger counter = new AtomicInteger();
        counter.set(offset);
        parkingSlots.stream().forEach(parkingSlot -> {
            parkingSlot.setSlotID(counter.incrementAndGet());
            parkingSlot.setSlotDisplayName("P-".concat(String.valueOf(counter.get())));
            System.out.println();
        });
    }
}
