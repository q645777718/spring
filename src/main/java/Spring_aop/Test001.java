package Spring_aop;

import Spring_aop.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test001 {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
		userService.add();
	}

}
