package Spring_IOC_annotation.service.impl;

import Spring_IOC_annotation.annotation.ExtResource;
import Spring_IOC_annotation.annotation.ExtService;
import Spring_IOC_annotation.service.OrderService;
import Spring_IOC_annotation.service.UserService;


//将该类注入到spring容器里面
@ExtService
public class UserServiceImpl implements UserService {
	// 从Spring容器中读取bean
	@ExtResource
	private OrderService orderServiceImpl;

	public void add() {
		orderServiceImpl.addOrder();
		System.out.println("我是使用反射机制运行的方法");
	}

}
