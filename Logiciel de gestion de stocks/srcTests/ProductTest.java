import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ProductTest {
	Product p1, p2, p3;

	@Before
	public void setUp() throws Exception {
		p1 = new Product("p1", 5.9, 729.3);
		p2 = new Product("p2", 5.9);
		p3 = new Product("p3");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testProductString() {
		assertNotNull(p3);
		assertEquals(p3.getName(), "p3");
		assertTrue(p3.getChildren().isEmpty());	//Un produit ne doit pas avoir de catégories filles.
	}

	@Test
	public void testProductStringDouble() {
		assertNotNull(p2);
		assertEquals(p2.getName(), "p2");
		assertTrue(p2.getChildren().isEmpty());
		assertEquals(p2.getPrice(), 5.9, 0.001);
	}

	@Test
	public void testProductStringDoubleDouble() {
		assertNotNull(p1);
		assertEquals(p1.getName(), "p1");
		assertTrue(p1.getChildren().isEmpty());
		assertEquals(p1.getPrice(), 5.9, 0.001);
		assertEquals(p1.getCurrentQuantity(), 729.3, 0.001);
	}

	@Test
	public void testGetPrice() {
		assertEquals(p1.getPrice(),5.9, 0.001);
	}

	@Test
	public void testSetPrice() {
		p1.setPrice(29.3);
		assertEquals(p1.getPrice(), 29.3, 0.001);
	}

	@Test
	public void testGetQuantityLevels() throws QuantityHigherThanAvailabilityException {
		assertNotNull(p1.getQuantityLevels());
		p1.sell(2.3, 0);
		assertEquals(p1.getQuantityLevelOnDate(0), 727.0,0.001);
	}

	@Test
	public void testSetQuantityLevels() {
		HashMap<Integer,Double> qL = new HashMap<Integer,Double>();
		qL.put(3,5.9);
		p2.setQuantityLevels(qL);
		assertFalse(p2.getQuantityLevels().isEmpty());
	}

	@Test
	public void testSell() throws QuantityHigherThanAvailabilityException {
		p1.sell(2.3, 1);
		assertEquals(p1.getCurrentQuantity(), 727.0, 0.001);
	}

	@Test
	public void testGetCurrentQuantity() {
		assertEquals(p1.getCurrentQuantity(), 729.3, 0.001);
	}

	@Test
	public void testGetQuantityLevelOnDate() throws QuantityHigherThanAvailabilityException {
		p1.sell(2.3, 1);
		p1.sell(2.0, 2);
		assertEquals(p1.getQuantityLevelOnDate(2), 725.0,0.001);
	}

}
