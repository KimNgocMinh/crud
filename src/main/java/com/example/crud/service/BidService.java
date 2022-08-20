package com.example.crud.service;

import com.example.crud.dto.BidDTO;
import com.example.crud.model.Bid;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;


public interface BidService {

    HttpEntity<BidDTO> bid(Bid bid);

}
