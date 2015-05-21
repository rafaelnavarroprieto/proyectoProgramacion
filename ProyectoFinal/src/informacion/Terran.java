/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informacion;

import java.io.Serializable;

/**
 * Clase hija Terran
 *
 * @author Rafael Navarro Prieto
 * @version 1.0
 */
public class Terran extends Unidad implements Serializable {

	/**
	 * Campo que controla el uso de la habilidad
	 */
	private boolean habUtilizada = false;
	/**
	 * Estadistica unica de la raza
	 */
	private static float statRaza = 0.5f;

	/**
	 * @return the statRaza
	 */
	public float getStatRaza() {
		return statRaza;
	}

	/**
	 * Constructor
	 *
	 * @param nombre
	 *            nombre de la unidad
	 * @param tipo
	 *            tipo de la unidad
	 * @throws NombreNoValidoException
	 *             excepci�n que salta cuando el nombre no es v�lido
	 */
	public Terran(String nombre, Tipo tipo) throws NombreNoValidoException {
		super(nombre, tipo);
	}

	/**
	 * M�todo get del campo habUtilizada
	 *
	 * @return devuelve true si la habilidad ya fue usada o false si la
	 *         habilidad no fue usada
	 */
	public boolean isHabUtilizada() {
		return habUtilizada;
	}

	/**
	 * M�todo set del campo habUtilizada
	 *
	 * @param habUtilizada
	 *            campo booleano que controla el uso de la habilidad
	 */
	public void setHabUtilizada(boolean habUtilizada) {
		this.habUtilizada = habUtilizada;
	}

	/**
	 * M�todo que ejecuta la habilidad de los terran
	 */
	public void usarStimpack() {
		if (!isHabUtilizada()) {
			super.vida *= 0.5f;
			super.ataque *= 2;
		}
	}

	/**
	 * M�todo que calcula la vida de la unidad en funci�n al tipo de unidad y el
	 * azar
	 *
	 * @param tipo
	 *            tipo de la unidad
	 * @return devuelve la vida final de la unidad
	 */
	@Override
	public float calcularVida(Tipo tipo) {
		float resultado;
		int bonificador;
		switch (tipo) {
		case LIGERA:
			return realizarOperaci�nCalcularVida(tipo, 4, 3, getStatRaza());
		case MEDIANA:
			return realizarOperaci�nCalcularVida(tipo, 6, 3, getStatRaza());
		case PESADA:
			return realizarOperaci�nCalcularVida(tipo, 6, 4, getStatRaza());

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
	 * @return devuelve la cantidad final de vida que tiene la unidad
	 */
	private float realizarOperaci�nCalcularVida(Tipo tipo, int max, int min,
			float statRaza) {
		float resultado;
		int bonificador;
		bonificador = (int) (Math.random() * max + min);
		resultado = Math.round((tipo.getVida()
				* (Math.pow(bonificador * getStatRaza(), 2)) * 100) / 100);
		return resultado;
	}

	/**
	 * M�todo que calcula el ataque de la unidad segun el tipo de unidad y el
	 * azar
	 *
	 * @param tipo
	 *            tipo de unidad
	 * @return devuelve el ataque final de la unidad
	 */
	@Override
	public float calcularAtaque(Tipo tipo) {
		switch (tipo) {
		case LIGERA:
			return realizarOperaci�nCalcularAtaque(tipo, 3, 1, getStatRaza());
		case MEDIANA:
			return realizarOperaci�nCalcularAtaque(tipo, 4, 2, getStatRaza());
		case PESADA:
			return realizarOperaci�nCalcularAtaque(tipo, 5, 2, getStatRaza());

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
	private float realizarOperaci�nCalcularAtaque(Tipo tipo, int max, int min,
			float statRaza) {
		float resultado;
		int bonificador;
		bonificador = (int) (Math.random() * max + min);
		resultado = Math.round((tipo.getAtaque()
				* (Math.pow(bonificador * statRaza, 2) * 0.5f) * 100) / 100);
		return resultado;
	}

	/**
	 * Ataque avanzado
	 * 
	 * @return devuelve el da�o realizado
	 */
	@Override
	public float ataqueAvanzado() {
		float danio;
		switch (getTipo()) {
		case LIGERA:
			return realizarAtaque(0.6f, 3, 1);

		case MEDIANA:
			return realizarAtaque(0.6f, 4, 1);

		case PESADA:
			return realizarAtaque(0.6f, 5, 1);

		default:
			return danio = 0;

		}

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
			danio = Math.round((((getAtaque() / getStatRaza() * potenciaAtaque))	* (int) (Math.random() * max + min) * 100) / 100);
		}
		return danio;
	}

	/**
	 * Ataque medio
	 * 
	 * @return devuelve el da�o realizado
	 */
	@Override
	public float ataqueMedio() {
		float danio;
		switch (getTipo()) {
		case LIGERA:
			return realizarAtaque(0.35f, 3, 1);

		case MEDIANA:
			return realizarAtaque(0.35f, 4, 1);

		case PESADA:
			return realizarAtaque(0.35f, 5, 1);

		default:
			return danio = 0;

		}
	}

	/**
	 * Ataque b�sico
	 * 
	 * @return devuelve el da�o realizado
	 */
	@Override
	public float ataqueBasico() {
		float danio;
		switch (getTipo()) {
		case LIGERA:
			return realizarAtaque(0.15f, 3, 1);

		case MEDIANA:
			return realizarAtaque(0.15f, 4, 1);

		case PESADA:
			return realizarAtaque(0.15f, 5, 1);

		default:
			return danio = 0;

		}
	}

}
