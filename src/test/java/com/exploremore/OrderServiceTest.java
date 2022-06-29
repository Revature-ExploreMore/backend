package com.exploremore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.exploremore.dao.OrderDao;
import com.exploremore.entity.OrderEntity;
import com.exploremore.pojo.OrderPojo;
import com.exploremore.service.OrderServiceImpl;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
	
	@Mock
	OrderDao orderDao;
	
	@InjectMocks
	OrderServiceImpl orderService;
	
	private OrderPojo expectedOrderPojo;
	private OrderEntity dummyOrderEntity;
	@Test
	void contextLoads() {
	}
//    @DisplayName("JUnit test for view all orders method")
//    @Test
//    public void testViewAllOrders() {
//    	when(orderDao.findAll()).thenReturn(List.of(dummyOrderEntity, dummyOrderEntity));
//    	
//    	List<OrderPojo> actualAllOrderPojoList = orderService.viewAllOrders();
//    	
//    	assertNotNull(actualAllOrderPojoList);
//    	assertEquals(2, actualAllOrderPojoList.size());
//    }
//    
//    
//    @DisplayName("JUnit test for view order by Id method")
//    @Test
//    public void testViewOrderById(int id) {
//    	when(orderDao.findById(1)).thenReturn(List.of(dummyOrderEntity));
//    	List<OrderPojo> actualOrderPojo = orderService.viewOrderById(1);
//    	assertEquals(expectedOrderPojo, actualOrderPojo);
//    	
//    }
}
