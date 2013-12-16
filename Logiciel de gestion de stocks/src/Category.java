import java.util.LinkedList;
import java.util.List;


/**
 * Classe repr�sentant une cat�gorie et en m�me temps l'arbre de ses cat�gorie descendantes.
 *
 */
public class Category {
	String name;
	List<Category> children;
	
	/**
	 * Constructeur
	 * @param n nom de la cat�gorie
	 */
	public Category(String n){
		this.name = n;
		children = new LinkedList<Category>();
	}
	
	/**
	 * M�thode permetant l'ajout d'une cat�gorie fille
	 * @param c cat�gorie � ajouter
	 */
	public void addChild(Category c){
		children.add(c); 
	}
	
	/**
	 * M�thode retirant la cat�gorie pass�e en param�tre de la liste des enfants.
	 * @param cat cat�gorie � retirer de la liste des cat�gories filles
	 */
	public void removeChild(Category cat){
		if(children.contains(cat)){
			children.remove(cat);
		}
	}
	
	/**
	 * Retourne la cat�gorie m�re d'une cat�gorie pass�e en param�tre, en cherchant dans les descendants de la cat�gorie appelante.
	 * @param cat la cat�gorie dont on cherche la cat�gorie m�re
	 * @return null si cat n'a pas �t� trouv�e, renvoie la cat�gorie m�re si cat a �t� trouv�e.
	 */
	public Category getParentCategory(Category cat){
		//cat est la cat�gorie dont le parent est recherch�
		Category result;
		for(Category c:getChildren()){
			if(c == cat){
				return this;  //Si cat est enfant direct on retourne cat
			}
			else{           //Sinon on cherche dans cet enfant
				result = c.getParentCategory(cat);  //On cherche cat dans c
				if (result != null){  //La m�thode renvoie null seulement si la cat�gorie n'a pas �t� trouv�e.
					return result;
				}
			}
		}
		return null;  //On renvoie null si la cat�gorie cat n'a pas �t� trouv�e dans l'arbre d�fini par cat2
	}
	
	/**
	 * V�rifie que la structure de l'arbre est correcte.
	 * @return true si toutes les feuilles de l'arbre sont de type Product
	 */
	public boolean checkCategoryStructure(){
		if(children.size() == 0){
			if(this instanceof Product){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			if(this instanceof Product){
				return false;
			}
			else{
				for(Category cat:getChildren()){
					if(!cat.checkCategoryStructure()){
						return false;
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * Renvoie la liste des descendants directs de la catt�gorie appelante
	 * @return la liste des descendants directs de la cat�goorie appelante
	 */
	public List<Category> getChildren(){
		return this.children;
	}
	
	/**
	 * D�finit le nom de la cat�gorie
	 * @param n le nouveau nom de la cat�gorie
	 */
	public void setName(String n){
		this.name = n;
	}
	
	/**
	 * Renvoie le nom de la cat�gorie
	 * @return le nom de la cat�gorie
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * La m�thode toString renvoie le nom de la cat�gorie (utile pour l'affichage de l'arbre)
	 */
	public String toString(){
		return this.name;
	}
	
}
