package org.cardenete.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.sun.istack.NotNull;

@Entity
@Table(name="categoria")
@DynamicUpdate(value=true)
public class CategoriaBean {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@NotNull
	private int id;
	
	@Column(name="descripcion")
	@NotNull
	private String desc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "CategoriaBean [id=" + id + ", desc=" + desc + "]";
	}
}
