/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author User
 */
public class QueryFormation {
    private static boolean isfound = false;
    private static String  sql = "select";
    //private static Attribute attr = new Attribute();
    public static ArrayList<Attribute> attributeList = new ArrayList<Attribute>();
    
    public static String determineColumns(ArrayList<String> tokens)
    {
        Dictionary.populateDictionary();
        
        //check if token exist in dictionary
        for(int i = 0; i<tokens.size(); i++)
        {
            if(isfound == false)
            {
                for(int j = 0; j<Dictionary.idList.size(); j++)
                {
                    if(tokens.get(i).equalsIgnoreCase(Dictionary.idList.get(j)))
                    {
                        isfound = true;
                        if(!sql.contains("id"))
                        {
                            if(sql.length() == 6)
                            {
                                sql = sql + " " + "id";
                            }
                            else
                            {
                                sql = sql+",id";
                            }
                        }
                        Attribute a = new Attribute(tokens.get(i), Dictionary.idList.get(j));
                        attributeList.add(a);
                        isfound = false;
                        System.out.println(sql);
                    }
                }
            }
            
            if(isfound == false)
            {
                for(int j = 0; j<Dictionary.firstnameList.size(); j++)
                {
                    if(tokens.get(i).equalsIgnoreCase(Dictionary.firstnameList.get(j)))
                    {
                        isfound = true;
                        if(!sql.contains("firstname"))
                        {
                            if(sql.length() == 6)
                            {
                                sql = sql + " " + "firstname";
                            }
                            else
                            {
                                sql = sql+",firstname";
                            }
                        }
                        Attribute a = new Attribute("firstname", Dictionary.firstnameList.get(j));
                        attributeList.add(a);
                        isfound = false;
                        System.out.println(sql);
                    }
                }
            }
            
            if(isfound == false)
            {
                for(int j = 0; j<Dictionary.lastnameList.size(); j++)
                {
                    if(tokens.get(i).equalsIgnoreCase(Dictionary.lastnameList.get(j)))
                    {
                        isfound = true;
                        if(!sql.contains("lastname"))
                        {
                            if(sql.length() == 6)
                            {
                                sql = sql + " " + "lastname";
                            }
                            else
                            {
                                sql = sql+",lastname";
                            }
                        }
                        Attribute a = new Attribute("lastname", Dictionary.lastnameList.get(j));
                        attributeList.add(a);
                        isfound = false;
                        System.out.println(sql);
                    }
                }
            }
            
            if(isfound == false)
            {
                for(int j = 0; j<Dictionary.genderList.size(); j++)
                {
                    if(tokens.get(i).equalsIgnoreCase(Dictionary.genderList.get(j)))
                    {
                        isfound = true;
                        if(!sql.contains("gender"))
                        {
                           if(sql.length() == 6)
                           {
                            sql = sql + " " + "gender";
                           }
                           else
                           {
                            sql = sql+",gender";
                           } 
                        }
                        Attribute a = new Attribute("gender", Dictionary.genderList.get(j));
                        attributeList.add(a);
                        isfound = false;
                        System.out.println(sql);
                    }
                }
            }
            
            if(isfound == false)
            {
                for(int j = 0; j<Dictionary.departmentList.size(); j++)
                {
                    if(tokens.get(i).equalsIgnoreCase(Dictionary.departmentList.get(j)))
                    {
                        isfound = true;
                        if(!sql.contains("department"))
                        {
                            if(sql.length() == 6)
                            {
                                sql = sql + " " + "department";
                            }
                            else
                            {
                                sql = sql+",department";
                            }
                        }
                        Attribute a = new Attribute("department", Dictionary.departmentList.get(j));
                        attributeList.add(a);
                        isfound = false;
                        System.out.println(sql);
                    }
                }
            }
            
            if(isfound == false)
            {
                for(int j = 0; j<Dictionary.salaryList.size(); j++)
                {
                    if(tokens.get(i).equalsIgnoreCase(Dictionary.salaryList.get(j)))
                    {
                        isfound = true;
                        if(!sql.contains("salary"))
                        {
                            if(sql.length() == 6)
                            {
                            sql = sql + " " + "salary";
                            }
                            else
                            {
                                sql = sql+",salary";
                            }
                        }
                        Attribute a = new Attribute(tokens.get(i), Dictionary.salaryList.get(j));
                        attributeList.add(a);
                        isfound = false;
                        System.out.println(sql);
                    }
                }
            }
        }
        if(sql.length() ==6)
        {
            //System.out.println("Query could not be processed");
            JOptionPane.showMessageDialog(null, "Query could not be processed", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        //list attributes
       System.out.println();
            for (int i = 0; i < attributeList.size(); i++) {
              System.out.println(attributeList.get(i).getName() + " " + attributeList.get(i).getValue());
         }
//            System.out.println();
//            //System.out.println(attribute.getValue(i.toString(i)));
        
        return sql +  " " + "from employee";
    }
    
    
    public static String completeQuery(String queryColumns)
    {
        String query = queryColumns;
        int count = 0;
        String det = "";
        
        for(int j = 0; j<QueryTokenizer.tokens.size(); j++)
        {
            if(QueryTokenizer.tokens.get(j).equalsIgnoreCase("and"))
            {
                det = "and";
            }
            else if(QueryTokenizer.tokens.get(j).equalsIgnoreCase("or"))
            {
                det = "or";
            }
        }

        
        for(int i=0; i < attributeList.size(); i++)
        {
            if(!attributeList.get(i).getName().equalsIgnoreCase(attributeList.get(i).getValue()))
            {
                if(count == 0)
                {
                    query = query + " " + "where" + " " + attributeList.get(i).getName() + "=" + "'" + attributeList.get(i).getValue() + "'";
                    count++;
                }
                else if(count >= 1 && det.equalsIgnoreCase("and"))
                {
                    query = query + " " + "and" + " " + attributeList.get(i).getName() + "=" + "'" + attributeList.get(i).getValue() + "'";
                }
                else if(count >= 1 && det.equalsIgnoreCase("or"))
                {
                    query = query + " " + "or" + " " + attributeList.get(i).getName() + "=" + "'" + attributeList.get(i).getValue() + "'";
                }
            }
        }
        return query;
    }
    
    public static void restAttributeList()
    {
        attributeList.clear();
    }
}
