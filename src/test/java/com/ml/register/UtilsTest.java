package com.ml.register;

import com.ml.register.dtos.OrderDTO;
import com.ml.register.dtos.OrderRegisterDTO;
import com.ml.register.entities.OrderRegister;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UtilsTest {

	private final Page<OrderRegisterDTO> LIST_ORDERS_REGISTER = builderOrderRegisterList();

	@Test
	public void mapEntityPageIntoDtoPageWithSuccess() {
		Page<OrderRegister> orders = Utils.mapEntityPageIntoDtoPage(LIST_ORDERS_REGISTER, OrderRegister.class);

		assertEquals(1, orders.getSize());
	}

	private Page<OrderRegisterDTO> builderOrderRegisterList() {
		return new PageImpl<>(Collections.singletonList(
				OrderRegisterDTO.builder()
						.walletID(1L)
						.build()
		));
	}

}
