package HotelReservation;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HotelReservationTest {

	private HotelReservationService hotelReservationService;
	private Hotel lakewood;
	private Hotel bridgewood;
    private Hotel ridgewood;

	@Before
	public void setup() throws Exception {
		hotelReservationService = new HotelReservationService();
		 HashMap<CustomerType, Rate> customerTypeRateMap = new HashMap<>();
	        customerTypeRateMap.put(CustomerType.REGULAR,new Rate(110,90));
	        customerTypeRateMap.put(CustomerType.REWARD, new Rate(80,80));
	        lakewood = new Hotel("Lakewood",3, customerTypeRateMap);

	        customerTypeRateMap = new HashMap<>();
	        customerTypeRateMap.put(CustomerType.REGULAR,new Rate(160,40));
	        customerTypeRateMap.put(CustomerType.REWARD, new Rate(110,50));
	        bridgewood = new Hotel("Bridgewood", 4, customerTypeRateMap);

	        customerTypeRateMap = new HashMap<>();
	        customerTypeRateMap.put(CustomerType.REGULAR,new Rate(220,150));
	        customerTypeRateMap.put(CustomerType.REWARD, new Rate(100,40));
	        ridgewood = new Hotel("Ridgewood", 5, customerTypeRateMap);
	        hotelReservationService.addHotel(lakewood);
	        hotelReservationService.addHotel(bridgewood);
	        hotelReservationService.addHotel(ridgewood);
	}

	@Test
	public void givenHotel_whenInvokedAddHotel_shouldBeAbleToAdd() {
		Assert.assertTrue(this.hotelReservationService.addHotel(lakewood));
	}
	
	 @Test
	    public void givenDateRange_whenSearched_shouldReturnCheapestHotelBasedOnWeekdayAndWeekend() {
	        List<Result> cheapestHotelResult =
	                hotelReservationService.findCheapestHotelsBasedOnDay(CustomerType.REGULAR,
	                        "11Sep2020", "12Sep2020");

	        Assert.assertEquals(2,cheapestHotelResult.size());
	        Assert.assertEquals(200,cheapestHotelResult.get(0).getTotalRate());
	    }
}
