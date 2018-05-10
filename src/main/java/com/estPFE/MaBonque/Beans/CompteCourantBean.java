package com.estPFE.MaBonque.Beans;

import java.util.Date;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC")
public class CompteCourantBean extends CompteBean {

	private double decouvert;

	public CompteCourantBean() {
		super();
	}

	public CompteCourantBean(String codeCompte, Date dateCreation, double solde, ClientBean client, double decouvert) {
		super(codeCompte, dateCreation, solde, client);
		this.decouvert = decouvert;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

}
