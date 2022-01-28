package sse3305;

import java.util.Scanner;

public class Register {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("*******************Welcome to the registration system*******************");
		System.out.print("\n");
		System.out.println("Please enter a user name£º");
		String username = scanner.next();
		System.out.println("Please enter password£º");
		String pwd = scanner.next();
		System.out.println("Please enter your password again£º");
		String repwd = scanner.next();
		String result =register(username,pwd,repwd);
		System.out.print(result);
	}
	public static String register(String username, String pwd, String repwd) {
		if(username.length()>=4) {
			if(pwd.length()>=5) {
				if(pwd.length()<=14) {
					if(pwd.equals(repwd)) {
						return "Registration successful! Please remember the user name and password";
					}else {
						return"The two passwords are inconsistent£¡";
					}
				}else {
					return"The password contains a maximum of 14 characters";
				}
			}else {
				return"The password must contain at least 5 characters";
			}
		}else {
			return"The username cannot contain less than 4 characters";
		}
		
	}
}
