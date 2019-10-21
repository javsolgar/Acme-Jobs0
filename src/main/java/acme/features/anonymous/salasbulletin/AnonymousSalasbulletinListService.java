
package acme.features.anonymous.salasbulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.Salasbulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousSalasbulletinListService implements AbstractListService<Anonymous, Salasbulletin> {

	//	Internal state ----------------------------------------------------------------------------------

	@Autowired
	AnonymousSalasbulletinRepository repository;


	//	AbstractListService<Administrator, SalasBulletin> interface ---------------------------------------------

	@Override
	public boolean authorise(final Request<Salasbulletin> request) {
		assert request != null;
		return true;
	}

	@Override
	public Collection<Salasbulletin> findMany(final Request<Salasbulletin> request) {
		assert request != null;

		Collection<Salasbulletin> result;

		result = this.repository.findMany();

		return result;
	}

	@Override
	public void unbind(final Request<Salasbulletin> request, final Salasbulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "surname", "dni");

	}
}
