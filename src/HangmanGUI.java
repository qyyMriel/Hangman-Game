/*
 *  Title      : HangmanGUI.java
 *  Description: This is a class called HangmanGUI.
 * @author Yi Qin
 * @version 1.0
 */
import javax.swing.JFrame;
import java.util.*;
import java.io.*;
public class HangmanGUI extends HangmanCL {

    public static void main(String[] args){
        char choice;
        HangmanGUI start = new HangmanGUI();
        GUI g1 = new GUI();

        int userCho=0;
        while(userCho==0){
            start.connect();
            
            while(start.times()==0){
                if(start.tim == 0){
                    System.out.println("Welcome to Hangman:");
                    start.words();
                }
                else{
                    //Call GUI and create the graphic.
                    g1.miss();
                    System.out.println("Word:"+ start.prints);
                    start.misses();
                    start.getsIn();
                    start.ifValid();
                    if ((start.v==true)&&!(start.getmisses()==5)){
                        start.match();
                    }
                    else if((start.v==true)&&(start.getmisses()==5)){
                        start.match();
                        g1.miss();
                    }
                }
            }
     
            System.out.println("Would you like to play again? Y/N  ");
            Scanner get = new Scanner(System.in);
            choice=get.nextLine().charAt(0);

            if (choice=='n'|| choice=='N'){
                userCho=1;
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
