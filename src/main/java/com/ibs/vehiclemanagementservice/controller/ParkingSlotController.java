package com.ibs.vehiclemanagementservice.controller;

import com.ibs.vehiclemanagementservice.model.ConfirmBooking;
import com.ibs.vehiclemanagementservice.model.ParkingZone;
import com.ibs.vehiclemanagementservice.service.ParkingSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParkingSlotController {

    @Autowired
    private ParkingSlotService parkingSlotService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/common/parkingSlots")
    public Iterable<ParkingZone> getAllParkingSlots(){
//        return ResponseEntity.ok(parkingSlotService.getAllSlots());
        return parkingSlotService.getAllSlots();
    }

//    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/admin/parkingSlot")
    public ResponseEntity addNewParkingSlot(@RequestBody ParkingZone parkingZone){
        return ResponseEntity.ok(parkingSlotService.addSlot(parkingZone));
    }

    @PostMapping("/user/confirmBooking")
    public ResponseEntity confirmBooking(@RequestBody ConfirmBooking confirmBooking){
        ParkingZone parkingZone = parkingSlotService.reserve(confirmBooking);
        return ResponseEntity.ok(parkingZone);
    }

    @GetMapping("/user/reserveFeasibility")
    public ResponseEntity reserveFeasibility(){
        return ResponseEntity.ok(parkingSlotService.reserveFeasibility());
    }

    @GetMapping("/admin/flushParkingSlots")
    public ResponseEntity flushParkingSlots(){
        return ResponseEntity.ok(parkingSlotService.flushParkingSlots());
    }
}
