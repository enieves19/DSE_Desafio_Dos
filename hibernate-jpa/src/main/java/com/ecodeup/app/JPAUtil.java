/* Metodo que hace referencia al archivo persistence que permite instanciar la BD */
package com.ecodeup.app;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	/*Variable de tipo string que almacena la variable Persistence*/
	private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";
	/*creamos objeto del tipo EntityManagerFactory que contendra la conexion hacia la base de datos*/
	private static EntityManagerFactory factory;
	/* Creacion de dos metodos */
	/* Primer metodo permite obtener la conexion*/
	public static EntityManagerFactory getEntityManagerFactory() {
		/* si el objeto factory de la clase EntityManagerFactory es igual a null , ese objeto factory utilizara un metodo estatico de la clase
		 * Persistence el cual ocupara el metodo create entityManagerFactory que es un metodo de hibernate y le pasaremos el nombre de la persistencia
		 * una vez pasado ese nombre este metodo se encarga de pasar al objeto factory todo la parte de conexion y propiedades de la conexion hacia la BD
		 */
		if (factory==null) {
			factory=Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		/* Returnamos el objeto con todas las propiedades para que posteriormente hibernate pueda hacer todas las operaciones crud */
		return factory;				
	}
	/* Segundo metodo permite cerrar la conexion */
	public static void shutdown() {
		
		if (factory!=null) {
			factory.close();
		}		
	}
}