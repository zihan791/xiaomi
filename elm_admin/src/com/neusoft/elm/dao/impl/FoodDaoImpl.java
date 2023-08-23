package com.neusoft.elm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.elm.dao.FoodDao;
import com.neusoft.elm.po.Food;
import com.neusoft.elm.util.DButil;

public class FoodDaoImpl implements FoodDao
{
	private Connection con=null;
	private PreparedStatement pst=null;
	private ResultSet rs=null;

	@Override
	public List<Food> getFoodByBusinessId(Integer businessId)
	{
		List<Food> foodList=new ArrayList<Food>();
		String sql="select * from food where businessId=? order by foodId";
		
		try
		{
			con=DButil.getConnection();
			pst=con.prepareStatement(sql);
			pst.setInt(1,businessId);
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				Food food=new Food();
				food.setBusinessId(rs.getInt("businessId"));
				food.setFoodExplain(rs.getString("foodExplain"));
				food.setFoodId(rs.getInt("foodId"));
				food.setFoodName(rs.getString("foodName"));
				food.setFoodPrice(rs.getDouble("foodPrice"));
				
				foodList.add(food);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DButil.close(rs,pst,con);
		}
		
		return foodList;
	}

	@Override
	public int saveFood(Food food)
	{
		int result=0;
		String sql="insert into food values(null,?,?,?,?)";
		
		try
		{
			con=DButil.getConnection();
			pst=con.prepareStatement(sql);
			pst.setString(1,food.getFoodName());
			pst.setString(2,food.getFoodExplain());
			pst.setDouble(3,food.getFoodPrice());
			pst.setInt(4,food.getBusinessId());
			
			result=pst.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DButil.close(rs,pst,con);
		}
		
		
		return result;
	}

	@Override
	public int updateFood(Food food)
	{
		int result=0;
		String sql="update food set foodName=?,foodPrice=?,foodExplain=? where foodId=?";
		
		try
		{
			con=DButil.getConnection();
			pst=con.prepareStatement(sql);
			pst.setString(1,food.getFoodName());
			pst.setDouble(2,food.getFoodPrice());
			pst.setString(3,food.getFoodExplain());
			pst.setInt(4,food.getFoodId());
			
			result=pst.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DButil.close(rs,pst,con);
		}
		
		
		return result;
	}

	@Override
	public Food getFoodById(Integer foodId,Integer businessId)
	{
		Food food=null;
		String sql="select * from food where foodId=? and businessId=?";
		
		try
		{
			con=DButil.getConnection();
			pst=con.prepareStatement(sql);
			pst.setInt(1,foodId);
			pst.setInt(2,businessId);
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				food=new Food();
				food.setBusinessId(rs.getInt("businessId"));
				food.setFoodExplain(rs.getString("foodExplain"));
				food.setFoodId(rs.getInt("foodId"));
				food.setFoodName(rs.getString("foodName"));
				food.setFoodPrice(rs.getDouble("foodPrice"));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DButil.close(rs,pst,con);
		}
		
		return food;
	}

	@Override
	public int deleteFood(Integer foodId, Integer businessId)
	{
		int result=0;
		String sql="delete from food where foodId=? and businessId=?";
		
		try
		{
			con=DButil.getConnection();
			pst=con.prepareStatement(sql);
			pst.setInt(1,foodId);
			pst.setInt(2,businessId);
			
			result=pst.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DButil.close(rs,pst,con);
		}
		
		return result;
	}

	@Override
	public int deleteFoodByBusiness(Integer businessId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
