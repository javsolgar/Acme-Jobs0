
package acme.features.anonymous.gonzalezbulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.Gonzalezbulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousGonzalezbulletinListService implements AbstractListService<Anonymous, Gonzalezbulletin> {

	//	Internal state ----------------------------------------------------------------------------------

	@Autowired
	AnonymousGonzalezbulletinRepository repository;


	//	AbstractListService<Administrator, Shout> interface ---------------------------------------------

	@Override
	public boolean authorise(final Request<Gonzalezbulletin> request) {
		assert request != null;
		return true;
	}

	@Override
	public Collection<Gonzalezbulletin> findMany(final Request<Gonzalezbulletin> request) {
		assert request != null;

		Collection<Gonzalezbulletin> result;

		result = this.repository.findMany();

		return result;
	}

	@Override
	public void unbind(final Request<Gonzalezbulletin> request, final Gonzalezbulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "text", "age", "moment");
	}
}
