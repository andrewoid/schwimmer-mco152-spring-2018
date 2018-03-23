package schwimmer.physics;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProjectileGraphGui extends JFrame {

	private AnimatedProjectileGraph projectileGraph;


	public ProjectileGraphGui() {
		
		setTitle("Projectile Viewer");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		projectileGraph = new AnimatedProjectileGraph();
		panel.add(projectileGraph, BorderLayout.CENTER);
		
		setContentPane(panel);
		
		Thread thread = new Thread(this::advanceGraph);
		thread.start();
		
	}
	
	public void advanceGraph() {
		while (true) {
			projectileGraph.repaint();
		}
	}
	
	
	public static void main(String args[]) {
		new ProjectileGraphGui().setVisible(true);
	}
	
}
