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
     * Campo que contiene la regeneración de vida
     */
    private float regeneracionDeVida;

    /**
     * Método get del campo regeneracionDeVida
     *
     * @return devuelve la regeneración de vida
     */
    public float getRegeneracionDeVida() {
        return regeneracionDeVida;
    }

    /**
     * Método set de la regeneracionDeVida
     *
     * @param regeneracionDeVida regeneración de vida
     */
    public void setRegeneracionDeVida(float regeneracionDeVida) {
        this.regeneracionDeVida = regeneracionDeVida;
    }

    /**
     * Constructor
     *
     * @param nombre nombre de la unidad
     * @param tipo tipo de la unidad
     * @throws NombreNoValidoException excepción que salta cuando el nombre no
     * es válido
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
     * Método que hace regenerar la vida de la unidad zerg
     */
    public void regenerarVida() {
        super.vida += getRegeneracionDeVida();
    }

    /**
     * Método que calcula la vida de la unidad en función al tipo de unidad y el
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
                bonificador = (int) (Math.random() * 3 + 1);
                resultado = Math.round((tipo.vida * (bonificador * 2.5f) * 100) / 100);
                return resultado;
            case MEDIANA:
                bonificador = (int) (Math.random() * 4 + 3);
                resultado = Math.round((tipo.vida * (bonificador * 2.2f) * 100) / 100);
                return resultado;
            case PESADA:
                bonificador = (int) (Math.random() * 4 + 3);
                resultado = Math.round(((tipo.vida * (bonificador * 3) * 0.4f) * 100) / 100);
                return resultado;
        }
        return 0;
    }

    /**
     * Método que calcula el ataque de la unidad segun el tipo de unidad y el
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
                bonificador = (int) (Math.random() * 3 + 2);
                resultado = Math.round((tipo.ataque * (bonificador * 0.3f) * 100) / 100);
                return resultado;
            case MEDIANA:
                bonificador = (int) (Math.random() * 3 + 2);
                resultado = Math.round((tipo.ataque * (bonificador * 0.2f) * 100) / 100);
                return resultado;
            case PESADA:
                bonificador = (int) (Math.random() * 4 + 2);
                resultado = Math.round((tipo.ataque * (bonificador * 0.3f) * 100) / 100);
                return resultado;
        }
        return 0;
    }
    /**
     * Ataque avanzado
     * @return devuelve el daño realizado
     */
    public float ataqueAvanzado() {
        float danio;
        int probabilidadDeGolpe;
        switch (getTipo()) {
            case LIGERA:
                probabilidadDeGolpe = (int) (Math.random() * 10 + 1);
                if (probabilidadDeGolpe > 8) {
                    danio = 0;
                } else {
                    danio = Math.round(((getAtaque() / 1.5f) * (int) (Math.random() * 3 + 1) * 100) / 100);
                }
                break;
            case MEDIANA:
                probabilidadDeGolpe = (int) (Math.random() * 10 + 1);
                if (probabilidadDeGolpe > 6) {
                    danio = 0;
                } else {
                    danio = Math.round(((getAtaque() / 1.5f) * (int) (Math.random() * 4 + 2) * 100) / 100);
                }
                break;
            case PESADA:
                probabilidadDeGolpe = (int) (Math.random() * 10 + 1);
                if (probabilidadDeGolpe > 3) {
                    danio = 0;
                } else {
                    danio = Math.round(((getAtaque() / 1.5f) * (int) (Math.random() * 4 + 2) * 100) / 100);
                }
                break;
            default:
                danio = 0;
                break;
        }
        return danio;
    }
    /**
     * Ataque medio
     * @return devuelve el daño realizado
     */
    @Override
    public float ataqueMedio() {
        float danio;
        int probabilidadDeGolpe;
        switch (getTipo()) {
            case LIGERA:
                probabilidadDeGolpe = (int) (Math.random() * 10 + 1);
                if (probabilidadDeGolpe > 8) {
                    danio = 0;
                } else {
                    danio = Math.round(((getAtaque() / 1.5f) * (int) (Math.random() * 3 + 1) * 100) / 100);
                }
                break;
            case MEDIANA:
                probabilidadDeGolpe = (int) (Math.random() * 10 + 1);
                if (probabilidadDeGolpe > 6) {
                    danio = 0;
                } else {
                    danio = Math.round(((getAtaque() / 1.5f) * (int) (Math.random() * 4 + 2) * 100) / 100);
                }
                break;
            case PESADA:
                probabilidadDeGolpe = (int) (Math.random() * 10 + 1);
                if (probabilidadDeGolpe > 3) {
                    danio = 0;
                } else {
                    danio = Math.round(((getAtaque() / 1.5f) * (int) (Math.random() * 4 + 2) * 100) / 100);
                }
                break;
            default:
                danio = 0;
                break;
        }
        return danio;
    }
    /**
     * Ataque básico
     * @return devuelve el daño realizado
     */
    @Override
    public float ataqueBasico() {
        float danio;
        int probabilidadDeGolpe;
        switch (getTipo()) {
            case LIGERA:
                probabilidadDeGolpe = (int) (Math.random() * 10 + 1);
                if (probabilidadDeGolpe > 8) {
                    danio = 0;
                } else {
                    danio = Math.round(((getAtaque() / 1.5f) * (int) (Math.random() * 3 + 1) * 100) / 100);
                }
                break;
            case MEDIANA:
                probabilidadDeGolpe = (int) (Math.random() * 10 + 1);
                if (probabilidadDeGolpe > 6) {
                    danio = 0;
                } else {
                    danio = Math.round(((getAtaque() / 1.5f) * (int) (Math.random() * 4 + 2) * 100) / 100);
                }
                break;
            case PESADA:
                probabilidadDeGolpe = (int) (Math.random() * 10 + 1);
                if (probabilidadDeGolpe > 3) {
                    danio = 0;
                } else {
                    danio = Math.round(((getAtaque() / 1.5f) * (int) (Math.random() * 4 + 2) * 100) / 100);
                }
                break;
            default:
                danio = 0;
                break;
        }
        return danio;
    }

}
