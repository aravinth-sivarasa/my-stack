package io.demo.product;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class InvoiceControllerV1Test {

	@Autowired
	private MockMvc mockMvc;
	private ObjectMapper objectMapper = new ObjectMapper();
	private final String invoiceURL="/invoices/v1";

	@Test
	@WithMockUser
	@SuppressWarnings("rawtypes")
	void getAllInvoices() throws Exception {
		ResultActions response = this.mockMvc.perform(get(invoiceURL));
		response.andDo(print()).andExpect(status().isOk());
		List list = returnObject(response, List.class);
		assertEquals(2, list.size());
	}


	@Test
	void getAllInvoices_Error() throws Exception {
		ResultActions response = this.mockMvc.perform(get(invoiceURL));
		response.andDo(print()).andExpect(status().is3xxRedirection());
	}

	<T>T returnObject(ResultActions response,Class<T> objectType) throws UnsupportedEncodingException, JsonMappingException, JsonProcessingException{
		String responseString = response.andReturn().getResponse().getContentAsString();
		return objectMapper.readValue(responseString, objectType);
	}
}
