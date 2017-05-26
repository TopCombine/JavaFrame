package com.sxt.mystruts.model;

import com.sxt.struts3.ActionForm;

/**
 * 产品对象
 * @author wenber
 *
 */
public class Product implements ActionForm{
	//产品名
	private String name;
	//编号
	private String code;
	//描述
	private String desc;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	

}
