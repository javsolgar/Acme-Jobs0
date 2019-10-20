
package acme.features.anonymous.solisBulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.SolisBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousSolisBulletinListService implements AbstractListService<Anonymous, SolisBulletin> {

	//	Internal state ----------------------------------------------------------------------------------

	@Autowired
	AnonymousSolisBulletinRepository repository;

	//	AbstractListService<Administrator, SolisBulletin> interface -------------------------------------


	@Override
	public boolean authorise(final Request<SolisBulletin> request) {
		assert request != null;
		return true;
	}

	@Override
	public Collection<SolisBulletin> findMany(final Request<SolisBulletin> request) {
		assert request != null;

		Collection<SolisBulletin> result;

		result = this.repository.findMany();

		return result;
	}

	@Override
	public void unbind(final Request<SolisBulletin> request, final SolisBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "state", "text", "moment");

	}

}
