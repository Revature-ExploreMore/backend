package com.exploremore;

//@ExtendWith(MockitoExtension.class)
//public class CartTest {
//	
//	@Mock
//	private CartDao cartDaoMock;
//	
//	@InjectMocks
//	CartServiceImpl cartService;
//	
//	private CartPojo expectedCartPojo;
//	private CartEntity dummyCartEntity;
//
////	@BeforeEach
////	public void setup() {
////		expectedCartPojo = new CartPojo(1, LocalDateTime.parse("2022-06-25T22:37:24.894"), LocalDateTime.parse("2022-06-26T22:37:24.894"), false, BigDecimal.valueOf(100.00), 1, 1);
////		dummyCartEntity = new CartEntity(1, LocalDateTime.parse("2022-06-25T22:37:24.894"), LocalDateTime.parse("2022-06-26T22:37:24.894"), false, BigDecimal.valueOf(100.00), 1, 1);		
////	}
//	
//	@Test
//	public void getCartTest() {
//		
//		Optional<CartEntity> cartEntity = Optional
//				.of(new CartEntity(1, LocalDateTime.parse("2022-06-25T22:37:24.894"), LocalDateTime.parse("2022-06-26T22:37:24.894"), false, BigDecimal.valueOf(100.00), 1, 1));
//		
//		when(cartDaoMock.findByUserId(1)).thenReturn(cartEntity);
//	}
//}
