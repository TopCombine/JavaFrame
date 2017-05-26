package com.sxt.mystruts.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxt.mystruts.model.Product;
import com.sxt.struts3.Action;
import com.sxt.struts3.ActionForm;
/**
 * 添加产品的业务处理类
 * @author Administrator
 *
 */
public class ProductAction implements Action{
	
	public String execute(HttpServletRequest request,HttpServletResponse response,ActionForm form){
		Product product=(Product)form;
		System.out.println(product.getName()+"="+product.getCode()+"="+product.getDesc());
		request.setAttribute("product", product);
		return "addproductresult.jsp";
	}

}
