package org.example;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class Main {
    public static void main (String [] args){
    System.out.printf("Hola bienvenido!");
    Session newSession = null; //inicializamos sesión en Hibernate
    try{
        newSession = new Configuration().configure().buildSessionFactory().openSession(); // configura Hibernate y abre una nueva sesión.
    }catch (Exception e){
        System.out.println("Error al abrir la sesión: " + e.getMessage()); // manejamos cualquier excepción en la configuración.
    }
    //Realizamos una consulta para obtener ciudades con el nombre Kabul.
    Query <city> q = newSession.createQuery("From city where Name= 'Kabul'",city.class);
    List<city> resultList =q.list();
    System.out.println("num of cities: " + resulList.size());
    for (city next : resultList){
        System.out.println("next language: " + next.getName());
    }

    //Realizamos una consulta para obtener todos los registros de Dim_Language
    Query qDL = newSession.createQuery("From Dim_language", Dim_Language.class);
    List<Dim_Language> resultListDL =qDL.list();
    System.out.println("num of language: " + resulListDL.size();
    for (Dim_LAnguage next : resultListDL){
        System.out.println("next language: " + next.getLanguage());
    }

    try{
        //Iniciamos una transacción para guardar un nuevo lenguaje.
        newSession.beginTransaction();
        Dim_Language new_language = new Dim_Language();
        new_language.setLanguageCode("Ita");
        new_language.setLanguage("Italian");
        new_language.setCreated_dt(java.time.LocalDateTime.now());
        new_language.setUpdate_dt(java.time.LocaDateTime.now());
        newSession.save(new_language);
        newSession.getTransaction().commit();
    }catch(Exception ex){  //manejamos cualquier excepción durante la Transacción
        //handle any errors
        System.out.println("SQLException:" + ex.getMessage());
    }


}