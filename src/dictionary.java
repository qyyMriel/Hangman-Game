
/**
 *  Title      : dictionary.java
 *  Description: This is a class called dictionary.
 * @author Yi Qin
 * @version 1.0
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.math.*;

public class dictionary { 
 
   private final ArrayList <String> dic1 = new ArrayList();
   private final String[] dic2 = new String[15];
   private String af;
   private int b;
   private String oneLine = null;
   private int c = 0;
   private int cho;
   private static final String FILENAME = "dictionary.txt";
   private final File myFile = new File (FILENAME);
   
     /** 
     * Read in the words from dictionary. And, add the words into the 
     * arrylist of words
     * @exception it will throw a exception when the text doesn't exist. 
     */ 
     
    public dictionary(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(myFile)); 
            oneLine = reader.readLine();
            while(oneLine!=null){
                dic1.add(oneLine);
                oneLine = reader.readLine();
                b++;
            } 
           
            for(int i = 0;i<b;i++){
                dic2[i] = dic1.get(i);
                dic2[i] = dic2[i].toLowerCase();
            }
            reader.close();   
        }
        catch(Exception e){
            System.out.println("Errors occur.");
            System.exit(0);
        }
    }

    /** 
     * Choose a random word from dictionary. (cho)
     * If a word is selected, it will not be selected next time.
     */      

    public String choose(){
        cho = (int)((Math.random()*dic1.size())-1);
        af = dic2[cho];
        dic1.remove(cho);
        return af;
    }
}  

