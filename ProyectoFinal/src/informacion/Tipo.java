/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informacion;

/**
 * Enumeración que contiene los diferentes tipos de unidades con su
 * correspondiente vida y ataque base
 *
 * @author Rafael Navarro Prieto
 * @version 1.0
 */
public enum Tipo {

    /**
     * Unidad ligera con 10 de vida base y 3 de ataque base
     */
    LIGERA(10, 3),
    /**
     * Unidad mediana con 20 de vida base y 8 de ataque base
     *
     */
    MEDIANA(20, 8),
    /**
     * Unidad pesada con 50 de vida base y 15 de ataque base
     *
     */
    PESADA(50, 15);
    /**
     * vida base
     */
    int vida;
    /**
     * ataque base
     */
    int ataque;
    /**
     * Constructor
     * @param vida vida base
     * @param ataque ataque base
     */
    Tipo(int vida, int ataque) {
        setVida(vida);
        setAtaque(ataque);
    }
    /**
     * Método get de la vida
     * @return devuelve la vida
     */
    public int getVida() {
        return vida;
    }
    /**
     * Método get del ataque
     * @return devuelve el ataque
     */
    public int getAtaque() {
        return ataque;
    }
    /**
     * Método set de la vida
     * @param vida vida del tipo
     */
    public void setVida(int vida) {
        this.vida = vida;
    }
    /**
     * Método set del ataque
     * @param ataque ataque del tipo3
     */
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

}
