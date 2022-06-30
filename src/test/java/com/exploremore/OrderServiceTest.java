package com.exploremore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.exploremore.dao.OrderDao;
import com.exploremore.entity.OrderEntity;
import com.exploremore.exceptions.EmptyOrderList;
import com.exploremore.exceptions.GlobalException;
import com.exploremore.exceptions.OrderNotFoundException;
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
	private LocalDateTime orderTimestamp;
	BigDecimal bd1 = new BigDecimal("30.00");


	@BeforeEach
	public void setup() {
		expectedOrderPojo = new OrderPojo(1, orderTimestamp, bd1, 1);
		dummyOrderEntity = new OrderEntity(1, orderTimestamp, bd1, 1);
	}

	@DisplayName("JUnit test for view all orders method")
	@Test
	public void testViewAllOrders() throws GlobalException, EmptyOrderList {
		when(orderDao.findAll()).thenReturn(List.of(dummyOrderEntity, dummyOrderEntity));
		List<OrderPojo> actualAllOrderPojoList = orderService.viewAllOrders();
		assertNotNull(actualAllOrderPojoList);
		assertEquals(2, actualAllOrderPojoList.size());
		assertEquals(expectedOrderPojo.getId(), actualAllOrderPojoList.get(0).getId());
	}

	@DisplayName("JUnit test for view order by Id method")
	@Test
	public void testViewOrderById() throws GlobalException, OrderNotFoundException {
		//Test1 for Id:1
		when(orderDao.findById(1)).thenReturn(List.of(dummyOrderEntity));
		List<OrderPojo> actualOrderPojo = orderService.viewOrderById(1);
		assertNotNull(actualOrderPojo);
		assertEquals(expectedOrderPojo.getId(), actualOrderPojo.get(0).getId());
		
		//Test1 for Id:2
		when(orderDao.findById(2)).thenReturn(List.of(dummyOrderEntity));
		List<OrderPojo> actualOrderPojo1 = orderService.viewOrderById(2);
		assertNotNull(actualOrderPojo1);
		assertEquals(expectedOrderPojo.getId(), actualOrderPojo1.get(0).getId());

	}
}
