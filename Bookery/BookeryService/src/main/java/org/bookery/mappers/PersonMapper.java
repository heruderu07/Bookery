package org.bookery.mappers;

import org.bookery.models.Person;
import org.bookery.projections.PersonProjection;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class PersonMapper
{	
	ModelMapper mapper;

	public PersonMapper()
	{
		mapper = new ModelMapper();
	
	}

	public PersonProjection project(Person model)
	{		
		return mapper.map(model, PersonProjection.class);
	}

	public Person unproject(PersonProjection projection)
	{
		return mapper.map(projection, Person.class);
	}
}