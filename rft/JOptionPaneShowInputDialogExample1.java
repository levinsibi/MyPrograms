package rft;

import javax.swing.*;

/**
 * JOptionPane showInputDialog example #1.
 * A simple showInputDialog example.
 * @author alvin alexander, http://alvinalexander.com
 */
public class JOptionPaneShowInputDialogExample1
{
  public static void main(String[] args)
  {
    // a jframe here isn't strictly necessary, but it makes the example a little more real
   
    // prompt the user to enter their name
   // String name = JOptionPane.showInputDialog(null, "What's your name?");
   /* 
    

    // get the user's input. note that if they press Cancel, 'name' will be null
    System.out.printf("The user's name is '%s'.\n", name);
    System.exit(0);
    */
    JFrame frame = new JFrame("Input");
    String []pizzas = { "select","Cheese", "Pepperoni", "Sausage", "Veggie" };
   /* String favoritePizza = (String) JOptionPane.showInputDialog(frame, 
            "What is your favorite pizza?",
            "Favorite Pizza",
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            pizzas, 
            pizzas[0]);
    */
   //String favoritePizza = (String) JOptionPane.showInputDialog( frame, "favorite pizza", "PIZZA", JOptionPane.QUESTION_MESSAGE, null, pizzas, pizzas[0]);
    
    String favoritePizza = (String) JOptionPane.showInputDialog(frame, "favorite pizza", "PIZZA", JOptionPane.QUESTION_MESSAGE, null, pizzas, pizzas[0]);
        // favoritePizza will be null if the user clicks Cancel
        System.out.printf("Favorite pizza is %s.\n", favoritePizza);
        System.exit(0);
    
       
    
    
  }
  
  
}