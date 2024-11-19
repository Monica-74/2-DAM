package org.example;

//Importamos las librerias necesarias para definir una entidad y su tabla correspondiente en JPA.
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity // Marcamos la clase como una entidad JPA que se mapeará a una tabla en la base de datos.
@Table(name = "city") // Especificamos el nombre de la tabla en la base de datos a la que se mapeará esta entidad.

public class city {  // Definimos los atributos de la clase que corresponden a las columnas de la tabla.
    private int ID;
    private String Name;
    private String CountryCode;
    private String District;
    private int Population;
    private List<city>cities = new ArrayList<>(); // Creamos una lista para almacenar múltiples instancias de la clase 'city'.

    public String getDistrict() { // Creamos los Métodos getter para acceder a los atributos de la clase.
        return District;
    }

    public int getPopulation() {
        return Population;
    }


    public String getName() {
        return Name;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public List<city> getCities() {
        return cities;
    }

    public int getID() {
        return ID;
    }

    public void setCountryCode(String countryCode) { // Creamos los métodos setter para modificar los atributos de la clase.

        this.CountryCode = countryCode;
    }

    public void setPopulation(int population) {
        this.Population = population;
    }

    public void setCities(List<city> cities) {
        this.cities = cities;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.Name = name;
    }

}
