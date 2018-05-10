package com.estPFE.MaBonque.Services;

import org.springframework.data.domain.Page;

import com.estPFE.MaBonque.Beans.CompteBean;
import com.estPFE.MaBonque.Beans.OperationBean;

public interface IBanqueService {
	public CompteBean consulterCompte(String codeCmpt);
	public void verser(String codeCmpt, double montant);
	public void retirer(String codeCmpt, double montant);
	public void virement(String codeCmptFrom, String codeCmptTo, double montant);
	public Page<OperationBean> listOperations(String codeCmpt, int page, int size);
	
}
