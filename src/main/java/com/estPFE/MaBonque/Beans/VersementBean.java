package com.estPFE.MaBonque.Beans;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("V")
public class VersementBean extends OperationBean {

	public VersementBean() {
		super();
	}

	public VersementBean(Date dateOperation, double montant, CompteBean compte) {
		super(dateOperation, montant, compte);
	}

}
