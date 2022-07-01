package com.exploremore.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exploremore.dao.CartCourseDao;
import com.exploremore.dao.CartDao;
import com.exploremore.entity.CartCourseEntity;
import com.exploremore.entity.CartEntity;
import com.exploremore.exceptions.GlobalException;
import com.exploremore.pojo.CartCoursePojo;
import com.exploremore.pojo.CartPojo;
import com.exploremore.pojo.CategoryPojo;
import com.exploremore.pojo.CoursePojo;
import com.exploremore.pojo.UserPojo;


@Service
public class CartServiceImpl implements CartService{
	
	final static Logger LOG = LoggerFactory.getLogger(CartServiceImpl.class);
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	CartCourseDao cartCourseDao;
	

	@Override
	public List<CartCoursePojo> getCartCourses(int cart_id) {
		
		List<CartCourseEntity> allCartCourseEntity = cartCourseDao.findByCartId(cart_id);

		List<CartCoursePojo> allCartCoursePojo = new ArrayList<CartCoursePojo>();
		
		for(CartCourseEntity fetchedCartCourseEntity : allCartCourseEntity) {
			CartCoursePojo returnedCartCoursePojo = new CartCoursePojo();
			BeanUtils.copyProperties(fetchedCartCourseEntity, returnedCartCoursePojo);
			
			CartPojo fetchedCartPojo = new CartPojo();
			BeanUtils.copyProperties(fetchedCartCourseEntity.getCart(), fetchedCartPojo);
			
			CoursePojo fetchedCoursePojo = new CoursePojo();
			BeanUtils.copyProperties(fetchedCartCourseEntity.getCourse(), fetchedCoursePojo);
			
			CategoryPojo fetchedCategoryPojo = new CategoryPojo();
			BeanUtils.copyProperties(fetchedCartCourseEntity.getCourse().getCategory(), fetchedCategoryPojo);
			
			returnedCartCoursePojo.setCart(fetchedCartPojo);
			returnedCartCoursePojo.setCourse(fetchedCoursePojo);
			returnedCartCoursePojo.getCourse().setCategoryId(fetchedCategoryPojo);
			allCartCoursePojo.add(returnedCartCoursePojo);
		}
		return allCartCoursePojo;
	}

	@Override
	public CartPojo getCart(int user_id) throws GlobalException {
		
		Optional<CartEntity> cartEntityOpt = cartDao.findByUserId(user_id);
		CartPojo currentCartPojo = null;
		if(cartEntityOpt.isPresent()) {
		
			CartEntity currentCartEntity = cartEntityOpt.get();
			currentCartPojo = new CartPojo();	
			BeanUtils.copyProperties(currentCartEntity, currentCartPojo);
		}else {
			throw new GlobalException("Cart not found for this user");
		}
		return currentCartPojo;
	}

	@Override
	public boolean deleteCartCourse(int cart_course_id) {
		cartCourseDao.deleteById(cart_course_id);
		return true;
	};
	
	@Override
    public int addCourseToCart(CartCoursePojo cartCourse) {
        System.out.println(cartCourse);
        CoursePojo coursePojo = cartCourse.getCourse();
        CartPojo cartPojo = cartCourse.getCart();
        
        return cartCourseDao.saveByCourseIdAndCartId(coursePojo.getId(), cartPojo.getId());
    }


	@Override
	public CartPojo addNewCartToUser(UserPojo user) {
		CartEntity cart = new CartEntity(0, LocalDateTime.now(), LocalDateTime.now(), false, 
				BigDecimal.valueOf(0), user.getId(), 1);
		cart = cartDao.save(cart);
		CartPojo cartPojo = new CartPojo();
		BeanUtils.copyProperties(cart, cartPojo);
		return cartPojo;
	}
	
	@Override
	public boolean emptyCart(int cartId) throws GlobalException {
		cartCourseDao.deleteByCartId(cartId);
		return true;
   }
}


