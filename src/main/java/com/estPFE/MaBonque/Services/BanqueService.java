package com.estPFE.MaBonque.Services;

import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;
import java.util.Date;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estPFE.MaBonque.Beans.CompteBean;
import com.estPFE.MaBonque.Beans.CompteCourantBean;
import com.estPFE.MaBonque.Beans.OperationBean;
import com.estPFE.MaBonque.Beans.RetraitBean;
import com.estPFE.MaBonque.Beans.VersementBean;
import com.estPFE.MaBonque.dao.CompteRepository;
import com.estPFE.MaBonque.dao.OperationReapository;

@Service
@Transactional
public class BanqueService implements IBanqueService {

	@Autowired
	private CompteRepository compteRepo;
	@Autowired
	private OperationReapository opreationRepo;
	
	@Override
	public CompteBean consulterCompte(String codeCmpt) {
		Optional<CompteBean> compte = compteRepo.findById(codeCmpt);
		if (!compte.isPresent()) throw new RuntimeException("Compte Introuvable");
		return compte.get();
	}

	@Override
	public void verser(String codeCmpt, double montant) {
		CompteBean compte = consulterCompte(codeCmpt);
		VersementBean v = new VersementBean(new Date(), montant, compte);
		opreationRepo.save(v);
		compte.setSolde(compte.getSolde() + montant);
		compteRepo.save(compte);
	}

	@Override
	public void retirer(String codeCmpt, double montant) {
		Optional<CompteBean> compte = compteRepo.findById(codeCmpt);
		double facilitesCaisse = 0;
		
		if (compte.get() instanceof CompteCourantBean)
			facilitesCaisse = ((CompteCourantBean) compte.get()).getDecouvert();
		if (compte.get().getSolde()+facilitesCaisse < montant)
			throw new RuntimeException("Solde insuffisant");
		RetraitBean r = new RetraitBean(new Date(), montant, compte.get());
		opreationRepo.save(r);
		compte.get().setSolde(compte.get().getSolde() + montant);
		compteRepo.save(compte.get());		
	}

	@Override
	public void virement(String codeCmptFrom, String codeCmptTo, double montant) {
		if (codeCmptFrom.equals(codeCmptTo))
			throw new RuntimeException("Virement sur le même compte est impossible");
		retirer(codeCmptFrom, montant);
		verser(codeCmptTo, montant);
	}

	@Override
	public Page<OperationBean> listOperations(String codeCmpt, int page, int size) {
		return opreationRepo.listOperations(codeCmpt, new PageRequest(page, size));
	}

}
