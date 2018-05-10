package schwimmer.earthquake.net;

import retrofit2.Call;
import retrofit2.http.GET;
import schwimmer.earthquake.EarthquakeFeedModel;

public interface USGSEarthquakeService {
	
	@GET("/earthquakes/feed/v1.0/summary/all_month.geojson")
	Call<EarthquakeFeedModel> getAllMonth();
	
}
