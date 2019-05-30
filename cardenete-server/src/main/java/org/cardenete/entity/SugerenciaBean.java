package org.cardenete.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.sun.istack.NotNull;


@Entity
@Table(name="sugerencia")
//@SecondaryTables({
//	@SecondaryTable(name = "usuario", pkJoinColumns = { @PrimaryKeyJoinColumn(name = "id") })
//})
@DynamicUpdate(value=true)
public class SugerenciaBean {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@NotNull
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="email")
	private String email;
	
	@Column(name="sugerencia")
	@NotNull
	private String sugerencia;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private UsuarioBean id_usuario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSugerencia() {
		return sugerencia;
	}

	public void setSugerencia(String sugerencia) {
		this.sugerencia = sugerencia;
	}

	public UsuarioBean getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(UsuarioBean id_usuario) {
		this.id_usuario = id_usuario;
	}

	@Override
	public String toString() {
		return "SugerenciaBean [id=" + id + ", nombre=" + nombre + ", email=" + email + ", sugerencia=" + sugerencia
				+ ", id_usuario=" + id_usuario + "]";
	}
	
	
	
}
