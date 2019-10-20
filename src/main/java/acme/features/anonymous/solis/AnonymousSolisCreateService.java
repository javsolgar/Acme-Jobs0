
package acme.features.anonymous.solis;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.Solis;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousSolisCreateService implements AbstractCreateService<Anonymous, Solis> {

	// Internal Sate ---------------------------------------------------------------------------------------

	@Autowired
	AnonymousSolisRepository repository;


	@Override
	public boolean authorise(final Request<Solis> request) {
		assert request != null;
		return true;
	}

	@Override
	public Solis instantiate(final Request<Solis> request) {
		assert request != null;

		Solis result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);

		result = new Solis();
		result.setAuthor("Mick Wallas");
		result.setState("Nervous");
		result.setText("I'm gonna have my last exam of ADDA");
		result.setMoment(moment);

		return result;
	}

	@Override
	public void unbind(final Request<Solis> request, final Solis entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "author", "state", "text");
	}

	@Override
	public void bind(final Request<Solis> request, final Solis entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors);

	}

	@Override
	public void validate(final Request<Solis> request, final Solis entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<Solis> request, final Solis entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);

	}

}
