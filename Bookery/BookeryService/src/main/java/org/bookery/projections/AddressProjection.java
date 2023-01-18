package org.bookery.projections;

import java.util.UUID;

import org.bookery.constants.AddressType;
import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

public class AddressProjection extends RepresentationModel<AddressProjection>
{	
	@Getter @Setter	private UUID id;
	@Getter @Setter	private UUID personId;
	@Getter @Setter	private AddressType type;
	@Getter @Setter	private String street;
	@Getter @Setter	private String number;
	@Getter @Setter	private String postCode;
	@Getter @Setter	private String city;
	@Getter @Setter	private String state;
	@Getter @Setter	private String country;
	@Getter @Setter	private String other;
	
	public AddressProjection() 
	{
		super();		
	}
}