package com.neusoft.elm;

import java.util.Scanner;

import com.neusoft.elm.po.Business;
import com.neusoft.elm.view.BusinessView;
import com.neusoft.elm.view.FoodView;
import com.neusoft.elm.view.impl.BusinessViewImpl;
import com.neusoft.elm.view.impl.FoodViewImpl;

public class ElmBusinessEntry
{
	public void work()
	{
		Scanner input=new Scanner(System.in);
		
		System.out.println("------------------------------------------------------------");
		System.out.println("|   \t\t\t饿了么后台管理\t\t\t   |");
		System.out.println("------------------------------------------------------------");
		
		BusinessView businessView=new BusinessViewImpl();
		Business business=businessView.login();
		
		if(business!=null)
		{
			System.out.println("已成功登录，很高兴为您服务");
			
			int menu=0;
			while(menu!=5)
			{
				System.out.println("------------------------------------------------------------");
				System.out.println("\t\t\t菜单：商家管理\t\t\t");
				System.out.println("\t\t\t1.查看商家信息\t\t\t");
				System.out.println("\t\t\t2.修改商家信息\t\t\t");
				System.out.println("\t\t\t  3.修改密码\t\t\t");
				System.out.println("\t\t\t4.所属商品管理\t\t\t");
				System.out.println("\t\t\t  5.退出系统\t\t\t");
				System.out.print("请输入您需要的操作对应的序号：");
				menu=input.nextInt();
				System.out.println("------------------------------------------------------------");
				
				switch(menu)
				{
				case 1:
					businessView.showBusiness(business.getBusinessId());
					break;
				case 2:
					businessView.updateBusiness(business.getBusinessId());
					break;
				case 3:
					businessView.updatePass(business.getBusinessId());
					break;
				case 4:
					foodMange(business.getBusinessId());
					break;
				case 5:
					System.out.println("已成功退出系统，欢迎您的下次使用");
					break;
				default:
					System.out.println("操作失败：请输入正确的操作序号");
					break;
				}
				
			}
		}
		else
		{
			System.out.println("登录失败:请输入正确的商家编号和密码");
		}
	}
	
	private void foodMange(Integer businessId)
	{
		Scanner input=new Scanner(System.in);
		FoodView foodView=new FoodViewImpl();
		int menu=0;
		
		while(menu!=5)
		{
			System.out.println("------------------------------------------------------------");
			System.out.println("\t\t\t菜单：商品管理\t\t\t");
			System.out.println("\t\t\t1.查看商品列表\t\t\t");
			System.out.println("\t\t\t  2.新增商品\t\t\t");
			System.out.println("\t\t\t  3.修改商品\t\t\t");
			System.out.println("\t\t\t  4.删除商品\t\t\t");
			System.out.println("\t\t\t    5.返回\t\t\t");
			System.out.print("请输入您需要的操作对应的序号：");
			menu=input.nextInt();
			System.out.println("------------------------------------------------------------");
			
			switch(menu)
			{
			case 1:
				foodView.showFood(businessId);
				break;
			case 2:
				foodView.addFood(businessId);
				break;
			case 3:
				foodView.updateFood(businessId);
				break;
			case 4:
				foodView.deleteFood(businessId);
				break;
			case 5:
				break;
			default:
				System.out.println("操作失败：请输入正确的操作序号");
				break;
			}
		}
	}
	
	public static void main(String[] args)
	{
		new ElmBusinessEntry().work();
	}
}
