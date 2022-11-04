package com.bilgeadam.course04.submissions.marathons.marathon03.group03;

import com.bilgeadam.course04.submissions.marathons.marathon03.group03.util.CommonData;
import com.bilgeadam.course04.submissions.marathons.marathon03.group03.view.Menu;

public class BankManagment {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Wrong number of arguments. Expected <<<1>>> actual <<<" + args.length + ">>>");
			System.exit(100);
		}
		CommonData.getInstance().setPropertiesFile(args[0]);
		CommonData.getInstance().info("The Bank of Group03");
		
		System.out.println("The Bank of Group03\n");
		Menu.showMenu();
	}
}