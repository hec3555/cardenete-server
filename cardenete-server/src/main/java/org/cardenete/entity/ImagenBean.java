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
@Table(name="articulo")
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
	
	@Column(name="desc")
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
	
}
