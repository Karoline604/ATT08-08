/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KAROL
 */
public class  Util {
    
    public static final int LARGURA_TELA = 760;
    public static final int ALTURA_TELA = 428;
    
    /**
     * Método que verifica se houve colisão entre dois objetos.
     * 
     * @param a => Objeto A
     * @param b => Objeto B
     * @return true => Se houve colisão.
     * @return false => Se não houve colisão.
     */
    public static boolean verificaColisao(Objeto a, Objeto b) {

        // Plano de colisao X
        int aPlanoDeColisaoLargura = a.getX() + a.getLargura();
        int bPlanoDeColisaoLargura = b.getX() + b.getLargura();

        // Plano de colisao Y
        int aPlanoDeColisaoAltura = a.getY() + a.getAltura();
        int bPlanoDeColisaoAltura = b.getY() + b.getAltura();

        // Verifica se houve colisão
        if ((a.getX() >= b.getX() && a.getX() <= bPlanoDeColisaoLargura
                || b.getX() >= a.getX() && b.getX() <= aPlanoDeColisaoLargura)
                && (a.getY() >= b.getY() && a.getY() <= bPlanoDeColisaoAltura
                || b.getY() >= a.getY() && b.getY() <= aPlanoDeColisaoAltura)) {
            return true;
        }

        return false;
    }
    
    /**
     * Método responsável por limitar o número de frames por segundo.
     *
     * @param FPS => Quantidade de Frames por Segundo
     */
    public static void gameFrameLimiter(int FPS) {

        int limit = 1000 / FPS; // Cálculo do FPS

        try {
            Thread.sleep(limit);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

    
    

