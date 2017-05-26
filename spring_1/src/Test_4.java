import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sxt.model.Card;
import com.sxt.model.User;


public class Test_4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		ApplicationContext fac=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		User user=(User) fac.getBean("user");
		Card card=user.getCard();
		System.out.println(user.getUserName()+"=="+card.getCardNo());
	}

}
