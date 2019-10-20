
package acme.features.anonymous.solis;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.bulletins.Solis;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousSolisRepository extends AbstractRepository {

	@Query("select s from Solis s")
	Collection<Solis> findMany();

}
