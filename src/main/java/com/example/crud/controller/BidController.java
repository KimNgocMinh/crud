package com.example.crud.controller;

import com.example.crud.dto.BidDTO;
import com.example.crud.model.Bid;
import com.example.crud.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bid")
public class BidController {

    private final BidService bidService;

    @Autowired
    public BidController(BidService bidService) {
        this.bidService = bidService;
    }
//    void undoBid();
//    void contactSeller();
//    void watchList();
//    void getNoti();
//    void changeCurrency();
//    boolean rateUser();

    @PostMapping()
    public HttpEntity<BidDTO> bidProduct(@RequestBody Bid bid) {
        System.out.println("here");
        return bidService.bid(bid);
    }
}
