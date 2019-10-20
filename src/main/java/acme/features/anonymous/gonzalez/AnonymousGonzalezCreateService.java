
package acme.features.anonymous.gonzalez;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.Gonzalez;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousGonzalezCreateService implements AbstractCreateService<Anonymous, Gonzalez> {

	//	Internal State -------------------------------------------------------------

	@Autowired
	AnonymousGonzalezRepository repository;


	@Override
	public boolean authorise(final Request<Gonzalez> request) {
		assert request != null;
		return true;
	}

	@Override
	public Gonzalez instantiate(final Request<Gonzalez> request) {
		assert request != null;

		Gonzalez result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);

		result = new Gonzalez();
		result.setAuthor("John Doe");
		result.setText("Lorem ipsum!");
		result.setCity("Madrid");
		result.setMoment(moment);
		return result;
	}

	@Override
	public void unbind(final Request<Gonzalez> request, final Gonzalez entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "text", "city");

	}

	@Override
	public void bind(final Request<Gonzalez> request, final Gonzalez entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void validate(final Request<Gonzalez> request, final Gonzalez entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<Gonzalez> request, final Gonzalez entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);

	}

}
