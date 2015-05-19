/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informacion;

/**
 * Interfaz que contiene los ataques que pueden realizar las unidades
 * @author Rafael Navarro Prieto
 * @version 1.0
 */
public interface Combatible {
    /**
     * Ataque básico
     * @return devuelve el daño realizado
     */
    float ataqueBasico();
    /**
     * Ataque medio
     * @return devuelve el daño realizado
     */
     float ataqueMedio();
    /**
     * Ataque avanzado
     * @return devuelve el daño realizado
     */
    float ataqueAvanzado();
}
