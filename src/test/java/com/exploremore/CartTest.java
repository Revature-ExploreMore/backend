package com.exploremore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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

import com.exploremore.dao.CartCourseDao;
import com.exploremore.dao.CartDao;
import com.exploremore.entity.CartCourseEntity;
import com.exploremore.entity.CartEntity;
import com.exploremore.entity.CategoryEntity;
import com.exploremore.entity.CourseEntity;
import com.exploremore.exceptions.GlobalException;
import com.exploremore.pojo.CartCoursePojo;
import com.exploremore.pojo.CartPojo;
import com.exploremore.service.CartServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CartTest {
	
	@Mock
	private CartDao cartDaoMock;
	
	@Mock
	private CartCourseDao cartCourseDaoMock;
	
	@InjectMocks
	private CartServiceImpl cartService;
	
	private CartPojo expectedCartPojo;
	private CartEntity dummyCartEntity;
	private CourseEntity dummyCourseEntity;
	private CategoryEntity dummyCategoryEntity;

	@BeforeEach
	public void setup() {
		expectedCartPojo = new CartPojo(1, LocalDateTime.parse("2022-06-25T22:37:24.894"), LocalDateTime.parse("2022-06-26T22:37:24.894"), false, BigDecimal.valueOf(100.00), 1, 1);
		dummyCartEntity = new CartEntity(1, LocalDateTime.parse("2022-06-25T22:37:24.894"), LocalDateTime.parse("2022-06-26T22:37:24.894"), false, BigDecimal.valueOf(100.00), 1, 1);
		dummyCategoryEntity = new CategoryEntity(1, "Math");
		dummyCourseEntity= new CourseEntity(1, "Math", "Math rules", 10.00, "https://images.unsplash.com/photo-1632571401005-458e9d244591?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1171&q=80", dummyCategoryEntity);
	}
	
	@DisplayName("JUnit test for getCart method")
	@Test
	public void testGetCart() throws GlobalException {
		
		Optional<CartEntity> dummyCartEntity = Optional
				.of(new CartEntity(1, LocalDateTime.parse("2022-06-25T22:37:24.894"), LocalDateTime.parse("2022-06-26T22:37:24.894"), false, BigDecimal.valueOf(100.00), 1, 1));
		
		
		
		when(cartDaoMock.findByUserId(1)).thenReturn(dummyCartEntity);
		
		CartPojo expectedCartPojo = new CartPojo(1,LocalDateTime.parse("2022-06-25T22:37:24.894"), LocalDateTime.parse("2022-06-26T22:37:24.894"), false, BigDecimal.valueOf(100.00), 1, 1);
		CartPojo actualCartPojo = null;
		
		try {
		actualCartPojo = cartService.getCart(1);
		} catch(GlobalException e){
			e.printStackTrace();
		}
		assertEquals(expectedCartPojo, actualCartPojo);
	}
	
	@DisplayName("JUnit test for deleteCartCourse method")
    @Test
    public void testDeleteCartCourse() throws GlobalException{
		doNothing().when(cartCourseDaoMock).deleteById(1);
    	cartService.deleteCartCourse(1);
    	verify(cartCourseDaoMock, times(1)).deleteById(1);
	}
	
    @DisplayName("JUnit test for getCartCourses method")
    @Test
    public void testGetCartCourses() throws GlobalException{
        CartCourseEntity dummyCartCourseEntity = new CartCourseEntity(0, dummyCourseEntity, dummyCartEntity);
    	when(cartCourseDaoMock.findByCartId(1)).thenReturn(List.of(dummyCartCourseEntity, dummyCartCourseEntity));
   
        List<CartCoursePojo> actualCartCoursePojo = cartService.getCartCourses(1);

        assertNotNull(actualCartCoursePojo);
        assertEquals(2, actualCartCoursePojo.size());
    }
}
