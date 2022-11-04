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

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "transaction_platforms")
public class TransactionPlatform {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_platform_oid")
	private long oid;

	@Column(name = "platform_name", nullable = false, unique = true)
	private String name;

	@OneToMany(mappedBy = "transactionPlatform")
	private Set<Transaction> transactions;

	public TransactionPlatform(String name) {
		super();
		this.name = name;
	}

}
