/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackinggame;


import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author SCHOLES
 */
public class Game extends javax.swing.JFrame{
    public static ArrayList<String> dict = new ArrayList<String>();
    String correct;
    BufferedReader inTxt;
    String dictWord;
    public static ArrayList<String> pickedWords = new ArrayList<String>();
     ArrayList<String> PickedWords;
     int difficulty;
     int count;
     Boolean iscorrect;
     Random randomGenerator;
     Boolean ifcorrect;
     int randomInt;
     String correctword;
     int countgame;
     public static final String[] diffno = { "1","2","3","4","5"};
     public static final String[] yesno = {"Yes","No"};
     
    /**
     * Creates new form Game
     */
    public Game() {
        initComponents();
        ifcorrect = false;
        GuessTf.requestFocusInWindow();
        JFrame frame = new JFrame("Difficulty");
        String diff = (String) JOptionPane.showInputDialog(frame,
                "Choose difficulty", "Choose Difficulty",
                JOptionPane.QUESTION_MESSAGE,
                null,
                diffno,
                diffno[0]);
        difficulty = Integer.parseInt(diff);
        try{
        File inputFile = new File("C:\\words\\enable1.txt");
        FileInputStream fis = new FileInputStream(inputFile);
        inTxt = new BufferedReader(new java.io.InputStreamReader(fis));
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
        
        for(int m=0;m<PickedWords.size();m++)
        {
            int c=0;
            WordListTA.append(PickedWords.get(m)+"\t");
            c++;
            if(c%3==0){WordListTA.append("\n");}
        }
        randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(PickedWords.size()-1);
        correctword = PickedWords.get(randomInt);
        countgame = 4;
      
    }
    public void newGame(){
    JFrame frame = new JFrame("Play Again?");
        String again = (String) JOptionPane.showInputDialog(frame,
                "Play Again?", "Choose",
                JOptionPane.QUESTION_MESSAGE,
                null,
                yesno,
                yesno[0]);
        System.out.println(again);     
        if(again.equals("Yes"))
        {
            this.dispose();
            Game game = new Game();
            game.setVisible(true);
        }
        else if(again.equals("No")){System.exit(0);}
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        GuessTf = new javax.swing.JTextField();
        Infolb = new javax.swing.JLabel();
        EnterBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Countlb = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        WordListTA = new javax.swing.JTextArea();
        detailslb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 124, 72));

        GuessTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GuessTfKeyPressed(evt);
            }
        });

        Infolb.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        Infolb.setText("Enter Guess Below:");

        EnterBtn.setMnemonic('V');
        EnterBtn.setText("Enter");
        EnterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnterBtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel2.setText("Guesses Left");

        Countlb.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        Countlb.setForeground(new java.awt.Color(255, 0, 0));
        Countlb.setText("4");

        WordListTA.setBackground(new java.awt.Color(20, 124, 72));
        WordListTA.setColumns(5);
        WordListTA.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        WordListTA.setForeground(new java.awt.Color(255, 255, 255));
        WordListTA.setLineWrap(true);
        WordListTA.setRows(5);
        jScrollPane1.setViewportView(WordListTA);

        detailslb.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(GuessTf, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Infolb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Countlb)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(23, 23, 23))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(EnterBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(detailslb)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Infolb)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GuessTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Countlb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EnterBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(detailslb)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EnterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnterBtnActionPerformed
        // TODO add your handling code here:
        
        //int correctletters = 0;
        //Boolean correct = false;
        String guess = "";
        
       
        char[] correctarr = correctword.toCharArray();
        char[] guessarr;
        
        guess = GuessTf.getText().toString();
        int correctletters =0;
        if(guess.equals(correctword))
        {
            WordListTA.setText("Correct!!!");
            Font font = new Font("Calibri",Font.BOLD,24);
            WordListTA.setFont(font);
            newGame();
        }
        else
        {
            countgame--;
            if (countgame == 0)
            {
                //EnterBtn.setEnabled(false);
                WordListTA.setText("Game Over. The correct password was "+correctword);
                Font font = new Font("Calibri",Font.BOLD,24);
                WordListTA.setFont(font);
                newGame();
                
            }
            guessarr = guess.toCharArray();
            for(int i=0;i<guessarr.length;i++)
            {
                if(guessarr[i] == correctarr[i])
                {
                    
                    correctletters++;
                }
            }
            detailslb.setText("Incorrect. You got "+correctletters+" positions correct");
            Countlb.setText(""+countgame);
            GuessTf.setText("");
            GuessTf.requestFocusInWindow();
            
            
        }
        
      
        
    }//GEN-LAST:event_EnterBtnActionPerformed

    private void GuessTfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GuessTfKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
              String guess = "";
        
       
        char[] correctarr = correctword.toCharArray();
        char[] guessarr;
        
        guess = GuessTf.getText().toString();
        int correctletters =0;
        if(guess.equals(correctword))
        {
            WordListTA.setText("Correct!!!");
            Font font = new Font("Calibri",Font.BOLD,24);
            WordListTA.setFont(font);
            newGame();
        }
        else
        {
            countgame--;
            if (countgame == 0)
            {
                //EnterBtn.setEnabled(false);
                WordListTA.setText("Game Over. The correct password was "+correctword);
                Font font = new Font("Calibri",Font.BOLD,24);
                WordListTA.setFont(font);
                newGame();
                
            }
            guessarr = guess.toCharArray();
            for(int i=0;i<guessarr.length;i++)
            {
                if(guessarr[i] == correctarr[i])
                {
                    
                    correctletters++;
                }
            }
            detailslb.setText("Incorrect. You got "+correctletters+" positions correct");
            Countlb.setText(""+countgame);
            GuessTf.setText("");
            GuessTf.requestFocusInWindow();
            
            
        }
        }
    }//GEN-LAST:event_GuessTfKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Countlb;
    private javax.swing.JButton EnterBtn;
    private javax.swing.JTextField GuessTf;
    private javax.swing.JLabel Infolb;
    private javax.swing.JTextArea WordListTA;
    private javax.swing.JLabel detailslb;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

     
}
