package com.ml.register.entities;

import com.ml.register.constants.StatusOrder;
import com.ml.register.constants.TypeOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORDER_REGISTER")
public class OrderRegister implements Serializable {

	private static final long serialVersionUID = 7936511196282917233L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "ID_ORDER_REGISTER_SEQ")
	private Long id;

	@Column(name = "TYPE_ORDER")
	private TypeOrder typeOrder;

	@Column(name = "PRICE")
	private BigDecimal price;

	@Column(name = "QUANTITY")
	private Long quantity;

	@Column(name = "STATUS_ORDER")
	private StatusOrder statusOrder;

	@Column(name = "WALLET_ID")
	private Long walletID;

	@Column(name = "DATE_REGISTER")
	private LocalDateTime dateRegister;

	@PrePersist
	public void prePersist() {
		dateRegister = LocalDateTime.now();
	}

}
