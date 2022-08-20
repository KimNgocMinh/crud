package com.example.crud.dto;

import com.example.crud.model.Bid;

import java.time.LocalDateTime;

public class BidDTO {
    private double price;
    private LocalDateTime actionTime;
    private LocalDateTime scheduleTime;
    private String message;
    private String buyer;
    private String productName;
    public BidDTO(Bid bid) {
        this.price = bid.getBidPrice();
        this.actionTime = bid.getActionTime();
        this.scheduleTime = bid.getScheduleTime();
        this.buyer = bid.getUser().getFirstName();
        this.productName = bid.getProduct().getName();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
