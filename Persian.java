/**
 *  Persian.java
 *  Represents Persian cats, a cat species
 *  @author Hannah Huang, Phillip Yu, Caroline Gao
 *  Period 1
 */

public class Persian extends Cat
{
	//Declares the size of litter and amount of weight gain for Persian Cats
	final int WEIGHT_GAIN = 15;
	final int LITTER_SIZE = 2;
	
	// Instance variable to hold the sound cats make 
	private String sound;
	
	//This constructor instantiates all of the GUI elements 
	//including name, age, price, weight, and color of cat 
	public Persian(String theName, int theAge, double thePrice, double theWeight)
	{
		super(theName, theAge, thePrice, theWeight, "white");
	}

	/*
	 * Adds a given amount of pounds when the cat gains weight
	 * @param gained the amount of pounds to gain
	 */
	public void gainWeight(int gained)
	{
		super.gainWeight(WEIGHT_GAIN);
		System.out.println("Too fat!");
	}
	
	/* 
	 * Makes a cat sound 
	 * @return the string of the sounds the cat makes
	 */
	public String makeSound()
	{
		String sound = "mew";
		System.out.println(sound);
		return sound;
	}
	
	/* 
	 * Increases the quantity of cats when a cat has a litter of kittens
	 * @param numKits the amount of kittens in a litter
	 */
	public void haveLitter(int numKits)
	{
		super.haveLitter(LITTER_SIZE);
	}
	
	/*
	 * Cat gets haircut and loses given amount of weight after haicut
	 */
	public void getHaircut()
	{
		super.loseWeight(1);
	}

	/** Returns the Cat object's data as a formatted string
	 *  @return a string containing cat's instance data
	 */
	public String toString()
	{
		return super.toString();
	}
	
}