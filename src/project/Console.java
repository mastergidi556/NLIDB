/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Console {
    public static void main(String[] args)
    {
        try
        {
           //Tokenize query
           ArrayList<String> tokens =  QueryTokenizer.Tokenize("List okiki gender");
           
           //Remove stopwords
           ArrayList<String> tokenized = StopwordRemover.removeStopWords(tokens);
           
           //Pos tagging and Lemmatization of tokens
           ArrayList<String> lemmatizedTokens = Pos.Tag(tokenized);
           
           //Determine columns
           String queryColumns = QueryFormation.determineColumns(lemmatizedTokens);
           
           //Determine Where clause 
           String queryWhere = QueryFormation.completeQuery(queryColumns);
           System.out.println(queryWhere);
           
           //Execute Query
           SqlEngine.excecuteQuery(queryWhere);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
