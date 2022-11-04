package com.bilgeadam.course04.submissions.marathons.marathon03.group03.view;

import java.util.ArrayList;
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
		
		
		for (Customer customer : custList) {
			System.out.println("Musteri No\tMusteri Adi");
			System.out.println(customer.getCustomerNumber() + "\t\t" + customer.getFullName());
			accountListForCustomer=customer.getAccounts();
			for (Account account : accountListForCustomer) {				
				System.out.println("\t\t\tSube\t\tHesap No\tHesap Turu");
				System.out.println("\t\t\t"+account.getBranchName()+"\t\t"+account.getNumber()+"\t\t"+account.getAccountTypeName());
				transactionListForAccount=account.getTransactions();
				for (Transaction transaction : transactionListForAccount) {
					
					System.out.println("\t\t\tHESAP HAREKETLERI");
					System.out.println("\t\t\tTarih\t\tIslem Kodu\tHareket\t\tIslem\t\t\t\tIslem Bakiyesi");
					System.out.println("\t\t\t"+transaction.getTransDate() + "\t"+transaction.getTransactionCodeName()+
							"\t\t"+transaction.getNumber()+"\t\t"+transaction.getTransactionPlatformName()+
							"den "+transaction.getTransactionTypeName()+"\t\t"+transaction.getAmount());
					System.out.println();
					
				}
				System.out.println("--------------------------------------------------------------------------------------------------------------------");
			}
			System.out.println("====================================================================================================================");
			System.out.println("====================================================================================================================\n");
		}
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
