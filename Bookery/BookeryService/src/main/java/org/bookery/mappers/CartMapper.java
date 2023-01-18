package org.bookery.mappers;

import java.util.UUID;

import org.bookery.models.Cart;
import org.bookery.projections.CartProjection;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class CartMapper
{	
	ModelMapper mapper;

	public CartMapper()
	{
		mapper = new ModelMapper();
		
		mapper
			.createTypeMap(Cart.class, CartProjection.class)
			.<UUID>addMapping(source -> source.getPerson().getId(),	(destination, value) -> destination.setPersonId(value));	
	}

	public CartProjection project(Cart model)
	{		
		return mapper.map(model, CartProjection.class);
	}

	public Cart unproject(CartProjection projection)
	{
		return mapper.map(projection, Cart.class);
	}
}