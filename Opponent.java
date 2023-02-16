import javax.swing.*;

class Opponent
{
	private int hp;
	private String name;
	private Item []opponentitems = new Item[50];
	int noOfItems;
	ImageIcon oppimage,oppweapon,oppweapon2; 
	public Opponent(String name)
	{
		hp = 100;
		this.name = name;
		oppimage = new ImageIcon("images/oppcut.png");
		oppweapon = new ImageIcon("images/sword.png");
        oppweapon2 = new ImageIcon("images/trident.png");
		this.opponentitems[0] = new Item(5,"Sword",oppweapon);
		this.opponentitems[1] = new Item(7,"Trident",oppweapon2);
		noOfItems = 0;
	}
    public ImageIcon returnOpponentImage()
	{
		return oppimage;
	}
	public String returnOpponentName()
	{
		return this.name;
	}
	public Item returnOpponentItem(int index)
	{
		return opponentitems[index];
	}
	public void addItem(int damage,String desc,ImageIcon img)
	{
		noOfItems++;
		this.opponentitems[noOfItems-1] = new Item(damage,desc,img);
	}
}