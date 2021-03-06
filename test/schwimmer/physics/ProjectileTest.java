package schwimmer.physics;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProjectileTest {

	@Test
	public void testGetX() {
		// given
		Projectile p = new Projectile(72, 23);
		
		// when
		double x = p.getX(10);
		
		// then
		assertEquals(71.0739, x, 0.1);
	}
	
	@Test
	public void testGetY() {
		// given
		Projectile p = new Projectile(72, 23);
		
		// when
		double y = p.getY(10);
		
		// then
		assertEquals(-271.2570, y, 0.1);
	}

}
