import javax.swing.JScrollPane;
import javax.swing.tree.*;
import javax.swing.*;






public class Arbre extends JTree{
	/**
	 * @param args
	 */
	protected JTree arbre;
	protected DefaultTreeModel treeModel;
	protected DefaultMutableTreeNode node;
	protected Category rootCategory;

	// *********** Constructeur *********************
	public Arbre(Category magasin){
		rootCategory = magasin;
		node = buildTree(magasin);
		treeModel = new DefaultTreeModel(node);
		arbre = new JTree(treeModel);
		arbre.setEditable(true);
	}


	// **************** Methodes ********************
	/*
	 * Methode permettant de creer un arbre
	 * Methode recursive
	 * Parametre en entree : category
	 */
	private DefaultMutableTreeNode buildTree(Category cat){
		//Cr�ation d'une racine initiale
		DefaultMutableTreeNode racine = new DefaultMutableTreeNode(cat);
		for (Category child : cat.children){
			racine.add(buildTree(child));
		}
		return racine;
	}
	
	public DefaultMutableTreeNode getLastSelectedNode(){
		return (DefaultMutableTreeNode) arbre.getLastSelectedPathComponent();
	}


	
	public void updateTree(){
		node = buildTree(rootCategory);
		treeModel.setRoot(node);
		treeModel.reload();
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Category magasin = new Category("Magasin");
	}


}

