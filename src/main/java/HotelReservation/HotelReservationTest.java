package HotelReservation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HotelReservationTest {

	private HotelReservationService hotelReservationService;
	private Hotel lakewood;

	@Before
	public void setup() throws Exception {
		hotelReservationService = new HotelReservationService();
		lakewood = new Hotel("Lakewood", 4);
	}

	@Test
	public void givenHotel_whenInvokedAddHotel_shouldBeAbleToAdd() {
		Assert.assertTrue(this.hotelReservationService.addHotel(lakewood));
	}

}
