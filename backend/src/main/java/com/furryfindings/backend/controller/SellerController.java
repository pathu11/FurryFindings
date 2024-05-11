package com.furryfindings.backend.controller;

import com.furryfindings.backend.dto.SellerDto;
import com.furryfindings.backend.service.SellerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/seller")
public class SellerController {
    private SellerService sellerService;

    @PostMapping
    public ResponseEntity<SellerDto> createSeller(@RequestBody SellerDto sellerDto) {
        SellerDto savedSeller = sellerService.createSeller(sellerDto);
        return new ResponseEntity<SellerDto>(savedSeller, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getSellerById(@PathVariable("id") long sellerId) {
        SellerDto sellerDto = sellerService.getSellerById(sellerId);
        return ResponseEntity.ok(sellerDto);
    }

    @GetMapping
    public ResponseEntity<List<SellerDto>> getAllSellers() {
        List<SellerDto> sellers = sellerService.getAllSellers();
        return ResponseEntity.ok(sellers);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateSeller(@PathVariable("id") Long sellerId,
                                               @RequestBody SellerDto updatedSeller) {
        SellerDto sellerDto = sellerService.updateSeller(sellerId, updatedSeller);
        return ResponseEntity.ok(sellerDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSeller(@PathVariable("id") Long sellerId) {
        sellerService.deleteSeller(sellerId);
        return ResponseEntity.ok("Seller deleted successfully");
    }
}
