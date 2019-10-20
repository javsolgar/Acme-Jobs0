
package acme.features.anonymous.gonzalezbulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.Gonzalezbulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousGonzalezbulletinCreateService implements AbstractCreateService<Anonymous, Gonzalezbulletin> {

	//	Internal State -------------------------------------------------------------

	@Autowired
	AnonymousGonzalezbulletinRepository repository;


	@Override
	public boolean authorise(final Request<Gonzalezbulletin> request) {
		assert request != null;
		return true;
	}

	@Override
	public Gonzalezbulletin instantiate(final Request<Gonzalezbulletin> request) {
		assert request != null;

		Gonzalezbulletin result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);

		result = new Gonzalezbulletin();
		result.setAuthor("John Doe");
		result.setText("Lorem ipsum!");
		result.setAge(30);
		result.setMoment(moment);
		return result;
	}

	@Override
	public void unbind(final Request<Gonzalezbulletin> request, final Gonzalezbulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "text", "age");

	}

	@Override
	public void bind(final Request<Gonzalezbulletin> request, final Gonzalezbulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void validate(final Request<Gonzalezbulletin> request, final Gonzalezbulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<Gonzalezbulletin> request, final Gonzalezbulletin entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);

	}

}
