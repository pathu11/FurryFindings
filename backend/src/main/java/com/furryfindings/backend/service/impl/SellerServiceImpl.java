package com.furryfindings.backend.service.impl;

import com.furryfindings.backend.dto.SellerDto;
import com.furryfindings.backend.entity.Seller;
import com.furryfindings.backend.exception.ResourceNotFoundException;
import com.furryfindings.backend.mapper.SellerMapper;
import com.furryfindings.backend.repository.SellerRepository;
import com.furryfindings.backend.repository.SellerRepository;
import com.furryfindings.backend.service.SellerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SellerServiceImpl implements SellerService {
    private SellerRepository sellerRepository;
    @Override
    public SellerDto createSeller(SellerDto  sellerDto) {

        Seller  seller = SellerMapper.mapToSeller(sellerDto);
        Seller savedSeller = sellerRepository.save(seller);

        return SellerMapper.mapToSellerDto(savedSeller);
    }

    @Override
    public SellerDto getSellerById(Long  sellerId) {
        Seller  seller =  sellerRepository.findById( sellerId)
                .orElseThrow(() -> new ResourceNotFoundException(" seller does not exist with given id : " +  sellerId));

        return SellerMapper.mapToSellerDto( seller);    }

    @Override
    public List<SellerDto> getAllSellers() {
        List<Seller>  sellers =  sellerRepository.findAll();
        return  sellers.stream().map((seller) ->
                SellerMapper.mapToSellerDto(seller)).collect(Collectors.toList());
    }

    @Override
    public SellerDto updateSeller(Long  sellerId, SellerDto updatedSeller) {
        Seller seller = sellerRepository.findById( sellerId).orElseThrow(
                () -> new ResourceNotFoundException(" seller does not exist with given id " +  sellerId)
        );

        seller.setFirstName(updatedSeller.getFirstName());
        seller.setLastName(updatedSeller.getLastName());
        seller.setEmail(updatedSeller.getEmail());

        Seller updatedSellerObj =  sellerRepository.save( seller);

        return SellerMapper.mapToSellerDto(updatedSellerObj);
    }

    @Override
    public void deleteSeller(Long  sellerId) {
        Seller  seller =  sellerRepository.findById(sellerId).orElseThrow(
                () -> new ResourceNotFoundException(" seller does not exist with given id: " +  sellerId)
        );

        sellerRepository.deleteById(sellerId);
    }
}
