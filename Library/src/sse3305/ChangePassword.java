package sse3305;

import java.util.Scanner;

public class ChangePassword {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your old password");
		String oldpwd=scanner.next();
	    
		System.out.println("Please enter your new password");
		String newpwd=scanner.next();
		System.out.println("Please enter the new password again");
		String repwd=scanner.next();
		String result =ChangePassword.Change(oldpwd, newpwd, repwd);
		System.out.println(result);
	}	
	public static String Change(String oldpwd,String newpwd,String repwd) {
			
		if(newpwd.length()<5 || newpwd.length()>14) {
				return "The password cannot be less than 5 characters or more than 14 characters";
			}else if(oldpwd.equals(newpwd)) {
				return "Please enter a password that does not match the original password Please try again";
			}else {
				if(newpwd.equals(repwd)) {
					return "Modify the success";
				}else {
					return "The two passwords are inconsistent";
				}
			}
	}
}