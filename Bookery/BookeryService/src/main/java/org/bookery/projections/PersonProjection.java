package org.bookery.projections;

import java.util.Date;
import java.util.UUID;

import org.bookery.constants.PersonType;
import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

public class PersonProjection extends RepresentationModel<PersonProjection>
{
	@Getter @Setter private UUID id;
	@Getter @Setter private PersonType type;
	@Getter @Setter private String taxNumber;
	@Getter @Setter private Date birthdate;
	@Getter @Setter private String name;
	@Getter @Setter private String surname;
	@Getter @Setter private Double discount;

	public PersonProjection()
	{
		super();
	}
}