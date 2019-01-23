package org.cardenete.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="seccion")
public class SeccionBean {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@NotNull
	private int id;
	
	@Column(name="nom_seccion")
	private String nom_seccion;
	
	@Column(name="desc")
	private String desc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom_seccion() {
		return nom_seccion;
	}

	public void setNom_seccion(String nom_seccion) {
		this.nom_seccion = nom_seccion;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "SeccionBean [id=" + id + ", nom_seccion=" + nom_seccion + ", desc=" + desc + "]";
	}
	
	
}
