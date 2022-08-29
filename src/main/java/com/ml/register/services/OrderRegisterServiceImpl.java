package com.ml.register.services;

import com.ml.register.Utils;
import com.ml.register.dtos.OrderRegisterDTO;
import com.ml.register.entities.OrderRegister;
import com.ml.register.repositories.OrderRegisterRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderRegisterServiceImpl implements OrderRegisterService {

	@Autowired
	private OrderRegisterRepository orderRegisterRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public void createOrderRegister(OrderRegisterDTO orderRegisterDTO) {
        log.info("OrderRegisterServiceImpl.createOrderRegister - Input - orderRegister.Type:{} ", orderRegisterDTO.getTypeOrder());

		OrderRegister orderRegister = modelMapper.map(orderRegisterDTO, OrderRegister.class);
        orderRegisterRepository.save(orderRegister);

        log.debug("OrderRegisterServiceImpl.createOrderRegister - End");
	}

	@Override
	public Page<OrderRegisterDTO> listAll(Pageable pageable) {
		log.info("OrderRegisterServiceImpl.listAll - Input - pageSize: {} ", pageable.getPageSize());

		Page<OrderRegister> entities = orderRegisterRepository.findAll(pageable);
		Page<OrderRegisterDTO> orderRegisterDTOS = Utils.mapEntityPageIntoDtoPage(entities, OrderRegisterDTO.class);

		log.debug("OrderRegisterServiceImpl.listAll - End - listSize: {} ", orderRegisterDTOS.getContent().size());
		return orderRegisterDTOS;
	}
}
