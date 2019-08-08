
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KAROL
 */
 public class Level1 extends JPanel {
    
    public ArrayList<Plataforma> plataformas= new ArrayList<>();
    Scanner file;
    String aux;
    private BufferedImage fundo;
    private Personagem personagem;
    private Plataforma plataforma;
    private Chao []chao= new Chao[5];
    private boolean[] controleDeTeclas = new boolean[4];
    private Thread colisao;
    private Thread controle;
    private JFrame frame;
    
    private boolean ligado;
    
    public Level1(JFrame frame){
        
        this.frame=frame;
        
        setLayout(null);
        
        try{
            fundo= ImageIO.read(new File("src/imagens/fase1.jpg"));
             
        }catch(Exception e){
            e.printStackTrace();
        }
        
        inicializa();
        inicializaPlataforma("posicao.txt");
        iniciaControle();
        setSize(760, 428);
        setVisible(true);
    }
    
    public void colisao(){
        colisao= new Thread(new Runnable(){
            @Override
            public void run() {
                while(isLigado()){
                    //if(Util.verificaColisao(personagem, plataforma)){
                        
                    //}
                }
            }
            
            
        });
        
        colisao.start();
    }
   
    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(fundo, 0, 0, getWidth()-10, getHeight()-25, null);
        
        personagem.draw(g);
        //plataforma.draw(g);
        
        for(int i=0; i<5; i++){
            chao[i].draw(g);
        }
    }
    
    public void inicializa(){
       
        personagem= new Personagem(20, 211, 71, 110, 2,2, true);
        
        for (int i = 0, x = 0; i < 5; i++) {
            chao[i] = new Chao(x, 323, 150, 75,5,5, true);
            x += 150;
        }
        
        setLigado(true);
    }
    
    public void inicializaPlataforma(String arqs){
        
        try{
            file= new Scanner(new File(arqs));
        }catch(Exception e){
            e.printStackTrace();
        }
        while(true){
            try{
                aux=file.nextLine();
                System.out.println(aux);
            }catch(Exception e){
                break;
            }
            plataformas.add(new Plataforma(50, 50, 95, 20,5,5, true, aux));
        }
    }
    
    public void movimenta(int x, int y){
        for(int i=0;i<plataformas.size();i++){
            plataformas.get(i).x+=x;
            plataformas.get(i).y+=y;
        }
        
        addPlataforma();
    }
    
    public void addPlataforma(){
        Graphics g = null;
        for(Plataforma x: plataformas){
             x.draw(g);
        }
    }
    private void iniciaControle() {

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                setKey(e.getKeyCode(), true);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                setKey(e.getKeyCode(), false);
                personagem.imagemAtual();
            }
        });

        controle = new Thread(new Runnable() {
            @Override
            public void run() {
                
                while (isLigado()) {

                    if (controleDeTeclas[0] && personagem.getX() > 0) {
                        personagem.moverParaEsquerda(); 
                    }
                    if (controleDeTeclas[1] && personagem.getLargura() + personagem.getX() <= getWidth()-26) {
                        personagem.moverParaDireita();
                    }
                    if(controleDeTeclas[2] && personagem.getY() <= 211){
                        personagem.moverParaBaixo();
                    }
                    if(controleDeTeclas[3] && personagem.getAltura() + personagem.getY() <= getHeight()){
                        personagem.moverParaCima();
                    }
                    Util.gameFrameLimiter(30);
                }
            }

        });

        controle.start();
    }
    
    public void setKey(int key, boolean status) {
        switch (key) {
            
            case KeyEvent.VK_LEFT:
                controleDeTeclas[0] = status;
                break;
            case KeyEvent.VK_RIGHT:
                controleDeTeclas[1] = status;
                break;
            case KeyEvent.VK_DOWN:
                controleDeTeclas[2] = status;
                break;
            case KeyEvent.VK_UP:
                controleDeTeclas[3] = status;
                break;
        }
    }
   
}
