
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KAROL
 */
public class Chao extends Objeto{

    private BufferedImage chao;
    
    public Chao(int x, int y, int largura, int altura, int velc_x, int velc_y, boolean ativo) {
        super(x, y, largura, altura, velc_x, velc_y, ativo);
        
        try{
            chao= ImageIO.read(new File("src/imagens/chao.png"));
            
            }catch(Exception e){
                e.printStackTrace();
            }
    }
    
    public void draw(Graphics g){
        
        Graphics2D g2d = (Graphics2D) g;
   
        g2d.drawImage(chao,getX(),getY(),getLargura(), getAltura(), null);
    }
    
}
