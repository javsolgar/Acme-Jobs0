
package acme.features.anonymous.gonzalezbulletin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.bulletins.Gonzalezbulletin;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/gonzalezbulletin/")
public class AnonymousGonzalezbulletinController extends AbstractController<Anonymous, Gonzalezbulletin> {

	//	Internal  state ----------------------------------------------------------------------------------------

	@Autowired
	private AnonymousGonzalezbulletinListService	listService;

	@Autowired
	private AnonymousGonzalezbulletinCreateService	createService;


	//	constructor --------------------------------------------------------------------------------------------

	@PostConstruct
	private void inicialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}

}
