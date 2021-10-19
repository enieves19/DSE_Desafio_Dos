/*LINK DEL VIDEO : https://drive.google.com/file/d/1If39DUuNK0pI2HeB1bH3QEPAeM8NfNfN/view?usp=sharing*/
package com.ecodeup.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ecodeup.model.Producto;


public class MainApp {

	@SuppressWarnings({ "unchecked", "resource" })
	public static void main(String[] args) {
		int opcion = 0;
		Scanner scanner = new Scanner(System.in);
		Producto producto;
		/* entity Nos trae de JPAUtil nos trae el objeto Factory con todo lo que contiene la BD */
		EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
		while (opcion!=5) {
			System.out.println("1. Crear Vehiculo");
			System.out.println("2. Buscar Vehiculo");
			System.out.println("3. Actualizar Vehiculo");
			System.out.println("4. Eliminar Vehiculo");
			System.out.println("5. Salir");
			System.out.println("Elija una opción:");

			opcion = scanner.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("Digite el nombre del propietario del Vehiculo:");
				/*Creamos objeto de tipo producto*/
				producto = new Producto();
				producto.setId(null);
				scanner.nextLine();
				producto.setNombre(scanner.nextLine());
				System.out.println("Digite el modelo del Vehiculo ( Sedan o Pick Up):");
				producto.setModelo(scanner.nextLine());
				System.out.println("Digite la Marca del vehiculo:");
				producto.setMarca(scanner.nextLine());
				System.out.println("Digite el Color del vehiculo:");
				producto.setColor(scanner.nextLine());
				System.out.println("Digite el Motivo del vehiculo( Reparacion o Mantenimiento):");
				producto.setMotivo(scanner.nextLine());
				System.out.println("Digite el precio de reparacion del vehiculo:");
				producto.setPrecio(scanner.nextDouble());
				System.out.println(producto);
				/*Metodo get transaction que es mas que JDBC que permite la transaccion a la BD*/
				entity.getTransaction().begin();
				/* Metodo Persist le pasamos el objeto producto que permite almacenarlo a la BD */
				entity.persist(producto);
				/*Finalizando la transaccion hacia la BD */
				entity.getTransaction().commit();
				System.out.println("Vehiculo registrado..");
				System.out.println();
				break;

			case 2:
				System.out.println("Digite el id del vehiculo a buscar:");
				/*creando variable producto*/
				producto = new Producto();
				/*metodo Find que proporciona Hibernate 
				 * Primer parametro hace referencia a la clase que esta instanciado al objeto el cual voy a obtener de la BD
				 * Y segundo parametro sera el ID del objeto
				 * */
				producto = entity.find(Producto.class, scanner.nextLong());
				if (producto != null) {
					System.out.println(producto);
					System.out.println();
				} else {
					System.out.println();
					System.out.println("vehiculo no encontrado... Lista de vehiculos completa");
					/*Si no se encuentra el vehiculo */
					List<Producto> listaProductos= new ArrayList<>();
					/*Recogeremos todos los registros de la BD mediante el Query el cual lo pasaremos posteriormente a la Lista*/
					Query query=entity.createQuery("SELECT p FROM Producto p");
					listaProductos=query.getResultList();
					for (Producto p : listaProductos) {
						System.out.println(p);
					}
					
					System.out.println();
				}

				break;
			case 3:
				System.out.println("Digite el id del vehiculo a actualizar:");
				producto = new Producto();
				/*metodo Find que proporciona Hibernate 
				 * Primer parametro hace referencia a la clase que esta instanciado al objeto el cual voy a obtener de la BD
				 * Y segundo parametro sera el ID del objeto
				 * */
				producto = entity.find(Producto.class, scanner.nextLong());
				if (producto != null) {
					System.out.println(producto);
					System.out.println("Digite el nombre del propietario del Vehiculo:");
					scanner.nextLine();
					producto.setNombre(scanner.nextLine());
					System.out.println("Digite el modelo del Vehiculo ( Sedan o Pick Up):");
					producto.setModelo(scanner.nextLine());
					System.out.println("Digite la Marca del Vehiculo:");
					producto.setMarca(scanner.nextLine());
					System.out.println("Digite el Color del Vehiculo:");
					producto.setColor(scanner.nextLine());
					System.out.println("Digite el Motivo del vehiculo( Reparacion o Mantenimiento):");
					producto.setMotivo(scanner.nextLine());
					System.out.println("Digite el precio de reparacion del Vehiculo:");
					producto.setPrecio(scanner.nextDouble());
					/*Metodo get transaction que es mas que JDBC que permite la transaccion a la BD*/
					entity.getTransaction().begin();
					/* Metodo Merge de hibernate le pasaremos los nuevos atributos al producto */
					entity.merge(producto);
					/*Finalizando la transaccion hacia la BD */
					entity.getTransaction().commit();
					
					System.out.println("Vehiculo actualizado..");
					System.out.println();
				} else {
					System.out.println("Vehiculo no encontrado....");
					System.out.println();
				}
				break;
			case 4:
				System.out.println("Digite el id del Vehiculo a eliminar:");
				producto = new Producto();
				/*metodo Find que proporciona Hibernate 
				 * Primer parametro hace referencia a la clase que esta instanciado al objeto el cual voy a obtener de la BD
				 * Y segundo parametro sera el ID del objeto
				 * */
				producto = entity.find(Producto.class, scanner.nextLong());
				if (producto != null) {
					System.out.println(producto);
					/*Metodo get transaction que es mas que JDBC que permite la transaccion a la BD*/
					entity.getTransaction().begin();
					/*Metodo Remove de hibernate el cual recibe como parametro el objeto producto para eliminarlo posteriormente*/
					entity.remove(producto);
					/*Finalizando la transaccion hacia la BD */
					entity.getTransaction().commit();
					System.out.println("Vehiculo eliminado...");
				} else {
					System.out.println("Vehiculo no encontrado...");
				}
				break;
			case 5:entity.close();JPAUtil.shutdown();
			break;

			default:
				System.out.println("Opción no válida\n");
				break;
			}
		}
	}

}


