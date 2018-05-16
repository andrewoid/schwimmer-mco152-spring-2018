package schwimmer.earthquake.net;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.inject.Inject;
/*import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Comparator;
import java.util.Optional;
*/
import javax.swing.*;
import javax.swing.text.JTextComponent;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;

/*import elberger.earthquake.Earthquake;
import elberger.earthquake.EarthquakeFeed;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;*/
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
public class EarthquakeView extends JFrame //implements WindowListener
{
	private static final long serialVersionUID = 6111006689421939040L;
	private JTextField monthMag;
	private JTextField monthLoc;
	private JTextField weekMag;
	private JTextField weekLoc;
	private JTextField dayMag;
	private JTextField dayLoc;
	private JTextField hourMag;
	private JTextField hourLoc;
	
	@Inject
	public EarthquakeView(EarthquakeController controller)
	{
		setTitle("Largest Earthquakes");
		setSize(700, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JPanel earthquakePanel = new JPanel();
		earthquakePanel.setLayout(new GridLayout(8, 2));
		
		JLabel monthMagLabel = new JLabel("Past month magnitude:");
		JLabel monthLocLabel = new JLabel("Past month location:");
		JLabel weekMagLabel = new JLabel("Past week magnitude:");
		JLabel weekLocLabel = new JLabel("Past week location:");
		JLabel dayMagLabel = new JLabel("Past day magnitude:");
		JLabel dayLocLabel = new JLabel("Past day location:");
		JLabel hourMagLabel = new JLabel("Past hour magnitude:");
		JLabel hourLocLabel = new JLabel("Past hour location:");
		
		monthMag = new JTextField();
		monthLoc = new JTextField();
		weekMag = new JTextField();
		weekLoc = new JTextField();
		dayMag = new JTextField();
		dayLoc = new JTextField();
		hourMag = new JTextField();
		hourLoc = new JTextField();
		
		earthquakePanel.add(monthMagLabel);
		earthquakePanel.add(monthMag);
		earthquakePanel.add(monthLocLabel);
		earthquakePanel.add(monthLoc);
		earthquakePanel.add(weekMagLabel);
		earthquakePanel.add(weekMag);
		earthquakePanel.add(weekLocLabel);
		earthquakePanel.add(weekLoc);
		earthquakePanel.add(dayMagLabel);
		earthquakePanel.add(dayMag);
		earthquakePanel.add(dayLocLabel);
		earthquakePanel.add(dayLoc);		
		earthquakePanel.add(hourMagLabel);
		earthquakePanel.add(hourMag);
		earthquakePanel.add(hourLocLabel);
		earthquakePanel.add(hourLoc);		
		
		monthMag.setEditable(false);
		monthLoc.setEditable(false);		
		weekMag.setEditable(false);
		weekLoc.setEditable(false);
		dayMag.setEditable(false);
		dayLoc.setEditable(false);
		hourMag.setEditable(false);
		hourLoc.setEditable(false);
		
		panel.add(earthquakePanel, BorderLayout.CENTER);
		
		add(panel);
		
		controller.refreshData();
	}

	public JTextField getMonthMagTextField()
	{
		return monthMag;
	}

	public JTextField getMonthLocTextField()
	{
		return monthLoc;
	}

	public JTextField getWeekMagTextField()
	{
		return weekMag;
	}

	public JTextField getWeekLocTextField()
	{
		return weekLoc;
	}

	public JTextField getDayMagTextField()
	{
		return dayMag;
	}

	public JTextComponent getDayLocTextField()
	{
		return dayLoc;
	}

	public JTextComponent getHourMagTextField()
	{
		return hourMag;
	}

	public JTextComponent getHourLocTextField()
	{
		return hourLoc;
	}
	
	public static void main(String[] args)
	{
		Injector injector = Guice.createInjector(new EarthquakeModule());

		EarthquakeView view = injector.getInstance(EarthquakeView.class);
			
		view.setVisible(true);
	}
}
