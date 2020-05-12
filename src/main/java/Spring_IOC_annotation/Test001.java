package Spring_IOC_annotation;



import Spring_IOC_annotation.service.UserService;
import Spring_IOC_annotation.spring.ClassPathXmlApplicationContext;


public class Test001 {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("Spring_IOC_annotation.service.impl");
		UserService userService = (UserService) app.getBean("userServiceImpl");
		userService.add();
	}

}
