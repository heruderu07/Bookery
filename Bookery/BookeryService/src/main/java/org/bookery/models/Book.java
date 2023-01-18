package org.bookery.models;

import java.util.List;
import java.util.UUID;

import org.bookery.constants.GenreType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Book")
public class Book
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Getter @Setter private UUID id;

	@Enumerated(EnumType.STRING)
	@Column(name = "genres", nullable = false)
	@Getter @Setter private List<GenreType> genres;

	@Column(name = "name", nullable = false)
	@Getter @Setter private String name;

	@Column(name = "inventory", nullable = false)
	@Getter @Setter private int inventory;

	@Column(name = "price", nullable = false)
	@Getter @Setter private int price;

	@Column(name = "discount")
	@Getter @Setter private Double discount;

	@Override
	public String toString() 
	{
		return String
			.format("Book [id=%s, genres=%s, name=%s, inventory=%s, price=%s, discount=%s]", 
				id,	genres, name, inventory, price, discount);
	}
}