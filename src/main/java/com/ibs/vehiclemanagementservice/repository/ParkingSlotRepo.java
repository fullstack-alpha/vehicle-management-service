package com.ibs.vehiclemanagementservice.repository;

import com.ibs.vehiclemanagementservice.model.ParkingZone;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParkingSlotRepo extends CrudRepository<ParkingZone, String> {
    Optional<ParkingZone> findByZoneID(String zoneId);
}
