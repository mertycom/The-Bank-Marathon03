package com.bilgeadam.course04.submissions.marathons.marathon03.group03.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table (name = "accounts")
@ToString (exclude = { "customer","branch","account_type"})
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_oid")
	private long oid;
	
	@ManyToOne
	@JoinColumn(name = "customer_oid", nullable = false)
	private Customer customer;

	@Column(name = "account_number", nullable = false, unique = true)
	private long number;
	
	@ManyToOne
	@JoinColumn(name = "account_type_oid", nullable = false)
	private AccountTypes account_type;
	
	@ManyToOne
	@JoinColumn(name = "bank_branch_oid", nullable = false)
	private Branch branch;
	
	@OneToMany(mappedBy = "account")
	private Set<Transaction> transactions;
	
	public List<Transaction> getTransactions() {
		System.out.println();
		List<Transaction> list = new ArrayList();
		for (Transaction ent : this.transactions) {
			list.add(ent);
		}
		return list;
	}
	
	public String getBranchName() {
		return this.getBranch().getName();
	}
	
	public String getAccountTypeName() {
		return getAccount_type().getName();
	}
}
