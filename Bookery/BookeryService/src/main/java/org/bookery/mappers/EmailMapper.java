package org.bookery.mappers;

import java.util.UUID;

import org.bookery.models.Email;
import org.bookery.projections.EmailProjection;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class EmailMapper
{	
	ModelMapper mapper;

	public EmailMapper()
	{
		mapper = new ModelMapper();
		
		mapper
			.createTypeMap(Email.class, EmailProjection.class)
			.<UUID>addMapping(source -> source.getPerson().getId(),	(destination, value) -> destination.setPersonId(value));		
	}

	public EmailProjection project(Email model)
	{		
		return mapper.map(model, EmailProjection.class);
	}

	public Email unproject(EmailProjection projection)
	{
		return mapper.map(projection, Email.class);
	}
}