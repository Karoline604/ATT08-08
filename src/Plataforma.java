
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KAROL
 */
public class Plataforma extends Objeto{
    
    private static final long serialVersionUID = 1L;
    String []a ;
    private BufferedImage plataforma;
    int x,y,largura, altura;
    
    public Plataforma(int x, int y, int largura, int altura, int velc_x, int velc_y, boolean ativo, String n1){
        super(x,y,largura,altura,velc_x,velc_y, ativo);
        
        a=n1.split(" ");
        x=Integer.parseInt(a[0]);
        y=Integer.parseInt(a[1]);
        largura=Integer.parseInt(a[2]);
        altura=Integer.parseInt(a[3]);
        
        try{
            plataforma =ImageIO.read(new FileInputStream("src/imagens/plataforma.png"));
    
        }catch(Exception e){
            e.printStackTrace();
        }
    
        
    }       
    
    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(plataforma, x, y, largura, altura, null);
    }
}