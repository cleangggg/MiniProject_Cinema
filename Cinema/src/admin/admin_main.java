package admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class admin_main {

	Scanner input = new Scanner(System.in);

	ArrayList list;
	adminDto ad = new adminDto();

	public void admin() {
		while (true) {
			System.out.println("관리자 페이지입니다");
			System.out.println("원하시는 메뉴를 선택하세요");
			System.out.println("1.영화 관리");
			System.out.println("2.멤버 관리");
			System.out.println("3.돌아가기");
			int sel = input.nextInt();
			switch (sel) {
			case 1:
				System.out.println("영화관리메뉴");
				System.out.println("1.영화추가");
				System.out.println("2.영화삭제");
				System.out.println("3.영화수정");
				sel = input.nextInt();
				switch (sel) {
				case 1:

					System.out.println("추가할 영화 입력");
					String name = input.next();

					System.out.println("추가할 영화 가격 입력");
					int price = input.nextInt();

					System.out.println("추가할 영화 시간 입력");
					String time = input.next();

					System.out.println("추가할 영화 잔여좌석 입력");
					int countseat = input.nextInt();

					System.out.println("추가할 영화 지역 입력");
					String local = input.next();

					System.out.println("추가할 영화 극장 입력");
					String theater = input.next();

					list = new ArrayList<>();
					list.add(name);
					list.add(price);
					list.add(time);
					list.add(countseat);
					list.add(local);
					list.add(theater);

					ad.updateMovie(list);

					break;
				case 2:

					System.out.println("삭제할 영화 선택");
					name = input.next();
					ad.deleteMovie(name);

					break;
				case 3:					
					HashMap<String, ArrayList> map = new HashMap<>(); 
					Object a = null;
					System.out.println("수정할 영화 선택");
					System.out.println("영화정보입력");
					name = input.next();
					ad.selectMovie_Info(name);
					System.out.println("수정할 영화정보 num 입력");
					int num = input.nextInt();
					System.out.println("수정할 영화정보입력");
					String modify = input.next();
					switch(modify){
					case "money":
						System.out.println("수정할 영화 "+modify+" 입력");
						a = price = input.nextInt();
						break;
					case "movie_time":
						System.out.println("수정할 영화 "+modify+" 입력");
						a = time = input.next();
						break;
					case "movie_seatcount":
						System.out.println("수정할 영화 "+modify+" 입력");
						a = countseat = input.nextInt();
						break;
					case "cinema_location":
						System.out.println("수정할 영화 "+modify+" 입력");
						a = local = input.next();
						break;
					case "cinema_name":
						System.out.println("수정할 영화 "+modify+" 입력");
						a = theater = input.next();
						break;	
					}
					ad.modifyMovie( modify ,a , num );
					
				}

				break;
			case 2:
				System.out.println("멤버관리메뉴");
				System.out.println("1.멈버정보보기");
				System.out.println("2.멤버탈퇴시키기");
				sel = input.nextInt();
				switch (sel) {
				case 1:
					System.out.println("회원정보를 가져옵니다");
					ad.selectMember();
					break;
				case 2:
					System.out.println("탈퇴시킬 멤버id입력");
					String id = input.next();
					if (ad.deleteMember(id) == 0) {
						System.out.println("회원정보없음");
					} else {
						System.out.println("삭제완료");
					}
					break;

				}

				break;
			case 3:
				
				
				return;
				
			}
		}
	}
}