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
@Table(name = "Cart")
public class Cart
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Getter @Setter private UUID id;

	@Column(name = "price", nullable = false)
	@Getter @Setter private Double price;

	@Column(name = "postage", nullable = false)
	@Getter @Setter private Double postage;

	@ManyToOne
	@JoinColumn(name = "personId", foreignKey = @ForeignKey(name = "cart_person_fkey"), nullable = false)
	@Getter @Setter private Person person;
 
	@Override
	public String toString() 
	{
		return String
			.format("Cart [id=%s, price=%s, postage=%s, person=%s]", 
				id, price, postage, person);
	}
}