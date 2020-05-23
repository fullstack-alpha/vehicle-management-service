package com.ibs.vehiclemanagementservice.service;

import com.ibs.vehiclemanagementservice.model.ConfirmBooking;
import com.ibs.vehiclemanagementservice.model.EmployeeParkingSlotMap;
import com.ibs.vehiclemanagementservice.model.ParkingZone;

import java.util.List;
import java.util.Optional;

public interface ParkingSlotService {
    List<ParkingZone> getAllSlots();

    ParkingZone addSlot(ParkingZone parkingZone);

    ParkingZone reserve(ConfirmBooking confirmBooking);

    List<EmployeeParkingSlotMap> reserveFeasibility();

    boolean flushParkingSlots();
}
