/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InvalidFormatException;

/**
 *
 * @author User
 */
public class QueryTokenizer {
    public static ArrayList<String> tokens = new ArrayList<String>();
    
    public static ArrayList<String> Tokenize(String query) throws InvalidFormatException, IOException
    {
        String lowerCaseQuery = query.toLowerCase();//Normalize to lowercase
        InputStream is = new FileInputStream("en-token.zip");
	TokenizerModel model = new TokenizerModel(is);
	Tokenizer tokenizer = new TokenizerME(model);
        tokens.addAll(Arrays.asList(tokenizer.tokenize(lowerCaseQuery)));//Add tokens to arraylist
//	for (String token : tokens)
//        {
//            System.out.println(token);
//        }
	is.close();// close stream
        return tokens;
    }
    
    public static void resetTokenList()
    {
        tokens.clear();
    }
}
