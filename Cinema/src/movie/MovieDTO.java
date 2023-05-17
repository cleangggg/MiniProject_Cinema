package movie;

public class MovieDTO {
	// 영화예매용
		private String movie_name, movie_time;
		private int money, movie_seatcount, num;
		private String cinema_location, cinema_name;
		
		public int getNum() { return num; }
		public void setNum(int num) { this.num = num; }
		
		public String getMovie_name() { return movie_name; }
		public void setMovie_name(String movie_name) { this.movie_name = movie_name; }
		
		public int getMoney() { return money; }
		public void setMoney(int money) { this.money = money; }
		
		public int getMovie_seatcount() { return movie_seatcount; }
		public void setMovie_seatcount(int movie_seatcount) { this.movie_seatcount = movie_seatcount; }
		
		public String getMovie_time() { return movie_time; }
		public void setMovie_time(String movie_time) { this.movie_time = movie_time; }
		
		public String getCinema_location() { return cinema_location; }
		public void setCinema_location(String cinema_location) { this.cinema_location = cinema_location; }
		
		public String getCinema_name() { return cinema_name; }
		public void setCinema_name(String cinema_name) { this.cinema_name = cinema_name; }
		
		// 티켓확인용
		private String member_id, ticketing, movie;

		public String getMember_id() { return member_id; }
		public void setMember_id(String member_id) { this.member_id = member_id; }
		
		public String getTicketing() { return ticketing; }
		public void setTicketing(String ticketing) { this.ticketing = ticketing; }
		
		public String getMovie() { return movie; }
		public void setMovie(String movie) { this.movie = movie; }
}
