package HotelReservation;

import java.util.ArrayList;
import java.util.List;

public class HotelReservationService {
	private List<Hotel> hotels;

	public HotelReservationService() {
		this.hotels = new ArrayList<>();
	}

	public boolean addHotel(Hotel hotel) {
		return this.hotels.add(hotel);
	}

}
