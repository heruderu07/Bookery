package org.bookery.mappers;

import org.bookery.models.Credential;
import org.bookery.projections.CredentialProjection;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;



@Component
public class CredentialMapper 
{
	
	ModelMapper modelMapper;

	public CredentialMapper()
{
		modelMapper = new ModelMapper();
	
		modelMapper
	.createTypeMap(Credential.class, CredentialProjection.class)
	.<String>addMapping(source -> source.getPerson().getName(),	(destination, value) -> destination.setPersonName(value));

}

public CredentialProjection project(Credential model)
{		
	return modelMapper.map(model, CredentialProjection.class);
}

public Credential unproject(CredentialProjection projection)
{
	return modelMapper.map(projection, Credential.class);
}
}