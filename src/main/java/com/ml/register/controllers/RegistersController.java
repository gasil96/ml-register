package com.ml.register.controllers;

import com.ml.register.dtos.OrderRegisterDTO;
import com.ml.register.services.OrderRegisterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Register List", description = "Access to list all registers")
@Slf4j
@RestController
@RequestMapping
public class RegistersController {

	@Autowired
	private OrderRegisterService orderRegisterService;

	@Operation(summary = "list events by status")
	@GetMapping("/v1/orders/list")
	public ResponseEntity<Page<OrderRegisterDTO>> listAll(Pageable pageable) {
		log.info("RegistersController.listAll - Start ");

		Page<OrderRegisterDTO> orders = orderRegisterService.listAll(pageable);

		log.debug("RegistersController.listAll - End - size: {}}", orders.getContent().size());
		return ResponseEntity.ok().body(orders);
	}

}
