/**
 * CatStoreRunner.java
 * A CatStoreRunner object creates a GUI environment of a CatStore 
 * that tests the methods of the Cat class and its subclasses.
 * @author Hannah Huang, Phillip Yu, Caroline Gao
 * Period 1
 */
 
// Import statements
import java.util.Scanner;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.awt.*;

public class CatStoreRunner extends JFrame implements ActionListener, MouseListener
{
	/** Run the viewer
	 */
	public static void main(String[] args) throws IOException
    {
    	CatStoreRunner myMenu = new CatStoreRunner();
    	myMenu.setVisible(true);	
    }

	// Window dimensions
	private static final int FRAME_WIDTH       = 1000;
	private static final int FRAME_HEIGHT      = 350;
	private static final int FRAME_X_ORIGIN    = 50;
	private static final int FRAME_Y_ORIGIN    = 50;
	
	// Declare GUI elements
	private JLabel title, one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve, thirteen, fourteen, fifteen;
	private JPanel left;
	private JTextArea display;
	private JMenuBar menuBar;
	private JMenuItem save, load, quit;
	private JScrollPane scroller;
	private JMenu menu;
	
	// Manager of cats
	private CatStore owner;
	
	/**
	 * The constructor instantiates all of the GUI elements, adds them to the content pane, 
	 * and adds the listeners to the GUI elements
	 */
	public CatStoreRunner()
	{
		owner = new CatStore();
		
		setTitle("Cat Store");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

		left = new JPanel();
		left.setLayout(new GridLayout(11,1));

		title = new JLabel("MENU:");
		title.setForeground(Color.RED);
		left.add(title);

		display = new JTextArea();
		display.setFont(new Font("Courier",Font.BOLD,12));
		display.setEditable(false);
		display.setBorder(BorderFactory.createLineBorder(Color.CYAN));
		
		scroller = new JScrollPane(display);

		setupMenusAndListeners();
		
		getContentPane().add(left, BorderLayout.WEST);
		getContentPane().add(scroller, BorderLayout.CENTER);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/** Initialize menu
	 */
	private void setupMenusAndListeners()
	{
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		save = new JMenuItem("Save");
		load = new JMenuItem("Load");
		quit = new JMenuItem("Quit");
		
		save.addActionListener(this);
		load.addActionListener(this);
		quit.addActionListener(this);
		
		menu = new JMenu("File");
		menu.add(save);
		menu.add(load);
		menu.add(quit);
		
		menuBar.add(menu);
		
		one = new JLabel(" Add cat");
		two = new JLabel(" Display all cats");
		three = new JLabel(" Find cat by ID number");
		four = new JLabel(" Find cat by name");
		five = new JLabel(" Find cats by species");
		six = new JLabel(" Sort by ID number");
		seven = new JLabel(" Sort cats alphabetically by name");
		eight = new JLabel(" Sort cats by price");
		nine = new JLabel(" Change name of a given cat");
		ten = new JLabel(" Sell a cat");
		eleven = new JLabel(" Get store balance");
		twelve = new JLabel(" Make given cat gain weight");
		thirteen = new JLabel(" Make given cat make a sound");
		fourteen = new JLabel(" Change a given cat's price");
		fifteen = new JLabel(" Play with a given cat");
	
		one.addMouseListener(this);
		two.addMouseListener(this);
		three.addMouseListener(this);
		four.addMouseListener(this);
		five.addMouseListener(this);
		six.addMouseListener(this);
		seven.addMouseListener(this);
		eight.addMouseListener(this);
		nine.addMouseListener(this);
		ten.addMouseListener(this);
		eleven.addMouseListener(this);
		twelve.addMouseListener(this);
		thirteen.addMouseListener(this);
		fourteen.addMouseListener(this);
		fifteen.addMouseListener(this);
		

		left.add(one);
		left.add(two);
		left.add(three);
		left.add(four);
		left.add(five);
		left.add(six);
		left.add(seven);
		left.add(eight);
		left.add(nine);
		left.add(ten);
		left.add(eleven);
		left.add(twelve);
		left.add(thirteen);
		left.add(fourteen);
		left.add(fifteen);
	}
	
	/** Required by the MouseListener interface.  Invoked when the mouse is clicked.
	 *  @param e the MouseEvent that triggered the method
	 */
	public void mouseClicked(MouseEvent e)
	{
		// nothing needed, but method required by interface
	}
	
	/** Required by the MouseListener interface.  Invoked when the mouse is released.
	 *  @param e the MouseEvent that triggered the method
	 */
	public void mouseReleased(MouseEvent e)
	{
		// nothing needed, but method required by interface
	}
	
	/** Required by the MouseListener interface.  Invoked when no mouse buttons are clicked and 
	 *  the mouse pointer enters a particular gui element.  In this implementation, if the mouse
	 *  pointer enters one of the menu labels, the label is set to red.
	 *  @param e the MouseEvent that triggered the method
	 */
	public void mouseEntered(MouseEvent e)
	{
		JLabel label = (JLabel) e.getSource();
		label.setForeground(Color.red);
	}
	
	/** Required by the MouseListener interface.  Invoked when no mouse buttons are clicked and 
	 *  the mouse pointer leaves a particular gui element.  In this implementation, if the mouse
	 *  pointer leaves one of the menu labels, the label is set to back to black.
	 *  @param e the MouseEvent that triggered the method
	 */
	public void mouseExited(MouseEvent e)
	{
		JLabel label = (JLabel) e.getSource();
		label.setForeground(Color.black);
	}
	
	/** Required by the MouseListener interface.  Invoked when the left mouse button is pressed.
	 *  In this implementation, if the mouse is pressed on a particular labels, that menu item
	 *  is invoked.
	 *  @param e the MouseEvent that triggered the method
	 */
	public void mousePressed(MouseEvent e) 
	{
		String theName;
		String theSpecies;
		String theColor;
		int theAge;
		int theID;
		double thePrice;
		double theWeight;
		int quantity;
		JLabel label = (JLabel) e.getSource();

		try
		{
			//Adds a cat to the inventory
			if (label.equals(one)) 
			{
				// Using this as the first parameter in showxxxDialog places the message window
				// on top of the menu window (which is this).
				theName = JOptionPane.showInputDialog(this, "Enter the cat name");
				theAge = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter the starting age (must be an integer)"));
				thePrice = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter the cat price (must be a number)"));
				theWeight = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter the cat weight (must be a number)"));
				String[] choices = {"Tabby", "Siamese", "Maine Coon", "Persian", "Scottish Fold"};
				String catType = (String) JOptionPane.showInputDialog(this, "Choose cat type", "Input",
					JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
				Cat kitty;
				if (catType.equals(choices[0]))
				{
					String [] colors = {"Brown", "Gray", "Red", "Cream", "Silver"};
					String catColor = (String) JOptionPane.showInputDialog(this, "Choose cat color", "Input",
					JOptionPane.QUESTION_MESSAGE, null, colors, colors[0]);
					theColor = catColor;
					kitty = new Tabby(theName, theAge, thePrice, theWeight, theColor);
				}
				else if (catType.equals(choices[1]))
				{
					kitty = new Siamese(theName, theAge, thePrice, theWeight);
				}
				else if (catType.equals(choices[2]))
				{
					String [] colors = {"Brown", "White", "Black", "Blue"};
					String catColor = (String) JOptionPane.showInputDialog(this, "Choose cat color", "Input",
					JOptionPane.QUESTION_MESSAGE, null, colors, colors[0]);
					theColor = catColor;
					kitty = new MaineCoon(theName, theAge, thePrice, theWeight, theColor);
				}
				else if (catType.equals(choices[3]))
				{
					kitty = new Persian(theName, theAge, thePrice, theWeight);
				}
				else
				{
					String [] colors = {"White", "Brown", "Gold", "Gray", "RAINBOW!!"};
					String catColor = (String) JOptionPane.showInputDialog(this, "Choose cat color", "Input",
					JOptionPane.QUESTION_MESSAGE, null, colors, colors[0]);
					theColor = catColor;
					kitty = new ScottishFold(theName, theAge, thePrice, theWeight, theColor);
				}
				owner.addCat(kitty);
				
				// Add to text in display window
				display.append("Cat added: " + kitty + "\n \n");
			}
	
			
			// Display all cats
			else if (label.equals(two)) 
			{
				display.setText("");  // clear the display window 
				showOwner();
			}
			// Finds cat given an ID number
			else if (label.equals(three)) 
			{
				theID = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter desired ID number"));
				if (owner.findCatByID(theID) != null)
				{
					Cat kitty = owner.findCatByID(theID);
					display.append("Cat found: " + kitty + "\n \n"); // Add to text in display window
				}
				else //displays message screen indicating invalid ID if invalid ID entered
					JOptionPane.showMessageDialog(this, "Not a valid ID");
			}
			// Finds cat given a cat name
			else if (label.equals(four)) 
			{
				theName = JOptionPane.showInputDialog(this, "Enter the cat name");
				if (owner.findCatByName(theName) != null)
				{
					Cat kitty = owner.findCatByName(theName);
					display.append("Cat found: " + kitty + "\n\n"); // Add to text in display window
				}
				else //displays message screen indicating invalid name if invalid name entered
					JOptionPane.showMessageDialog(this, "Not a valid name");
			}
			// Finds all cats of a certain species
			else if (label.equals(five)) 
			{
				String[] choices = {"Tabby", "Siamese", "MaineCoon", "Persian", "ScottishFold"};
				String catType = (String) JOptionPane.showInputDialog(this, "Choose cat type", "Input",
					JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
				theSpecies = catType;
				display.append("Cats found: " + owner.findCatsBySpecies(theSpecies) + "\n\n"); // Add to text in display window
			}
			// Sorts all cats by ID in ascending order
			else if (label.equals(six))  
			{
				owner.sortCatsByID();
				JOptionPane.showMessageDialog(this, "Sorted by ID. Click \"display cats\" to see new list.");
			}	
			// Sorts all cats by name in alphabetical order	   
			else if (label.equals(seven))  
			{
				owner.sortCatsByName();
				JOptionPane.showMessageDialog(this, "Sorted alphabetically. Click \"display cats\" to see new list.");
			}
			// Sorts all cats by price in ascending order		    
			else if (label.equals(eight))  
			{
				owner.sortCatsByPrice();
				JOptionPane.showMessageDialog(this, "Sorted by price. Click \"display cats\" to see new list.");
			}
			// Changes name of a cat given its ID number		    
			else if (label.equals(nine))  
			{
				theName = JOptionPane.showInputDialog(this, "Enter the original cat name to change");
				if (owner.findCatByName(theName) != null)
				{
					Cat kitty = owner.findCatByName(theName);
					String newName = JOptionPane.showInputDialog(this, "Enter the new cat name. Click \"display cats\" to see new cat name.");
					kitty.changeName(newName);
				}
				else //displays message screen indicating invalid name if invalid name entered
					JOptionPane.showMessageDialog(this, "Not a valid name."); 
			}
			// Sells a cat given its ID number, thus removing the cat and increasing the store balance
			else if (label.equals(ten))  
			{
				theID = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter the ID number of the cat you want to sell"));
				if (owner.findCatByID(theID) != null)
				{
					Cat kitty = owner.findCatByID(theID);
					owner.sellCat(theID);
					JOptionPane.showMessageDialog(this, kitty.getName() + " sold. Balance updated. ");
				}
				else //displays message screen indicating invalid ID if invalid ID entered
					JOptionPane.showMessageDialog(this, "Not a valid ID"); 
			}
			// Displays current balance
			else if (label.equals(eleven))  
			{
				JOptionPane.showMessageDialog(this, "Current balance: " + owner.getBalance());
			}
			// Makes cat gain weight (differing based on type of cat) given its ID	     
			else if (label.equals(twelve))  
			{
				theID = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter the ID number of the cat you want to make gain weight (differs depending on type of cat)"));
				if (owner.findCatByID(theID) != null)
				{
					Cat kitty = owner.findCatByID(theID);
					int gained = 0;
					kitty.gainWeight(gained);
					JOptionPane.showMessageDialog(this, kitty.getName() + " got fatter. Weight updated. New weight: " + kitty.getWeight());
				}
				else //displays message screen indicating invalid ID if invalid ID entered
					JOptionPane.showMessageDialog(this, "Not a valid ID");
			}
			// Makes cat make a sound (differing based on type of cat) given its ID	  	 
			else if (label.equals(thirteen)) 
			{
				theID = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter the ID number of the cat you want to make a sound (differs depending on type of cat)"));
				if (owner.findCatByID(theID) != null)
				{
					Cat kitty = owner.findCatByID(theID);
					JOptionPane.showMessageDialog(this, kitty.getName() + " says: " + kitty.makeSound());
				}
				else //displays message screen indicating invalid ID if invalid ID entered
					JOptionPane.showMessageDialog(this, "Not a valid ID"); 
			}
			// Changes price of a cat given its ID
			else if (label.equals(fourteen)) 
			{
				theID = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter the ID number of the cat you want to change the price of"));
				double newPrice = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter the new price"));
				if (owner.findCatByID(theID) != null)
				{
					Cat kitty = owner.findCatByID(theID);
					kitty.changePrice(newPrice);
					JOptionPane.showMessageDialog(this, kitty.getName() + "'s price has been changed to " + kitty.getPrice());
				}
				else //displays message screen indicating invalid ID if invalid ID entered
					JOptionPane.showMessageDialog(this, "Not a valid ID"); 
			}
			// Plays with cat given its ID; the method of playing differs based on the type of cat
			// MaineCoon, Siamese, and Tabby cats get trained and emit a new sound after playing
			// Persian and ScottishFold cats get a haircut and lose weight after playing
			else
			{
				theID = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter the ID number of the cat you want to play with"));
				if (owner.findCatByID(theID) != null)
				{
					Cat kitty = owner.findCatByID(theID);
					if (kitty instanceof MaineCoon)
					{
						((MaineCoon)kitty).trainCat();								
						JOptionPane.showMessageDialog(this, kitty.getName() + " has been trained. It seems like it now makes a new sound. Good kitty!");
					}
					else if (kitty instanceof Siamese)
					{
						((Siamese)kitty).trainCat();								
						JOptionPane.showMessageDialog(this, kitty.getName() + " has been trained. It seems like it now makes a new sound. Good kitty!");
					}
					else if (kitty instanceof Tabby)
					{
						((Tabby)kitty).trainCat();								
						JOptionPane.showMessageDialog(this, kitty.getName() + " has been trained. It seems like it now makes a new sound. Good kitty!");
					}
					else if (kitty instanceof Persian)
					{
						((Persian)kitty).getHaircut();								
						JOptionPane.showMessageDialog(this, kitty.getName() + " has gotten a haircut. So much hair was cut that it seems to have lost weight. Good kitty!");
					}
					else
					{
						((ScottishFold)kitty).getHaircut();
						JOptionPane.showMessageDialog(this, kitty.getName() + " has gotten a haircut. So much hair was cut that it seems to have lost weight. Good kitty!");
					}
				}
				else //displays message screen indicating invalid ID if invalid ID entered
					JOptionPane.showMessageDialog(this, "Not a valid ID"); 
			}
		}
		catch(NumberFormatException hi) //displays "invalid input" message if NumberFormatException encountered
		{
			JOptionPane.showMessageDialog(this, "Invalid input.");
		}	 
	}
	
	/** ActionPerformed is required by the ActionListener interface.  
	 *  It is invoked whenever one of the menu items is selected.
	 *  The possible menu items that can be activated are quit, save and load.
	 *  @param e the ActionEvent that triggered the method
	 */
	public void actionPerformed(ActionEvent e)
	{
		String menuName = e.getActionCommand();
		
		if (menuName.equals("Quit"))
		{
			System.exit(0);
		}
		else if (menuName.equals("Save"))
		{
			String fileName = JOptionPane.showInputDialog(this, "Enter file name");
			try
			{
				owner.saveToFile(fileName);
			}
			catch (IOException exc) 
			{
				exc.printStackTrace();
			}
		}
		else if (menuName.equals("Load"))
		{
			display.setText("");// clear the display window
			String inputFile = JOptionPane.showInputDialog(this, "Enter name of file to load. Try CatList.txt!");
			try
			{
				owner.loadFromFile(inputFile);
			}
			catch (FileNotFoundException ex)
    	    {
    	    	ex.printStackTrace();
    	    }
			showOwner();
		}
		
	}
	
	/** Displays the cat inventory contents in the display pane
	 */
	private void showOwner()
	{
		display.setText("Cats:" + owner.toString() + "\n \n");
	}
}



    