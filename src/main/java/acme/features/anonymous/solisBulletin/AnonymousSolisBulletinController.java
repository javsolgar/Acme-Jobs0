
package acme.features.anonymous.solisBulletin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.bulletins.SolisBulletin;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/SolisBulletin/")
public class AnonymousSolisBulletinController extends AbstractController<Anonymous, SolisBulletin> {

	//	Internal state ------------------------------------------------------------------------

	@Autowired
	private AnonymousSolisBulletinListService	listService;

	@Autowired
	private AnonymousSolisBulletinCreateService	createService;


	//	Constructors --------------------------------------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}

}
