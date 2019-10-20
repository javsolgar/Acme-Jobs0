
package acme.features.anonymous.solis;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.Solis;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousSolisListService implements AbstractListService<Anonymous, Solis> {

	//	Internal state ----------------------------------------------------------------------------------

	@Autowired
	AnonymousSolisRepository repository;

	//	AbstractListService<Administrator, Solis> interface -------------------------------------


	@Override
	public boolean authorise(final Request<Solis> request) {
		assert request != null;
		return true;
	}

	@Override
	public Collection<Solis> findMany(final Request<Solis> request) {
		assert request != null;

		Collection<Solis> result;

		result = this.repository.findMany();

		return result;
	}

	@Override
	public void unbind(final Request<Solis> request, final Solis entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "state", "text", "moment");

	}

}
