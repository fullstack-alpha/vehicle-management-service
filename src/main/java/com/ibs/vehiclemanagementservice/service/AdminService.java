package com.ibs.vehiclemanagementservice.service;

import com.ibs.vehiclemanagementservice.exception.VehicleDetailsNotFoundException;
import com.ibs.vehiclemanagementservice.model.VehicleDtls;
import javax.mail.MessagingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final UserVehicleDtlsService vehicleDtlsService;
    private final EmailService emailService;

    public AdminService(UserVehicleDtlsService vehicleDtlsService,EmailService emailService) {
        this.vehicleDtlsService = vehicleDtlsService;
        this.emailService=emailService;
    }

    public Page<VehicleDtls> getAllVehicleDtlsWithPagination(Integer page, Integer size) {
        return vehicleDtlsService.getAllVehicleDtlsWithPagination(page,size);
    }


    public void updateAndSendMail(VehicleDtls dtls,int id) {
        final VehicleDtls vehicleDtls = vehicleDtlsService.findVehicleDtlsById(id)
                .orElseThrow(() -> new VehicleDetailsNotFoundException("No vehicle details found with this id"));
        vehicleDtls.setRequestStatus(dtls.getRequestStatus());
        logger.info("Updating MongoDb with {} for id ",dtls,id);
        vehicleDtlsService.updateVehicleDtls(vehicleDtls);
        logger.info("Sending mail to {} ",dtls.getEmployeeId());
        try {
            emailService.sendMessageUsingThymeleafTemplate("ajithtalias@hotmail.com", "test sub");
        }catch (MessagingException e){
            logger.error(e.getMessage());
        }
    }

}
