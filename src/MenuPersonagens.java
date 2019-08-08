
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KAROL
 */
public class MenuPersonagens extends JPanel{
    
    private BufferedImage fundoPerson;
           
    private JButton Besquerda;
    private JButton Bdireita;
    private JButton Bevoluir;
    private JButton Bsair;
    
    private ImageIcon imageEsquerda;
    private ImageIcon imageDireita;
    private ImageIcon imageEvoluir;
    private ImageIcon imageSair;
    
    public MenuPersonagens (){
        
        setLayout(null);
        
        try{
            fundoPerson=ImageIO.read(new FileInputStream("src/imagens/fundoperson.jpg"));
        }catch(Exception e){
           e.printStackTrace();
        }
        
        imageEsquerda= new ImageIcon("src/imagens/butap.png");
        imageDireita= new ImageIcon("src/imagens/butap.png");
        imageEvoluir= new ImageIcon("src/imagens/butap.png");
        imageSair= new ImageIcon("src/imagens/butap.png");
        
        Besquerda= new JButton();
        Bdireita= new JButton();
        Bevoluir= new JButton();
        Bsair= new JButton();
        
        Besquerda.setBorderPainted(false);
        Besquerda.setContentAreaFilled(false);
        
        Bdireita.setBorderPainted(false);
        Bdireita.setContentAreaFilled(false);
        
        Bevoluir.setBorderPainted(false);
        Bevoluir.setContentAreaFilled(false);
        
        Bsair.setBorderPainted(false);
        Bsair.setContentAreaFilled(false);
        
        Besquerda.setIcon(imageEsquerda);
        Bdireita.setIcon(imageDireita);
        Bevoluir.setIcon(imageEvoluir);
        Bsair.setIcon(imageSair);
        
        Besquerda.addActionListener( new ActionListener (){

            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        });
        
        Bdireita.addActionListener( new ActionListener (){

            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        });
        
        Bevoluir.addActionListener( new ActionListener (){

            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        });
        
        Bsair.addActionListener( new ActionListener (){

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                //Remove
                
            }
        });
        
        Besquerda.setBounds(170, 190, 300, 50);
        Bdireita.setBounds(170, 270, 300, 50);
        Bevoluir.setBounds(170, 350, 300, 50);
        Bsair.setBounds(170, 430, 300, 50);
        
        add(Besquerda);
        add(Bdireita);
        add(Bevoluir);
        add(Bsair);
        
        setSize(760, 428);
        setVisible(true);
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(fundoPerson, 0, 0, getWidth()-10, getHeight()-30, null);
    }
    
}
