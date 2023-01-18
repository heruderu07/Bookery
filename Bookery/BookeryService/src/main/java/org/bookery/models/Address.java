package org.bookery.models;

import java.util.UUID;

import org.bookery.constants.AddressType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "Address", schema = "public")
public class Address 
{	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Getter @Setter private UUID id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	@Getter @Setter private AddressType type;

	@Column(name = "street")
	@Getter @Setter private String street;

	@Column(name = "number")
	@Getter @Setter private String number;

	@Column(name = "postCode")
	@Getter @Setter private String postCode;

	@Column(name = "city", nullable = false)
	@Getter @Setter private String city;

	@Column(name = "state")
	@Getter @Setter private String state;

	@Column(name = "country", nullable = false)
	@Getter @Setter private String country;

	@Column(name = "other")
	@Getter @Setter private String other;
	
	@ManyToOne
	@JoinColumn(name = "personId", foreignKey = @ForeignKey(name = "address_person_fkey"), nullable = false)
	@Getter @Setter private Person person;

	@Override
	public String toString() 
	{
		return String
			.format("Address [id=%s, type=%s, street=%s, number=%s, postCode=%s, city=%s, state=%s, country=%s, other=%s, person=%s]", 
				id, type, street, number, postCode, city, state, country, other, person);
	}	
}