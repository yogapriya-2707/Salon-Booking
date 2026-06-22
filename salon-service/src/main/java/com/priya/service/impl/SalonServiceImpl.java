package com.priya.service.impl;

import com.priya.model.Salon;
import com.priya.payload.dto.SalonDTO;
import com.priya.repository.SalonRepository;
import com.priya.service.SalonService;
import com.priya.service.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalonServiceImpl implements SalonService {

    private final SalonRepository salonRepository;

    @Override
    public Salon createSalon(SalonDTO request, UserDTO user) {

        Salon salon = new Salon();

        salon.setName(request.getName());
        salon.setAddress(request.getAddress());
        salon.setEmail(request.getEmail());
        salon.setCity(request.getCity());
        salon.setImages(request.getImages());
        salon.setOwnerId(user.getId());
        salon.setOpeningTime(request.getOpeningTime());
        salon.setClosingTime(request.getClosingTime());
        salon.setPhoneNumber(request.getPhoneNumber());

        return salonRepository.save(salon);
    }

    @Override
    public Salon updateSalon(SalonDTO salonDTO, UserDTO user, Long salonId) throws Exception {

        Salon existingSalon = salonRepository.findById(salonId)
                .orElseThrow(() -> new Exception("Salon does not exist"));

        if (!existingSalon.getOwnerId().equals(user.getId())) {
            throw new Exception("You don't have permission to update this salon");
        }
        if(existingSalon != null) {
            existingSalon.setName(salonDTO.getName());
            existingSalon.setAddress(salonDTO.getAddress());
            existingSalon.setEmail(salonDTO.getEmail());
            existingSalon.setCity(salonDTO.getCity());
            existingSalon.setImages(salonDTO.getImages());
            existingSalon.setOpeningTime(salonDTO.getOpeningTime());
            existingSalon.setClosingTime(salonDTO.getClosingTime());
            existingSalon.setPhoneNumber(salonDTO.getPhoneNumber());

            return salonRepository.save(existingSalon);
        }
        throw new Exception("Salon does not exist");
    }

    @Override
    public List<Salon> getAllSalons() {
        return salonRepository.findAll();
    }

    @Override
    public Salon getSalonById(Long salonId) throws Exception {

        Salon salon = salonRepository.findById(salonId)
                .orElseThrow(() -> new Exception("Salon does not exist"));

        return salon;
    }

    @Override
    public Salon getSalonByOwnerId(Long ownerId) {
        return salonRepository.findByOwnerId(ownerId);
    }

    @Override
    public List<Salon> searchSalonByCity(String city) {
        return salonRepository.searchSalons(city);
    }
}