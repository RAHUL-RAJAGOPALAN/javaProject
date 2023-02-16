import javax.swing.*;

class Item
{
	String desc;
	int damage;
	ImageIcon image;

	public Item(int damage,String desc,ImageIcon img)
	{
		this.damage = damage;
		this.desc = desc;
		this.image = img;
	}

	public ImageIcon returnImage()
	{
		return image;
	}

	public String returnDesc()
	{
		return desc;
	}
}