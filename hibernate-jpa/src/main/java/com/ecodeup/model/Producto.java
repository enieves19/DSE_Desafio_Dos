package com.ecodeup.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/* Declarando entidad que va a persistir en la BD */
@Entity
/* Indicamos la clase producto se va almacenar en la tabla producto */
@Table(name="productos")
public class Producto {
	/*Notacion ID que identifica que el atributo ID es el ID de la tabla a la cual se va a mapear el objeto */
	@Id
	/*Nos indica que el campo ID sera autoincrementable , generandolo automaticamente */
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	/*Especificandole a hibernate que hay un campo NOMBRE dentro de la base de datos dentro de esta clase en el cual se mapeara en la BD*/
	@Column
	private String nombre;
	/*Especificandole a hibernate que hay un campo MODELO dentro de la base de datos dentro de esta clase en el cual se mapeara en la BD*/
	@Column
	private String modelo;
	/*Especificandole a hibernate que hay un campo MARCA dentro de la base de datos dentro de esta clase en el cual se mapeara en la BD*/
	@Column
	private String marca;
	/*Especificandole a hibernate que hay un campo AÑO dentro de la base de datos dentro de esta clase en el cual se mapeara en la BD*/
	@Column
	private Integer anio;
	/*Especificandole a hibernate que hay un campo MOTIVO dentro de la base de datos dentro de esta clase en el cual se mapeara en la BD*/
	@Column
	private String motivo;
	/*Especificandole a hibernate que hay un campo COLOR dentro de la base de datos dentro de esta clase en el cual se mapeara en la BD*/
	@Column
	private String color;
	/*Especificandole a hibernate que hay un campo PRECIO dentro de la base de datos dentro de esta clase en el cual se mapeara en la BD*/
	@Column
	private double precio;
	
	/* Metodo para obtener un ID dentro de la BD */
	public Long getId() {
		return id;
	}
	/*Metodo para registrar un ID dentro de la BD*/
	public void setId(Long id) {
		this.id = id;
	}
	
	/*Metodo para obtener un Nombre dentro de la BD */
	public String getNombre() {
		return nombre;
	}
	/* Metodo para registrar un Nombre dentro de la BD */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/*Metodo para obtener un Modelo dentro de la BD */
	public String getModelo() {
		return modelo;
	}
	/* Metodo para registrar un Modelo dentro de la BD */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	/*Metodo para obtener una Marca dentro de la BD */
	public String getMarca() {
		return marca;
	}
	/* Metodo para registrar una Marca dentro de la BD */
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	/*Metodo para obtener un Color dentro de la BD */
	public String getColor() {
		return color;
	}
	/* Metodo para registrar un Color dentro de la BD */
	public void setColor(String color) {
		this.color = color;
	}
	
	/*Metodo para obtener un Motivo dentro de la BD */
	public String getMotivo() {
		return motivo;
	}
	/* Metodo para registrar un Color dentro de la BD */
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	/* Metodo para obetener un Precio dentro de la BD */
	public double getPrecio() {
		return precio;
	}
	/* Metodo para registrar un Precio dentro de la BD */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", modelo=" + modelo +", marca=" + marca + ", color="+ color+ ",motivo=" + motivo +", precio=" + precio + "]";
	}
	
}