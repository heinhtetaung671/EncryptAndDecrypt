package encryptAndDecrypt;

import java.util.Scanner;

public class EncryptAndDecrypt {
	Scanner sc = new Scanner(System.in);
	private int menu;
	private int algoNum;
	private String userInput = "";

	void showMessage(String str) {
		String s = "";
		for (int i = 0; i < str.length(); i++) {
			s += "=";
		}

		System.out.println("==" + s + "==");
		System.out.println("= " + str + " =");
		System.out.println("==" + s + "==");
	}

	void showMenu() {

		do {
			System.out.println("1. ENCRYPT.");
			System.out.println("2. DECRYPT.");
			System.out.println("choose a number of menu that u want to do : ");
			menu = sc.nextInt();
			if (menu <= 0 || menu > 2) {
				System.out.println("the number you entered was incorrect!");
			}
		} while (menu <= 0 || menu > 2);

	}

	boolean isEncrypt() {
		if (menu == 1) {
			return true;
		}
		return false;
	}

	void getAlgoNum() {

		do {
			if (isEncrypt()) {
				System.out.println("enter ENCRYPT number : ");
			} else {
				System.out.println("enter DECRYPT number : ");
			}
			algoNum = sc.nextInt();

			if (algoNum < 1 || algoNum > 20) {
				System.out.println("the number you entered was incorrect!");
			}
		} while (algoNum < 1 || algoNum > 20);

	}

	void getWord() {
		Scanner s = new Scanner(System.in);
		String temp = "";
		if (isEncrypt()) {
			temp = "ENCRYPT";
		} else {
			temp = "DECRYPT";
		}

		System.out.println("enter a Word that u want to " + temp + " : ");

		userInput = s.nextLine().trim();

	}

	void result() {

		String temp = "";
		if (isEncrypt()) {
			for (int i = 0; i < userInput.length(); i++) {
				temp += (char) (userInput.charAt(i) + algoNum);
			}

			System.out.println("encrypted word is : ");
			showMessage(temp);
		} else {
			for (int i = 0; i < userInput.length(); i++) {
				temp += (char) (userInput.charAt(i) - algoNum);
			}
			System.out.println("decrypted word is : ");
			showMessage(temp);
		}
	}

	String restart(String str) {
		System.out.println(str);
		return sc.next();
	}

	void breakLine() {
		System.out.println();
	}

	void run() {
		do {
			showMessage("WELCOME TO ENCRYPT AND DECRYPT SYSTEM");
			breakLine();

			showMenu();

			getAlgoNum();

			getWord();

			result();
			breakLine();
		} while (restart("do you want to restart? (enter \"y\" for yes) :").equalsIgnoreCase("y"));
	}
}
