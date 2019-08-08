
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KAROL
 */
public class Personagem extends Objeto{
    
    private BufferedImage parado, paradoInverso, pulo;
    private BufferedImage atual;
    private BufferedImage hopper[]= new BufferedImage[6];
    private BufferedImage hopperInvertido[]= new BufferedImage[6];
    private boolean direcao = true;
    private int cont;
    private int gravidade;
    private boolean pulou;
    private int dx, dy;
    
    private static final int CHAO = 211;
    private static final int MAXALTURAPULO = 600;
    
    public Personagem(int x, int y, int largura, int altura, int velc_x, int velc_y, boolean ativo) {
        super(x, y, largura, altura, velc_x, velc_y, ativo);
        
        try{
            for(int i=0;i<6;i++){
                hopper[i]=ImageIO.read(new FileInputStream("src/imagens/run (" + (i+1) + ").png") );
                hopperInvertido[i]=ImageIO.read(new FileInputStream("src/imagens/runInvertido ("+ (i+1) + ").png"));
                pulo=ImageIO.read(new FileInputStream("src/imagens/run (2).png"));
            }
            
            parado= ImageIO.read(new File("src/imagens/run (1).png"));
            paradoInverso= ImageIO.read(new File("src/imagens/paradoInverso.png"));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        pulou = false;
        gravidade = 1;
        atual = parado;
    }
    
    @Override
    public void moverParaDireita(){
        if(!(x+largura> 850)){
            x+=velc_x;
            direcao = true;
            if (cont < 6) {
                atual = hopper[cont];
                cont++;
            } else {
                cont = 0;
            }
            
        }
    }
    
    @Override
    public void moverParaEsquerda(){
        if(!(x<0)){
            x-=velc_x;
            direcao = false;
            if(cont<6){
                atual=hopperInvertido[cont];
                cont++;
            }else{
                cont=0;
            }
        }
    }
    
    @Override
    public void moverParaCima(){
        if(y<MAXALTURAPULO){
            atual=pulo;
            y-=velc_y;
            
        }
    }
    
    @Override
    public void moverParaBaixo(){
        if(y<CHAO){
            atual=parado;
            while(y!=CHAO){
                y+=velc_y;
        }
      }
    }
    
    public void imagemAtual(){
        if (direcao)atual= parado;
        else atual = paradoInverso;
    }
    
    public void draw(Graphics g){
        g.drawImage(atual, x, y, largura, altura, null);
    }
}
    