package com.estPFE.MaBonque;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.estPFE.MaBonque.Beans.ClientBean;
import com.estPFE.MaBonque.Beans.CompteBean;
import com.estPFE.MaBonque.Beans.CompteCourantBean;
import com.estPFE.MaBonque.Beans.CompteEpargneBean;
import com.estPFE.MaBonque.Beans.RetraitBean;
import com.estPFE.MaBonque.Beans.VersementBean;
import com.estPFE.MaBonque.Services.IBanqueService;
import com.estPFE.MaBonque.dao.ClientRepository;
import com.estPFE.MaBonque.dao.CompteRepository;
import com.estPFE.MaBonque.dao.OperationReapository;

@SpringBootApplication
public class ExamSpringMvcApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepo;
	@Autowired
	private CompteRepository compteRepo;
	@Autowired
	private OperationReapository operationReapo;
	@Autowired
	private IBanqueService banqueService;

	public static void main(String[] args) {
		SpringApplication.run(ExamSpringMvcApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
//		ClientBean c1 = clientRepo.save(new ClientBean("yassine", "yassine.elhalaoui@gmail.com"));
//		ClientBean c2 = clientRepo.save(new ClientBean("mouad", "mouad.Ben@gmail.com"));
//
//		CompteBean cpmt1 = compteRepo.save(new CompteCourantBean("cc001", new Date(), 20000.0, c1, 200));
//		CompteBean cpmt2 = compteRepo.save(new CompteEpargneBean("ce001", new Date(), 3000.0, c2, 300.0));
//
//		operationReapo.save(new VersementBean(new Date(), 350.0, cpmt1));
//		operationReapo.save(new VersementBean(new Date(), 400.0, cpmt1));
//		operationReapo.save(new RetraitBean(new Date(), 100.0, cpmt1));
//		operationReapo.save(new RetraitBean(new Date(), 200.0, cpmt1));
//
//		operationReapo.save(new VersementBean(new Date(), 350.0, cpmt2));
//		operationReapo.save(new VersementBean(new Date(), 350.0, cpmt2));
//		operationReapo.save(new RetraitBean(new Date(), 200.0, cpmt2));
//		operationReapo.save(new RetraitBean(new Date(), 200.0, cpmt2));
//
//		banqueService.verser("cc001", 1000.0);

	}

}
