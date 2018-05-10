package com.estPFE.MaBonque.Beans;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CE")
public class CompteEpargneBean extends CompteBean {

	private double taux;

	public CompteEpargneBean() {
		super();
	}

	public CompteEpargneBean(String codeCompte, Date dateCreation, double solde, ClientBean client, double taux) {
		super(codeCompte, dateCreation, solde, client);
		this.taux = taux;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

}
