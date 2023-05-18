package Service;

import java.util.Scanner;

import Member.MemberService;
import admin.admin_main;
import location.location_service;
import movie.Movie;
import ticketing.ticketing;

public class main {

	public static void main(String[] args) {
		location_service ls = new location_service();
		MemberService ms = new MemberService();
		Movie mv = new Movie();
		ticketing tk = new ticketing();
		admin_main ad = new admin_main();
		while (true) {
			System.out.println("환영합니다.");
			System.out.println("원하시는 메뉴를 선택하시오");
			System.out.println("1.로그인화면");
			System.out.println("2.티켓 예약");
			System.out.println("3.영화확인하기");
			System.out.println("4.프로그램 종료");
			Scanner input = new Scanner(System.in);
			int sel = input.nextInt();
			switch (sel) {
			case 1:
				System.out.println("관리자 권한으로 로그인 하려면 admin 아니면 일반계정");
				String user = input.next();
				if (user.equals("admin")) {
					ad.admin();
				} else {
					ms.memberMain();
				}
				break;
			case 2:

				mv.movieMain();

//			tk.ticketing();
				break;
			case 3:

				ls.select_cinema();
				break;
			case 4:
				System.out.println("bye bye~~");
				System.exit(0);
			}
		}
	}

}
