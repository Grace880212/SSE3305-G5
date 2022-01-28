package sse3305;

import java.util.Scanner;

	public class BookBill {
		public static void main(String[] args) {
			BookBill bil=new BookBill();
			Scanner scanner = new Scanner(System.in);
			System.out.println("Input book_num:");
			int book_num = scanner.nextInt();
			System.out.println("Please input the day:");
			int day = scanner.nextInt();
			String result = calculate(book_num, day);
			System.out.println(result);
		}		


	static String calculate(int book_num, int day) {
		double bil_amount = 0.00; 
		double deposit =0.00;
		if (book_num <=0 || book_num > 10) {
			return "invalided number";
		}else if(day >0) {
			if(day <4) {
				deposit=10;
				bil_amount =day * 0.9 * book_num + deposit;
				return "You need pay "+deposit+"deposit£¬"+"total "+bil_amount+"RM";
				}else if(day <8) {
					deposit=20;
					bil_amount =day * 1.9 * book_num + deposit;
					return "You need pay "+deposit+"deposit£¬"+"total "+bil_amount+"RM";
				}else if(day <15) {
					deposit=30;
					bil_amount =day * 2.9 * book_num + deposit;
					return "You need pay "+deposit+"deposit£¬"+"total "+bil_amount+"RM"; 
				}else {
					deposit=100;
					bil_amount =day * 5.9 * book_num + deposit;
					return "You need pay "+deposit+"deposit£¬"+"total "+bil_amount+"RM";
				}
		    } else {
		    	return "Please input right days";
		    }
	}
}