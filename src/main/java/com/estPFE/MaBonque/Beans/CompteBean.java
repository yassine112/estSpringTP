package com.estPFE.MaBonque.Beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CMPT", discriminatorType = DiscriminatorType.STRING, length = 2)
public class CompteBean implements Serializable {

	@Id
	private String codeCompte;
	private Date dateCreation;
	private double solde;
	@ManyToOne
	@JoinColumn(name = "codeClient")
	private ClientBean client;
	@OneToMany(mappedBy = "compte")
	private Set<OperationBean> operations;

	public CompteBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteBean(String codeCompte, Date dateCreation, double solde, ClientBean client) {
		super();
		this.codeCompte = codeCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.client = client;
	}

	public String getCodeCompte() {
		return codeCompte;
	}

	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public ClientBean getClient() {
		return client;
	}

	public void setClient(ClientBean client) {
		this.client = client;
	}

	public Set<OperationBean> getOperations() {
		return operations;
	}

	public void setOperations(Set<OperationBean> operations) {
		this.operations = operations;
	}

}
