package com.neusoft.elm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.elm.dao.BusinessDao;
import com.neusoft.elm.po.Business;
import com.neusoft.elm.util.DBUtil;

public class BusinessDaoImpl implements BusinessDao
{
	private Connection con=null;
	private PreparedStatement pst=null;
	private ResultSet rs=null;
	
	@Override
	public List<Business> listBusiness()
	{
		List<Business> list=new ArrayList<Business>();
		String sql="select * from business order by businessId";
		
		try
		{
			con=DBUtil.getConnection();
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				Business business=new Business();
				business.setBusinessId(rs.getInt("businessId"));
				business.setPassword(rs.getString("password"));
				business.setBusinessName(rs.getString("businessName"));
				business.setBusinessAddress(rs.getString("businessAddress"));
				business.setBusinessExplain(rs.getString("businessExplain"));
				business.setStarPrice(rs.getDouble("starPrice"));
				business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
				
				list.add(business);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBUtil.Close(rs,pst,con);
		}
		
		return list;
	}
	
	@Override
	public int saveBusiness(Business business)
	{
		int businessId=0;
		String sql="insert into business(businessName,password) values(?,?)";
		
		try
		{
			con=DBUtil.getConnection();
			pst =con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1,business.getBusinessName());
			pst.setString(2,business.getPassword());
			pst.executeUpdate();
			rs=pst.getGeneratedKeys();
			
			if(rs.next())
			{
				businessId=rs.getInt(1);
		    }
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBUtil.Close(rs,pst,con);
		}
		
		return businessId;
	}
	
	@Override
	public int deleteBusiness(Integer businessId)
	{
		int result=0;
		String sql="delete from business where businessId=?";
		
		try
		{
			con=DBUtil.getConnection();
			pst=con.prepareStatement(sql);
			pst.setInt(1,businessId);
			
			result=pst.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBUtil.Close(rs,pst,con);
		}
		
		return result;
	}

	@Override
	public Business getBusinessByIdByPass(Integer businessId, String password)
	{
		Business business=null;
		String sql="select * from business where businessId=? and password=?";
		
		try
		{
			con=DBUtil.getConnection();
			pst=con.prepareStatement(sql);
			pst.setInt(1,businessId);
			pst.setString(2,password);
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				business=new Business();
				business.setBusinessId(rs.getInt("businessId"));
				business.setPassword(rs.getString("password"));
				business.setBusinessName(rs.getString("businessName"));
				business.setBusinessAddress(rs.getString("businessAddress"));
				business.setBusinessExplain(rs.getString("businessExplain"));
				business.setStarPrice(rs.getDouble("starPrice"));
				business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBUtil.Close(rs,pst,con);
		}
		
		return business;
	}

	@Override
	public Business getBusinessById(Integer businessId)
	{
		Business business=null;
		String sql="select * from business where businessId=?";
		
		try
		{
			con=DBUtil.getConnection();
			pst=con.prepareStatement(sql);
			pst.setInt(1,businessId);
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				business=new Business();
				business.setBusinessId(rs.getInt("businessId"));
				business.setPassword(rs.getString("password"));
				business.setBusinessName(rs.getString("businessName"));
				business.setBusinessAddress(rs.getString("businessAddress"));
				business.setBusinessExplain(rs.getString("businessExplain"));
				business.setStarPrice(rs.getDouble("starPrice"));
				business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBUtil.Close(rs,pst,con);
		}
		
		
		return business;
	}

	@Override
	public int updateBusiness(Business business)
	{
		int result=0;
		String sql = "update business set businessName=?,businessAddress=?,businessExplain=?,starPrice=?,deliveryPrice=? where businessId=?";
		
		try
		{
			con=DBUtil.getConnection();
			pst=con.prepareStatement(sql);
			pst.setString(1,business.getBusinessName());
			pst.setString(2,business.getBusinessAddress());
			pst.setString(3,business.getBusinessExplain());
			pst.setDouble(4,business.getStarPrice());
			pst.setDouble(5,business.getDeliveryPrice());
			pst.setInt(6,business.getBusinessId());
			
			result=pst.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBUtil.Close(rs,pst,con);
		}
		
		return result;
	}

	@Override
	public int updateBusinessOnPass(Integer businessId,String password)
	{
		int result=0;
		String sql = "update business set password=? where businessId=?";
		
		try
		{
			con=DBUtil.getConnection();
			pst=con.prepareStatement(sql);
			pst.setString(1,password);
			pst.setInt(2,businessId);
			
			result=pst.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBUtil.Close(rs,pst,con);
		}
		
		return result;
	}
	
}
