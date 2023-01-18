package org.bookery.projections;

import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

public class ItemProjection extends RepresentationModel<ItemProjection>
{
	@Getter @Setter private UUID id;
	@Getter @Setter private UUID cartId;
	@Getter @Setter private UUID bookId;
	@Getter @Setter private Double discount;
	@Getter @Setter private Double price;
	@Getter @Setter private int quantity;
	
	public ItemProjection()
	{
		super();
	}
}