package ticketing;

import java.util.Scanner;

public class ticketing {

	public void ticketing() {
		tk_service ts = new tk_service();
		Scanner input = new Scanner(System.in);
		System.out.println("영화예매하기");
		System.out.println("영화이름 검색");
		String movie = input.next();
		
		ticketing_entity te = ts.ticketing(movie);

		System.out.println("원하는 시간대선택 ");
		String time = input.next();	
		ts.reduce_count(movie,time);
			
		
		
	
		
		
	}
	
}
