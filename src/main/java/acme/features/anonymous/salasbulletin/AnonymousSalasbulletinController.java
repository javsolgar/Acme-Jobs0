
package acme.features.anonymous.salasbulletin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.bulletins.Salasbulletin;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/salasbulletin/")
public class AnonymousSalasbulletinController extends AbstractController<Anonymous, Salasbulletin> {

	//	Internal  state ----------------------------------------------------------------------------------------

	@Autowired
	private AnonymousSalasbulletinListService	listService;

	@Autowired
	private AnonymousSalasbulletinCreateService	createService;


	//	constructor --------------------------------------------------------------------------------------------

	@PostConstruct
	private void inicialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}

}
