package schwimmer.earthquake;

public class Earthquake {
	private String id;
	private EarthquakeProperties properties;
	
	public Earthquake(int mag, String place, int time) {
		properties = new EarthquakeProperties(mag, place, time);
	}
	public String getId() {
		return id;
	}
	public EarthquakeProperties getProperties() {
		return properties;
	}
}
