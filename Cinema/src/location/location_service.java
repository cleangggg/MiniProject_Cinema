package location;

import java.util.Scanner;

public class location_service {

	public void select_cinema() {

		String thea = null;
		String loc = null;
		location_function lf = new location_function();
		location_entity le = new location_entity();

		System.out.println("영화 and 시간대 잔여자리 보여주기");
		// if 잔여석수가 있으면 예매 가능

		Scanner input = new Scanner(System.in);
		int sel = input.nextInt();
		switch (sel) {
		case 1:
			System.out.println("원하시는 위치 선택");// 서울 ,경기
			System.out.println("1.서울, 2.경기도");
			loc = input.next();
			le.setCinema_location(loc);
			if (loc.equals("서울")) {
				System.out.println("원하시는 극장선택");// 종로 강남 , 야탑 의정부
				System.out.println("1.종로,2.강남");
				thea = input.next();
				lf.selectMovie_INFO(loc,thea);
				
				
			}
			if (loc.equals("경기도")) {
				System.out.println("원하시는 극장선택");// 종로 강남 , 야탑 의정부
				System.out.println("1.cgv야탑,2.cgv의정부");
				thea = input.next();
				
				lf.selectMovie_INFO(loc,thea);
			}
			
			break;
		}

	}

}
