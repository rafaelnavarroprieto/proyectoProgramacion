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
	 * Unidad ligera con 10 de vida base , 3 de ataque base y 8 de probabilidad
	 * de golpear
	 */
	LIGERA(10, 3, 8),
	/**
	 * Unidad mediana con 20 de vida base , 8 de ataque base y 6 de probabilidad
	 * de golpear
	 *
	 */
	MEDIANA(20, 8, 6),
	/**
	 * Unidad pesada con 50 de vida base , 15 de ataque base y 3 de probabilidad
	 * de golpear
	 *
	 */
	PESADA(50, 15, 3);
	/**
	 * vida base
	 */
	int vida;
	/**
	 * ataque base
	 */
	int ataque;
	/**
	 * 
	 */
	int pGolpe;

	/**
	 * Constructor
	 * 
	 * @param vida
	 *            vida base
	 * @param ataque
	 *            ataque base
	 * @param pGolpe
	 *            probabilidad de golpear
	 */
	Tipo(int vida, int ataque, int pGolpe) {
		setVida(vida);
		setAtaque(ataque);
		setpGolpe(pGolpe);
	}

	/**
	 * @return the pGolpe
	 */
	public int getpGolpe() {
		return pGolpe;
	}

	/**
	 * @param pGolpe
	 *            the pGolpe to set
	 */
	private void setpGolpe(int pGolpe) {
		this.pGolpe = pGolpe;
	}

	/**
	 * Método get de la vida
	 * 
	 * @return devuelve la vida
	 */
	public int getVida() {
		return vida;
	}

	/**
	 * Método get del ataque
	 * 
	 * @return devuelve el ataque
	 */
	public int getAtaque() {
		return ataque;
	}

	/**
	 * Método set de la vida
	 * 
	 * @param vida
	 *            vida del tipo
	 */
	public void setVida(int vida) {
		this.vida = vida;
	}

	/**
	 * Método set del ataque
	 * 
	 * @param ataque
	 *            ataque del tipo3
	 */
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

}
