package com.bilgeadam.course04.submissions.marathons.marathon03.group03.model;

import java.util.Date;
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
@Table (name = "transaction_code")
public class TransactionCode {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_code_oid")
	private long oid;
	
	@Column(name = "transaction_code_name", length = 50, nullable = false, unique = true)
	private String name;
	
	@OneToMany(mappedBy = "transactionCode")
	private Set<TransactionType> transactionType;
	
}
