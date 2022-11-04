package com.bilgeadam.course04.submissions.marathons.marathon03.group03.model;

import java.time.LocalDate;
import java.util.List;
import com.bilgeadam.course04.submissions.marathons.marathon03.group03.dao.TransactionCodeDAO;
import com.bilgeadam.course04.submissions.marathons.marathon03.group03.dao.TransactionTypeDAO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "transactions")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_oid")
	private long oid;

	@ManyToOne
	@JoinColumn(name = "account_oid", nullable = false)
	private Account account;

	@Column(name = "transaction_number", nullable = false)
	private long number;

	@ManyToOne
	@JoinColumn(name = "transaction_type_oid", nullable = false)
	private TransactionType transactionType;

	@Column(name = "transaction_amount", nullable = false)
	private long amount;

	@Column(name = "date", nullable = false)
	private LocalDate date;

	@ManyToOne
	@JoinColumn(name = "transaction_platform_oid", nullable = false)
	private TransactionPlatform transactionPlatform;

	public Transaction(long number, long amount, LocalDate date) {
		super();
		this.number = number;
		this.amount = amount;
		this.date = date;
	}

	private List<TransactionCode> getTransactionCodeList() {
		TransactionCodeDAO transCodeDao = new TransactionCodeDAO();
		List<TransactionCode> transactionCodeList = transCodeDao.retrieve();
		return transactionCodeList;
	}

	private List<TransactionType> getTransactionTypeList() {
		TransactionTypeDAO transCodeDao = new TransactionTypeDAO();
		List<TransactionType> transactionCodeList = transCodeDao.retrieve();
		return transactionCodeList;
	}

	public String getTransactionCodeName() {
		return getTransactionType().getTransactionCode().getName();

	}

	public String getTransactionPlatformName() {
		return getTransactionPlatform().getName();
	}

	public String getTransDate() {
		LocalDate date = getDate();

		return date.getDayOfMonth() + "." + date.getMonthValue() + "." + date.getYear();
	}

	public String getTransactionTypeName() {
		return getTransactionType().getName();

	}

}
