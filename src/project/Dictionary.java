/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Dictionary {
   public static ArrayList<String> idList = new ArrayList<String>();
   public static ArrayList<String> firstnameList = new ArrayList<String>();
   public static ArrayList<String> lastnameList = new ArrayList<String>();
   public static ArrayList<String> genderList = new ArrayList<String>();
   public static ArrayList<String> departmentList = new ArrayList<String>();
   public static ArrayList<String> salaryList = new ArrayList<String>();
   
  
   
   public static ArrayList<String>  populateIdList()
   {
       try
       {
           idList.add("id");
           Connection conn = Connectiondb.connect();
           
           Statement st = conn.createStatement();
           ResultSet rs = null;
           String sql = "SELECT id FROM employee";
           rs=st.executeQuery(sql);
           
           while(rs.next())
           { 
               idList.add(rs.getString("id"));
           }
           
//           for (int i = 0; i < idList.size(); i++) {
//               System.out.println(idList.get(i));
//           }
       }
       catch(Exception e)
       {
           
       }
       return idList;
   }
   
   public static ArrayList<String>  populateFirstnameList()
   {
       try
       {
           firstnameList.add("firstname");
//           firstnameList.add("first");
//           firstnameList.add("names");
//           firstnameList.add("name");
//           firstnameList.add("firstnames");
           Connection conn = Connectiondb.connect();
           
           Statement st = conn.createStatement();
           ResultSet rs = null;
           String sql = "SELECT firstname FROM employee";
           rs=st.executeQuery(sql);
           
           while(rs.next())
           { 
               firstnameList.add(rs.getString("firstname"));
           }
           
//           for (int i = 0; i < firstnameList.size(); i++) {
//               System.out.println(firstnameList.get(i));
//           }
       }
       catch(Exception e)
       {
           
       }
       return firstnameList;
   }
   
   public static ArrayList<String>  populateLastnameList()
   {
       try
       {
           lastnameList.add("lastname");
//           lastnameList.add("last");
//           lastnameList.add("name");
//           lastnameList.add("names");
//           lastnameList.add("lastnames");
           
           Connection conn = Connectiondb.connect();
           
           Statement st = conn.createStatement();
           ResultSet rs = null;
           String sql = "SELECT lastname FROM employee";
           rs=st.executeQuery(sql);
           
           while(rs.next())
           { 
               lastnameList.add(rs.getString("lastname"));
           }
           
//           for (int i = 0; i < lastnameList.size(); i++) {
//               System.out.println(lastnameList.get(i));
//           }
       }
       catch(Exception e)
       {
           
       }
       return lastnameList;
   }
   
   public static ArrayList<String>  populateGenderList()
   {
       try
       {
           genderList.add("gender");
           genderList.add("male");
           genderList.add("female");
       }
       catch(Exception e)
       {
           
       }
       return genderList;
   }
   
   public static ArrayList<String>  populateDepartmentList()
   {
       try
       {
           departmentList.add("department");
           departmentList.add("finance");
           departmentList.add("technology");
           departmentList.add("computer");
           departmentList.add("health");
       }
       catch(Exception e)
       {
           
       }
       return departmentList;
   }
   
   public static ArrayList<String>  populateSalaryList()
   {
       try
       {
           salaryList.add("salary");
           
       }
       catch(Exception e)
       {
           
       }
       return salaryList;
   }
   
   public static void populateDictionary()
   {
        Dictionary.populateIdList();
        Dictionary.populateFirstnameList();
        Dictionary.populateLastnameList();
        Dictionary.populateGenderList();
        Dictionary.populateDepartmentList();
        Dictionary.populateSalaryList();
   }
           
}
