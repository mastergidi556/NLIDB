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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class SqlEngine {
   
   public static void excecuteQuery(String query)
   {
       try
       {
           Connection conn = Connectiondb.connect();
           Statement st = conn.createStatement();
           ResultSet rs = null;
           rs=st.executeQuery(query);
           int count = 0;
           
           //remove duplicate attributes
           for(int i = 0; i<QueryFormation.attributeList.size(); i++)
           {
               if(QueryFormation.attributeList.get(i).getName().equalsIgnoreCase("department"))
               {
                   count++;
                   if(count > 1)
                   {
                       QueryFormation.attributeList.remove(i);
                        break;
                   }
               }
           }
          
           
           while(rs.next())
           { 
               for(int i = 0; i<QueryFormation.attributeList.size(); i++)
               {
                   try
                   {
                       if(QueryFormation.attributeList.get(i).getName().equalsIgnoreCase("id"))
                       {
                           System.out.println(rs.getString("id"));
                       }
                       else if(QueryFormation.attributeList.get(i).getName().equalsIgnoreCase("firstname"))
                       {
                           System.out.println(rs.getString("firstname"));
                       }
                       else if(QueryFormation.attributeList.get(i).getName().equalsIgnoreCase("lastname"))
                       {
                           System.out.println(rs.getString("lastname"));
                       }
                       else if(QueryFormation.attributeList.get(i).getName().equalsIgnoreCase("gender"))
                       {
                           System.out.println(rs.getString("gender"));
                       }
                       else if(QueryFormation.attributeList.get(i).getName().equalsIgnoreCase("department"))
                       {
                           System.out.println(rs.getString("department"));
                       }
                       else if(QueryFormation.attributeList.get(i).getName().equalsIgnoreCase("salary"))
                       {
                           System.out.println("£"+rs.getString("salary"));
                       }
                       
                   }
                   catch(Exception e)
                    {

                    }
               }
           }
       }
       catch(Exception e)
       {
           
       }
   }
}
