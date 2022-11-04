package com.bilgeadam.course04.submissions.marathons.marathon03.group03.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
@Table (name = "customers")
@ToString (exclude = { "account"})
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_oid")
	private long oid;
	
	@Column(name = "customer_number")
	private long customerNumber;
	
	@Column(name = "customer_name", length = 50)
	private String customerName;

	@Column(name = "customer_surname")
	private String customerSurame;
	
	@OneToMany(mappedBy = "customer")
	private Set<Account> account;

	public String getFullName() {
		return this.getCustomerName()+" "+this.getCustomerSurame();
	}
	
	public void addAccount(Account account) {
		if (this.account == null) {
			this.account = new HashSet<>();
		}
		this.account.add(account);
	}
	
	public List<Account> getAccounts() {
		System.out.println();
		List<Account> list = new ArrayList();
		for (Account ent : this.account) {
			list.add(ent);
		}
		return list;
	}
	
}
