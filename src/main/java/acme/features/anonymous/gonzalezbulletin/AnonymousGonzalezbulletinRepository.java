
package acme.features.anonymous.gonzalezbulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.bulletins.Gonzalezbulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousGonzalezbulletinRepository extends AbstractRepository {

	@Query("select s from Gonzalezbulletin s")
	Collection<Gonzalezbulletin> findMany();

}
