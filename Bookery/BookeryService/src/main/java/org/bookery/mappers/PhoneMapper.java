package org.bookery.mappers;

import java.util.UUID;

import org.bookery.models.Phone;
import org.bookery.projections.PhoneProjection;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class PhoneMapper
{	
	ModelMapper mapper;

	public PhoneMapper()
	{
		mapper = new ModelMapper();
		
		mapper
			.createTypeMap(Phone.class, PhoneProjection.class)
			.<UUID>addMapping(source -> source.getPerson().getId(),	(destination, value) -> destination.setPersonId(value));
	}

	public PhoneProjection project(Phone model)
	{		
		return mapper.map(model, PhoneProjection.class);
	}

	public Phone unproject(PhoneProjection projection)
	{
		return mapper.map(projection, Phone.class);
	}
}