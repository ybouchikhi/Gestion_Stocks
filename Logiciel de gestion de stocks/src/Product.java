import java.util.Date;
import java.util.Calendar;
import java.util.HashMap;


public class Product extends Category{
	protected static int idMax = 0;
	protected int id;
	protected Double price;
	protected HashMap<Integer,Double> quantityLevels;
	protected Double currentQuantity;

	public Product(String n) {
		super(n);
		quantityLevels = new HashMap<Integer,Double>();
		id = idMax+1;
	}
	
	public Product(String n, Double p) {
		super(n);
		this.price = p;
		quantityLevels = new HashMap<Integer,Double>();
		id = idMax+1;
	}
	
	public Product(String n, Double p, Double currentQ) {
		super(n);
		this.price = p;
		this.currentQuantity = currentQ;
		quantityLevels = new HashMap<Integer,Double>();
		id = idMax+1;
	}
	
	/**
	 * @return the idMax
	 */
	public static int getIdMax() {
		return idMax;
	}

	/**
	 * @param idMax the idMax to set
	 */
	public static void setIdMax(int idMax) {
		Product.idMax = idMax;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	/**
	 * @return the quantityLevels
	 */
	public HashMap<Integer, Double> getQuantityLevels() {
		return quantityLevels;
	}

	/**
	 * @param quantityLevels the quantityLevels to set
	 */
	public void setQuantityLevels(HashMap<Integer, Double> quantityLevels) {
		this.quantityLevels = quantityLevels;
	}

	public void sell(double quantity, int simulationDate) throws QuantityHigherThanAvailabilityException{
		if(quantity > currentQuantity){
			throw new QuantityHigherThanAvailabilityException(quantity);
		}
		else{
			this.currentQuantity -= quantity;
			quantityLevels.put(simulationDate, this.currentQuantity);
		}
	}

	public Double getCurrentQuantity() {
		return currentQuantity;
	}
	
	public void setCurrentQuantity(double q){
		currentQuantity = q;
	}

	public double getQuantityLevelOnDate(int d) {
		System.out.println("Liste des historiques pour le produit " + this.getName());
		for(int date:quantityLevels.keySet()){
			System.out.println(date);
			System.out.println(d);
		}
		try{
			return quantityLevels.get(d);
		}
		catch(Exception e){
			return 0;
		}
	}
	
}
