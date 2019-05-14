/**
 * 
 */
package com.retail;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.retail.controller.RetailAppController;
import com.retail.repository.ShopRepository;



/**
 * @author Usr
 *
 */

@RunWith(SpringRunner.class)
@WebMvcTest(RetailAppController.class)
public class RetailControllerTest {
	
	
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
    private ShopRepository shopRepository;
	
	
	@Test
	public void findShopByIdTest() throws Exception {
		mockMvc.perform( MockMvcRequestBuilders
				.get("/retail/shop/id/1")
				.accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk());
	}
	
	


}
