package Spring_IOC_annotation.service.impl;

import Spring_IOC_annotation.annotation.ExtService;
import Spring_IOC_annotation.service.OrderService;


@ExtService
public class OrderServiceImpl implements OrderService {

	@Override
	public void addOrder() {
		System.out.println("addOrder");
	}

}
