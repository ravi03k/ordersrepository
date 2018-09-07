package com.ravi.SpringBootOrderServiceApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ravi.SpringBootOrderServiceApplication.model.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

}
