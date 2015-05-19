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
     * Método set del campo escudo
     *
     * @param escudo escudo de la unidad
     */
    public void setEscudo(float escudo) {
        this.escudo = escudo;
    }

    /**
     * Método set del campo regenerable
     *
     * @param regenerable campo que determina si el escudo se regenera o no se
     * regenera
     */
    public void setRegenerable(boolean regenerable) {
        this.regenerable = regenerable;
    }

    /**
     * Método set del campo regeneracionDeEscudo
     *
     * @param regeneracionDeEscudo campo que especifica cuanto se regenera
     */
    public void setRegeneracionDeEscudo(float regeneracionDeEscudo) {
        this.regeneracionDeEscudo = regeneracionDeEscudo;
    }

    /**
     * Método get del campo escudo
     *
     * @return devuelve el escudo de la unidad
     */
    public float getEscudo() {
        return escudo;
    }

    /**
     * Método get del campo regenerable
     *
     * @return devuelve true si el escudo puede regenerarse o false si el escudo
     * no puede regenerarse
     */
    public boolean isRegenerable() {
        return regenerable;
    }

    /**
     * Método get del campo renegeracionDeEscudo
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
     * @throws NombreNoValidoException excepciï¿½n que salta si el nombre no
     * cumple el patrón
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
     * Método para regenerar el escudo de las unidades
     */
    public void regenerarEscudo() {
        if (isRegenerable()) {
            setEscudo(getEscudo() + getRegeneracionDeEscudo());
        }
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
                bonificador = (int) (Math.random() * 4 + 2);
                resultado = Math.round((tipo.vida * (bonificador * 2) * 100) / 100);
                return resultado;
            case MEDIANA:
                bonificador = (int) (Math.random() * 6 + 4);
                resultado = Math.round((((tipo.vida * (bonificador * 3)) * 0.4f) * 100) / 100);
                return resultado;
            case PESADA:
                bonificador = (int) (Math.random() * 10 + 6);
                resultado = Math.round(((tipo.vida * (bonificador * 5)) * 0.1f * 100) / 100);
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
                resultado = Math.round((tipo.ataque * (bonificador * 0.7f) * 100) / 100);
                return resultado;
            case MEDIANA:
                bonificador = (int) (Math.random() * 2 + 1);
                resultado = Math.round((tipo.ataque * (bonificador * 0.7f) * 100) / 100);
                return resultado;
            case PESADA:
                bonificador = (int) (Math.random() * 2 + 1);
                resultado = Math.round((tipo.ataque * (bonificador * 0.7f) * 100) / 100);
                return resultado;
        }
        return 0;
    }
    /**
     * Ataque avanzado
     * @return devuelve el daño realizado
     */
    @Override
    public float ataqueAvanzado() {
        float danio;
        int probabilidadDeGolpe;
        switch (getTipo()) {
            case LIGERA:
                probabilidadDeGolpe = (int) (Math.random() * 10 + 1);
                if (probabilidadDeGolpe > 8) {
                    danio = 0;
                } else {
                    danio = Math.round(((getAtaque() / 0.5f) * (int) (Math.random() * 4 + 1) * 100) / 100);
                }
                break;
            case MEDIANA:
                probabilidadDeGolpe = (int) (Math.random() * 10 + 1);
                if (probabilidadDeGolpe > 6) {
                    danio = 0;
                } else {
                    danio = Math.round(((getAtaque() / 0.5f) * (int) (Math.random() * 5 + 1) * 100) / 100);
                }
                break;
            case PESADA:
                probabilidadDeGolpe = (int) (Math.random() * 10 + 1);
                if (probabilidadDeGolpe > 3) {
                    danio = 0;
                } else {
                    danio = Math.round(((getAtaque() / 0.6f) * (int) (Math.random() * 5 + 1) * 100) / 100);
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
                    danio = Math.round(((getAtaque() / 0.7f) * (int) (Math.random() * 4 + 1) * 100) / 100);
                }
                break;
            case MEDIANA:
                probabilidadDeGolpe = (int) (Math.random() * 10 + 1);
                if (probabilidadDeGolpe > 6) {
                    danio = 0;
                } else {
                    danio = Math.round(((getAtaque() / 0.7f) * (int) (Math.random() * 5 + 1) * 100) / 100);
                }
                break;
            case PESADA:
                probabilidadDeGolpe = (int) (Math.random() * 10 + 1);
                if (probabilidadDeGolpe > 3) {
                    danio = 0;
                } else {
                    danio = Math.round(((getAtaque() / 0.8f) * (int) (Math.random() * 5 + 1) * 100) / 100);
                }
                break;
            default:
                danio = 0;
                break;
        }
        return danio;    }
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
                    danio = Math.round(((getAtaque() / 1.0f) * (int) (Math.random() * 4 + 1) * 100) / 100);
                }
                break;
            case MEDIANA:
                probabilidadDeGolpe = (int) (Math.random() * 10 + 1);
                if (probabilidadDeGolpe > 6) {
                    danio = 0;
                } else {
                    danio = Math.round(((getAtaque() / 1.0f) * (int) (Math.random() * 5 + 1) * 100) / 100);
                }
                break;
            case PESADA:
                probabilidadDeGolpe = (int) (Math.random() * 10 + 1);
                if (probabilidadDeGolpe > 3) {
                    danio = 0;
                } else {
                    danio = Math.round(((getAtaque() / 1.0f) * (int) (Math.random() * 5 + 1) * 100) / 100);
                }
                break;
            default:
                danio = 0;
                break;
        }
        return danio;
    }

}
