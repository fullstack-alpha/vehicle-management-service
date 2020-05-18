package com.ibs.vehiclemanagementservice.model;

public class ConfirmBooking {
    private String zoneID;
    private Integer slotID;

    public String getZoneID() {
        return zoneID;
    }

    public void setZoneID(String zoneID) {
        this.zoneID = zoneID;
    }

    public Integer getSlotID() {
        return slotID;
    }

    public void setSlotID(Integer slotID) {
        this.slotID = slotID;
    }
}
