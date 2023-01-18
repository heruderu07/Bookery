package org.bookery.mappers;

import java.util.UUID;

import org.bookery.models.Item;
import org.bookery.projections.ItemProjection;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class ItemMapper
{	
	ModelMapper mapper;

	public ItemMapper()
	{
		mapper = new ModelMapper();
				
		mapper
			.createTypeMap(Item.class, ItemProjection.class)
			.<UUID>addMapping(source -> source.getBook().getId(),	(destination, value) -> destination.setBookId(value))
			.<UUID>addMapping(source -> source.getCart().getId(),	(destination, value) -> destination.setCartId(value));
	}

	public ItemProjection project(Item model)
	{		
		return mapper.map(model, ItemProjection.class);
	}

	public Item unproject(ItemProjection projection)
	{
		return mapper.map(projection, Item.class);
	}
}