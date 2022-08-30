package com.ml.register.services.rabbit;

import com.ml.register.constants.TypeOrder;
import com.ml.register.dtos.OrderDTO;
import com.ml.register.dtos.OrderRegisterDTO;
import com.ml.register.services.OrderRegisterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class RabbitMqReceiverTest {

	private static final Long ID = 1L;
	private static final BigDecimal PRICE = BigDecimal.TEN;
	private static final Long QUANTITY = 100L;
	private final OrderDTO ORDER_MOCK = builderOrderDTO();
	private final OrderRegisterDTO ORDER_REGISTER_MOCK = builderOrderRegisterDTO();

	@InjectMocks
	private RabbitMqReceiver rabbitMqReceiver;

	@Mock
	private OrderRegisterService orderRegisterService;

	@Test
	public void receivedMessageWithSuccess() {
		rabbitMqReceiver.receivedMessage(ORDER_MOCK);

		verify(orderRegisterService).createOrderRegister(ORDER_REGISTER_MOCK);
	}

	private OrderRegisterDTO builderOrderRegisterDTO() {
		return OrderRegisterDTO.builder()
				.walletID(ID)
				.price(PRICE)
				.quantity(QUANTITY)
				.typeOrder(TypeOrder.BUY)
				.build();
	}

	private OrderDTO builderOrderDTO() {
		return OrderDTO.builder()
				.walletID(ID)
				.price(PRICE)
				.quantity(QUANTITY)
				.typeOrder(TypeOrder.BUY)
				.build();
	}

}
