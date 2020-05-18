package com.ibs.vehiclemanagementservice.model;

import org.springframework.data.annotation.Id;

public class ParkingSlots {

    private Integer slotID;
    private String slotDisplayName;
    private String slotDisplayIcon;
    private boolean booked;

    public Integer getSlotID() {
        return slotID;
    }

    public void setSlotID(Integer slotID) {
        this.slotID = slotID;
    }

    public String getSlotDisplayName() {
        return slotDisplayName;
    }

    public void setSlotDisplayName(String slotDisplayName) {
        this.slotDisplayName = slotDisplayName;
    }

    public String getSlotDisplayIcon() {
        return slotDisplayIcon;
    }

    public void setSlotDisplayIcon(String slotDisplayIcon) {
        this.slotDisplayIcon = slotDisplayIcon;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public ParkingSlots() {
    }

    public ParkingSlots(Integer slotID, String slotDisplayName, String slotDisplayIcon, boolean booked) {
        this.slotID = slotID;
        this.slotDisplayName = slotDisplayName;
        this.slotDisplayIcon = slotDisplayIcon;
        this.booked = booked;
    }
}
