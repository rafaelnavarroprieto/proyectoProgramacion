/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informacion;


import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Clase padre unidad
 *
 * @author Rafael Navarro Prieto
 * @version 1.0
 */
public abstract class Unidad implements Creacionable, Serializable {
    
    /**
     * Patron que controla el nombre de los personajes
     */
    static final private Pattern patron = Pattern.compile("^[A-Z]([a-z]){3,20}$");
    /**
     * Método que valida el nombre de las unidades
     * @param nombre nombre para validar
     * @return devuelve true si el nombre cumple el patron o false si el nombre no cumple el patrón
     */
     static private boolean validarNombre(String nombre) {
        return patron.matcher(nombre).matches();
    }
    /**
     * Nombre único de la unidad
     */
    protected String nombre;
    /**
     * Número de victorias
     */
    private int victorias = 0;
    /**
     * Número de derrotas
     */
    private int derrotas = 0;
    /**
     * Vida de laa unidad
     */
    protected float vida;
    /**
     * Ataque de la unidad
     */
    protected float ataque;
    /**
     * Tipo de la unidad
     */
    private Tipo tipo;
    /**
     * Número de aciertos consecutivos
     */
    private int aciertos = 0;
    /**
     * Cadena que contiene la fecha actual de la creación con un formato
     * específico
     */
    private String fechaDeCreacion;

    /**
     * Método get del nombre
     *
     * @return devuelve el nombre de la unidad
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * MÃ©todo get de las victorioas de la unidad
     *
     * @return devuelve el nÃºmero de victorias de la unidad
     */
    public int getVictorias() {
        return victorias;
    }

    /**
     * MÃ©todo get de las derrotas de la unidad
     *
     * @return devuelve el nÃºmero de derrotas de la unidad
     */
    public int getDerrotas() {
        return derrotas;
    }

    /**
     * MÃ©todo get de la vida de la unidad
     *
     * @return devuelve la vida de la unidad
     */
    public float getVida() {
        return vida;
    }

    /**
     * MÃ©todo get del ataque 
     *
     * @return devuelve el ataque de la unidad
     */
    public float getAtaque() {
        return ataque;
    }

    /**
     * MÃ©todo get del tipo 
     *
     * @return devuelve el tipo de la unidad
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     * MÃ©todo get del campo aciertos
     *
     * @return devuelve el nÃºmero de aciertos consecutivos
     */
    public int getAciertos() {
        return aciertos;
    }

    /**
     * MÃ©todo get de la fecha de creaciÃ³n
     *
     * @return devuelve la fecha de creaciÃ³n
     */
    public String getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    /**
     * MÃ©todo set del campo nombre
     *
     * @param nombre nombre para asignar
     * @throws NombreNoValidoException excepción que salta cuando el nombre no
     * es válido segun el patron especifico
     *
     */
    public void setNombre(String nombre) throws NombreNoValidoException {
        if (validarNombre(nombre)) {
            this.nombre = nombre;
        } else {
            throw new NombreNoValidoException("El nombre no es válido");
        }
    }

    /**
     * Método set del campo victorias
     */
    public void setVictorias() {
        ++this.victorias;
    }

    /**
     * Método set del campo derrotas
     */
    public void setDerrotas() {
        ++this.derrotas;
    }

    /**
     * Método set de la vida
     *
     * @param vida vida para asignar
     */
    public void setVida(float vida) {
        this.vida = vida;
    }

    /**
     * Método set del ataque
     *
     * @param ataque ataque para asignar
     */
    public void setAtaque(float ataque) {
        this.ataque = ataque;
    }

    /**
     * Método set del campo tipo
     *
     * @param tipo tipo para asignar
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    /**
     * Método set del campo aciertos
     *
     * @param aciertos aciertos para asignar
     */
    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

    /**
     * Método set del campo fechaDeCreacion
     *
     * @param fechaDeCreacion fecha para asignar
     */
    public void setFechaDeCreacion(Date fechaDeCreacion) {
        DateFormat formato = DateFormat.getDateInstance();
        this.fechaDeCreacion = formato.format(fechaDeCreacion);
    }

    /**
     * Constructor
     *
     * @param nombre nombre de la unidad
     * @param tipo tipo de la unidad
     * @throws NombreNoValidoException excepción que se lanza si el nombre no
     * cumple el patrón
     */
    public Unidad(String nombre, Tipo tipo) throws NombreNoValidoException {
        setNombre(nombre);
        setVida(calcularVida(tipo));
        setAtaque(calcularAtaque(tipo));
        setTipo(tipo);
        setFechaDeCreacion(new Date());
    }

    /**
     * Método que calcula la vida de las unidades
     *
     * @param tipo tipo de la unidad
     * @return devuelve la cantidad de vida final de la unidad
     */
    @Override
    public abstract float calcularVida(Tipo tipo);

    /**
     * Método que calcula el ataque de las unidades
     *
     * @param tipo tipo de la unidad
     * @return devuelve la cantidad de ataque final de la unidad
     */
    @Override
    public abstract float calcularAtaque(Tipo tipo);
    /**
     * Método que interactua con las unidades
     * @return devuelve un nÃºmero indicando el daño que realiza
     */
    public abstract float test();
    /**
     * Método toString que muestra el estado de las unidades
     * @return devuelve un mensaje con el estado de cada campo de la unidad
     */
    @Override
    public String toString() {
        return "Unidad{" + "nombre=" + nombre + "\n victorias=" + victorias + ""
                + "\n derrotas=" + derrotas + "\n vida=" + vida + "\n ataque=" + ataque + ""
                + "\n tipo=" + tipo + "\n aciertos=" + aciertos + " fechaDeCreacion=" + fechaDeCreacion + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.nombre);
        return hash;
    }
    /**
     * Método equal que utiliza para comparar unidades por su nombre
     * @param obj objeto que se desea comparar
     * @return devuelve true si los objetos coinciden o false si los objetos no coinciden
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Unidad other = (Unidad) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

}
