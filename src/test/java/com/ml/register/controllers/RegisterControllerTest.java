package com.ml.register.controllers;

import com.ml.register.dtos.OrderRegisterDTO;
import com.ml.register.services.OrderRegisterService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class RegisterControllerTest {

	private final Page<OrderRegisterDTO> LIST_ORDERS_REGISTER = builderOrderRegisterList();

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webAppContext;

	@MockBean
	private OrderRegisterService orderRegisterService;

	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		mockMvc = webAppContextSetup(webAppContext).build();
	}

	@Test
	public void listAllWithSuccess() throws Exception {
		when(orderRegisterService.listAll(any()))
				.thenReturn(LIST_ORDERS_REGISTER);

		mockMvc.perform(get("/v1/orders/list")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.content.[0].id").value(LIST_ORDERS_REGISTER.getContent().get(0).getId()))
				.andExpect(status().isOk());
	}

	@Test
	public void listAllWithSuccessWithoutContent() throws Exception {
		when(orderRegisterService.listAll(any()))
				.thenReturn(new PageImpl<>(Collections.emptyList()));

		mockMvc.perform(get("/v1/orders/list")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.totalElements").value(0))
				.andExpect(status().isOk());
	}

	private Page<OrderRegisterDTO> builderOrderRegisterList() {
		return new PageImpl<>(Collections.singletonList(
				OrderRegisterDTO.builder()
						.walletID(1L)
						.build()
		));
	}

}
