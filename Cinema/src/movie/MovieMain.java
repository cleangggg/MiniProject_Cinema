package movie;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieMain {
	public static void main(String[] args) {
		DB db = new DB();
		Scanner sc = new Scanner(System.in);
		int choice, result = 0;
		String movie_name, movie_time, cinema_location, cinema_name;
		String member_id;
		int money, seatcount, num, index = 0;
		while(true) {
			System.out.println("=== 영화 예매 ===");
			System.out.println("1. 옇화예매");
			System.out.println("2. 영화예매확인");
			System.out.println("3. 영화예매취소");
			System.out.println("4. 종료");
			System.out.print(">>> ");
			choice = sc.nextInt();
			switch(choice) {
			case 1 : 
				System.out.println("=== 영화 예매 ===");
				ArrayList<MovieDTO> movie_list = db.showMovie();
				for(MovieDTO dd : movie_list) {
					System.out.println("영화번호 : " + dd.getNum());
					System.out.println("영화제목 : " + dd.getMovie_name());
					System.out.println("영화시간 : " + dd.getMovie_time());
					System.out.println("영화잔여석 : " + dd.getMovie_seatcount() + "석");
					System.out.println("영화관위치 : " + dd.getCinema_location());
					System.out.println("영화관이름 : " + dd.getCinema_name());
					System.out.println("---------------");
				}
				System.out.print("예매할 영화번호 : ");
				num = sc.nextInt();
				result = db.seat_check(num);
				if(result == 0) {
					System.out.println("잔여석이 없습니다.");
				} else {
					MovieDTO dto = db.choice_movie(num);
					System.out.println("영화제목 : " + dto.getMovie_name());
					System.out.println("영화시간 : " + dto.getMovie_time());
					System.out.println("영화관위치 : " + dto.getCinema_location());
					System.out.println("영화관이름 : " + dto.getCinema_name());
					System.out.println("예매가 완료되었습니다");
				}
				break;
			case 2 : 
				System.out.println("=== 영화 예매 확인 ===");
				System.out.print("아이디 입력 : ");
				member_id = sc.next();
				MovieDTO dto = db.re_view(member_id);
				if(dto == null) {
					System.out.println(member_id + "님의 예매내역이 없습니다");
				} else {
					System.out.println("아이디 : " + dto.getMember_id());
					System.out.println("티켓번호 : " + dto.getTicketing());
					System.out.println("영화제목 : " + dto.getMovie());
					System.out.println("영화시간 : " + dto.getMovie_time());
				}
				break;
			case 3 : 
				System.out.println("=== 영화 예매 취소 ===");
				System.out.print("아이디입력 : ");
				member_id = sc.next();
				result = db.delete(member_id);
				if(result == 0) {
					System.out.println(member_id + "님의 예매내역이 없습니다");
				} else {
					System.out.println(member_id + "님 예매가 취소되었습니다");
				}
				break;
			case 4 : 
				System.out.println("종료합니다");
				System.exit(1);
			}
		}
	}
}
