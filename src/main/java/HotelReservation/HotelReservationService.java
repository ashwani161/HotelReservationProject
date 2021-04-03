package HotelReservation;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HotelReservationService {
	private List<Hotel> hotels;
	private static final DateTimeFormatter DATE_RANGE_FORMAT = DateTimeFormatter.ofPattern("ddMMMyyyy");


	public HotelReservationService() {
		this.hotels = new ArrayList<>();
	}

	public boolean addHotel(Hotel hotel) {
		return this.hotels.add(hotel);
	}
	
	 public List<Result> findCheapestHotelsBasedOnDay(CustomerType customerType, String initialDateRange, String endDateRange) {
	        LocalDate initialDate = LocalDate.parse(initialDateRange, DATE_RANGE_FORMAT);
	        LocalDate endDate = LocalDate.parse(endDateRange, DATE_RANGE_FORMAT);

	        List<Result> results = this.hotels.stream()
	                .map(hotel -> {
	                    Result result = new Result();
	                    result.setHotelName(hotel.name);
	                    result.setTotalRate(hotel.getTotalRate(customerType, initialDate, endDate));
	                    return result;
	                }).sorted(Comparator.comparing(Result::getTotalRate)).collect(Collectors.toList());

	        return results.stream().filter(result -> result.getTotalRate()==results.get(0).getTotalRate())
	                .collect(Collectors.toList());
	    }
}
