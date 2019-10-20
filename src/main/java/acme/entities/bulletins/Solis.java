
package acme.entities.bulletins;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Solis extends DomainEntity {

	//Serialization identifier --------------------------------------------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	//	Atributes ---------------------------------------------------------------------------------------------------

	@NotBlank
	private String				author;

	@NotBlank
	private String				state;

	@NotBlank
	private String				text;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				moment;

}
