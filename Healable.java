import javax.swing.*;

class Healable
{
	int hpIncrease;
	String desc;
	ImageIcon image;

	public Healable(int hp, String desc,ImageIcon img)
	{
		hpIncrease = hp;
		this.desc = desc;
		image = img;
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