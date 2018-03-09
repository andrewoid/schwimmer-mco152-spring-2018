package schwimmer.physics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class ProjectileGraph extends JComponent {

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("paintComponent is called");
		Projectile projectile = new Projectile(50, 100);
		g.setColor(Color.RED);
		g.translate(0, getHeight());
		for (int i=0; i<20; i++) {
			double x = projectile.getX(i);
			double y = -projectile.getY(i);
			g.drawOval((int)x, (int)y, 5, 5);
		}
		
	}

	
	
	
}
