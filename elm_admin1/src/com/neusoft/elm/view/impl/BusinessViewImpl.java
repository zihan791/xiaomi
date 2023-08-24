package com.neusoft.elm.view.impl;

import java.util.List;
import java.util.Scanner;

import com.neusoft.elm.dao.BusinessDao;
import com.neusoft.elm.dao.impl.BusinessDaoImpl;
import com.neusoft.elm.po.Business;
import com.neusoft.elm.view.BusinessView;

public class BusinessViewImpl implements BusinessView
{
	private Scanner input=new Scanner(System.in);
	
	@Override
	public void showAllBusiness()
	{
		BusinessDao dao=new BusinessDaoImpl();
		List<Business> listBusiness=dao.listBusiness();
		
		for(int i=0;i<listBusiness.size();i++)
		{
			System.out.println(listBusiness.get(i));
		}
	}
	
	@Override
	public void saveBusiness()
	{
		BusinessDao dao=new BusinessDaoImpl();
		Business business=new Business();
		
		System.out.print("请输入新建商家名称：");
		business.setBusinessName(input.next());
		business.setPassword("123");
		
		int businessId=dao.saveBusiness(business);
		if(businessId>=0)
		{
			System.out.println("已成功新建商家");
			System.out.println("新商家编号："+businessId+"，初始密码为123");
		}
		else
		{
			System.out.println("修改失败，请检查输入信息是否合规");
		}
	}
	
	@Override
	public void deleteBusiness()
	{
		BusinessDao dao=new BusinessDaoImpl();
		
		System.out.print("请输入删除商家编号：");
		Integer businessId=input.nextInt();
		
		int result=dao.deleteBusiness(businessId);
		if(result!=0)
		{
			System.out.println("已成功删除商家");
		}
		else
		{
			System.out.println("操作失败，请检查输入信息是否合规");
		}
	}

	@Override
	public Business login()
	{
		System.out.print("请输入商家编号：");
		int businessId=input.nextInt();
		System.out.print("请输入密码：");
		String password=input.next();
		
		BusinessDao dao=new BusinessDaoImpl();
		
		return dao.getBusinessByIdByPass(businessId,password);
	}

	@Override
	public void showBusiness(Integer businessId)
	{
		BusinessDao dao=new BusinessDaoImpl();
		System.out.println("已显示您的详细信息");
		System.out.println(dao.getBusinessById(businessId));
	}

	@Override
	public void updateBusiness(Integer businessId)
	{
		String yes="y";
		String key=null;
		BusinessDao dao=new BusinessDaoImpl();
		Business business=dao.getBusinessById(businessId);
		
		System.out.println("已显示当前商家信息");
		System.out.println(business);
		
		
		System.out.print("是否修改商家名称（是:y   否:任意其他键）：");
		key=input.next();
		if(key.equals(yes))
		{
			System.out.print("请输入新的商家名称：");
			business.setBusinessName(input.next());
		}
		
		System.out.print("是否修改商家地址（是:y   否:任意其他键）：");
		key=input.next();
		if(key.equals(yes))
		{
			System.out.print("请输入新的商家地址：");
			business.setBusinessAddress(input.next());
		}
		
		System.out.print("是否修改商家介绍（是:y   否:任意其他键）：");
		key=input.next();
		if(key.equals(yes))
		{
			System.out.print("请输入新的商家介绍：");
			business.setBusinessExplain(input.next());
		}
		
		System.out.print("是否修改起送费（是:y   否:任意其他键）：");
		key=input.next();
		if(key.equals(yes))
		{
			System.out.print("请输入新的起送费：");
			business.setStarPrice(input.nextDouble());
		}
		
		System.out.print("是否修改配送费（是:y   否:任意其他键）：");
		key=input.next();
		if(key.equals(yes))
		{
			System.out.print("请输入新的配送费：");
			business.setDeliveryPrice(input.nextDouble());
		}
		
		int result=dao.updateBusiness(business);
		if(result!=0)
		{
			System.out.println("已成功修改商家信息");
		}
		else
		{
			System.out.println("修改失败，请检查输入信息是否合规");
		}
	}

	@Override
	public void updatePass(Integer businessId)
	{
		String key=null;
		BusinessDao dao=new BusinessDaoImpl();
		Business business=dao.getBusinessById(businessId);
		
		System.out.print("请输入您的旧密码：");
		key=input.next();
		if(!key.equals(business.getPassword()))
		{
			System.out.println("操作失败，密码错误");
			return;
		}
		
		System.out.print("请输入您的新密码：");
		key=input.next();
		if(key.equals(business.getPassword()))
		{
			System.out.println("操作失败，新密码不能与旧密码一致");
			return;
		}
		
		int result=dao.updateBusinessOnPass(businessId,key);
		if(result!=0)
		{
			System.out.println("已成功修改密码");
		}
		else
		{
			System.out.println("修改失败，请检查输入信息是否合规");
		}
		
	}
	
}
