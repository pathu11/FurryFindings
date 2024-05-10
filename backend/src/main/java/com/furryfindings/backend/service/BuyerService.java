package com.furryfindings.backend.service;

import com.furryfindings.backend.dto.BuyerDto;

import java.util.List;

public interface BuyerService {

    BuyerDto createBuyer(BuyerDto buyerDto);

    BuyerDto getBuyerById(Long buyerId);

    List<BuyerDto> getAllBuyers();

    BuyerDto updateBuyer(Long buyerId, BuyerDto updatedBuyer);

    void deleteBuyer(Long buyerId);
}
