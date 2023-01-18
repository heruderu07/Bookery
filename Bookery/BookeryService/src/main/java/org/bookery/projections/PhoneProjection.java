package org.bookery.projections;

import java.util.UUID;

import org.bookery.constants.PhoneType;
import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

public class PhoneProjection extends RepresentationModel<PhoneProjection>
{		
	@Getter @Setter private UUID id;
	@Getter @Setter private UUID personId;
	@Getter @Setter private PhoneType type;
	@Getter @Setter private String number;

	public PhoneProjection() 
	{
		super();		
	}	
}