package Spring_IOC_XML;

import Spring_IOC_XML.spring.ClassPathXmlApplicationContext;
import Spring_IOC_XML.spring.entity.User;
import org.dom4j.DocumentException;


/**
 * @author shkstart
 * @create 2020-05-11 19:54
 */
public class Test002 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, DocumentException, IllegalAccessException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = (User) applicationContext.getBean("user");
        System.out.println(user);
    }
}
