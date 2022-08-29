package com.ml.register.repositories;

import com.ml.register.entities.OrderRegister;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRegisterRepository extends JpaRepository<OrderRegister, Long> {

}
