package org.bookery.models;

import java.util.UUID;

import org.bookery.constants.RoleType;
import org.springframework.security.core.GrantedAuthority;

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
@Table(name = "Roles")
public class Role implements GrantedAuthority 
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Getter @Setter private UUID id;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, unique = true)
	@Getter @Setter private RoleType roleType;
		
	@Override
	public String getAuthority() 
	{		
		return roleType.toString();
	}
}