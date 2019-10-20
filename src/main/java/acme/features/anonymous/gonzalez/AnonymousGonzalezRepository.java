
package acme.features.anonymous.gonzalez;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.bulletins.Gonzalez;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousGonzalezRepository extends AbstractRepository {

	@Query("select s from Gonzalez s")
	Collection<Gonzalez> findMany();

}
