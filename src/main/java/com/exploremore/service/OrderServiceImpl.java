package com.exploremore.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exploremore.dao.OrderDao;
import com.exploremore.entity.OrderEntity;
import com.exploremore.exceptions.EmptyOrderList;
import com.exploremore.exceptions.GlobalException;
import com.exploremore.exceptions.OrderNotFoundException;
import com.exploremore.pojo.OrderPojo;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao orderDao;

	final static Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Override
	public OrderPojo addOrder(OrderPojo orderPojo) throws GlobalException {
		OrderEntity orderEntity = new OrderEntity();
		BeanUtils.copyProperties(orderPojo, orderEntity);
		OrderEntity returnedOrderEntity = orderDao.saveAndFlush(orderEntity);
		orderPojo.setId(returnedOrderEntity.getId());
		return orderPojo;
	}

	@Override
	public List<OrderPojo> viewAllOrders() throws GlobalException, EmptyOrderList {
		List<OrderEntity> allOrderEntity = orderDao.findAll();
		List<OrderPojo> allOrderPojo = new ArrayList<OrderPojo>();

		if (allOrderEntity.isEmpty()) {
			throw new EmptyOrderList();
		} else {
			for (OrderEntity fetchedOrderEntity : allOrderEntity) {
				OrderPojo returnedOrderPojo = new OrderPojo(fetchedOrderEntity.getId(),
						fetchedOrderEntity.getOrderTimestamp(), fetchedOrderEntity.getOrderTotal(),
						fetchedOrderEntity.getUserId());

				allOrderPojo.add(returnedOrderPojo);
			}
		}
		return allOrderPojo;
	}

	@Override
	public List<OrderPojo> viewOrderById(int id) throws GlobalException, OrderNotFoundException {
		List<OrderEntity> searchOrderEntity = orderDao.findById(id);
		List<OrderPojo> searchOrderPojo = new ArrayList<OrderPojo>();

		if (searchOrderEntity.isEmpty()) {
			throw new OrderNotFoundException(id);
		} else {
			for (OrderEntity fetchedOrderEntity : searchOrderEntity) {
				OrderPojo returnOrderPojo = new OrderPojo(fetchedOrderEntity.getId(),
						fetchedOrderEntity.getOrderTimestamp(), fetchedOrderEntity.getOrderTotal(),
						fetchedOrderEntity.getUserId());

				searchOrderPojo.add(returnOrderPojo);
			}
		}
		return searchOrderPojo;
	}

}
