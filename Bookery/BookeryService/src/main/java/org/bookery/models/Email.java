package org.bookery.models;

import java.util.UUID;

import org.bookery.constants.EmailType;

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
@Table(name = "Email")
public class Email
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Getter @Setter private UUID id;

	@ManyToOne
	@JoinColumn(name = "personId", foreignKey = @ForeignKey(name = "email_person_fkey"), nullable = false)
	@Getter @Setter private Person person;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	@Getter @Setter private EmailType type;

	@Column(name = "address", nullable = false)
	@Getter @Setter private String address;
	
	@Override
	public String toString() 
	{
		return String
			.format("Email [id=%s, person=%s, type=%s, address=%s]", 
				id, person, type, address);
	}
}