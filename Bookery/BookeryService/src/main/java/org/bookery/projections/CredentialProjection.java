package org.bookery.projections;

import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

public class CredentialProjection extends RepresentationModel<CredentialProjection>
{
	@Getter @Setter private UUID id;
	@Getter @Setter private String personName;
	@Getter @Setter private String login;
	@Getter @Setter private String password;
	
	public CredentialProjection()
	{
		super ();
	}
}
