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
public abstract class Unidad implements Creacionable, Serializable, Combatible {
    
    /**
     * Patron que controla el nombre de los personajes
     */
    static final private Pattern patron = Pattern.compile("^[A-Z]([a-z]){3,20}$");
    /**
     * M�todo que valida el nombre de las unidades
     * @param nombre nombre para validar
     * @return devuelve true si el nombre cumple el patr�n o false si el nombre no cumple el patr�n
     */
     static private boolean validarNombre(String nombre) {
        return patron.matcher(nombre).matches();
    }
    /**
     * Nombre �nico de la unidad
     */
    protected String nombre;
    /**
     * N�mero de victorias
     */
    private int victorias = 0;
    /**
     * N�mero de derrotas
     */
    private int derrotas = 0;
    /**
     * Vida de la unidad
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
     * N�mero de aciertos consecutivos
     */
    private int aciertos = 0;
    /**
     * Cadena que contiene la fecha actual de la creaci�n con un formato
     * espec�fico
     */
    private String fechaDeCreacion;

    /**
     * M�todo get del nombre
     *
     * @return devuelve el nombre de la unidad
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * M�todo get de las victorioas de la unidad
     *
     * @return devuelve el n�mero de victorias de la unidad
     */
    public int getVictorias() {
        return victorias;
    }

    /**
     * M�todo get de las derrotas de la unidad
     *
     * @return devuelve el n�mero de derrotas de la unidad
     */
    public int getDerrotas() {
        return derrotas;
    }

    /**
     * M�todo get de la vida de la unidad
     *
     * @return devuelve la vida de la unidad
     */
    public float getVida() {
        return vida;
    }

    /**
     * M�todo get del ataque 
     *
     * @return devuelve el ataque de la unidad
     */
    public float getAtaque() {
        return ataque;
    }

    /**
     * M�todo get del tipo 
     *
     * @return devuelve el tipo de la unidad
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     * M�todo get del campo aciertos
     *
     * @return devuelve el n�mero de aciertos consecutivos
     */
    public int getAciertos() {
        return aciertos;
    }

    /**
     * M�todo get de la fecha de creaci�n
     *
     * @return devuelve la fecha de creaci�n
     */
    public String getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    /**
     * M�todo set del campo nombre
     *
     * @param nombre nombre para asignar
     * @throws NombreNoValidoException excepci�n que salta cuando el nombre no
     * es v�lido segun el patr�n especifico
     *
     */
    public void setNombre(String nombre) throws NombreNoValidoException {
        if (validarNombre(nombre)) {
            this.nombre = nombre;
        } else {
            throw new NombreNoValidoException("El nombre no es v�lido");
        }
    }

    /**
     * M�todo set del campo victorias
     */
    public void setVictorias() {
        ++this.victorias;
    }

    /**
     * M�todo set del campo derrotas
     */
    public void setDerrotas() {
        ++this.derrotas;
    }

    /**
     * M�todo set de la vida
     *
     * @param vida vida para asignar
     */
    public void setVida(float vida) {
        this.vida = vida;
    }

    /**
     * M�todo set del ataque
     *
     * @param ataque ataque para asignar
     */
    public void setAtaque(float ataque) {
        this.ataque = ataque;
    }

    /**
     * M�todo set del campo tipo
     *
     * @param tipo tipo para asignar
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    /**
     * M�todo set del campo aciertos
     *
     * @param aciertos aciertos para asignar
     */
    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

    /**
     * M�todo set del campo fechaDeCreacion
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
     * @throws NombreNoValidoException excepci�n que se lanza si el nombre no
     * cumple el patr�n
     */
    public Unidad(String nombre, Tipo tipo) throws NombreNoValidoException {
        setNombre(nombre);
        setVida(calcularVida(tipo));
        setAtaque(calcularAtaque(tipo));
        setTipo(tipo);
        setFechaDeCreacion(new Date());
    }

    /**
     * M�todo que calcula la vida de las unidades
     *
     * @param tipo tipo de la unidad
     * @return devuelve la cantidad de vida final de la unidad
     */
    @Override
    public abstract float calcularVida(Tipo tipo);

    /**
     * M�todo que calcula el ataque de las unidades
     * 
     *
     * @param tipo tipo de la unidad
     * @return devuelve la cantidad de ataque final de la unidad
     */
    @Override
    public abstract float calcularAtaque(Tipo tipo);
     @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.nombre);
        return hash;
    }
    /**
     * M�todo equal que utiliza para comparar unidades por su nombre
     * @param obj objeto que se desea comparar
     * @return devuelve true si los objetos coinciden o false si los objetos no coinciden
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        final Unidad other = (Unidad) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    /**
     * Ataque avanzado
     * @return devuelve el da�o realizado
     */
    @Override
    public abstract float ataqueAvanzado();
    /**
     * Ataque medio
     * @return devuelve el da�o realizado
     */
    @Override
    public abstract float ataqueMedio();
    /**
     * Ataque b�sico
     * @return devuelve el da�o realizado
     */
    @Override
    public abstract float ataqueBasico();

}
