package com.neusoft.elm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.elm.dao.BusinessDao;
import com.neusoft.elm.po.Admin;
import com.neusoft.elm.po.Business;
import com.neusoft.elm.util.DButil;
public class BusinessDaoImpl implements BusinessDao{
	private Connection con = null;
	 private PreparedStatement pst = null;
	 private ResultSet rs = null;
     @Override
     public List<Business> listBusiness(String businessName,String businessAddress){
    	 List<Business> list = new ArrayList();
     	StringBuffer sql = new StringBuffer("select * from business where 1=1");
     	if(businessName!=null&&businessAddress.equals("")){
     		sql.append(" and businessName like '%"+businessName+"%' ");
     	}
     	if(businessName!=null&&businessAddress.equals("")){
     		sql.append(" and businessAddress like '%"+businessAddress+"%' ");
     	}
     	try {
     		con = DButil.getConnection();
 			pst = con.prepareStatement(sql.toString());
 			rs = pst.executeQuery();
 			while(rs.next()) {
 				Business business = new Business();
 				business.setBusinessId(rs.getInt("businessId"));
 				business.setPassword(rs.getString("password"));
 				business.setBusinessName(rs.getString("businessName"));
 				business.setBusinessAddress(rs.getString("businessAddress"));
 				business.setBusinessExplain(rs.getString("businessExplain"));
 				business.setStarPrice(rs.getDouble("starPrice"));
 				business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
 			    list.add(business);
 			}
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}finally {
 			DButil.close(rs, pst, con);
 		}
     	return list;
     }
     @Override
     public int saveBusiness(String businessName) {
    	int businessId = 0;
    	String sql = "insert into business(businessName,password) values(?,'123')";
      	try {
      		con = DButil.getConnection();
  			pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
  			pst.setString(1, businessName);
  			pst.executeUpdate();
  			rs = pst.getGeneratedKeys();
  			if(rs.next()) {
  				businessId = rs.getInt(1);
  			}
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}finally {
  			DButil.close(rs, pst, con);
  		}
      	return businessId;
     }
     @Override
     public int removeBusiness(int businessId) {
     	int result = 0;
    	String delFootSql = "delete from food where businessId=?";
    	String delBusinessSql = "delete from business where businessId=?";
       	try {
       		con = DButil.getConnection();
       		con.setAutoCommit(false);
       		
   			pst = con.prepareStatement(delFootSql);
   			pst.setInt(1, businessId);
   			pst.executeUpdate();
   			
   			pst = con.prepareStatement(delBusinessSql);
   			pst.setInt(1, businessId);
   			pst.executeUpdate();
   			result = pst.executeUpdate();
   			
   			con.commit();
   		} catch (SQLException e) {
   			// TODO Auto-generated catch block
   		    result = 0;
   			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
   			e.printStackTrace();
   		}finally {
   			DButil.close(null, pst, con);
   		}
       	return businessId;
     }
}
