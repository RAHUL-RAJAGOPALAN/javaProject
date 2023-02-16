import javax.swing.*;

class Player
{
	private int hp;
	ImageIcon playerImage;
	private int noOfItems;
	private int noOfHealables;
	public Item []items = new Item[50];
	private Healable []healables = new Healable[50];

	public Player()
	{
		hp = 100;
		noOfItems = 1;
		noOfHealables = 2;

		ImageIcon img = new ImageIcon("images/sword.png");
		ImageIcon img2 = new ImageIcon("images/smallPotion.png");

		playerImage = new ImageIcon("images/gamehero1.png");
		
		items[0] = new Item(5,"Sword",img);
		healables[0] = new Healable(10,"small",img2);
		healables[1] = new Healable(10,"small",img2);
	}

	public ImageIcon returnPlayerImage()
	{
		return playerImage;
	}

	public Item returnItem(int index)
	{
		return items[index];
	}

	public Healable returnHealable(int index)
	{
		return healables[index];
	}

	public void addItem(int damage,String desc,ImageIcon img)
	{
		noOfItems++;
		this.items[noOfItems-1] = new Item(damage,desc,img);
	}

}