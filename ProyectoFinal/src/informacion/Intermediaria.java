/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informacion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Clase intermediária que contiene los elementos que se utilizaran en todo el
 * programa(Lista y archivo)
 *
 * @author Rafael Navarro Prieto
 * @version 1.0
 *
 */
public class Intermediaria implements Serializable {
      /**
     * Campo que comprueba la modificacián de la lista
     */
    public static boolean modificado = false;
    
    public static String fecha = formatoFecha();
    /** 
     * Patron que controla el nombre del fichero
     */
    static final Pattern patronFichero = Pattern.compile("^((\\w)+(\\.rnp))$");
    /**
     * Lista que contendra las unidades creadas
     */
    public static Lista lista = new Lista();
    /**
     * Archivo que utilizara el programa para guardar , cargar y crear uno nuevo
     */
    public static File archivo = new File("Sin_Titulo");

   /**
    * Método set del archivo
    * @param archivo nombre del nuevo archivo
    */
    public static void setArchivo(String archivo) {
        Intermediaria.archivo = new File(archivo);
    }
    /**
     * Método set del campo modificado 
     * @param modificado campo booleano
     */
    public static void setModificado(boolean modificado) {
        Intermediaria.modificado = modificado;
    }
    /**
     * Método get del campo modificado
     * @return devuelve true si se modifico la lista o false si no se modifico
     */
    public static boolean isModificado() {
        return modificado;
    }

    /**
     * Método que valida el nombre del fichero
     * @param nombre nombre del fichero
     * @return devuelve true si el nombre es cumple el patrón o false si el nombre no cumple el patrón
     */
    public static boolean validarFichero(String nombre) {
        return patronFichero.matcher(nombre).matches();
    }
    /**
     * Método guardar un objeto pidiendo un nombre de archivo que se creara
     *
     * @param objeto objeto que se le pasa para guardar
     * @param nombre fichero seleccionado
     * @throws IOException Exception que lanza cuando el flujo acaba
     */
    public static void guardarComo(Object objeto, File nombre) throws IOException {
        archivo = comprobarArchivo(nombre);
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(archivo))) {

            out.writeObject(objeto);
            setModificado(false);

        }
    }

    /**
     * Método que compruena el nombre del archivo
     *
     * @param fichero2 nombre del archivo
     * @return devuelve el archivo sin ninguna modificación si el nombre
     * coincide con el patron especificado o en caso negativo se le añadira al
     * archivo la extension .rnp
     */
    public static File comprobarArchivo(File fichero2) {
        if (patronFichero.matcher(fichero2.getName()).matches()) {
            return fichero2;
        } else {
            setArchivo(fichero2.getAbsolutePath() + ".rnp");
            return archivo;
        }

    }

    /**
     * Método guardar que guarda el contenido de un archivo ya existente
     *
     * @param objeto objeto que queremos guardar
     * @throws IOException Exception que lanza cuando el flujo acaba
     */
    public static void guardar(Object objeto) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(archivo))) {
            out.writeObject(objeto);
            setModificado(false);
        }
    }

    /**
     * Método que crea un nuevo archivo
     *
     */
    public static void nuevo() {
    	setArchivo("Sin_titulo");
        lista = new Lista();
        setModificado(false);
        
    }

    /**
     * Método que te carga un fichero que contiene un objeto
     *
     * @throws IOException Exception que lanza cuando el flujo acaba
     * @throws ClassNotFoundException Exception que se lanza si el objeto
     * destino pertenece a la misma clase que el objeto del fichero
     */
    public static void abrir(File archivo) throws IOException, ClassNotFoundException {
     
        
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(
                archivo))) {
             lista = (Lista) in.readObject();
             setModificado(false);
           
        }
    }
    /**
     * Método que devuelve la fecha
     * @return devuelve el campo fecha
     */
    public static String getFecha() {
        return fecha;
    }
    /**
     * Método que da formato a la fecha
     * @return devuelve la fecha con el formato dd-mmm-aaaa
     */
    public static String formatoFecha() {
        Date fecha = new Date();
        DateFormat formato = DateFormat.getDateInstance();
        return formato.format(fecha);
       
    }

}
