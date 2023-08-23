package com.neusoft.elm.view.impl;

import java.util.List;
import java.util.Scanner;
import com.neusoft.elm.dao.BusinessDao;
import com.neusoft.elm.dao.impl.BusinessDaoImpl;
import com.neusoft.elm.po.Business;
import com.neusoft.elm.view.BusinessView;
public class BusinessViewImpl implements BusinessView{
	Scanner input = new Scanner(System.in);
	@Override
       public void listBusinessAll() {
    	   BusinessDao dao = new BusinessDaoImpl();
    	   List<Business> list = dao.listBusiness(null,null);
    	   System.out.println("商家编号\t\t商家名称\t\t商家地址\t\t商家介绍\t\t起送费\t\t配送费");
    	   for(Business B:list) {
    		   System.out.println(B.getBusinessId()+"\t"+B.getBusinessName()+"\t     "+B.getBusinessAddress()+"\t"+B.getBusinessExplain()+"\t"+B.getStarPrice()+"\t"+B.getDeliveryPrice());
    	   }
       }
       @Override
       public void listBusiness() {
    	   String businessName = "";
    	   String businessAddress = "";
    	   String inputStr = "";
    	   System.out.println("是否需要输入商家名称关键词(Y/N): ");
    	   inputStr = input.next();
    	   if(inputStr.equals("Y")) {
    		   System.out.println("请输入商家名称关键词: ");
    	       businessName = input.next();    	   }
  
       System.out.println("是否需要输入商家地址关键词(Y/N): ");
       if(inputStr.equals("Y")) {
		   System.out.println("请输入商家地址关键词: ");
	       businessAddress = input.next();    	   }
       BusinessDao dao = new BusinessDaoImpl();
       List<Business> list = dao.listBusiness(businessName, businessAddress);
       System.out.println("商家编号\t\t商家名称\t\t商家地址\t\t商家介绍\t\t起送费\t\t配送费");
	   for(Business B:list) {
		   System.out.println(B.getBusinessId()+"\t"+B.getBusinessName()+"\t     "+B.getBusinessAddress()+"\t"+B.getBusinessExplain()+"\t"+B.getStarPrice()+"\t"+B.getDeliveryPrice());
	   }
   }
       @Override
       public void saveBusiness() {
    	   System.out.println("请输入商家名称: ");
    	   String businessName = input.next();
    	   BusinessDao dao = new BusinessDaoImpl();
    	   int businessId = dao.saveBusiness(businessName);
    	   if(businessId>0) {
    		   System.out.println("新建商家成功！商家编号为: "+businessId);   
    	   }else {
    		   System.out.println("新建商家失败！");
    	   }
       }
       @Override
       public void removeBusiness() {
    	   System.out.println("请输入商家编号: ");
    	   int businessId = input.nextInt();
    	   System.out.println("是否确认删除(Y/N): ");
    	   if(input.next().equals("Y")) {
    		   BusinessDao dao = new BusinessDaoImpl();
        	   int result = dao.removeBusiness(businessId);
        	   if(result==businessId) {
        		   System.out.println("delete accomplish!");
        	   }else {
        		   System.out.println(result+"delete false,please try again!");
        	   }
        	   
    	   }
       }
}
