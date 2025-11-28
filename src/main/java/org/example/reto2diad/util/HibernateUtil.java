package org.example.reto2diad.util;

import org.example.reto2diad.model.Copia;
import org.example.reto2diad.model.Pelicula;
import org.example.reto2diad.model.Usuario;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    /**
     * Construye la SessionFactory cargando la configuración desde el archivo hibernate.cfg.xml.
     * Si falla, imprime el error y detiene la aplicación.
     */
    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();

            configuration.configure("hibernate.cfg.xml");

            configuration.addAnnotatedClass(Usuario.class);
            configuration.addAnnotatedClass(Pelicula.class);
            configuration.addAnnotatedClass(Copia.class);

            return configuration.buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println("La inicialización de SessionFactory falló. Verifica hibernate.cfg.xml y tu conexión a la DB.");
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Método para acceder a la SessionFactory.
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Cierra la SessionFactory.
     */
    public static void shutdown() {
        getSessionFactory().close();
    }
}