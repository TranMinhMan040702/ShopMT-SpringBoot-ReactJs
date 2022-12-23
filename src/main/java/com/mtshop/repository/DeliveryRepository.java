package com.mtshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mtshop.entity.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long>{

}
