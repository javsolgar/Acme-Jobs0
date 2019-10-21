
package acme.features.anonymous.salasbulletin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.Salasbulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousSalasbulletinCreateService implements AbstractCreateService<Anonymous, Salasbulletin> {

	//	Internal State -------------------------------------------------------------

	@Autowired
	AnonymousSalasbulletinRepository repository;


	@Override
	public boolean authorise(final Request<Salasbulletin> request) {
		assert request != null;
		return true;
	}

	@Override
	public Salasbulletin instantiate(final Request<Salasbulletin> request) {
		assert request != null;

		Salasbulletin result;

		result = new Salasbulletin();
		result.setName("Name");
		result.setSurname("Surname");
		result.setDni("12345678S");

		return result;
	}

	@Override
	public void validate(final Request<Salasbulletin> request, final Salasbulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void bind(final Request<Salasbulletin> request, final Salasbulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Salasbulletin> request, final Salasbulletin entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "surname", "dni");

	}

	@Override
	public void create(final Request<Salasbulletin> request, final Salasbulletin entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
