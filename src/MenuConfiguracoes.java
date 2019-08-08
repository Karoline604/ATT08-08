
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */
public class MenuConfiguracoes extends JPanel {
    
    private JFrame frame;
    private BufferedImage fundoC;
    
    private boolean ligadoS=false;
    private boolean ligadoM=false;
    
    private JButton Bmusica;
    private JButton Bsom;
    private JButton Bvoltar;
    
    private ImageIcon imageMusica;
    private ImageIcon imageSom;
    private ImageIcon imageVoltar;
    private ImageIcon imageSomL;
    private ImageIcon imageMusicaL;
    
    public MenuConfiguracoes(JFrame frame){
    
        this.frame=frame;
        
        setLayout(null);
   
        try {
            fundoC = ImageIO.read(new FileInputStream("src/imagens/fundoConfig.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        imageMusica= new ImageIcon("src/imagens/musicaD.png");
        imageSom= new ImageIcon ("src/imagens/somD.png");
        imageVoltar= new ImageIcon("src/imagens/seta.png");
        imageSomL= new ImageIcon("src/imagens/somL.png");
        imageMusicaL= new ImageIcon("src/imagens/musicaL.png");
        
        Bmusica= new JButton();
        Bsom= new JButton();
        Bvoltar= new JButton();
        
        Bmusica.setBorderPainted(false);
        Bmusica.setContentAreaFilled(false);
        
        Bsom.setBorderPainted(false);
        Bsom.setContentAreaFilled(false);
        
        Bvoltar.setBorderPainted(false);
        Bvoltar.setContentAreaFilled(false);
        
        Bmusica.setIcon(imageMusica);
        Bsom.setIcon(imageSom);
        Bvoltar.setIcon(imageVoltar);
        
        Bmusica.addActionListener(new ActionListener () {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
        
        });
        
        Bsom.addActionListener(new ActionListener (){
                @Override
                public void actionPerformed(ActionEvent e) {

                }
    
        });
        
        Bvoltar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                    frame.getContentPane().removeAll();

                    MenuPrincipal mp= new MenuPrincipal(frame);

                    frame.getContentPane().add(mp);

                    mp.requestFocusInWindow();
            }
            
            
        });
        
        Bsom.addMouseListener( new MouseListener (){
            @Override
            public void mouseClicked(MouseEvent me) {
                if(ligadoS==false){
                    Bsom.setIcon(imageSomL);
                    ligadoS=true;
                }else
                    if(ligadoS==true){
                        Bsom.setIcon(imageSom);
                        ligadoS=false;
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }
            @Override
            public void mouseReleased(MouseEvent me){ 
            }
            @Override
            public void mouseEntered(MouseEvent me) {   
            }
            @Override
            public void mouseExited(MouseEvent me) {
            }
           
        });
        
        Bmusica.addMouseListener( new MouseListener (){
            @Override
            public void mouseClicked(MouseEvent me) {
                if(ligadoM==false){
                    Bmusica.setIcon(imageMusicaL);
                    ligadoM=true;
                }else
                    if(ligadoM==true){
                        Bmusica.setIcon(imageMusica);
                        ligadoM=false;
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {                
            }
            @Override
            public void mouseReleased(MouseEvent me) {                
            }
            @Override
            public void mouseEntered(MouseEvent me) {
            }
            @Override
            public void mouseExited(MouseEvent me) {   
            }
            
        });
        
            
            Bsom.setBounds(420,80, 50, 30);
            Bmusica.setBounds(420, 139, 50, 30);
            Bvoltar.setBounds(50, 50, 50,38);
            
            add(Bsom);
            add(Bmusica);
            add(Bvoltar);

            setSize(760, 428);
            setVisible(true);
               
    }
    
   
    @Override
    public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(fundoC, 0, 0, getWidth()-10, getHeight()-30, null);
        }
    
}
