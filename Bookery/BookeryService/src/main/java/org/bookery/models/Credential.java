package org.bookery.models;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Credential", uniqueConstraints = @UniqueConstraint(name = "login_ukey", columnNames = { "login" }))
public class Credential implements UserDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Getter @Setter private UUID id;

	@OneToOne(fetch = FetchType.LAZY)
    @MapsId    
    @JoinColumn(name = "id", foreignKey = @ForeignKey(name = "user_person_fkey"))	
	@Getter @Setter private Person person;
	
	@Column(name = "login", nullable = false)
	@Getter @Setter	private String login;
	
	@Column(name = "password", nullable = false)
	@Getter @Setter private String password;
	
	@ManyToMany
	@JoinTable(name = "table_credential_role",
	joinColumns = @JoinColumn(name = "credentialId"),
	inverseJoinColumns = @JoinColumn(name = "roleId"))
	private List<Role> roles;

	
	public String toString() 
	{
		return String
			.format("Credential [id=%s, person=%s, login=%s, password=%s, roles=%s]", 
				id, person, login, password, roles);
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {	
		
		return this.roles;
	}


		
	@Override
	public String getUsername() {
		
		return this.login;
	}


	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}


	@Override
	public boolean isEnabled() {

		return true;
	}
	
}
