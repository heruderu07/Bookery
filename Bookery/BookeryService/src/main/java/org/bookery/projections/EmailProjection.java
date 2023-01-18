package org.bookery.projections;

import java.util.UUID;

import org.bookery.constants.EmailType;
import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

public class EmailProjection extends RepresentationModel<EmailProjection>
{
	@Getter @Setter private UUID id;
	@Getter @Setter private UUID personId;
	@Getter @Setter private EmailType type;
	@Getter @Setter private String address;
	
	public EmailProjection()
	{
		super();
	}
}