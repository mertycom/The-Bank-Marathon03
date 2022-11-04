package com.bilgeadam.course04.submissions.marathons.marathon03.group03.model;

import java.util.Set;

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

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "transaction_types")
public class TransactionType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_type_oid")
	private long oid;

	@Column(name = "type_name", length = 50, nullable = false, unique = true)
	private String name;

	@OneToMany(mappedBy = "transactionType")
	private Set<Transaction> transactions;

	@ManyToOne
	@JoinColumn(name = "transaction_code_oid", nullable = false)
	private TransactionCode transactionCode;

	public TransactionType(String name) {
		super();
		this.name = name;
	}

}
