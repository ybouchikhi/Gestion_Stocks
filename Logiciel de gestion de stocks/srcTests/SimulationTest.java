import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SimulationTest {
	Simulation simulation;
	Product product;
	Product product2;
	Category cat;
	@Before
	public void setUp() throws Exception {
		
		simulation= new Simulation();
		product= new Product("Banane");
		cat=new Category("fruits");
		product2= new Product("fraise",3.0, 200.0);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSimulation() {
		
		assertNotNull(simulation);
	}

	@Test
	public void testGetListOfProducts() {
		assertFalse(simulation.getListOfProducts()==null);
	}

	@Test
	public void testSetListOfProducts() {
		List<Product> TestList = new ArrayList<Product>() ;
		TestList.add(product);
		simulation.setListOfProducts(TestList);
		assertEquals(simulation.listOfProducts, TestList);
	}

	@Test
	public void testAddProduct() {
		simulation.addProduct(product);
		assertEquals(simulation.listOfProducts.get(simulation.listOfProducts.size()-1), product);
	}

	@Test
	public void testRemoveProduct() {
		simulation.addProduct(product);
		simulation.removeProduct(product);
		assertEquals(simulation.listOfProducts.size(),0);
	}

	@Test
	public void testAddProductsOfCategory() {
		Simulation simulation= new Simulation();
		Product productpomme= new Product("pomme");
		cat.addChild(productpomme);
		cat.addChild(product);
		simulation.addProductsOfCategory(cat);
		assertEquals(simulation.listOfProducts.get(0), productpomme);
		assertEquals(simulation.listOfProducts.get(1), product);
		
	}

	@Test
	public void testRun() {
		
	}

	@Test
	public void testSimulationStep() throws QuantityHigherThanAvailabilityException {
		simulation.listOfProducts.add(product2);
		simulation.active=true; //supposons que la simulation tourne
	simulation.simulationStep();
	assertTrue(product2.quantityLevels!=null); //si la méthode n'a pas marché quantityLevels reste egal à null
	assertTrue(simulation.simulationDate!=0);//si la méthode n'a pas marché datesimulation reste egal à 0
	
	}

	@Test
	public void testGetSimulationDate() {
		simulation.simulationDate=3;
		assertEquals(simulation.simulationDate, 3);
	}

	@Test
	public void testSetSimulationDate() {
	simulation.setSimulationDate(5);
	assertEquals(simulation.simulationDate, 5);
	}

	@Test
	public void testGetSimulationSpeed() {
		assertEquals(simulation.simulationSpeed, 3);
	}

	@Test
	public void testStartPause() {
		simulation.active=true; //
		assertEquals(simulation.startPause(), false);
	}

	@Test
	public void testStopSimulation() {
		simulation.startPause();
		simulation.stopSimulation();
		assertEquals(simulation.active, false);
		
	}

	@Test
	public void testSetSimulationSpeed() {
		simulation.setSimulationSpeed(10);
		assertEquals(simulation.simulationSpeed, 10);
	}

}
