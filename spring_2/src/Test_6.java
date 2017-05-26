import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sxt.model.User;
import com.sxt.service.IUserService;


public class Test_6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ApplicationContext fac=new ClassPathXmlApplicationContext("applicationContext_default.xml");
		
		IUserService userService= (IUserService) fac.getBean("userService");
		userService.getUser(0);
		userService.saveUser(new User());
		
		//ICardService cardService=(ICardService) fac.getBean("cardServiceProxy");
		//cardService.getCard(0);
		
		
	}

}
