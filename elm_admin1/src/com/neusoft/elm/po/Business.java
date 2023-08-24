package com.neusoft.elm.po;

public class Business
{
	private Integer businessId;
	private String password;
	private String businessName;
	private String businessAddress;
	private String businessExplain;
	private Double starPrice;
	private Double deliveryPrice;
	
	public String toString()
	{
		return "商家编号:"+businessId+
			   "\n商家密码:"+password+
			   "\n商家名称:"+businessName+
			   "\n商家地址:"+businessAddress+
			   "\n商家介绍:"+businessExplain+
			   "\n起送费:"+starPrice+
			   "\n配送费:"+deliveryPrice;
	}
	
	public Integer getBusinessId()
	{
		return businessId;
	}
	public void setBusinessId(Integer businessId)
	{
		this.businessId=businessId;
	}
	
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
	
	public String getBusinessName()
	{
		return businessName;
	}
	public void setBusinessName(String businessName)
	{
		this.businessName=businessName;
	}
	
	public String getBusinessAddress()
	{
		return businessAddress;
	}
	public void setBusinessAddress(String businessAddress)
	{
		this.businessAddress=businessAddress;
	}
	
	public String getBusinessExplain()
	{
		return businessExplain;
	}
	public void setBusinessExplain(String businessExplain)
	{
		this.businessExplain=businessExplain;
	}
	
	public Double getStarPrice()
	{
		return starPrice;
	}
	public void setStarPrice(Double starPrice)
	{
		this.starPrice=starPrice;
	}
	
	public Double getDeliveryPrice()
	{
		return deliveryPrice;
	}
	public void setDeliveryPrice(Double deliveryPrice)
	{
		this.deliveryPrice=deliveryPrice;
	}
	
	
}
