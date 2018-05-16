package schwimmer.earthquake.net;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import org.junit.Test;
import org.mockito.Mockito;

import retrofit2.Call;
import schwimmer.earthquake.Earthquake;
import schwimmer.earthquake.EarthquakeFeedModel;

public class EarthquakeControllerTest {

	@Test
	public void testRequestMonth() {
		// given
		EarthquakeView view = Mockito.mock(EarthquakeView.class);
		USGSEarthquakeService service = (USGSEarthquakeService) Mockito.mock(USGSEarthquakeService.class);
		EarthquakeController controller = new EarthquakeController(view, service);
		Call<EarthquakeFeedModel> call = Mockito.mock(Call.class);
		Mockito.when(service.getAllMonth()).thenReturn(call);
		JTextField field = Mockito.mock(JTextField.class);
		Mockito.when(view.getMonthLocTextField()).thenReturn(field);
		Mockito.when(field.getText()).thenReturn("something");
		
		// when
		controller.requestMonth();
		
		// then
		// THIS IS WRONG
		assertFalse(view.getMonthLocTextField().getText().equals(""));
		
	}
	
	@Test
	public void testShowLargestEarthquake() {
		// given
		EarthquakeView view = Mockito.mock(EarthquakeView.class);
		USGSEarthquakeService service = Mockito.mock(USGSEarthquakeService.class);
		EarthquakeController controller = new EarthquakeController(view, service);
		JTextField mag = Mockito.mock(JTextField.class);
		JTextField loc = Mockito.mock(JTextField.class);
		
		List<Earthquake> list = new ArrayList<Earthquake>();
		list.add(new Earthquake(2, "touro brooklyn", 1));
		list.add(new Earthquake(5, "touro manhattan", 2));
		list.add(new Earthquake(3, "touro queens", 3));
		EarthquakeFeedModel model = new EarthquakeFeedModel("", list);
		
		// when
		controller.showLargestEarthquake(model, mag, loc);
		
		// then
		Mockito.verify(mag).setText("5.0");
		Mockito.verify(loc).setText("touro manhattan");
		
	}

}












