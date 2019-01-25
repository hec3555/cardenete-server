package org.cardenete.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

@Entity()
@Table(name="usuario")
@SecondaryTables({
	@SecondaryTable(name = "tipo_usuario", pkJoinColumns = { @PrimaryKeyJoinColumn(name = "id") })
})
public class UsuarioBean {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@NotNull
	private int id;
	
	@Column(name="nombre")
	@NotNull
	private String nombre;
	
	@Column(name="ape1")
	@NotNull
	private String ape1;
	
	@Column(name="ape2")
	private String ape2;
	
	@Column(name="fecha_nacimiento")
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date fecha_nacimiento;
	
	@Column(name="fecha_alta")
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date fecha_alta;
	
	@Column(name="login")
	@NotNull
	private String login;
	
	@Column(name="pass")
	private String pass;
	
	@Column(name="email")
	@NotNull
	private String email;
	
	
	@Column(name="token")
	@NotNull
	private String token;
	
	@Column(name="confirmado")
	@NotNull
	private boolean confirmado;
	
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_usuario")
	@NotNull
	private TipoUsuarioBean id_tipo_usuario;


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


	public String getApe1() {
		return ape1;
	}


	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}


	public String getApe2() {
		return ape2;
	}


	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}


	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}


	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}


	public Date getFecha_alta() {
		return fecha_alta;
	}


	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}

	@JsonIgnore
	public String getPass() {
		return pass;
	}

	@JsonProperty
	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public boolean isConfirmado() {
		return confirmado;
	}


	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}


	public TipoUsuarioBean getId_tipo_usuario() {
		return id_tipo_usuario;
	}


	public void setId_tipo_usuario(TipoUsuarioBean id_tipo_usuario) {
		this.id_tipo_usuario = id_tipo_usuario;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "UsuarioBean [id=" + id + ", nombre=" + nombre + ", ape1=" + ape1 + ", ape2=" + ape2
				+ ", fecha_nacimiento=" + fecha_nacimiento + ", fecha_alta=" + fecha_alta + ", login=" + login
				+ ", pass=" + pass + ", email=" + email + ", token=" + token + ", confirmado=" + confirmado
				+ ", id_tipo_usuario=" + id_tipo_usuario + "]";
	}


	
	
	
	
}
