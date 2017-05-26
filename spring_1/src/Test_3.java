import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sxt.model.User;
import com.sxt.service.IUserService;

public class Test_3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// BeanFactory fac=new XmlBeanFactory(new
		// FileSystemResource("src/applicationContext.xml"));

		// 应用上下文
		// ApplicationContext fac=new
		// FileSystemXmlApplicationContext("src/applicationContext.xml");
		ApplicationContext fac = new ClassPathXmlApplicationContext("applicationContext.xml");

		// UserServiceImpl userService=(UserServiceImpl)
		// fac.getBean("userService");
		// 采用接口方式
		IUserService userService = (IUserService) fac.getBean("userService");
		User user = new User();
		user.setUserName("张三");
		userService.saveUser(user);
		user = userService.getUser(1);
		// System.out.println("取="+user.getUserName());

		// 开闭原则 开放：增加功能 ========== 关闭：修改功能
	}

}
