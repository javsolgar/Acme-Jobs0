
package acme.features.anonymous.salasbulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.bulletins.Salasbulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousSalasbulletinRepository extends AbstractRepository {

	@Query("select s from Salasbulletin s")
	Collection<Salasbulletin> findMany();

}
