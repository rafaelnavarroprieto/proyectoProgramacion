/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informacion;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Emvoltorio de la lista que contendra las unidades y una serie de métodos
 * básicos:
 * <li>
 * <ol>Añadir</ol>
 * <ol>Eliminar</ol>
 * <ol>Devolver una unidad de la lista por el nombre</ol>
 * <ol>Devolver una lista con unidades por tipo de unidad</ol>
 * <ol>Devolver una lista con unidades por raza</ol>
 * </li>
 *
 * @author Rafael Navarro Prieto
 * @version 1.0
 */
public class Lista implements Serializable {

    /**
     * Lista que contendra las unidades
     */
    ArrayList<Unidad> lista = new ArrayList<Unidad>();
    
    /**
     * Método que añade una unidad a la lista
     *
     * @param nombre nombre de la unidad
     * @param tipo tipo de la unidad
     * @param raza raza de la unidad
     * @return devuelve true si la unidad se añadio con exito o lanzara un una
     * excepción si no se pude añadir
     * @throws UnidadRepetidaException excepción que se lanza cuando la unidad
     * ya existe en la lista
     * @throws NombreNoValidoException excepción que se lanza cuando el nombre
     * de la unidad no es válida
     */
    public boolean annadir(String nombre, Tipo tipo, Raza raza) throws NombreNoValidoException, UnidadRepetidaException{
        Unidad unidadTemporal;
        switch (raza) {
            case PROTOS:
                unidadTemporal = new Protos(nombre, tipo);
                break;
            case TERRAN:
                unidadTemporal = new Terran(nombre, tipo);
                break;
            case ZERG:
                unidadTemporal = new Zerg(nombre, tipo);
                break;
            default:
                unidadTemporal = null;
                break;
        }
        if (lista.contains(unidadTemporal)) {
            throw new UnidadRepetidaException("La unidad ya fue creada");
        }
        Intermediaria.setModificado(true);
        return lista.add(unidadTemporal);
    }

    /**
     * Método que elimina una unidad
     *
     * @param nombre nombre de la unidad
     * @return devuelve true si la unidad de pudo eliminar o lanzara una
     * excepción
     * @throws UnidadNoExistenteException excepción que se lanza cuando la
     * unidad no existe en la lista
     */
    public boolean eliminar(String nombre) throws UnidadNoExistenteException, NombreNoValidoException {
        Unidad unidadTemporal = getUnidad(nombre);
        if (lista.contains(unidadTemporal)) {
            Intermediaria.setModificado(true);
            return lista.remove(unidadTemporal);
        }
        throw new UnidadNoExistenteException("La unidad no existe");

    }

    /**
     * Método toString que muestra la lista
     *
     * @return devuelve un mensaje mostrando todas las unidades que almacena la
     * lista
     */
    @Override
    public String toString() {
        return "Lista{" + "lista=" + lista + '}';
    }

    /**
     * Método que devuelve una unidad de la lista por le nombre
     *
     * @param nombre nombre de la unidad para buscar
     * @return devuelve una unidad que este dentro de la lista
     * @throws UnidadNoExistenteException excepción que salta cuando la unidad
     * no existe
     */
    public Unidad getUnidad(String nombre) throws UnidadNoExistenteException {
        Unidad unidadTemporal = null; // recorro todo el array porque...
        for (Unidad unidad : lista) {
            if (unidad.getNombre().equals(nombre)) { //si creo un objeto Unidad me obliga a redefinir los métodos abstractos
                unidadTemporal = unidad; //y si creo una unidad hija solo me devolvera aquellas unidades de ese tipo
            }
        }
        if (unidadTemporal != null) {
            return unidadTemporal;
        } else {
            throw new UnidadNoExistenteException("La unidad no existe");
        }
    }

    /**
     * Método que muestra el tamaÃ±o de la lista
     *
     * @return devuelve el número de unidades que tiene la lista
     */
    public int size() {
        return lista.size();
    }

    /**
     * Método que devuelve una lista con las unidades de una misma raza
     *
     * @param raza raza de la unidad
     * @return devuelve una lista con todas las unidades de una misma raza
     */
    public ArrayList<Unidad> getRaza(Raza raza) throws ListaRazaVaciaExcepcion {
        ArrayList<Unidad> listaPorRaza = new ArrayList<>();
        for (Unidad unidad : lista) {
            switch (raza) {
                case PROTOS:
                    if (unidad instanceof Protos) {
                        listaPorRaza.add(unidad);
                    }
                    break;
                case TERRAN:
                    if (unidad instanceof Terran) {
                        listaPorRaza.add(unidad);
                    }
                    break;
                case ZERG:
                    if (unidad instanceof Zerg) {
                        listaPorRaza.add(unidad);
                    }
                    break;
            }
        }
        if (listaPorRaza.isEmpty()) {
            throw new ListaRazaVaciaExcepcion("No hay ninguna unidad de esa raza");
        }
        return listaPorRaza;
    }

    /**
     * Método que devuelve una lista con las unidades de un mismo tipo
     *
     * @param tipo tipo de la unidad
     * @return devuelve una lista con todas las unidades de un mismo tipo
     */
    public ArrayList<Unidad> getTipo(Tipo tipo) throws ListaTipoVaciaExcepcion {
        ArrayList<Unidad> listaPorTipo = new ArrayList<>();
        for (Unidad unidad : lista) {
            if (unidad.getTipo() == tipo) {
                listaPorTipo.add(unidad);
            }
        }
        if (listaPorTipo.isEmpty()) {
            throw new ListaTipoVaciaExcepcion("No hay ninguna unidad de ese tipo");
        }
        return listaPorTipo;
    }

    /**
     * Método que devuelve una unidad segun el indice en el que se encuentre
     *
     * @param index posicion de la lista
     * @return devuelve una unidad correspondiente a la posición asignada
     * @throws UnidadNoExistenteException excepción que se lanza cuando el
     * indice especificado no esta relacionado a ninguna unidad
     */
    public Unidad getUnidadIndice(int index) throws UnidadNoExistenteException {
        if (index < 0 || lista.isEmpty()) {
            throw new UnidadNoExistenteException("La unidad no existe");
        } else {
            return lista.get(index);
        }
    }

}
