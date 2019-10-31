/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author User
 */
class Connectiondb {
    public static Connection connect()
    {
        String conString = "jdbc:derby://localhost:1527/project";
        Connection con  = null;
        String uName = null;
        String uPass= null;
        
        //Connect to database
        try
        {
            con = DriverManager.getConnection(conString, uName, uPass);
//            if(con != null)
//            {
//                System.out.println("Connected to DB");
//            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return con;
    }
}
