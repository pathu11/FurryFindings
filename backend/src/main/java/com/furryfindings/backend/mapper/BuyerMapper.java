package com.furryfindings.backend.mapper;

import com.furryfindings.backend.dto.BuyerDto;
import com.furryfindings.backend.entity.Buyer;

public class BuyerMapper {
    public static BuyerDto mapToBuyerDto(Buyer buyer) {
        return new BuyerDto(
                buyer.getId(),
                buyer.getFirstName(),
                buyer.getLastName(),
                buyer.getEmail()
        );
    }

    public static Buyer mapToBuyer(BuyerDto buyerDto) {
        return new Buyer(
                buyerDto.getId(),
                buyerDto.getFirstName(),
                buyerDto.getLastName(),
                buyerDto.getEmail()
        );
    }
}
