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
     * Constructor
     *
     * @param nombre nombre de la unidad
     * @param tipo tipo de la unidad
     * @throws NombreNoValidoException excepción que salta cuando el nombre no
     * es válido
     */
    public Terran(String nombre, Tipo tipo) throws NombreNoValidoException {
        super(nombre, tipo);
    }

    /**
     * Método get del campo habUtilizada
     *
     * @return devuelve true si la habilidad ya fue usada o false si la
     * habilidad no fue usada
     */
    public boolean isHabUtilizada() {
        return habUtilizada;
    }

    /**
     * Método set del campo habUtilizada
     *
     * @param habUtilizada campo booleano que controla el uso de la habilidad
     */
    public void setHabUtilizada(boolean habUtilizada) {
        this.habUtilizada = habUtilizada;
    }

    /**
     * Método que ejecuta la habilidad de los terran
     */
    public void usarStimpack() {
        if (!isHabUtilizada()) {
            super.vida *= 0.5f;
            super.ataque *= 2;
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
                bonificador = (int) (Math.random() * 4 + 3);
                resultado = Math.round((tipo.vida * (bonificador * 2.5f)*100)/100);
                return resultado;
            case MEDIANA:
                bonificador = (int) (Math.random() * 6 + 4);
                resultado = Math.round((((tipo.vida * (bonificador * 2.5f))*0.5)*100)/100);
                return resultado;
            case PESADA:
                bonificador = (int) (Math.random() * 2 + 1);
                resultado = Math.round(((tipo.vida * (bonificador * 4) * 0.3f)*100)/100);
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
                bonificador = (int) (Math.random() * 3 + 1);
                resultado = Math.round((tipo.ataque * (bonificador * 0.5f)*100)/100);
                return resultado;
            case MEDIANA:
                bonificador = (int) (Math.random() * 4 + 2);
                resultado = Math.round((tipo.ataque * (bonificador * 0.3f)*100)/100);
                return resultado;
            case PESADA:
                bonificador = (int) (Math.random() * 4 + 3);
                resultado = Math.round((tipo.ataque * (bonificador * 0.3f)*100)/100);
                return resultado;
        }
        return 0;
    }
    /**
     * Método que prueba la comunicación con el objeto
     * @return devuelve un número que simula el daño que realiza la unidad
     */
      @Override
    public float test() {
        float danio;
        int probabilidadDeGolpe;
        switch(getTipo()){
           case LIGERA:
               probabilidadDeGolpe = (int) (Math.random()*10 +1);
               if (probabilidadDeGolpe > 8) {
                   danio = 0;
               }else{
               danio = Math.round(((getAtaque() / 1.1f)*(int)(Math.random()*3+1)*100)/100);
               }
               break;
           case MEDIANA:
               probabilidadDeGolpe = (int) (Math.random()*10 +1);
               if (probabilidadDeGolpe >6) {
                   danio = 0;
               }else{
               danio = Math.round(((getAtaque() / 1.1f)*(int)(Math.random()*4+1)*100)/100);
               }
               break;
           case PESADA:
               probabilidadDeGolpe = (int) (Math.random()*10 +1);
               if (probabilidadDeGolpe > 3) {
                   danio = 0;
               }else{
               danio = Math.round(((getAtaque() / 1.1f)*(int)(Math.random()*4+1)*100)/100);
               }
               break;
               default:
                   danio = 0;
                   break;
        }
        return danio;
    }

}
