package com.priya.controller;

import com.priya.dto.CategoryDTO;
import com.priya.dto.SalonDTO;
import com.priya.dto.ServiceDTO;
import com.priya.model.ServiceOffering;
import com.priya.service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/service-offering/salon-owner")
public class SalonServiceOfferingController {

    private final ServiceOfferingService serviceOfferingService;

    @PostMapping
    public ResponseEntity<ServiceOffering> createService(
            @RequestBody ServiceDTO serviceDTO
    ) {
        SalonDTO salonDTO = new SalonDTO();
        salonDTO.setId(1L);

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(serviceDTO.getCategory());

        ServiceOffering serviceOffering =
                serviceOfferingService.createService(
                        salonDTO,
                        serviceDTO,
                        categoryDTO);

        return ResponseEntity.ok(serviceOffering);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ServiceOffering> updateService(
            @PathVariable Long id,
            @RequestBody ServiceOffering serviceOffering
    ) throws Exception {


        ServiceOffering serviceOfferings = serviceOfferingService
                .updateService(id,serviceOffering);

        return ResponseEntity.ok(serviceOfferings);
    }
}
