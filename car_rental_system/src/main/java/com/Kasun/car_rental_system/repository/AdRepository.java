package com.Kasun.car_rental_system.repository;

import com.Kasun.car_rental_system.entity.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {

  List<Ad> findAllByUserId(Long userId);

  List<Ad> findAllByServiceNameContaining(String name);

}
