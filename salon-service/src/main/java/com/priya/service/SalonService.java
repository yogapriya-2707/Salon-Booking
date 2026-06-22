package com.priya.service;

import com.priya.model.Salon;
import com.priya.payload.dto.SalonDTO;

import java.util.List;

public interface SalonService {
    Salon createSalon(SalonDTO salon, UserDTO user);
    Salon updateSalon(SalonDTO salon, UserDTO user, Long salonid) throws Exception;
    List<Salon> getAllSalons();
    Salon getSalonById(Long salonid) throws Exception;
    Salon getSalonByOwnerId(Long ownerid);
    List<Salon> searchSalonByCity(String city);
}
