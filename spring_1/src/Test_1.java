import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.sxt.model.Card;
import com.sxt.model.User;


public class Test_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*User user=new User();
		user.setUserName("志观哥与凤姐的故事");
		user.setUserAge(18);
		user.setUserPwd("520250");
		*/
		//创建一个Bean工厂
		BeanFactory fac=new XmlBeanFactory(new FileSystemResource("src/applicationCOntext.xml"));
		
		User user=(User) fac.getBean("user");
		
		System.out.println("姓名=="+user.getUserName());
		System.out.println("年龄=="+user.getUserAge());
		
		
		Card card=user.getCard();
		System.out.println("身份证号：="+card.getCardNo());
			
	}

}
