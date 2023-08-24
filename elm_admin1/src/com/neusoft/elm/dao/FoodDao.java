package com.neusoft.elm.dao;

import java.util.List;

import com.neusoft.elm.po.Food;

public interface FoodDao
{
	public List<Food> getFoodByBusinessId(Integer businessId);
	public int saveFood(Food food);
	public Food getFoodById(Integer foodId,Integer businessId);
	public int updateFood(Food food);
	public int deleteFood(Integer foodId,Integer businessId);
	public int deleteFoodByBusiness(Integer businessId);
}
