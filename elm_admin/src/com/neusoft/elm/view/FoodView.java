package com.neusoft.elm.view;

import com.neusoft.elm.po.Food;

public interface FoodView
{
	public void showFood(Integer businessId);
	public void addFood(Integer businessId);
	public void updateFood(Integer businessId);
	public void deleteFood(Integer businessId);
}
