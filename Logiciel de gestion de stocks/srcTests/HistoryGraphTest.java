import static org.junit.Assert.*;

import java.util.TreeMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class HistoryGraphTest {
	HistoryGraph hg;
	Category cat;
	Product prod;
	Product product;
	@Before
	public void setUp() throws Exception {
		hg=new HistoryGraph();
		cat= new  Category("Fruits");
		prod= new Product("banane", 2.0, 200.0);
		prod.quantityLevels.put(1, 50.0);
		prod.quantityLevels.put(0, 30.5);
		product= new Product("fraise", 3.0, 500.0);
		product.quantityLevels.put(1, 20.3);
		product.quantityLevels.put(0, 19.0);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetNbDays() {
		assertEquals(hg.getNbDays(), 20);
	}

	@Test
	public void testSetNbDays() {
		hg.setNbDays(25);
		assertEquals(hg.nbDays, 25);
	}

	@Test
	public void testGetEndDate() {
		hg.endDate=20;
		assertEquals(hg.getEndDate(), 20);
	}

	@Test
	public void testSetEndDate() {
		hg.setEndDate(10);
		assertEquals(hg.endDate, 10);
	}

	@Test
	public void testHistoryGraph() {
		hg=new HistoryGraph();
		assertNotEquals(hg, null);
	}

	@Test
	public void testAddCategoryToShow() {
		hg.addCategoryToShow(cat);
		assertEquals(hg.categoriesToShow.get(0), cat);
	}



	@Test
	public void testComputeTotalQuantities() {
		cat.addChild(product);
		cat.addChild(prod);
		hg.addCategoryToShow(cat);
		hg.computeTotalQuantities(1, cat);
		assertEquals(hg.computeTotalQuantities(1, cat),prod.quantityLevels.get(1)+product.quantityLevels.get(1),0.01);
	}

	@Test
	public void testComputeCategoryQuantities() { 
		TreeMap<Integer,Double> test=new TreeMap<Integer,Double>();
		hg.endDate=1;
		cat.addChild(product);
		cat.addChild(prod);
		test.put(0, prod.quantityLevels.get(0)+product.quantityLevels.get(0));
		test.put(1, prod.quantityLevels.get(1)+product.quantityLevels.get(1));
		assertEquals(test, hg.computeCategoryQuantities(cat));
	}

	@Test
	public void testPaintGraphics() {
	}

	@Test
	public void testRemoveCategory() {
		hg.addCategoryToShow(cat);
		hg.removeCategory(cat);
		assertTrue(hg.categoriesToShow.size()==0);
	}

}
