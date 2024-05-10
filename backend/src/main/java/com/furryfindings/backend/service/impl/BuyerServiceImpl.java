package com.furryfindings.backend.service.impl;

import com.furryfindings.backend.dto.BuyerDto;
import com.furryfindings.backend.entity.Buyer;
import com.furryfindings.backend.exception.ResourceNotFoundException;
import com.furryfindings.backend.mapper.BuyerMapper;
import com.furryfindings.backend.repository.BuyerRepository;
import com.furryfindings.backend.service.BuyerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BuyerServiceImpl implements BuyerService {

    private BuyerRepository buyerRepository;
    @Override
    public BuyerDto createBuyer(BuyerDto buyerDto) {

        Buyer buyer = BuyerMapper.mapToBuyer(buyerDto);
        Buyer savedBuyer = buyerRepository.save(buyer);

        return BuyerMapper.mapToBuyerDto(savedBuyer);
    }

    @Override
    public BuyerDto getBuyerById(Long buyerId) {
        Buyer buyer = buyerRepository.findById(buyerId)
                .orElseThrow(() -> new ResourceNotFoundException("Buyer does not exist with given id : " + buyerId));

        return BuyerMapper.mapToBuyerDto(buyer);    }

    @Override
    public List<BuyerDto> getAllBuyers() {
        List<Buyer> buyers = buyerRepository.findAll();
        return buyers.stream().map((buyer) ->
                BuyerMapper.mapToBuyerDto(buyer)).collect(Collectors.toList());
    }

    @Override
    public BuyerDto updateBuyer(Long buyerId, BuyerDto updatedBuyer) {
        Buyer buyer = buyerRepository.findById(buyerId).orElseThrow(
                () -> new ResourceNotFoundException("Buyer does not exist with given id " + buyerId)
        );

        buyer.setFirstName(updatedBuyer.getFirstName());
        buyer.setLastName(updatedBuyer.getLastName());
        buyer.setEmail(updatedBuyer.getEmail());

        Buyer updatedBuyerObj = buyerRepository.save(buyer);

        return BuyerMapper.mapToBuyerDto(updatedBuyerObj);
    }

    @Override
    public void deleteBuyer(Long buyerId) {
        Buyer buyer = buyerRepository.findById(buyerId).orElseThrow(
                () -> new ResourceNotFoundException("Buyer does not exist with given id: " + buyerId)
        );

        buyerRepository.deleteById(buyerId);
    }
}
