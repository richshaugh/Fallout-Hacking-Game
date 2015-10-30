/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackinggame;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.ArrayList;
import static java.lang.Math.*;
import java.util.Random;

/**
 *
 * @author SCHOLES
 */
public class HackingGame  {

   public static ArrayList<String> dict = new ArrayList<String>();
    
    public static void fillArrays(int difficulty) throws IOException {
        String correct;
        BufferedReader inTxt;
        String dictWord;
        ArrayList<String> pickedWords;
        //char[] f = correct.toCharArray();
           try{
        File inputFile = new File("C:\\words\\enable1.txt");
        FileInputStream fis = new FileInputStream(inputFile);
        inTxt = new BufferedReader(new InputStreamReader(fis));
        while( (dictWord=inTxt.readLine() )!=null)
            dict.add(dictWord);
        inTxt.close();
    }
    catch(Exception e){System.out.println("could not Acquire the dictionary");e.printStackTrace();System.exit(-1);}
           
        ArrayList<String> PickedWords = new ArrayList<String>(difficulty*3);
        int wordLength = (difficulty>3)?8:5;
        String word;
        
        for(int i=0;i<difficulty*5;i++)
        {
            boolean wordFound = false;
            while(!wordFound){
                word = dict.get((int)( (dict.size()-1)*random()));
                if(word.length()==wordLength){
                    PickedWords.add(word);
                    wordFound = true;
                }
            }
        }
      
        
        playGame(PickedWords);
        
       
        
    }
    public static void playGame(ArrayList<String>PickedWords) throws IOException
    {
        int count=4;
        //int correctletters = 0;
        Boolean correct = false;
        String guess = "";
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(PickedWords.size()-1);
        String correctword = PickedWords.get(randomInt);
        char[] correctarr = correctword.toCharArray();
        char[] guessarr;
       
        //System.out.println(correctword+" is the correct word");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("The password is one of this list of words. You have four guesses.");
         for(int i=0;i<PickedWords.size();i++)
        {
            System.out.println(PickedWords.get(i));
        } 
       
         while(!correct && count > 0)
         {
            int correctletters =0;
            System.out.print("Enter a guess: ");
            guess = br.readLine();
            
            if(guess.equals(correctword))
            {
                correct = true;
                count = 0;
                System.out.println("Correct!!!Do you wish to play again?y/n ");
                String cho = br.readLine();
               
                if (cho.equals("Y") || cho.equals("y"))                {
                    menu();
                }
                else if (cho.equals("N")|| cho.equals("n"))
                    System.exit(0);
           
            }
            else {
            count--;
            guessarr = guess.toCharArray();
            for(int i=0;i<guessarr.length;i++)
            {
                if(guessarr[i] == correctarr[i])
                {
                    
                    correctletters++;
                }
            }
            System.out.println("Incorrect. You got "+correctletters+" positions correct. You now have "+count+" guesses left");
            }
            
        
                 
            
         }
         System.out.println("Sorry you have now been locked out of the system. The correct password was "+correctword);
         System.exit(0);
        
         
    }
    public static void menu()throws IOException{
        
        System.out.println("**************************");
        System.out.println("Welcome to Fallout Hacking");
        System.out.println("**************************");
        System.out.println("1. V.Easy");
        System.out.println("2. Easy");
        System.out.println("3. Average");
        System.out.println("4. Hard");
        System.out.println("5. V.Hard");
        System.out.print("Make your choice now: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int choice;
        line = br.readLine();
        choice = Integer.parseInt(line);
        if (choice >= 1 && choice <= 5)
        fillArrays(choice);
        else
        {
           System.out.println("Invalid choice. Pick between 1 and 5");
           menu();  
        }
       
                
        
    }
 
    public static void main(String[] args) throws IOException
    {
       Game game = new Game();
       game.setVisible(true);
        //menu();
    }
    
}
