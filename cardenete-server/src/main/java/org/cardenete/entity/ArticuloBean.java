package org.cardenete.entity;

import java.util.Date;

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

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

@Entity
@Table(name="articulo")
@SecondaryTables({
	@SecondaryTable(name = "seccion", pkJoinColumns = { @PrimaryKeyJoinColumn(name = "id") }),
	@SecondaryTable(name = "usuario", pkJoinColumns = { @PrimaryKeyJoinColumn(name = "id") })
})
@DynamicUpdate(value=true)
public class ArticuloBean {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@NotNull
	private int id;
	
	@Column(name="titulo")
	@NotNull
	private String titulo;
	
	@Column(name="descripcion")
	private String desc;
	
	@Column(name="fecha")
	// @NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "Europe/Madrid")
	private Date fecha;
	
	@Column(name="articulo")
	@NotNull
	private String articulo;
	
	@Column(name="etiquetas")
	private String etiquetas;
	
	@ManyToOne
	@JoinColumn(name = "id_seccion")
	private SeccionBean id_seccion;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private UsuarioBean id_usuario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getArticulo() {
		return articulo;
	}

	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}

	public String getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(String etiquetas) {
		this.etiquetas = etiquetas;
	}

	public SeccionBean getId_seccion() {
		return id_seccion;
	}

	public void setId_seccion(SeccionBean id_seccion) {
		this.id_seccion = id_seccion;
	}

	public UsuarioBean getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(UsuarioBean id_usuario) {
		this.id_usuario = id_usuario;
	}

	@Override
	public String toString() {
		return "ArticuloBean [id=" + id + ", titulo=" + titulo + ", desc=" + desc + ", fecha=" + fecha + ", articulo="
				+ articulo + ", etiquetas=" + etiquetas + ", id_seccion=" + id_seccion + ", id_usuario=" + id_usuario
				+ "]";
	}
	
	
	
	
	
}
