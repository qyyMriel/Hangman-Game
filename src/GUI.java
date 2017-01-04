/*
*  Title      : GUI.java
 *  Description: This is a class called GUI.
 * @author Yi Qin
 * @version 1.0
 */
import java.awt.*;
import javax.swing.*;
public class GUI extends JFrame{
    HangmanCL start = new HangmanCL();
    public GUI(){
        this.setTitle("Hangman");
        this.setSize(700,700);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
         
    public void miss(){
       switch(start.getmisses()){
            case 0:{
            
                   this.add(new Frame());
                   this.setSize(700,700); 
                   this.setVisible(true);
                   break;
            }
            case 1:{
                   this.add(new Head());
                   this.setSize(700,700); 
                   this.setVisible(true);
                   break;
                   }
            case 2:{
                   this.add(new Body());
                   this.setSize(700,700); 
                   this.setVisible(true); 
                   break;
                   }
            case 3:{
                   this.add(new HandL());
                   this.setSize(700,700); 
                   this.setVisible(true);
                   break;
                   }
            case 4:{
                   this.add(new HandR());
                   this.setSize(700,700); 
                   this.setVisible(true);
                   break;
                   }
            case 5:{ 
                   this.add(new LegL());
                   this.setSize(700,700); 
                   this.setVisible(true);
                   break;
            }
            case 6:{  
                   this.add(new LegR());
                   this.setSize(700,700); 
                   this.setVisible(true);
                   break;
    `       }
       }
    }
    /*
   * this inner class is to draw the pole.
   */
    public class Frame extends JPanel{
        public void paintComponent(Graphics g){
            g.clearRect(0, 0, 700, 700);
            g.setColor(Color.black);
            g.fillRect(80,80,46,80);
            g.fillRect(126,80,200,40);
            g.fillRect(250,80,76,550);        
            g.fillRect(10,630,500,80);    
            
        }
    }
    /*
   * this inner class is to draw the head of the man
   */
    public class Head extends JPanel{
        public void paintComponent(Graphics g){
            g.setColor(Color.black);
            g.drawOval(63,160,80,80);
        }
    }
    /*
   * this inner class is to draw the body of the man.
   */
    public class Body extends JPanel{
        public void paintComponent(Graphics g){
               g.setColor(Color.black);
               g.fillRect(93,240,20,200);
        }
    }
    /*
       * this inner class is to draw the left hand of the man.
       */
    public class HandL extends JPanel{
        public void paintComponent(Graphics g){
               g.setColor(Color.black);
               g.drawLine(3,270,103,290);
        }
    }
    /*
       * this inner class is to draw the right hand of the man.
       */
    public class HandR extends JPanel{
        public void paintComponent(Graphics g){
            g.setColor(Color.black);
            g.drawLine(203,270,103,290);
        }   
    }
    /*
       * this inner class is to draw the left leg of the man.
       */

    public class LegL extends JPanel{
        public void paintComponent(Graphics g){
            g.setColor(Color.black);
            g.drawLine(2,460,103,440);
        }
    }
    /*
       * this inner class is to draw the right leg of the man.
       */
    public class LegR extends JPanel{
        public void paintComponent(Graphics g){
            g.setColor(Color.black);
            g.drawLine(204,460,103,440);
        }
    } 
}
