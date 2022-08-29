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
public class OrderDTO implements Serializable {

	private static final long serialVersionUID = 186572189214748082L;

	private String id;
	private TypeOrder typeOrder;
	private StatusOrder statusOrder;
	private BigDecimal price;
	private Long quantity;
	private Long walletID;
	private LocalDateTime dateOp;

}
