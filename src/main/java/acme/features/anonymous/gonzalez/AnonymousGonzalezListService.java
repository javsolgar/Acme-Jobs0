
package acme.features.anonymous.gonzalez;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.shouts.Gonzalez;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousGonzalezListService implements AbstractListService<Anonymous, Gonzalez> {

	//	Internal state ----------------------------------------------------------------------------------

	@Autowired
	AnonymousGonzalezRepository repository;


	//	AbstractListService<Administrator, Shout> interface ---------------------------------------------

	@Override
	public boolean authorise(final Request<Gonzalez> request) {
		assert request != null;
		return true;
	}

	@Override
	public Collection<Gonzalez> findMany(final Request<Gonzalez> request) {
		assert request != null;

		Collection<Gonzalez> result;

		result = this.repository.findMany();

		return result;
	}

	@Override
	public void unbind(final Request<Gonzalez> request, final Gonzalez entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "text", "city", "moment");
	}
}
