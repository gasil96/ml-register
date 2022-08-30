package com.ml.register.services;

import com.ml.register.dtos.OrderRegisterDTO;
import com.ml.register.entities.OrderRegister;
import com.ml.register.repositories.OrderRegisterRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class OrderRegisterServiceTest {

	private static final Long ID = 1L;
	private final OrderRegisterDTO ORDER_REGISTER_DTO = builderOrderRegisterDTO();
	private final OrderRegister ORDER_REGISTER = builderOrderRegister();
	private final Page<OrderRegister> LIST_ORDER_REGISTER = builderOrderRegisterList();

	@InjectMocks
	private OrderRegisterServiceImpl orderRegisterService;

	@Mock
	private OrderRegisterRepository orderRegisterRepository;

	@Mock
	private ModelMapper mapper;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void createUserWithSucess() {
		when(mapper.map(ORDER_REGISTER_DTO, OrderRegister.class)).thenReturn(ORDER_REGISTER);

		orderRegisterService.createOrderRegister(ORDER_REGISTER_DTO);

		verify(orderRegisterRepository).save(ORDER_REGISTER);
	}

	@Test
	public void listAllWithSucess() {
		when(orderRegisterRepository.findAll(PageRequest.of(0, 1))).thenReturn(LIST_ORDER_REGISTER);

		Page<OrderRegisterDTO> listOrderRegisterDTO = orderRegisterService.listAll(PageRequest.of(0, 1));

		assertEquals(1, listOrderRegisterDTO.getSize());
	}

	private OrderRegisterDTO builderOrderRegisterDTO() {
		return OrderRegisterDTO.builder()
				.walletID(ID)
				.build();
	}

	private OrderRegister builderOrderRegister() {
		return OrderRegister.builder()
				.walletID(ID)
				.build();
	}

	private Page<OrderRegister> builderOrderRegisterList() {
		return new PageImpl<>(Collections.singletonList(builderOrderRegister()));
	}

}
