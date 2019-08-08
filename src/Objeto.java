/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KAROL
 */
public abstract class Objeto {
    
    protected int x, y;
    protected int velc_x, velc_y;
    protected int largura, altura;
    protected boolean ativo;
    
    public Objeto(int x, int y, int largura, int altura, int velc_x, int velc_y, boolean ativo){
        
        this.x=x;
        this.y=y;
        this.velc_x=x;
        this.velc_y=y;
        this.largura=largura;
        this.altura=altura;
        this.ativo=ativo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVelc_x() {
        return velc_x;
    }

    public void setVelc_x(int velc_x) {
        this.velc_x = velc_x;
    }

    public int getVelc_y() {
        return velc_y;
    }

    public void setVelc_y(int velc_y) {
        this.velc_y = velc_y;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    public void moverParaCima(){
        
        y-=velc_y;
    }
    
    public void moverParaBaixo(){
        y+=velc_y;
    }
    
    public void moverParaDireita(){
        
        x+=velc_x;
    }
    
    public void moverParaEsquerda(){
        
        x-=velc_x;
    }
    
    public void moverParaCima(int v){
        
        y-=v;
    }
    
    public void moverParaBaixo(int v){
        
        y+=v;
    }
    
    public void moverParaDireita(int v){
        
        x+=v;
    }
    
    public void moverParaEsquerda(int v){
        
        x-=v;
    }
}
