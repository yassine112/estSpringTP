package com.estPFE.MaBonque.Beans;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ClientBean implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	private String name;
	private String email;
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	private Set<CompteBean> comptes;

	public ClientBean() {
		super();
	}

	public ClientBean(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<CompteBean> getComptes() {
		return comptes;
	}

	public void setComptes(Set<CompteBean> comptes) {
		this.comptes = comptes;
	}

}
