package com.furryfindings.backend.mapper;

import com.furryfindings.backend.dto.BuyerDto;
import com.furryfindings.backend.dto.SellerDto;
import com.furryfindings.backend.entity.Buyer;
import com.furryfindings.backend.entity.Seller;

public class SellerMapper {
    public static SellerDto mapToSellerDto(Seller seller) {
        return new SellerDto(
                seller.getId(),
                seller.getFirstName(),
                seller.getLastName(),
                seller.getEmail()
        );
    }

    public static Seller mapToSeller(SellerDto sellerDto) {
        return new Seller(
                sellerDto.getId(),
                sellerDto.getFirstName(),
                sellerDto.getLastName(),
                sellerDto.getEmail()
        );
    }
}
