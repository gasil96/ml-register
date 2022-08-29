package com.ml.register.services.rabbit;

import com.ml.register.dtos.OrderDTO;
import com.ml.register.dtos.OrderRegisterDTO;
import com.ml.register.services.OrderRegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitMqReceiver implements RabbitListenerConfigurer {

	@Autowired
	private OrderRegisterService orderRegisterService;

	@Override
	public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {

	}

	@RabbitListener(queues = "${spring.rabbitmq.queue}")
	public void receivedMessage(OrderDTO order) {
		log.debug("RabbitMqReceiver.receivedMessage - Input - order: {}", order);

		orderRegisterService.createOrderRegister(builderOrderRegister(order));

		log.debug("RabbitMqReceiver.receivedMessage - End");
	}

	private OrderRegisterDTO builderOrderRegister(OrderDTO orderDTO) {
		return OrderRegisterDTO.builder()
				.typeOrder(orderDTO.getTypeOrder())
				.price(orderDTO.getPrice())
				.quantity(orderDTO.getQuantity())
				.statusOrder(orderDTO.getStatusOrder())
				.walletID(orderDTO.getWalletID())
				.build();
	}

}
