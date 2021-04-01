package HotelReservation;

public class Hotel {
	public String name;
	public int rating;

	public Hotel(String name, int rating) {
		this.name = name;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
//	public static void main(String[] args) {
//		System.out.println("Welcome to Hotel Reservation Program");
//	}
}