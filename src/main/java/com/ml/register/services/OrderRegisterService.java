package com.ml.register.services;

import com.ml.register.dtos.OrderRegisterDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderRegisterService {

	void createOrderRegister(OrderRegisterDTO orderRegisterDTO);

	Page<OrderRegisterDTO> listAll(Pageable pageable);

}
