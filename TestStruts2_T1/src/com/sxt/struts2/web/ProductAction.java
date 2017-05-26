package com.sxt.struts2.web;

import com.opensymphony.xwork2.ActionSupport;
import com.sxt.struts2.model.Product;

/**
 * 产品业务类
 * @author Administrator
 *
 */
public class ProductAction extends ActionSupport{
	//用对象方式来封装参数
	private Product product;
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("收到产品信息="+product.getProductName()+"="+product.getSpec());
		return "index";
	}
	
}
