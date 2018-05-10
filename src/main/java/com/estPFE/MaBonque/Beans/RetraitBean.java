package com.estPFE.MaBonque.Beans;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("R")
public class RetraitBean extends OperationBean {

	public RetraitBean() {
		super();
	}

	public RetraitBean(Date dateOperation, double montant, CompteBean compte) {
		super(dateOperation, montant, compte);
	}

}
