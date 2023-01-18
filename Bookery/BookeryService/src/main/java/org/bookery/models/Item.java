package org.bookery.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Item")
public class Item
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Getter @Setter private UUID id;

	@ManyToOne
	@JoinColumn(name = "cartId", foreignKey = @ForeignKey(name = "cart_item_fkey"), nullable = false)
	@Getter @Setter private Cart cart;
 
	@ManyToOne
	@JoinColumn(name = "bookId", foreignKey = @ForeignKey(name = "book_item_fkey"), nullable = false)
	@Getter @Setter private Book book;

	@Column(name = "price", nullable = false)
	@Getter @Setter private Double price;
	
	@Column(name = "discount")
	@Getter @Setter private Double discount;

	@Column(name = "quantity", nullable = false)
	@Getter @Setter private int quantity;

	@Override
	public String toString() 
	{
		return String
			.format("Item [id=%s, cart=%s, book=%s, price=%s, discount=%s, quantity=%s]", 
				id, cart, book, price, discount, quantity);
	}
}