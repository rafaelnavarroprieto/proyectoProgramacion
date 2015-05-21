/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informacion;

import java.io.Serializable;

/**
 * Clase hija Protos
 *
 * @author Rafael Navarro Prieto
 * @version 1.0
 */
public class Protos extends Unidad implements Serializable {

    /**
     * Escudo de las unidades
     */
    private float escudo;
    /**
     * Campo que controla si se regenera el escudo
     */
    private boolean regenerable = true;
    /**
     * Campo que especifica cuanto se regenera de escudo
     */
    private float regeneracionDeEscudo;
    /**
     * estadistica unica de la raza
     */
	private static float statRaza = 0.7f;
	
	
    /**
	 * @return the statRaza
	 */
	public float getStatRaza() {
		return statRaza;
	}

	/**
     * M�todo set del campo escudo
     *
     * @param escudo escudo de la unidad
     */
    public void setEscudo(float escudo) {
        this.escudo = escudo;
    }

    /**
     * M�todo set del campo regenerable
     *
     * @param regenerable campo que determina si el escudo se regenera o no se
     * regenera
     */
    public void setRegenerable(boolean regenerable) {
        this.regenerable = regenerable;
    }

    /**
     * M�todo set del campo regeneracionDeEscudo
     *
     * @param regeneracionDeEscudo campo que especifica cuanto se regenera
     */
    public void setRegeneracionDeEscudo(float regeneracionDeEscudo) {
        this.regeneracionDeEscudo = regeneracionDeEscudo;
    }

    /**
     * M�todo get del campo escudo
     *
     * @return devuelve el escudo de la unidad
     */
    public float getEscudo() {
        return escudo;
    }

    /**
     * M�todo get del campo regenerable
     *
     * @return devuelve true si el escudo puede regenerarse o false si el escudo
     * no puede regenerarse
     */
    public boolean isRegenerable() {
        return regenerable;
    }

    /**
     * M�todo get del campo renegeracionDeEscudo
     *
     * @return devuelve la regeneracionDeEscudo
     */
    public float getRegeneracionDeEscudo() {
        return regeneracionDeEscudo;
    }

    /**
     * Constructor
     *
     * @param nombre nombre de la unidad
     * @param tipo tipo de la unidad
     * @throws NombreNoValidoException excepci�n que salta si el nombre no
     * cumple el patr�n
     */
    public Protos(String nombre, Tipo tipo) throws NombreNoValidoException {
        super(nombre, tipo);
        setEscudo(getVida());
        switch (tipo) {
            case LIGERA:
                setRegeneracionDeEscudo(10.5f);
                break;
            case MEDIANA:
                setRegeneracionDeEscudo(2.5f);
                break;
            case PESADA:
                setRegeneracionDeEscudo(1.5f);
                break;
        }
    }

    /**
     * M�todo para regenerar el escudo de las unidades
     */
    public void regenerarEscudo() {
        if (isRegenerable()) {
            setEscudo(getEscudo() + getRegeneracionDeEscudo());
        }
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
            switch (tipo) {
            case LIGERA:
			return realizarOperacionCalculoVida(tipo,4,2,getStatRaza());
            case MEDIANA:
    			return realizarOperacionCalculoVida(tipo,6,4,getStatRaza());

            case PESADA:
    			return realizarOperacionCalculoVida(tipo,10,6,getStatRaza());

        }
        return 0;

    }
    /**
     * Realiza los calculos para dar la vida final de la unidad
     * @param tipo tipo de unidad
     * @param max valor m�ximo de la bonificaci�n por tipo
     * @param min valor m�nimo de la bonificaci�n por tipo
     * @param statRaza bonificaci�n de la raza
     * @return devuelve la cantidad total de vida que tendra la unidad
     */
	private float realizarOperacionCalculoVida(Tipo tipo, int max, int min,float statRaza) {
		float resultado;
		int bonificador;
		bonificador = (int) (Math.random() * max + min);
		resultado = Math.round(((tipo.getVida() * (bonificador * statRaza))/0.7 * 100) / 100);
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
       switch (tipo) {
            case LIGERA:
			return realizarOperaci�nCalcularAtaque(tipo,3,2,getStatRaza());
            case MEDIANA:
            	return realizarOperaci�nCalcularAtaque(tipo,4,3,getStatRaza());
            case PESADA:
            	return realizarOperaci�nCalcularAtaque(tipo,5,3,getStatRaza());
        }
        return 0;
    }
    /**
     * Realiza los calculos para designar el ataque de la unidad
     * @param tipo tipo de unidad
     * @param max  valor m�ximo para la bonificaci�n por tipo
     * @param min  valor m�nimo para la bonificaci�n por tipo
     * @param statRaza valor unico de la raza
     * @return devuelve la estadistica ataque ya final para asignarse
     */
	private float realizarOperaci�nCalcularAtaque(Tipo tipo, int max , int min, float statRaza) {
		float resultado;
		int bonificador;
		bonificador = (int) (Math.random() * max + min);
		resultado = Math.round((tipo.getAtaque() * (bonificador * statRaza) * 100) / 100);
		return resultado;
	}
    /**
     * Ataque avanzado
     * @return devuelve el da�o realizado
     */
    @Override
    public float ataqueAvanzado() {
        float danio;
        switch (getTipo()) {
            case LIGERA:
            	return danio = realizarAtaque(0.7f,4,1);
                
            case MEDIANA:
            	return danio = realizarAtaque(0.7f,5,1);
                
            case PESADA:
            	return	danio = realizarAtaque(0.7f,7,1);
               
            default:
              return  danio = 0;
                
        }
   
    }
    /**
     * Realizael calculo final del da�o que realizara
     * @param potenciaAtaque cuantificador que aumenta el ataque 
     * @param max valor m�ximo de probabilidad por tipo
     * @param min valor m�mino de probabilidad por tipo
     * @return devuelve el da�o causado
     */
	private float realizarAtaque(float potenciaAtaque ,int max,int min) {
		float danio;
		int probabilidadDeGolpe;
		probabilidadDeGolpe = (int) (Math.random() * 10 + 1);
		if (probabilidadDeGolpe > getTipo().getpGolpe()) {
		    danio = 0;
		} else {
		    danio = Math.round(((getAtaque() / getStatRaza()*potenciaAtaque)*0.7 * (int) (Math.random() * max + min) * 100) / 100);
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
 			danio = realizarAtaque(0.3f,4,1);
                 break;
             case MEDIANA:
             	danio = realizarAtaque(0.3f,5,1);
                 break;
             case PESADA:
             	danio = realizarAtaque(0.3f,7,1);
                 break;
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
 			danio = realizarAtaque(0.1f,4,1);
                 break;
             case MEDIANA:
             	danio = realizarAtaque(0.1f,5,1);
                 break;
             case PESADA:
             	danio = realizarAtaque(0.1f,7,1);
                 break;
             default:
                 danio = 0;
                 break;
         }
         return danio;
    }

}
