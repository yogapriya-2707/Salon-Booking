package com.priya.model;

import lombok.Data;

@Data
public class SalonReport {
    private Long SalonId;
    private String salonName;
    private int totalEarnings;
    private Integer totalBookings;
    private Integer cancelledBookings;
    private Double totalRefund;

}
