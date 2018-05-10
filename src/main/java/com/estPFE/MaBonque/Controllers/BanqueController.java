package com.estPFE.MaBonque.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.estPFE.MaBonque.Beans.CompteBean;
import com.estPFE.MaBonque.Beans.OperationBean;
import com.estPFE.MaBonque.Services.IBanqueService;

@Controller
public class BanqueController {
	
	@Autowired
	private IBanqueService banqueService;
	
	@RequestMapping("/opt")
	public String index() {
		return "comptes";
	}
	
	@RequestMapping("/consultecompte")
	public String consulter(Model model,String codeCompte, @RequestParam(name="page", defaultValue = "0")int page, @RequestParam(name="size", defaultValue = "4")int size) {
		model.addAttribute("codeCompte", codeCompte);
		try {
			CompteBean compte = banqueService.consulterCompte(codeCompte);
			
			Page<OperationBean> pageOperation = banqueService.listOperations(codeCompte, page, size);
			int[] pages = new int[pageOperation.getTotalPages()];
			
			model.addAttribute("compte", compte);
			model.addAttribute("listOperation", pageOperation.getContent());
			model.addAttribute("pages", pages);
		} catch (Exception e) {
			model.addAttribute("exeption", e);
		}
		return "comptes";
	}
	
	@RequestMapping(value = "/operationsave", method = RequestMethod.POST)
	public String operationSave(Model model, String typeOpt, String codeCompte, double montant, String vers) {
		try {
			switch (typeOpt) {
				case "VERS":
					banqueService.verser(codeCompte, montant);
					break;
				case "RETR":
					banqueService.retirer(codeCompte, montant);
					break;
				case "VIR":
					banqueService.virement(codeCompte, vers, montant);
					break;
				default:
					model.addAttribute("error", "Type operation incorrect");
					break;
			}
		} catch (Exception e) {
			return "redirect:/consultecompte?codeCompte=" + codeCompte + "&error=" + e.getMessage();
		}
		
		return "redirect:/consultecompte?codeCompte=" + codeCompte;
	}

}
