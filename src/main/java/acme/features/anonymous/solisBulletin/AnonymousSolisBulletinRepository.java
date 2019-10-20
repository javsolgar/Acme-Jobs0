
package acme.features.anonymous.solisBulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.bulletins.SolisBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousSolisBulletinRepository extends AbstractRepository {

	@Query("select s from SolisBulletin s")
	Collection<SolisBulletin> findMany();

}
