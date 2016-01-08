/** 
 *  CatStore.java
 *  Manages a collection (a store) of Cat objects and contains store inventory and methods representing store functions
 *  @author Hannah Huang, Phillip Yu, Caroline Gao
 *  Period 1
 */
 
 
// Import statements
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CatStore
{
	private static List<Cat> animals; 	// List of cats in store inventory
	private static double balance;		// Total monetary balance of all cats in store
	
	
	/** Create an ArrayList representing a CatStore with no cats
	 */
	public CatStore()
	{
		animals = new ArrayList<Cat>();
		balance = 0;
	}
	
	/** Adds a new cat
	 *  @param newCat the cat to add to this store
	 */
	public void addCat(Cat newCat)
	{
		animals.add(newCat);
	}
	

	/** Return total balance of cat store
	 *  @return a double containing the balance of the store
	 */
	public double getBalance()
	{
		return balance;
	}
	
	/** Outputs all data in cat store to a .txt file
	 *	@param fileName the name of the file to print to
	 */
	public static void saveToFile(String fileName) throws IOException
	{
		PrintWriter animalsFile = new PrintWriter(fileName);
		for (int i = 0; i < animals.size(); i++)
		{
			animalsFile.println(animals.get(i));
			animalsFile.println();
		}		
		if (animalsFile != null)
				animalsFile.close();
	}
	
	/** Retrieves cat information from a text file
	 *  @param fileName the name of the file to import information from
	 */
	public static void loadFromFile(String fileName) throws FileNotFoundException
	{
		File catFile = new File(fileName);
		if (catFile.exists())
		{
			Scanner scan = new Scanner(catFile);
			while (scan.hasNextLine())
			{
				String name = scan.next();
				String species = scan.next();
				if (!scan.hasNextInt())
					species += scan.next();
				int age = scan.nextInt();
				double price = scan.nextDouble();
				double weight = scan.nextDouble();
				String color = scan.next();
				
				Cat aCat;
				if (species.equalsIgnoreCase("Tabby"))
				{
					aCat = new Tabby(name, age, price, weight, color);
					animals.add(aCat);
				}
				else if (species.equalsIgnoreCase("Persian"))
				{
					aCat = new Persian(name, age, price, weight);
					animals.add(aCat);
				}
				else if (species.equalsIgnoreCase("Siamese"))
				{
					aCat = new Siamese(name, age, price, weight);
					animals.add(aCat);
				}
				else if (species.equalsIgnoreCase("Maine Coon") || species.equalsIgnoreCase("MaineCoon"))
				{
					aCat = new MaineCoon(name, age, price, weight, color);
					animals.add(aCat);
				}
				else if (species.equalsIgnoreCase("Scottish Fold") || species.equalsIgnoreCase("ScottishFold"))
				{
					aCat = new ScottishFold(name, age, price, weight, color);
					animals.add(aCat);
				}
				else
					System.out.println("Invalid cat type!");

			}
		}
	}
	
		
	/** Returns cat store information in a string
	 *	@return a string containing all cats and their properties
	 */
	public String toString()
	{
		String build = "";
		for (Cat a : animals)
			build += a.toString() + "\n";
		return build;
	}
	
	
	/**	Search for existing cat by name 
	 *  @param givenName the name to search for
	 *	@return the Cat object if found
	 */
	public Cat findCatByName(String givenName)
	{
		for (int k = 0; k < animals.size(); k++)
		{
			if (animals.get(k).getName().equalsIgnoreCase(givenName))
				return animals.get(k);
		}
		return null;
	}
	
	/**	Search for existing cat by ID number
	 *  @param givenID the ID to search for
	 *	@return the Cat object if found
	 */
	public Cat findCatByID(int givenID)
	{
		for (int k = 0; k < animals.size(); k++)
		{
			if (animals.get(k).getID() == givenID)
				return animals.get(k);
		}
		return null;
	}
	
	/**	Find all cats of a certain species
	 *  @param givenSpecies the species to search for
	 *	@return the Cat object(s) if found
	 */
	public List<Cat> findCatsBySpecies(String givenSpecies)
	{
		List<Cat> species = new ArrayList<Cat>();
		for (int k = 0; k < animals.size(); k++)
		{
			Cat dude = animals.get(k);
			if (dude.getSpecies().equalsIgnoreCase(givenSpecies))
			{
				species.add(dude);
			}
		}
		return species;
	}
	
	/**	Find all cats of a given age
	 *  @param givenAge the age to search for
	 *	@return the Cat object(s) if found
	 */
	public List<Cat> findCatsByAge(int givenAge)
	{
		List<Cat> species = new ArrayList<Cat>();
		for (int k = 0; k < animals.size(); k++)
		{
			Cat dude = animals.get(k);
			if (dude.getAge() == givenAge)
			{
				species.add(dude);
			}
		}
		return species;
	}
	
	/** Sorts cats by ascending ID number
	 */
	public void sortCatsByID()
	{
		Collections.sort(animals, new Comparator<Cat>() 
		{
			public int compare(Cat a, Cat b) 
			{
				return a.getID() - b.getID();
			}
		});
	}
	
	/** Sort cats by name alphabetically
	 */
	public void sortCatsByName()
	{
		Collections.sort(animals, new Comparator<Cat>() 
		{
			public int compare(Cat a, Cat b) 
			{
				return a.getName().compareTo(b.getName());
			}
		});
	}
	
	/** Sort cats by ascending price
	 */
	public void sortCatsByPrice()
	{
		Collections.sort(animals, new Comparator<Cat>() 
		{
			public int compare(Cat a, Cat b) 
			{
				return (a.getPrice() - b.getPrice() <= 0) ? -1 : 1;
			}
		});
	}
	
	/**	Sells cat by removing from inventory and adding price to balance
	 *  @param givenID the ID of the cat to sell
	 */
	public void sellCat(int givenID)
	{
		int index = -1;
		for (int k = 0; k < animals.size(); k++)
		{
			if (animals.get(k).getID() == givenID)
				index = k;
		}
		double price = animals.get(index).getPrice();
		if (index != -1)
		{
			animals.remove(animals.get(index));
			balance += price;
		}
	}
	

}