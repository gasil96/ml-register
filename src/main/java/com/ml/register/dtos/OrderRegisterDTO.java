package com.ml.register.dtos;

import com.ml.register.constants.StatusOrder;
import com.ml.register.constants.TypeOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRegisterDTO implements Serializable {

	private static final long serialVersionUID = -6330686695441407990L;

	private Long id;
	private TypeOrder typeOrder;
	private BigDecimal price;
	private Long quantity;
	private StatusOrder statusOrder;
	private Long walletID;
	private LocalDateTime dateRegister;

}
