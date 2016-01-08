/**
 *  Cat.java
 *  An abstract class representing cats; is inherited by subclasses representing various species of cats
 *	Contains instance data and methods for each cat
 *	@author Hannah Huang, Phillip Yu, Caroline Gao
 *	Period 1
 */

public abstract class Cat
{
	// Static Data
	private static int nextCatID = 1000;	// The starting ID for first cat in store

	// Instance Data
	private String name;		// Name of cat
	private String species;		// Species (subclass) of cat
	private String color;		// Color of cat
	private boolean trained;	// Whether cat is trained
	private int age;			// Age of cat
	private int quantity;		// Quantity of cats in the store
	private double price;		// Price of cat
	private double weight;		// Weight of cat
	private int id;				// ID number of cat
	
	
	/** Create a Cat object to be instantiated by subclasses
	 */
	public Cat(String theName, int theAge, double thePrice, double theWeight, String theColor)
	{
		id = getNextID();
		name = theName;
		species = this.getClass().getSimpleName();
		age = theAge;
		price = thePrice;
		weight = theWeight;
		color = theColor;
	}
	
	/** Adds weight to cat
	 *  @param gain the number of pounds to add to cat's weight
	 */
	public void gainWeight(int gain)
	{
		weight += gain;
	}
	
	/** Subtracts weight from cat
	 *  @param loss the number of pounds to remove from cat's weight
	 */
	public void loseWeight(int loss)
	{
		weight -= loss;
	}
	
	/** Abstract method, implemented in subclasses, allowing cat to make a sound
	 *  @return a string containing the cat's sound
	 */
	public abstract String makeSound();
	
	/** Represents cat having a litter of kittens, adding to total cat quantity
	 *  @param kittens the number of kittens in litter
	 */
	public void haveLitter(int kittens)
	{
		quantity += kittens;
	}
	
	/** Changes name of cat to a name given by parameter
	 *  @param newName the new name of the cat
	 */
	public void changeName(String newName)
	{
		name = newName;
	}
	
	/** Changes price of cat to a price given by parameter
	 *  @param newPrice the new price of the cat
	 */
	public void changePrice(double newPrice)
	{
		price = newPrice;
	}
	
	/** Increases cat's age by one year
	 */
	public void increaseAge()
	{
		age++;
	}
	
	/** Return name of cat
	 *  @return the cat's name as a string
	 */
	public String getName()
	{
		return name;
	}
	
	/** Return species of cat
	 *  @return the cat's species as a string
	 */
	public String getSpecies()
	{
		return species;
	}
	
	/** Return color of cat
	 *  @return the cat's color as a string
	 */
	public String getColor()
	{
		return color;
	}
	
	/** Return age of cat
	 *  @return the cat's age as an integer
	 */
	public int getAge()
	{
		return age;
	}
	
	/** Return quantity of cat
	 *  @return the cat's quantity as an integer
	 */
	public int getQuantity()
	{
		return quantity;
	}
	
	/** Return ID number of cat
	 *  @return the cat's ID number as an integer
	 */
	public int getID()
	{
		return id;
	}
	
	/** Return price of cat
	 *  @return the cat's price as a double
	 */
	public double getPrice()
	{
		return price;
	}
	
	/** Return weight of cat
	 *  @return the cat's weight as a double 
	 */
	public double getWeight()
	{
		return weight;
	}
	
	/** Static method incrementing the next available ID number to assign to the next cat instantiated
	 *  @return next available cat ID as an integer
	 */
	private static int getNextID()
	{
		nextCatID++;
		return nextCatID;
	}
	
	/** Returns the Cat object's data as a formatted string
	 *  @return cat's instance data as a string
	 */
	public String toString()
	{
		return String.format("\n%-12s %7s %7s %15s %5s %9s %-15s \n%-12s %7.2f %7d %15s %5d %9.2f %-15s", "Name", "Price", "ID", 
		"Species", "Age", "Weight", "Color", name, price, id, species, age, weight, color);
	}

}