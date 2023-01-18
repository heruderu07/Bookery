package org.bookery.mappers;

import org.bookery.models.Book;
import org.bookery.projections.BookProjection;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class BookMapper
{	
	ModelMapper mapper;

	public BookMapper()
	{
		mapper = new ModelMapper();
	}

	public BookProjection project(Book model)
	{		
		return mapper.map(model, BookProjection.class);
	}

	public Book unproject(BookProjection projection)
	{
		return mapper.map(projection, Book.class);
	}
}