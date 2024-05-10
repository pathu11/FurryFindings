package com.furryfindings.backend.repository;

import com.furryfindings.backend.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {
}
