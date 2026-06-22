package com.priya.service;

import com.priya.domain.BookingStatus;
import com.priya.dto.BookingRequest;
import com.priya.dto.SalonDTO;
import com.priya.dto.ServiceDTO;
import com.priya.dto.UserDTO;
import com.priya.model.Booking;
import com.priya.model.SalonReport;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface BookingService {

    Booking create(BookingRequest booking,
                   UserDTO user,
                   SalonDTO salon,
                   Set<ServiceDTO> serviceDTOSet) throws Exception;

    List<Booking> getBookingsByCustomerId(Long customerId);
    List<Booking> getBookingsBySalon(Long salonId);
    Booking getBookingById(Long id) throws Exception;
    Booking updateBooking(Long bookingId, BookingStatus status) throws Exception;
    List<Booking> getBookingsByDate(LocalDate date, Long salonId);
    SalonReport getSalonReport(Long salonId);

    Booking createBooking(BookingRequest bookingRequest, UserDTO user, SalonDTO salon, Set<ServiceDTO> serviceDTOSet);

    List<Booking> getBookingsByCustomer(Long customerId);
}
