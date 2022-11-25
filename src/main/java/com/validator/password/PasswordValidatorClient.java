package com.validator.password;

import java.util.Iterator;
import java.util.Scanner;

import com.validator.password.response.PasswordValidatorResponse;

public class PasswordValidatorClient {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("=========================================================");
		System.out.println(" *** Welcome To Password Validator App *** ");
		System.out.println("=========================================================");
		PasswordUtility passwordUtility = null;
		while (Boolean.TRUE) {
			System.out.print("\n\n");
			System.out.println("Please choose the below Options");
			System.out.println("1. Validate a password");
			System.out.println("2. Add validation feature");
			System.out.println("3. Exit");
			String customerInput = sc.nextLine();
			if ("3".equalsIgnoreCase(customerInput)) {
				System.out.println("Thanks for using password validator App");
				break;
			} else if ("2".equalsIgnoreCase(customerInput)) {
				if (passwordUtility == null) {
					passwordUtility = new PasswordUtility();
				}
				while (Boolean.TRUE) {
					System.out.println("Select below available Feature");
					System.out.println("1. Minimum 3 Validations to be applied");
					System.out.println("2. Lowercase character Mandatory");
					customerInput = sc.nextLine();
					try {
						int input = Integer.parseInt(customerInput);
						if (input != 1 && input != 2) {
							System.out.println("Please enter valid option value");
						} else {
							passwordUtility.addFeature(Integer.parseInt(customerInput));
							break;
						}
					} catch (Exception e) {
						System.out.println("Please enter valid option value");
					}
				}

			} else if ("1".equalsIgnoreCase(customerInput)) {
				System.out.print("Please enter the password to validate:	");
				customerInput = sc.nextLine();
				if (passwordUtility == null) {
					passwordUtility = new PasswordUtility();
				}
				PasswordValidatorResponse passwordValidatorResponse = passwordUtility.validatePassword(customerInput);
				if (passwordValidatorResponse.isSuccess()) {
					System.out.println("*** Your Password Verified Successfully");
				} else {
					Iterator<String> it = passwordValidatorResponse.getErrorMessages().iterator();
					System.out.println("*** validation failed");
					while (it.hasNext()) {
						System.out.println(it.next());
					}

				}
				System.out.println("\n\n");
			}else {
				System.out.println("Please enter valid option value");
			}
		}
	}
}
