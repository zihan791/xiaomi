package com.neusoft.elm.view.impl;

import java.util.List;
import java.util.Scanner;

import com.neusoft.elm.dao.FoodDao;
import com.neusoft.elm.dao.impl.FoodDaoImpl;
import com.neusoft.elm.po.Food;
import com.neusoft.elm.view.FoodView;

public class FoodViewImpl implements FoodView
{
	private Scanner input=new Scanner(System.in);
	
	@Override
	public void showFood(Integer businessId)
	{
		FoodDao dao=new FoodDaoImpl();
		List<Food> list=dao.getFoodByBusinessId(businessId);
		
		System.out.println("已显示您的所有商品信息：");
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i));
			System.out.println();
		}
	}

	@Override
	public void addFood(Integer businessId)
	{
		Food food=new Food();
		FoodDao dao=new FoodDaoImpl();
		
		System.out.print("请输入新增商品名称：");
		food.setFoodName(input.next());
		System.out.print("请输入新增商品介绍：");
		food.setFoodExplain(input.next());
		System.out.print("请输入新增商品价格：");
		food.setFoodPrice(input.nextDouble());
		food.setBusinessId(businessId);
		
		int result=dao.saveFood(food);
		if(result!=0)
		{
			System.out.println("已成功新增商品");
		}
		else
		{
			System.out.println("操作失败，请检查输入信息是否合规");
		}
		
	}

	@Override
	public void updateFood(Integer businessId)
	{
		FoodDao dao=new FoodDaoImpl();
		String yes="y";
		String key=null;
		
		showFood(businessId);
		
		System.out.print("请输入修改商品的编号：");
		Integer foodId=input.nextInt();
		
		Food food=dao.getFoodById(foodId,businessId);
		if(food!=null)
		{	
			System.out.print("已显示当前商品信息：");
			System.out.println(food);
			
			System.out.print("是否修改商品名称（是:y   否:任意其他键）：");
			key=input.next();
			if(key.equals(yes))
			{
				System.out.print("请输入新的商品名称：");
				food.setFoodName(input.next());
			}
			
			System.out.print("是否修改商品介绍（是:y   否:任意其他键）：");
			key=input.next();
			if(key.equals(yes))
			{
				System.out.print("请输入新的商品介绍：");
				food.setFoodExplain(input.next());
			}
			
			System.out.print("是否修改商品价格（是:y   否:任意其他键）：");
			key=input.next();
			if(key.equals(yes))
			{
				System.out.print("请输入新的商品价格：");
				food.setFoodPrice(input.nextDouble());
			}
			
			int result=dao.updateFood(food);
			if(result!=0)
			{
				System.out.println("已成功修改商品信息");
			}
			else
			{
				System.out.println("修改失败，请检查输入信息是否合规");
			}
		}
		else
		{
			System.out.println("操作失败，请输入正确的商品编号");
		}
	}

	@Override
	public void deleteFood(Integer businessId)
	{
		FoodDao dao=new FoodDaoImpl();
		String yes="y";
		
		showFood(businessId);
		System.out.print("请输入删除商品的编号：");
		Integer foodId=input.nextInt();
		Food food=dao.getFoodById(foodId,businessId);
		
		if(food!=null)
		{
			System.out.print("已显示当前商品信息：");
			System.out.println(food);
			
			System.out.print("是否确认将其删除（是:y   否:任意其他键）：");
			if(input.next().equals(yes))
			{
				int result=dao.deleteFood(foodId,businessId);
				
				if(result!=0)
				{
					System.out.println("已成功删除商品");
				}
				else
				{
					System.out.println("删除失败，请检查输入信息是否合规");
				}
			}
		}
		else
		{
			System.out.println("操作失败，请输入正确的商品编号");
		}
	}
	
	
}
