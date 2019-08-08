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

/**
 *
 * @author KAROL
 */
public class MenuPrincipal extends JPanel {

    private static final long serialVersionUID = 1L;
    
    private BufferedImage fundoP;
    
    private JFrame Pframe;
    private JButton Bjogar;
    private JButton Bperson;
    private JButton Bconfig;
    
    private ImageIcon imageJogarD;
    private ImageIcon imagePersonD;
    private ImageIcon imageConfigD;
    private ImageIcon imageJogarL;
    private ImageIcon imagePersonL;
    private ImageIcon imageConfigL;
            
    public MenuPrincipal(JFrame frame){
        
        Pframe=frame;
        
        setLayout(null);
        
        try{
            fundoP=ImageIO.read(new FileInputStream("src/imagens/fundoP.jpg"));
        }catch(Exception e){
           e.printStackTrace();
        }
    
    imageJogarD=new ImageIcon("src/imagens/jogarD.png");
    imagePersonD= new ImageIcon("src/imagens/personD.png");
    imageConfigD= new ImageIcon("src/imagens/configD.png");
    imageJogarL= new ImageIcon("src/imagens/jogarL.png");
    imagePersonL= new ImageIcon("src/imagens/personL.png");
    imageConfigL= new ImageIcon("src/imagens/configL.png");
    
    Bjogar= new JButton();
    Bperson= new JButton();
    Bconfig= new JButton();
    
    Bjogar.setBorderPainted(false);
    Bjogar.setContentAreaFilled(false);
    
    Bperson.setBorderPainted(false);
    Bperson.setContentAreaFilled(false);
    
    Bconfig.setBorderPainted(false);
    Bconfig.setContentAreaFilled(false);
    
    Bjogar.setIcon(imageJogarD);
    Bperson.setIcon(imagePersonD);
    Bconfig.setIcon(imageConfigD);
    
    Bjogar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Pframe.getContentPane().removeAll();
                
                Level1 pf= new Level1(frame);
                
                Pframe.getContentPane().add(pf);
                
                pf.requestFocusInWindow();
                
            }
        
    });
    
    
    Bperson.addActionListener(new ActionListener (){
        
        @Override
        public void actionPerformed(ActionEvent e) {

        //remove
        Pframe.getContentPane().removeAll();
        
        //cria um novo
        MenuPersonagens mp= new MenuPersonagens();
        //adiciona
        Pframe.getContentPane().add(mp);
        
        //foca
        mp.requestFocusInWindow();
        
        }
        
    });
    
    Bconfig.addActionListener(new ActionListener (){
        
        @Override
        public void actionPerformed(ActionEvent ae) {
             
        //remove
        Pframe.getContentPane().removeAll();
        
        //cria um novo
        MenuConfiguracoes mc= new MenuConfiguracoes(Pframe);
        //adiciona
        Pframe.getContentPane().add(mc);
        
        //foca
        mc.requestFocusInWindow();
                
        }
       
    });
    
    Bjogar.addMouseListener(new MouseListener(){
            @Override
            public void mouseEntered(MouseEvent me) {
                
               Bjogar.setIcon(imageJogarL);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                Bjogar.setIcon(imageJogarD);
            }

            @Override
            public void mouseClicked(MouseEvent me) {
                
            }
            

            @Override
            public void mousePressed(MouseEvent me) {
                
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                
            }
        
        
    });
    
    Bperson.addMouseListener(new MouseListener(){
            @Override
            public void mouseEntered(MouseEvent me) {
                
               Bperson.setIcon(imagePersonL);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                Bperson.setIcon(imagePersonD);
            }

            @Override
            public void mouseClicked(MouseEvent me) {
                
            }

            @Override
            public void mousePressed(MouseEvent me) {
                
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                
            }
        
        
    });
    
        Bconfig.addMouseListener(new MouseListener(){
            @Override
            public void mouseEntered(MouseEvent me) {
                
               Bconfig.setIcon(imageConfigL);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                Bconfig.setIcon(imageConfigD);
            }

            @Override
            public void mouseClicked(MouseEvent me) {
                
            }

            @Override
            public void mousePressed(MouseEvent me) {
                
            }

            @Override
            public void mouseReleased(MouseEvent me) {
             
            }
        
    });
    
    // Posicionando os botões
        Bjogar.setBounds(250, 120, 219, 48);
        Bperson.setBounds(250, 205, 219, 48);
        Bconfig.setBounds(250, 285, 219, 48);

        // Adicionando Componentes ao Painel
        add(Bjogar);
        add(Bperson);
        add(Bconfig);

        // Configurações Finais do Painel
        setSize(760, 428);
        setVisible(true);
    
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(fundoP, 0, 0, getWidth()-10, getHeight()-25, null);
    }
}
