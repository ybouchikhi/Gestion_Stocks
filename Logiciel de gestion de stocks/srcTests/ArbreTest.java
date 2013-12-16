import static org.junit.Assert.*;

import javax.swing.tree.DefaultMutableTreeNode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ArbreTest {
	Category cat;
	Product prod;
	
	@Before
	public void setUp() throws Exception {
		cat = new Category("a");
		prod = new Product("Product");
		cat.addChild(prod);
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testArbre() {
		Arbre a = new Arbre(cat);
		assertSame(((DefaultMutableTreeNode) a.node.getRoot()).getUserObject(), cat);
	}

	

}
