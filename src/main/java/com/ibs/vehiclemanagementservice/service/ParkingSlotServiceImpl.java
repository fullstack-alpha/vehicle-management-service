package com.ibs.vehiclemanagementservice.service;

import com.ibs.vehiclemanagementservice.model.ConfirmBooking;
import com.ibs.vehiclemanagementservice.model.ParkingSlots;
import com.ibs.vehiclemanagementservice.model.ParkingZone;
import com.ibs.vehiclemanagementservice.repository.ParkingSlotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ParkingSlotServiceImpl implements ParkingSlotService {

    @Autowired
    private ParkingSlotRepo parkingSlotRepo;

    @Override
    public Iterable<ParkingZone> getAllSlots() {
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
            if(confirmBooking.getSlotID() == slot.getSlotID())
                slot.setBooked(true);
        });
        return parkingSlotRepo.save(existingParkingZone);
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
