/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author User
 */
public class StopwordRemover {
    private static String[] defaultStopWords = {"i", "a", "about", "an", "are", "as", "at", "be", "by", "com", "for", "from", "how","in",
                                         "is", "it", "of", "on", "that", "the", "this","to", "was", "what", "when", "where", "who", "will", "with"};
    
    private static ArrayList<String> stopwords = new ArrayList<String>();
    
    
    public static ArrayList<String> removeStopWords(ArrayList<String> tokens) {
        stopwords.addAll(Arrays.asList(defaultStopWords));//convert Array to list
        
        //compare tokens with stopwords and remove
        for (int i = 0; i < tokens.size(); i++) {
            if (stopwords.contains(tokens.get(i))) 
            {
                tokens.remove(i);
            }
        }
        return tokens;
    }
    
    
    public static void reset()
    {
        
    }
}
