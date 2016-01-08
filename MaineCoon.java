/**
 *  MaineCoon.java
 *  Represents Maine Coon cats, a cat species
 *  @author Hannah Huang, Phillip Yu, Caroline Gao
 *  Period 1
 */

public class MaineCoon extends Cat
{
	//Declares the size of litter and amount of weight gain for Maine Coons
	final int WEIGHT_GAIN = 8;
	final int LITTER_SIZE = 4;
	
	//Instance variable to hold the sound cats make and the initially untrained state
	private String sound;
	private boolean isTrained = false;
	
	//This constructor instantiates all of the GUI elements 
	//including name, ago, price, weight, and color of cat 
	public MaineCoon(String theName, int theAge, double thePrice, double theWeight, String theColor)
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
	 * Makes an inital sound if not trained but changes sound after cat is trained. 
	 * @return the string of the sounds the cat makes
	 */
	public String makeSound()
	{
		String sound = "arf";
		if (isTrained)
			sound = "meow";
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
	 * Trains the cat and makes a new sound after trained
	 */
	public void trainCat()
	{
		isTrained = true;
		makeSound();
		System.out.println("\nGood kitty!");
	}
	
	/** Returns the Cat object's data as a formatted string
	 *  @return a string containing cat's instance data
	 */
	public String toString()
	{
		return super.toString();
	}

}