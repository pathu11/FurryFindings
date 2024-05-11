package com.furryfindings.backend.service;

import com.furryfindings.backend.dto.BuyerDto;
import com.furryfindings.backend.dto.SellerDto;

import java.util.List;

public interface SellerService {
    SellerDto createSeller(SellerDto sellerDto);

    SellerDto getSellerById(Long sellerId);

    List<SellerDto> getAllSellers();

    SellerDto updateSeller(Long sellerId, SellerDto updatedSeller);

    void deleteSeller(Long sellerId);
}
