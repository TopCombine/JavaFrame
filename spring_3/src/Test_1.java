import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sxt.model.Card;
import com.sxt.model.User;
import com.sxt.service.ICardService;
import com.sxt.service.IUserService;


public class Test_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserService userService=(IUserService) context.getBean("userService");
		
		User user=new User();
		user.setUserName("张三");
		userService.saveUser(user);
		
		//ICardService cardService=(ICardService) context.getBean("cardService");
		//cardService.saveCard(new Card());
		//cardService.getCard(0);
	}

}
