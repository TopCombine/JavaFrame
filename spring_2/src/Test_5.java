import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sxt.service.ICardService;
import com.sxt.service.IUserService;


public class Test_5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ApplicationContext fac=new ClassPathXmlApplicationContext("applicationContext_auto.xml");
		
		IUserService userService= (IUserService) fac.getBean("userServiceProxy");
		userService.getUser(0);
		
		ICardService cardService=(ICardService) fac.getBean("cardServiceProxy");
		cardService.getCard(0);
		
		
	}

}
