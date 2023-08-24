package com.neusoft.elm.view;

import com.neusoft.elm.po.Business;

public interface BusinessView
{
	public void showAllBusiness();
	public void saveBusiness();
	public void deleteBusiness();
	
	public Business login();
	public void showBusiness(Integer businessId);
	public void updateBusiness(Integer businessId);
	public void updatePass(Integer businessId);
}