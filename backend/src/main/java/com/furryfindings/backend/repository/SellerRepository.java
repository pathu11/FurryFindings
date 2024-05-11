package com.furryfindings.backend.repository;

import com.furryfindings.backend.entity.Buyer;
import com.furryfindings.backend.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
