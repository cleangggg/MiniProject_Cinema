package Service;

import java.util.Scanner;

import location.location_service;
import member.account_service;
import ticketing.ticketing;

public class main {

	public static void main(String[] args) {
		location_service ls = new location_service();
		account_service as =new account_service();
		ticketing tk = new ticketing();
		System.out.println("환영합니다.");
		System.out.println("원하시는 메뉴를 선택하시오");
		System.out.println("1.로그인화면");
		System.out.println("2.티켓 예약");
		System.out.println("3.영화확인하기");
		Scanner input = new Scanner(System.in);
		int sel = input.nextInt();
		switch (sel) {
		case 1 :
			
			as.login();
			break;
		case 2:
			
			tk.ticketing();
			break;
		case 3:
			
			ls.select_cinema();
			break;
		
		}
		
		
	}
	
}