package org.cardenete.entity;

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

import com.sun.istack.NotNull;

@Entity
@Table(name="imagen")
@SecondaryTables({
	@SecondaryTable(name = "usuario", pkJoinColumns = { @PrimaryKeyJoinColumn(name = "id") }),
	@SecondaryTable(name = "categoria", pkJoinColumns = { @PrimaryKeyJoinColumn(name = "id") }),
})
public class ImagenBean {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@NotNull
	private int id;
	
	@Column(name="nom_imagen")
	@NotNull
	private String nom_imagen;
	
	@Column(name="descripcion")
	private String desc;
	
	@Column(name="foto")
	@NotNull
	private String foto;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private SeccionBean id_usuario;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private UsuarioBean id_categoria;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom_imagen() {
		return nom_imagen;
	}

	public void setNom_imagen(String nom_imagen) {
		this.nom_imagen = nom_imagen;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public SeccionBean getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(SeccionBean id_usuario) {
		this.id_usuario = id_usuario;
	}

	public UsuarioBean getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(UsuarioBean id_categoria) {
		this.id_categoria = id_categoria;
	}

	@Override
	public String toString() {
		return "ImagenBean [id=" + id + ", nom_imagen=" + nom_imagen + ", desc=" + desc + ", foto=" + foto
				+ ", id_usuario=" + id_usuario + ", id_categoria=" + id_categoria + "]";
	}
	
	
	
	
}
