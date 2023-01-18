package org.bookery.mappers;

import java.util.UUID;

import org.bookery.models.Address;
import org.bookery.projections.AddressProjection;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class AddressMapper
{	
	ModelMapper mapper;

	public AddressMapper()
	{
		mapper = new ModelMapper();

		mapper
			.createTypeMap(Address.class, AddressProjection.class)
			.<UUID>addMapping(source -> source.getPerson().getId(),	(destination, value) -> destination.setPersonId(value));
	}

	public AddressProjection project(Address model)
	{		
		return mapper.map(model, AddressProjection.class);
	}

	public Address unproject(AddressProjection projection)
	{
		return mapper.map(projection, Address.class);
	}
}