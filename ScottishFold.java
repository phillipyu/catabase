/**
 *  ScottishFold.java
 *  Represents Scottish Fold cats, a cat species
 *  @author Hannah Huang, Phillip Yu, Caroline Gao
 *  Period 1
 */

public class ScottishFold extends Cat
{
	//Declares the size of litter and amount of weight gain for Scottish Fold Cats
	final int WEIGHT_GAIN = 7;
	final int LITTER_SIZE = 4;
	
	// Instance variable to hold the sound cats make 
	private String sound;
	
	//This constructor instantiates all of the GUI elements 
	//including name, age, price, weight, and color of cat 
	public ScottishFold(String theName, int theAge, double thePrice, double theWeight, String theColor)
	{
		super(theName, theAge, thePrice, theWeight, theColor);
	}

	/*
	 * Adds a given amount of pounds when the cat gains weight
	 * @param gained the amount of pounds to gain
	 */
	public void gainWeight(int gained)
	{
		super.gainWeight(WEIGHT_GAIN);
	}
	
	/*
	 * Cat gets haircut and loses given amount of weight after haicut
	 */
	public void getHaircut()
	{
		super.loseWeight(1);
	}
	
	/* 
	 * Makes an cat sound 
	 * @return the string of the sounds the cat makes
	 */
	public String makeSound()
	{
		String sound = "purrrrr";
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
	
	/** Returns the Cat object's data as a formatted string
	 *  @return a string containing cat's instance data
	 */
	public String toString()
	{
		return super.toString();
	}

}