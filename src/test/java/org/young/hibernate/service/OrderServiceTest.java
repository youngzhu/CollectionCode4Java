package org.young.hibernate.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.young.db.DB;
import org.young.hibernate.dao.CustomerDAOImpl;
import org.young.hibernate.dao.ICustomerDAO;
import org.young.hibernate.dao.IOrderDAO;
import org.young.hibernate.dao.OrderDAOImpl;
import org.young.hibernate.dao.ProductDAOImpl;
import org.young.hibernate.entity.Customer;
import org.young.hibernate.entity.Order;
import org.young.hibernate.entity.OrderId;
import org.young.hibernate.entity.Product;

public class OrderServiceTest {

	private IOrderService service;
	
	private ICustomerService customerService;
	
	private IProductService productService;
	
	@Before
	public void init() {
		service = new OrderServiceImpl();
		IOrderDAO dao = new OrderDAOImpl();
		
		((OrderServiceImpl)service).setDao(dao);
		
		// 客户
		customerService = new CustomerServiceImpl();
		ICustomerDAO customerDAO = new CustomerDAOImpl();
		
		((CustomerServiceImpl)customerService).setDao(customerDAO);
		
		// 产品
		productService = new ProductServiceImpl();
		((ProductServiceImpl)productService).setDao(new ProductDAOImpl());
	}
	
	@Test
	public void testAdd() {
		Order order = createOrder();
		
		service.add(order);
	}

	/**
	 * 生成订单
	 * 
	 * @return
	 */
	private Order createOrder() {
		Order order = new Order();
		
		OrderId id = new OrderId();
		id.setOrderId(DB.generateUniqueKey(32));
		id.setCustomerId(getRandomCustomerId());
		id.setProductId(getRandomProductId());
		
		order.setId(id);
		order.setOrderDate(new Date());
		order.setRemark("测试-生成订单");
		
		
		return order;
	}

	/**
	 * 随机获取一个产品ID
	 * 
	 * @return
	 */
	private String getRandomProductId() {
		List<Product> list = productService.load();
		
		int randomIndex = new Random().nextInt(list.size());
		
		return list.get(randomIndex).getId();
	}

	/**
	 * 随机获取一个客户ID
	 * 
	 * @return
	 */
	private String getRandomCustomerId() {
		
		List<Customer> cstList = customerService.load();
		
		int randomIndex = new Random().nextInt(cstList.size());
		
		return cstList.get(randomIndex).getId();
	}

}
