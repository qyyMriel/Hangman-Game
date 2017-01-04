/*
*  Title      : HangmanCL.java
 *  Description: This is a class called HangmanCL.
 * @author Yi Qin
 * @version 1.0
 * Use this method to start game and this is the base of HangmanGUI.
 */

import javax.swing.JFrame;
import java.util.*;
import java.io.*;
public class HangmanCL {
    protected final dictionary d = new dictionary();
    protected String prints="_ ";
    protected int corrTime=0;
    protected String a = "";
    protected String wordprint=" ";
    protected boolean v;
    protected char g,k;
    protected static int miss = 0;
    protected int tim=0;
    protected char ch1[];
    protected char[] array2;
    protected ArrayList<Character>letter = new ArrayList();
    protected String choi="";
    
    public void connect(){
        choi = d.choose();
    }
    
    /**
    * This method is to get the random words.
    */
    public String choseLetter (){       
        return choi;
    }
    /**
    * This method is to get the length of random words.
    */
    public int choselength(){
        return this.choseLetter().length();
    }
    
    public void arrays(){
        ch1 = choseLetter().toCharArray();
        for(int i = 0; i < this.choselength();i++){
            letter.add(ch1[i]);
        }
    }
    
    /**
    * This method is to print the words.
    */
    protected String words(){
        arrays();
        for(int i=0;i<this.choselength()-1;i++){
            prints=prints+"_ ";
        }
        tim++;
        return prints;
    }
   /**
   * This method is to verify whether the input is valid.
   */
    protected void ifValid(){
        if(a.length()==1){
            g =a.charAt(0);
            if(!Character.isLetter(g)){
                System.out.println("Words only contain letters, no number or other characters.");
                v=false;
            }
            else{
                v=true;k=g;
            }
        }
        else{
            System.out.println("Input can only contain one letter!");
            v=false;
        }
   }
  /**
  * This method is to get the input of users. 
  *  @param a stands for the string we want to check.
  */    
   protected void getsIn(){
       System.out.println("Enter Guess:");
       Scanner myScanner = new Scanner(System.in);
       a = myScanner.nextLine();
       a = a.toLowerCase();
   }
    
   /**
   * This method is to get the times of misses.
   */
   protected int getMisses(){
       return this.miss;
   }
    
   /**
   * This method is to get the misses that you type.
   */
   protected void misses(){
       System.out.println("Misses: " + wordprint);
   }
    /**
    * This method is to verify if yor input is made up of words.
    */
    protected void match(){
       if(letter.contains(k)){
           System.out.println("Congratulations!What you guess is right!");
           corrTime++;
           array2 = prints.toCharArray();
           for(int i=0;i<this.choselength();i++)
           {
             if(letter.get(i)==k) array2[2*i]=k;
           }
           prints="";
           prints=new String(array2);//tranform the character array into String
       }
       else if(wordprint.indexOf(String.valueOf(k)) == -1){
           this.miss++;
           wordprint = wordprint.concat(a);
       }
    }

    //This method is to choose quit or continue.
    protected int times(){
        int ab=0;
        if(this.getMisses()<6){
            if(prints.contains("_")){
                return ab;
            }
            else{
                System.out.println("Congratulations, you win! You have guessed the word: swifter in" + corrTime + "guesses.");
                ab=1;return ab;
              }
        }
        else{
            ab=1;
            System.out.println("What a pity! You have run out of guesses. The word was: " + this.choseLetter()+"See you next time.");
            return ab;
        }
    }
   
    
    // This method is main method.Users can run this to start game. 
    public static void main(String[] args){
        char choice;
        HangmanCL start = new HangmanCL();
        int userCho=0;
        while(userCho==0){
            start.connect();
      
            while(start.times()==0){
                if(start.tim==0){
                    System.out.println("Welcome to Hangman:");
                    start.words();
                }
                else{
                    System.out.println("Word:"+ start.prints);
                    start.misses();
                    start.getsIn();
                    start.ifValid();
                    if (start.v == true){
                        start.match();
                    }
                }
            }
     
            System.out.println("Would you like to play again? Y/N  ");
            Scanner get = new Scanner(System.in);
            choice=get.nextLine().charAt(0);
          
            // This choice is to get whether user want to continue the game.
            if (choice=='n'|| choice=='N'){
                userCho=1;                //By choosing "n/N",the signal comes 2,it will lead you to leave
                System.out.println("Bye Bye ");
                System.exit(0);
            }

            else if (choice=='y'||choice=='Y'){
                start.miss=0;
                start.prints="_ ";
                start.wordprint="";
                start.tim=0;
            }
        }
        System.out.println("Congratulations!You are a gifted player.You have guessed all the words in dictionary. ");
        System.exit(0);
    }
}
