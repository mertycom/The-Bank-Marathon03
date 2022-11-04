package com.bilgeadam.course04.submissions.marathons.marathon03.group03.view;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import com.bilgeadam.course04.submissions.marathons.marathon03.group03.dao.CustomerDAO;
import com.bilgeadam.course04.submissions.marathons.marathon03.group03.model.Account;
import com.bilgeadam.course04.submissions.marathons.marathon03.group03.model.Customer;
import com.bilgeadam.course04.submissions.marathons.marathon03.group03.model.Transaction;
import com.bilgeadam.course04.submissions.marathons.marathon03.group03.util.CommonData;

public class Menu {

	public static void showMenu() {
		while (true) {
			System.out.println("1 - Musterilere ait hesap hareketlerini ver");
			System.out.println("0 - Programi sonlandir ");
			try {
				int selection = CommonData.getInstance().getScanner().nextInt();
				CommonData.getInstance().getScanner().nextLine();
				if (processSelection(selection)) {
					break;
				}
			} catch (Exception ex) {
				System.out.println("Doğru değer giriniz!");
				continue;
			}
		}
		System.out.println("Bye....");

	}

	public static void getCostumersAccount() {
		List<Customer> custList = new ArrayList<Customer>();
		CustomerDAO customerDAO = new CustomerDAO();
		List<Account> accountListForCustomer = new ArrayList<Account>();
		List<Transaction> transactionListForAccount = new ArrayList<Transaction>();

		custList = customerDAO.retrieve();

		Formatter fmt = new Formatter();
		
		fmt.format("========================================================================="
				+ "=====================================================\n");
		fmt.format("========================================================================="
				+ "=====================================================\n");
		for (Customer customer : custList) {
			fmt.format("%15s %15s \n", "Musteri No", "Musteri Adi");

			fmt.format("%15s %15s \n", customer.getCustomerNumber(), customer.getFullName());

			accountListForCustomer = customer.getAccounts();
			for (Account account : accountListForCustomer) {
				fmt.format("%15s %15s %15s %15s %15s\n", "", "", "Sube No", "Hesap No", "Hesap Turu");

				fmt.format("%15s %15s %15s %15s %15s\n", "", "", account.getBranchName(), account.getNumber(),
						account.getAccountTypeName());

				transactionListForAccount = account.getTransactions();
				for (Transaction transaction : transactionListForAccount) {
					fmt.format("%15s %15s %15s\n", "", "", "HESAP HAREKETLERI");

					fmt.format("%15s %15s %15s %15s %15s %25s %20s\n", "", "", "Tarih", "Islem Kodu", "Hareket",
							"Islem", "Islem Bakiyesi");

					fmt.format("%15s %15s %15s %15s %15s %25s %20s\n", "", "", transaction.getTransDate(),
							transaction.getTransactionCodeName(), transaction.getNumber(),
							transaction.getTransactionPlatformName() + "den " + transaction.getTransactionTypeName(),
							transaction.getAmount());

				}
				fmt.format("-----------------------------------------------------------------"
						+ "-------------------------------------------------------------\n");
			}
			fmt.format("========================================================================="
					+ "=====================================================\n");
			fmt.format("========================================================================="
					+ "=====================================================\n");
		}
		System.out.println(fmt);
	}

	public static boolean processSelection(int selection) {
		if (selection == 0)
			return true;

		switch (selection) {
		case 1:
			getCostumersAccount();
			break;
		default:
			break;
		}
		return false;
	}
}
