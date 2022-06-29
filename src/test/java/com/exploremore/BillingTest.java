package com.exploremore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.exploremore.dao.BillingDao;
import com.exploremore.entity.BillingEntity;
import com.exploremore.exceptions.GlobalException;
import com.exploremore.pojo.BillingPojo;
import com.exploremore.service.BillingServiceImpl;


@ExtendWith(MockitoExtension.class)
public class BillingTest {
	
	@Mock
	BillingDao billingDao;
	

	@InjectMocks
	BillingServiceImpl billingService;
	
	private BillingEntity dummyBillingEntity;
	
	@BeforeEach
    public void setup(){
        
        dummyBillingEntity = new BillingEntity(1, "Darnborough way", "Toronto", "Ontario", 503111, 2);
        
    }
	
	@DisplayName("JUnit test for save addBilling method")
    @Test
    public void testAddBilling() throws GlobalException{
       when(billingDao.saveAndFlush(any(BillingEntity.class))).thenReturn(dummyBillingEntity);
		

       BillingPojo sendBillingPojo = new BillingPojo(1, "Darnborough way", "Toronto", "Ontario", 503111, 2);
       BillingPojo actualBillingPojo = billingService.addBillingAddress(sendBillingPojo);

       assertEquals(1, actualBillingPojo.getId());
    }

}
