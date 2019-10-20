
package acme.features.anonymous.solisBulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.SolisBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousSolisBulletinCreateService implements AbstractCreateService<Anonymous, SolisBulletin> {

	// Internal Sate ---------------------------------------------------------------------------------------

	@Autowired
	AnonymousSolisBulletinRepository repository;


	@Override
	public boolean authorise(final Request<SolisBulletin> request) {
		assert request != null;
		return false;
	}

	@Override
	public SolisBulletin instantiate(final Request<SolisBulletin> request) {
		assert request != null;

		SolisBulletin result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);

		result = new SolisBulletin();
		result.setAuthor("Mick Wallas");
		result.setState("Nervous");
		result.setText("I'm gonna have my last exam of ADDA");
		result.setMoment(moment);

		return result;
	}

	@Override
	public void unbind(final Request<SolisBulletin> request, final SolisBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "author", "state", "text");
	}

	@Override
	public void bind(final Request<SolisBulletin> request, final SolisBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors);

	}

	@Override
	public void validate(final Request<SolisBulletin> request, final SolisBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<SolisBulletin> request, final SolisBulletin entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);

	}

}
