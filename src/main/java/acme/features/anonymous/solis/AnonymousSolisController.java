
package acme.features.anonymous.solis;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.bulletins.Solis;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/solis/")
public class AnonymousSolisController extends AbstractController<Anonymous, Solis> {

	//	Internal state ------------------------------------------------------------------------

	@Autowired
	private AnonymousSolisListService	listService;

	@Autowired
	private AnonymousSolisCreateService	createService;


	//	Constructors --------------------------------------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}

}
