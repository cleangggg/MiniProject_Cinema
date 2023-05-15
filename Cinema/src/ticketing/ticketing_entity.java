package ticketing;




public class ticketing_entity {

	private String movie_name,movie_time,cinema_location,cinema_name;
	private int money, movie_seater;
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public String getMovie_time() {
		return movie_time;
	}
	public void setMovie_time(String movie_time) {
		this.movie_time = movie_time;
	}
	public String getCinema_location() {
		return cinema_location;
	}
	public void setCinema_location(String cinema_location) {
		this.cinema_location = cinema_location;
	}
	public String getCinema_name() {
		return cinema_name;
	}
	public void setCinema_name(String cinema_name) {
		this.cinema_name = cinema_name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getMovie_seater() {
		return movie_seater;
	}
	public void setMovie_seater(int movie_seater) {
		this.movie_seater = movie_seater;
	}
	public ticketing_entity(String movie_name, String movie_time, String cinema_location, String cinema_name, int money,
			int movie_seater) {
		super();
		this.movie_name = movie_name;
		this.movie_time = movie_time;
		this.cinema_location = cinema_location;
		this.cinema_name = cinema_name;
		this.money = money;
		this.movie_seater = movie_seater;
	}
	public ticketing_entity() {}
	
}
