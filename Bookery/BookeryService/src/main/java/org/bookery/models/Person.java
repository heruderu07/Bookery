package org.bookery.models;

import java.util.Date;
import java.util.UUID;

import org.bookery.constants.PersonType;

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
@Table(name = "Person")
public class Person
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Getter @Setter private UUID id;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	@Getter @Setter private PersonType type;

	@Column(name = "taxNumber", nullable = false)
	@Getter @Setter private String taxNumber;

	@Column(name = "birthdate", nullable = false)
	@Getter @Setter private Date birthdate;

	@Column(name = "name")
	@Getter @Setter private String name;
	
	@Column(name = "surname", nullable = false)
	@Getter @Setter private String surname;
	
	@Column(name = "discount")
	@Getter @Setter private Double discount;

	@Override
	public String toString() 
	{
		return String
			.format("Person [id=%s, credential=%s, type=%s, taxNumber=%s, birthdate=%s, name=%s, surname=%s, discount=%s]", 
				id, type, taxNumber, birthdate, name, surname, discount);
	}
}