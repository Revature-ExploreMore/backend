package com.exploremore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.exploremore.dao.OrderDao;
import com.exploremore.entity.OrderEntity;
import com.exploremore.exceptions.GlobalException;
import com.exploremore.pojo.OrderPojo;
import com.exploremore.service.OrderServiceImpl;

@ExtendWith(MockitoExtension.class)
public class OrdersTest {

	@Mock
	OrderDao orderDao;
	

	@InjectMocks
	OrderServiceImpl orderService;
	
	private OrderEntity dummyOrderEntity;
	
	LocalDateTime passTime = LocalDateTime.now();
	BigDecimal passValue = BigDecimal.valueOf(400);
	
	@BeforeEach
    public void setup(){
        
		dummyOrderEntity = new OrderEntity(1, passTime, passValue, 2);
        
    }
	
	@DisplayName("JUnit test for save addOrder method")
    @Test
    public void testAddOrder() throws GlobalException{
       when(orderDao.saveAndFlush(any(OrderEntity.class))).thenReturn(dummyOrderEntity);
		

       OrderPojo sendOrderPojo = new OrderPojo(1, passTime, passValue, 2);
       OrderPojo actualOrderPojo = orderService.addOrder(sendOrderPojo);

       assertEquals(1, actualOrderPojo.getId());
    }
	
	
}
