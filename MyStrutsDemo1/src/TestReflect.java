import java.lang.reflect.Method;
import java.util.Date;

import com.sxt.mystruts.model.User;

public class TestReflect {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//com.sxt.mystruts.model.User
			//加载类
			Class cls = Class.forName("com.sxt.mystruts.model.User");
			//新建实现
			User user = (User) cls.newInstance();
			setValue(user, "userName", "张三");
			setValue(user, "age", 12);
			setValue(user, "regDate", new Date());
			System.out.println(user.getUserName() + "=" + user.getAge()
					+ user.getRegDate());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 给对象属性赋值
	 * @param obj 所赋值的对象
	 * @param attr 赋值的属性名
	 * @param value 值
	 */
	public static void setValue(Object obj, String attr, Object value) {
		try {
			//取得所有方法
			Method[] methods = obj.getClass().getDeclaredMethods();
			for (Method method : methods) {
				if(method.getName().equalsIgnoreCase("set"+attr)){
					Class paramClass=method.getParameterTypes()[0];
					if(paramClass==int.class){
						value=Integer.parseInt(value.toString());
					}
					Object [] objects=new Object[1];
					objects[0]=value;
					method.invoke(obj, objects);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
