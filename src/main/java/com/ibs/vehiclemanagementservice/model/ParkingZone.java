package com.ibs.vehiclemanagementservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class ParkingZone {

    @Id
    private String zoneID;
    private String zoneName;
    private List<ParkingSlots> parkingSlots;

    public String getZoneID() {
        return zoneID;
    }

    public void setZoneID(String zoneID) {
        this.zoneID = zoneID;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public List<ParkingSlots> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlots> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public ParkingZone() {
    }

    public ParkingZone(String zoneID, String zoneName, List<ParkingSlots> parkingSlots) {
        this.zoneID = zoneID;
        this.zoneName = zoneName;
        this.parkingSlots = parkingSlots;
    }
}
