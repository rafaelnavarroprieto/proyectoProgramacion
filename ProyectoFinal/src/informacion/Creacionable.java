/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informacion;

/**
 * Interfaz que calcula los parametros de creación
 * @author Rafael Navarro Prieto
 * @version 1.0
 */
public  interface Creacionable {
    /**
     * Método que calcula la vida 
     * @param tipo tipo de unidad
     * @return devuelve una cantidad de vida de tipo float
     */
      float calcularVida(Tipo tipo);
      /**
       * Método que calcula el ataque
       * @param tipo tipo de unidad
       * @return devuelve una cantidad de ataque de tipo float
       */
      float calcularAtaque(Tipo tipo);
}
