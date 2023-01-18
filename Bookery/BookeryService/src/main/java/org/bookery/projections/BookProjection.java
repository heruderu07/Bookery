package org.bookery.projections;

import java.util.List;
import java.util.UUID;

import org.bookery.constants.GenreType;
import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

public class BookProjection extends RepresentationModel<BookProjection>
{
	@Getter @Setter private UUID id;
	@Getter @Setter private List<GenreType> genres;
	@Getter @Setter private String name;
	@Getter @Setter private int inventory;
	@Getter @Setter private int price;
	@Getter @Setter private Double discount;

	public BookProjection()
	{
		super();
	}
}