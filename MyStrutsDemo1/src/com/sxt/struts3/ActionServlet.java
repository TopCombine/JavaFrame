package com.sxt.struts3;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 核心控制器
 * 
 * @author Administrator
 * 
 */
public class ActionServlet extends HttpServlet {

	public void init() throws ServletException {
		// 取得XML系统路径
		String path = this.getServletContext().getRealPath(
				"/WEB-INF/classes/struts.xml");
		// XML加载并初始化
		ParseXML.parse(path);
	}

	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// ============================================================
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			//是否有指定的调用方法==================================================
			String method=request.getParameter("method");
			// 得到你请求的路径
			String uri = request.getRequestURI();//-----MyStruts3.0/User.do
			// 取得请求的动作
			String actionPath = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
			// =========================================================
			// 得到动作所对应的actionMap //根据路径来分析应该用哪个业务来处理
			HashMap<String, String> actionMap = ParseXML.actionMaps.get("/"+ actionPath);
			// =========================formClassName===========
			// 根据动作中的formClassName得到form的名字
			String formClassNameKey = actionMap.get("formClassName"); //如UserForm
			// 根据名字得到formClass
			String formClassName = ParseXML.formMaps.get(formClassNameKey);  //如com.sxt.mystruts.model.User
			// =======================actionClass=============
			String actionClassName = actionMap.get("actionClassName");//如com.sxt.mystruts.web.UserAction
			// ==============================================

			String forwardjsp = null;
			// ===============参数封装==============
			// 添加用户的动作
			ActionForm obj = (ActionForm) Class.forName(formClassName).newInstance();
			// 将request里面的参数值封到指定的user对象中
			ObjectUtil.setValues(request, obj);
			// =================业务交给action===============
			Action action = (Action) Class.forName(actionClassName).newInstance();			
			if(method==null || method.equals("")){
				forwardjsp = action.execute(request, response, obj);
			}else{
				//------------------------根据指定action方法名进行调用-------------------------
				//组织好参数类型
				Class[] actionMethodParam=new Class[]{
						HttpServletRequest.class,HttpServletResponse.class,ActionForm.class
				};
				//根据参数类型得到方式
				Method actionMethod=action.getClass().getDeclaredMethod(method, actionMethodParam);
				Object[] actionMethodValue=new Object[]{
						request,response,obj
				};
				//给定参数值调用方式
				forwardjsp = (String)actionMethod.invoke(action, actionMethodValue);
				//-------------------------------------------------------------------------
			}
			//如果没有给定跳转的jsp那核心控制器就不跳转
			if(forwardjsp != null && !forwardjsp.equals("")){
				// ===============跳转=======================
				request.getRequestDispatcher(forwardjsp).forward(request, response);
				// =====================================
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
