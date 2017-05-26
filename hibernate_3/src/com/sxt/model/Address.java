package com.sxt.model;

/**
 * Address entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Address implements java.io.Serializable {

	// Fields

	private Integer addrId;
	private User user;
	private String addrName;
	private Integer listIndex;

	// Constructors

	/** default constructor */
	public Address() {
	}

	/** full constructor */
	public Address(User user, String addrName, Integer listIndex) {
		this.user = user;
		this.addrName = addrName;
		this.listIndex = listIndex;
	}

	// Property accessors

	public Integer getAddrId() {
		return this.addrId;
	}

	public void setAddrId(Integer addrId) {
		this.addrId = addrId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAddrName() {
		return this.addrName;
	}

	public void setAddrName(String addrName) {
		this.addrName = addrName;
	}

	public Integer getListIndex() {
		return this.listIndex;
	}

	public void setListIndex(Integer listIndex) {
		this.listIndex = listIndex;
	}

}