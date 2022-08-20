package com.example.crud.service.impl;

import com.example.crud.dto.BidDTO;
import com.example.crud.model.Bid;
import com.example.crud.model.Product;
import com.example.crud.model.User;
import com.example.crud.service.BidService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BidServiceImpl implements BidService {

    private final static String AUCTIONING = "auctioning";


    @Override

    public HttpEntity<BidDTO> bid(Bid bid) {
        if (bid.getScheduleTime() == null) {
            return bidImmediately(bid);
        }
        return null;
    }

    private HttpEntity<BidDTO> bidImmediately(Bid bid) {
        Product product = bid.getProduct();
        User user = bid.getUser();
        BidDTO bidDTO = new BidDTO(bid);
        if (product.getFinalPrice() > bid.getBidPrice()) {
            bidDTO.setMessage(BidMessage.LOWER_FAILED.label);
            return sendReponse(bidDTO);
        }

        if (bid.getActionTime().isAfter(product.getEndTime())) {
            bidDTO.setMessage(BidMessage.AUCTION_OVER.label);
            return sendReponse(bidDTO);
        }

        if (user.getTrustPoint() < 5) {
            bidDTO.setMessage(BidMessage.LOWER_TRUSTPOINT.label);
            return sendReponse(bidDTO);
        }
        bidDTO.setMessage(BidMessage.BID_ACCEPTED.label);
        return sendReponse(bidDTO);
    }

    private HttpEntity<BidDTO> sendReponse(BidDTO bidDTO) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<BidDTO> requestEntity =
                new HttpEntity<>(bidDTO, headers);

        return
                requestEntity;
    }

    enum BidMessage {

        LOWER_FAILED("CAN'T BID LOWER"),
        AUCTION_OVER("AUCTION FINISHED"),
        LOWER_TRUSTPOINT("YOU ARE NOT ALLOWED TO BID"),
        BID_ACCEPTED("SUCCESSFULLY!");

        final String label;

        BidMessage(String label) {
            this.label = label;
        }

    }
}
