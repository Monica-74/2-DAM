package org.example;

import org.hibernate.Session;  // interfaz para interactuar con la base de datos. Proporciona métodos para crear, leer y eliminar operaciones para instancias de entidades mapeadas.
import org.hibernate.query.Query; // interfaz que representa una consulta a la base de datos. Se utiliza para ejecutar consultas HQL (Hibernate Query Language) o SQL nativo y recuperar
// resultados.
import org.hibernate.cfg.Configuration; //clase que se utiliza para configurar Hibernate. Permite especificar las propiedades de configuración y los archivos de mapeo necesarios
// para inicializar Hibernate.

import java.util.List;

import static java.lang.Math.E;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");
        Session newSession = null; //inicializamos sesión en Hibernate
        try{
            newSession = new Configuration().configure().buildSessionFactory().openSession(); // configura Hibernate y abre una nueva sesión.
        }catch (Throwable ex){
        System.out.println("Error al abrir la sesión: " + e.getMessage());
            throw new ExceptionInInitializerError(ex);// manejamos cualquier excepción en la configuración.
        }
    //Realizamos una consulta para obtener ciudades con el nombre Kabul.
        Query q = newSession.createQuery("From city where Name= 'Kabul'", city.class);
        List<city> resultList = q.list();
        System.out.println("Numero de ciudades: " + resulList.size());
        for (city next : resultList){
            System.out.println("Ciudades: " + next.getName());
        }

    //Realizamos una consulta para obtener todos los registros de Dim_Language
        Query qDL = newSession.createQuery("From Dim_language", Dim_Language.class);
        List<Dim_Language> resultListDL =qDL.list();
        LiveStackFrame.PrimitiveSlot resulListDL;
        System.out.println("Número de Lenguajes: " + resulListDL.size());
        for (Dim_Language next : resultListDL){
            System.out.println("Lenguajes : " + next.getLanguage());
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
        }catch (Exception ex){  //manejamos cualquier excepción durante la Transacción
        //handle any errors
            System.out.println("SQLException :" + ex.getMessage());
        }

    }
}



