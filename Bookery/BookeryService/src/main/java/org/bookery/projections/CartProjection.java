package org.bookery.projections;

import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

public class CartProjection extends RepresentationModel<CartProjection>
{
	@Getter @Setter private UUID id;
	@Getter @Setter private UUID personId;
	@Getter @Setter private Double price;
	@Getter @Setter private Double postage;
	
	public CartProjection()
	{
		super();
	}
}