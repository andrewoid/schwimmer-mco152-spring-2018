package schwimmer.physics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class AnimatedProjectileGraph extends JComponent {
	
	double time = 0;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Projectile projectile = new Projectile(50, 100);
		g.setColor(Color.RED);
		g.translate(0, getHeight());
		

		double x = projectile.getX(time);
		double y = -projectile.getY(time);
		g.drawOval((int)x, (int)y, 5, 5);
		
		time+=0.005;
		
	}

	
	
	
}
