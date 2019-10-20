
package acme.features.anonymous.gonzalez;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.shouts.Gonzalez;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/gonzalez/")
public class AnonymousGonzalezController extends AbstractController<Anonymous, Gonzalez> {

	//	Internal  state ----------------------------------------------------------------------------------------

	@Autowired
	private AnonymousGonzalezListService	listService;

	@Autowired
	private AnonymousGonzalezCreateService	createService;


	//	constructor --------------------------------------------------------------------------------------------

	@PostConstruct
	private void inicialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}

}
