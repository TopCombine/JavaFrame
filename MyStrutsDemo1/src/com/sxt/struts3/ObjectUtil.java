package com.sxt.struts3;

import java.lang.reflect.Method;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class ObjectUtil {
	
	/**
	 * 将提交的所有参数赋给指的对象
	 * @param request
	 * @param user
	 */
	public static void setValues(HttpServletRequest request, Object obj) {
		//取得所有提交的参数
		Enumeration enu=request.getParameterNames();
		//询问有没有下一个
		while(enu.hasMoreElements()){
			//取得下一元素名
			String key=(String) enu.nextElement();
			setValue(obj,key,request.getParameter(key));
		}
	}
	
	/**
	 * 给对象属性赋值
	 * @param obj 所赋值的对象
	 * @param attr 赋值的属性名
	 * @param value 值
	 */
	public static  void setValue(Object obj,String attr,Object value){
		
		try {
			//通过对象得到类
			Class cls=obj.getClass();
			//通过类得到所有方法
			Method[] methods=cls.getDeclaredMethods();
			for (Method method : methods) {
				if(method.getName().equalsIgnoreCase("set"+attr)){
					//====================参数的匹配
					//取得参数的类型
					Class paramType=method.getParameterTypes()[0];
					if(paramType==int.class){
						value=Integer.parseInt(value.toString());
					}else if(paramType==long.class){
						value=Long.parseLong(value.toString());
					}
					//=====================方法的调用
					// 反射中调用方法 obj这方法所在的对象 args参数
					Object[] objs=new Object[1];
					objs[0]=value;
					method.invoke(obj,objs);
					break;
					//========================
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
