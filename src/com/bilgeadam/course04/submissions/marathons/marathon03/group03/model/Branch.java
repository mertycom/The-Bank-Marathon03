package com.bilgeadam.course04.submissions.marathons.marathon03.group03.model;

import java.util.HashSet;
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
@Table(name = "bank_branches")
@ToString
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bank_branch_oid")
	private long oid;

	@Column(name = "branch_number", nullable = false, unique = true)
	private long number;

	@Column(name = "branch_name", length = 50, nullable = false)
	private String name;

	@OneToMany(mappedBy = "branch")
	private Set<Account> account;

	public Branch(long number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	public void addAccount(Account account) {
		if (this.account == null) {
			this.account = new HashSet<>();
		}
		this.account.add(account);
	}

}
