import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KAROL
 */
public class top {
   
    private static JFrame frame;
    private static boolean jogando;
    
    private static void extensao(){
        
        frame = new JFrame("I N V E R T E D  G A M E ");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        
        MenuPrincipal mp= new MenuPrincipal(frame);
        mp.requestFocusInWindow();
        
        frame.getContentPane().add(mp);
        frame.setSize(760, 428);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }
    
    
     private static void launch() {
    
        reprinta();
    }
    
    public static void reprinta(){
        while(true){
            frame.repaint();
                        
        }
    }
    
    public static void main(String args[]){
        
        extensao();
        reprinta();
        
    }
}
