/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import opennlp.tools.cmdline.postag.POSModelLoader;
import opennlp.tools.lemmatizer.DictionaryLemmatizer;
import opennlp.tools.lemmatizer.LemmatizerME;
import opennlp.tools.lemmatizer.LemmatizerModel;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerFactory;
import opennlp.tools.postag.POSTaggerME;

/**
 *
 * @author User
 */
public class Pos {
    public static ArrayList<String> lemmatizedTokens = new ArrayList<String>();
    
    public static ArrayList<String> Tag(ArrayList<String> tokens)
    {
        try
        {
        POSModel model = new POSModelLoader().load(new File("en-pos-maxent.zip"));
        POSTaggerME tagger = new POSTaggerME(model);
        POSTaggerFactory posTaggerFactory = model.getFactory();
        
        //convert List to Array
        String[] tokenArray = new String[tokens.size()];
        tokenArray = tokens.toArray(tokenArray);
        
        String[] tags = tagger.tag(tokenArray);
        
        
            InputStream is = new FileInputStream("english-lemmatizer.txt");
            DictionaryLemmatizer lemmatizer = new DictionaryLemmatizer(is);
            //LemmatizerModel lemmaModel = new LemmatizerModel(is);
            //LemmatizerME lemmatizer = new LemmatizerME(lemmaModel);
            
            
            for (int i = 0; i<tokens.size(); i++) {
                String[] lemmas = lemmatizer.lemmatize(tokenArray, tags);
                if(lemmas[i].equalsIgnoreCase("o"))
                {
                    lemmatizedTokens.add(tokens.get(i));
                }
                else
                {
                    lemmatizedTokens.add(lemmas[i]);
                }
             //System.out.println(tokens.get(i) + "/" +lemmas[i] + "/" + tags[i]);
            }
            
//            for (int i = 0; i<lemmatizedTokens.size(); i++) {
//                System.out.println(lemmatizedTokens.get(i));
//            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        return lemmatizedTokens;
    }
    
    public static void resetLemmatizedTokenList()
    {
        lemmatizedTokens.clear();
    }
}
