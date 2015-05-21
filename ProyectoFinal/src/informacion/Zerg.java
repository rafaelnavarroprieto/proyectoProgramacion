/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informacion;

import java.io.Serializable;

/**
 * Clase hija de Zerg
 *
 * @author Rafael Navarro Prieto
 * @version 1.0
 */
public class Zerg extends Unidad implements Serializable {
	/**
	 * Estadistica unica de la raza
	 */
	private static float statRaza = 0.3f;
	
    /**
	 * @return the statRaza
	 */
	public static float getStatRaza() {
		return statRaza;
	}
	/**
     * Campo que contiene la regeneraci�n de vida
     */
    private float regeneracionDeVida;
    /**
     * M�todo get del campo regeneracionDeVida
     *
     * @return devuelve la regeneraci�n de vida
     */
    public float getRegeneracionDeVida() {
        return regeneracionDeVida;
    }
    /**
     * M�todo set de la regeneracionDeVida
     *
     * @param regeneracionDeVida regeneraci�n de vida
     */
    public void setRegeneracionDeVida(float regeneracionDeVida) {
        this.regeneracionDeVida = regeneracionDeVida;
    }

    /**
     * Constructor
     *
     * @param nombre nombre de la unidad
     * @param tipo tipo de la unidad
     * @throws NombreNoValidoException excepci�n que salta cuando el nombre no
     * es v�lido
     */
    public Zerg(String nombre, Tipo tipo) throws NombreNoValidoException {
        super(nombre, tipo);
        switch (tipo) {
            case LIGERA:
                setRegeneracionDeVida(20.5f);
                break;
            case MEDIANA:
                setRegeneracionDeVida(10.5f);
                break;
            case PESADA:
                setRegeneracionDeVida(5.5f);
                break;
        }
    }

    /**
     * M�todo que hace regenerar la vida de la unidad zerg
     */
    public void regenerarVida() {
        super.vida += getRegeneracionDeVida();
    }

    /**
     * M�todo que calcula la vida de la unidad en funci�n al tipo de unidad y el
     * azar
     *
     * @param tipo tipo de la unidad
     * @return devuelve la vida final de la unidad
     */
    @Override
    public float calcularVida(Tipo tipo) {
        float resultado;
        int bonificador;
        switch (tipo) {
            case LIGERA:
			return realizarOperacionCalcularVida(tipo,4,2,getStatRaza());
            case MEDIANA:
    			return realizarOperacionCalcularVida(tipo,6,3,getStatRaza());

            case PESADA:
    			return realizarOperacionCalcularVida(tipo,5,3,getStatRaza());

        }
        return 0;
    }
    /**
	 * Realiza los calculos para dar la vida final de la unidad
	 * 
	 * @param tipo
	 *            tipo de unidad
	 * @param max
	 *            valor m�ximo de la bonificaci�n por tipo
	 * @param min
	 *            valor m�nimo de la bonificaci�n por tipo
	 * @param statRaza
	 *            bonificaci�n de la raza
	 */
	private float realizarOperacionCalcularVida(Tipo tipo, int max ,int min , float statRaza) {
		float resultado;
		int bonificador;
		bonificador = (int) (Math.random() * max + min);
		resultado = Math.round(((tipo.getVida() *(bonificador * statRaza))*3) * 100) / 100;
		return resultado;
	}

    /**
     * M�todo que calcula el ataque de la unidad segun el tipo de unidad y el
     * azar
     *
     * @param tipo tipo de unidad
     * @return devuelve el ataque final de la unidad
     */
    @Override
    public float calcularAtaque(Tipo tipo) {
        float resultado;
        int bonificador;
        switch (tipo) {
            case LIGERA:
			return realizarOperacionCalcularAtaque(tipo,3,2,getStatRaza());
            case MEDIANA:
    			return realizarOperacionCalcularAtaque(tipo,4,2,getStatRaza());

            case PESADA:
    			return realizarOperacionCalcularAtaque(tipo,5,3,getStatRaza());

        }
        return 0;
    }
	/**
	 * Realiza los calculos para designar el ataque de la unidad
	 * 
	 * @param tipo
	 *            tipo de unidad
	 * @param max
	 *            valor m�ximo para la bonificaci�n por tipo
	 * @param min
	 *            valor m�nimo para la bonificaci�n por tipo
	 * @param statRaza
	 *            valor unico de la raza
	 * @return devuelve la estadistica ataque ya final para asignarse
	 */
	private float realizarOperacionCalcularAtaque(Tipo tipo, int max, int min, float statRaza) {
		float resultado;
		int bonificador;
		bonificador = (int) (Math.random() * max + min);
		resultado = Math.round(((tipo.ataque * (bonificador * statRaza)*3) * 100) / 100);
		return resultado;
	}
    /**
     * Ataque avanzado
     * @return devuelve el da�o realizado
     */
    public float ataqueAvanzado() {
        float danio;
        int probabilidadDeGolpe;
        switch (getTipo()) {
            case LIGERA:
    			return realizarAtaque(0.5f, 3, 2);
            case MEDIANA:
    			return realizarAtaque(0.5f, 4, 2);

            case PESADA:
    			return realizarAtaque(0.5f, 6, 3);

            default:
                danio = 0;
                break;
        }
        return danio;
    }
	/**
	 * Realizael calculo final del da�o que realizara
	 * 
	 * @param potenciaAtaque
	 *            cuantificador que aumenta el ataque
	 * @param max
	 *            valor m�ximo de probabilidad por tipo
	 * @param min
	 *            valor m�mino de probabilidad por tipo
	 * @return devuelve el da�o causado
	 */
	private float realizarAtaque(float potenciaAtaque, int max, int min) {
		float danio;
		int probabilidadDeGolpe;
		probabilidadDeGolpe = (int) (Math.random() * 10 + 1);
		if (probabilidadDeGolpe > getTipo().getpGolpe()) {
		    danio = 0;
		} else {
		    danio = Math.round(((getAtaque()* potenciaAtaque/ getStatRaza()) * (int) (Math.random() * max + min) * 100) / 100);
		}
		return danio;
	}
    /**
     * Ataque medio
     * @return devuelve el da�o realizado
     */
    @Override
    public float ataqueMedio() {
        float danio;
        switch (getTipo()) {
            case LIGERA:
    			return realizarAtaque(0.3f, 3, 2);
            case MEDIANA:
    			return realizarAtaque(0.3f, 4, 2);

            case PESADA:
    			return realizarAtaque(0.3f, 6, 3);

            default:
                danio = 0;
                break;
        }
        return danio;
    }
    /**
     * Ataque b�sico
     * @return devuelve el da�o realizado
     */
    @Override
    public float ataqueBasico() {
        float danio;
        switch (getTipo()) {
            case LIGERA:
    			return realizarAtaque(0.2f, 3, 2);
            case MEDIANA:
    			return realizarAtaque(0.2f, 4, 2);

            case PESADA:
    			return realizarAtaque(0.2f, 6, 3);

            default:
                danio = 0;
                break;
        }
        return danio;
    }

}
