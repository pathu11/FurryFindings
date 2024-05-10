package com.furryfindings.backend.controller;

import com.furryfindings.backend.dto.BuyerDto;
import com.furryfindings.backend.service.BuyerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/buyers")
public class BuyerController {

    private BuyerService buyerService;

    @PostMapping
    public ResponseEntity<BuyerDto> createBuyer(@RequestBody BuyerDto buyerDto) {
        BuyerDto savedBuyer = buyerService.createBuyer(buyerDto);
        return new ResponseEntity<>(savedBuyer, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<BuyerDto> getBuyerById(@PathVariable("id") long buyerId) {
        BuyerDto buyerDto = buyerService.getBuyerById(buyerId);
        return ResponseEntity.ok(buyerDto);
    }

    @GetMapping
    public ResponseEntity<List<BuyerDto>> getAllBuyers() {
        List<BuyerDto> buyers = buyerService.getAllBuyers();
        return ResponseEntity.ok(buyers);
    }

    @PutMapping("{id}")
    public ResponseEntity<BuyerDto> updateBuyer(@PathVariable("id") Long buyerId,
                                                      @RequestBody BuyerDto updatedBuyer) {
        BuyerDto buyerDto = buyerService.updateBuyer(buyerId, updatedBuyer);
        return ResponseEntity.ok(buyerDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBuyer(@PathVariable("id") Long buyerId) {
        buyerService.deleteBuyer(buyerId);
        return ResponseEntity.ok("Buyer deleted successfully");
    }
}
