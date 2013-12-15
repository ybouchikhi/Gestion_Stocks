import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CategoryTest {
	Category cat;
	Category ca;

	
	@Before
	public void setUp() throws Exception {
		cat = new Category("Catégorie test");
		ca = new Category("a");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCategory() {
		assertNotNull(cat);
	}

	@Test
	public void testAddChild() {
		int nC=5;
		int nP=3;
		for(int i=0;i<nC;i++){
			cat.addChild(new Category("enfant" + i));
		}
		for(int i=0;i<nP;i++){
			cat.addChild(new Product("P"+i, Math.random(), Math.random()));
		}
		assertEquals(cat.getChildren().size(), nP+nC);
	}

	@Test
	public void testRemoveChild() {
		cat.addChild(ca);
		cat.removeChild(ca);
		assertTrue(cat.getChildren().isEmpty());
	}

	@Test
	public void testGetParentCategory() {
		assertNull(cat.getParentCategory(cat));
		cat.addChild(ca);
		assertSame(cat.getParentCategory(ca),cat);
	}

	@Test
	public void testCheckCategoryStructure() {
		assertFalse(cat.checkCategoryStructure());
		cat.addChild(ca);
		assertFalse(cat.checkCategoryStructure());
		ca.addChild(new Product("p", 1.0,1.0));
		assertTrue(cat.checkCategoryStructure());
	}

	@Test
	public void testGetChildren() {
		assertTrue(cat.getChildren().isEmpty());
		cat.addChild(ca);
		assertSame(ca, cat.getChildren().get(0));
	}

	@Test
	public void testSetName() {
		cat.setName("new name");
		assertEquals(cat.getName(), "new name");
	}

	@Test
	public void testGetName() {
		assertEquals(cat.getName(), "Catégorie test");
	}

	@Test
	public void testToString() {
		assertEquals(cat.toString(), "Catégorie test");
	}

}
