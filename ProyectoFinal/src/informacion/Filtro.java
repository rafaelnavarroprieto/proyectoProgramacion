/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informacion;
import java.io.File;
import javax.swing.filechooser.FileFilter;
/**
 *
 * @author Rafael Navarro Prieto
 * @version 1.0
 */
public class Filtro extends FileFilter {
    /**
     * variable que guarda la extensi�n
     */
    private String extension;
    /**
     * variable que fuarda la descripci�n de la extensi�n
     */
    private String description;
    /**
     * Constructor
     * @param extension extensi�n especificada
     * @param description descripci�n de la extensi�n
     */
    public Filtro(String extension, String description) {
        this.extension = extension;
        this.description = description;
    }
    /**
     * M�todo que comprueba si los archivos son v�lidos
     * @param file archivo seleccionado
     * @return devuelve true si el archivo contiene la extensi�n correcta, en caso de que no la lleve
     * se le a�adira la extensi�n
     */
    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        }
        return file.getName().endsWith(extension);
    }
    /**
     * M�todo que devuelve la descripci�n
     * @return devuelve la descripci�n con respecto a una extensi�n
     */
    @Override
    public String getDescription() {
        return description + String.format(" (*%s)", extension);
    }
    /**
     * M�todo que devuelve la extensi�n
     * @return  devuelve la extensi�n
     */
    public String getExtension() {
        return extension;
    }
    
}

