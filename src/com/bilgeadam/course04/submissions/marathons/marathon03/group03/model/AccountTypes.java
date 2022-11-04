package com.bilgeadam.course04.submissions.marathons.marathon03.group03.model;

import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table (name = "account_types")
@ToString
public class AccountTypes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_type_oid")
	private long oid;
	
	@Column(name = "account_type_number", nullable = false, unique = true)
	private int number;
	
	@Column(name = "account_type_name", length = 50, nullable = false, unique = true)
	private String name;
	
	@OneToMany(mappedBy = "account_type")
	private Set<Account> account;

	public AccountTypes(int number, String name) {
		super();
		this.number = number;
		this.name = name;
	}
	
}
