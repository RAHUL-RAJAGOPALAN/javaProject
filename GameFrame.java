import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.lang.Thread;
import java.util.concurrent.TimeUnit;

public class GameFrame extends JFrame implements MouseListener
{

	ImageIcon background;
	ImageIcon icon;
	JLabel playerLabel;
	JLabel opponentLabel;
	JLayeredPane pane;
	JPanel PlayerinfoPanel;
	JPanel OpponentInfoPanel;
	int level;
	String clicked;
	JProgressBar Opponentbar;
	Player player;
	String turn = "Player";
	JProgressBar Playerbar;
	ImageIcon over;
	ImageIcon win;

	public GameFrame(int level) 
	{
		this.level = level;

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(1000,700);
		this.setTitle("Awesome Quest");

		icon = new ImageIcon("images/trident.png");
		this.setIconImage(icon.getImage());

		switch(level)
		{
			case 0:
			background = new ImageIcon("images/main_logo.png");
			
			JLabel label = new JLabel();
			label.setLayout(new BorderLayout());
			label.setIcon(background);
			label.setText("START GAME");
			label.setBackground(Color.black);
			label.setForeground(Color.green);
			label.setOpaque(true);
			label.setHorizontalTextPosition(JLabel.CENTER);
			label.setVerticalTextPosition(JLabel.BOTTOM);
			label.setFont(new Font("Times New Roman",Font.BOLD,20));
			label.setIconTextGap(-75);
			label.addMouseListener(this);

			this.add(label);
			this.pack();
			this.setVisible(true);
			break;

			case 1:
			System.out.println("Reached level 1.");
			player = new Player();
			Opponent opponent = new Opponent("ninja demon");

			pane = new JLayeredPane();
			pane.setBounds(0,0,1000,700);

			JLabel background = new JLabel();
			background.setIcon(new ImageIcon("images/bg1.jpg"));
			background.setBounds(0,0,1000,700);

			playerLabel = new JLabel();
			playerLabel.setIcon(player.returnPlayerImage());
			playerLabel.setBounds(0,400,300,300);
			//playerLabel.setBackground(Color.YELLOW);

			opponentLabel = new JLabel();
			opponentLabel.setIcon(opponent.returnOpponentImage());
			opponentLabel.setBounds(750,0,350,350);

			PlayerinfoPanel = new JPanel();
			PlayerinfoPanel.setLayout(new FlowLayout(FlowLayout.LEADING,8,8));
			PlayerinfoPanel.setBackground(Color.blue);
			PlayerinfoPanel.setBounds(200,470,700,150);
			PlayerinfoPanel.setOpaque(true);

			OpponentInfoPanel = new JPanel();
			OpponentInfoPanel.setLayout(new FlowLayout(FlowLayout.LEADING,8,8));
			OpponentInfoPanel.setBackground(new Color(255,140,0));
			OpponentInfoPanel.setBounds(50,100,700,150);

			JLabel label1 = new JLabel();
			label1.setIcon(player.returnItem(0).returnImage());
			label1.setText("PlayerSword");
			label1.setForeground(Color.white);
			label1.setFont(new Font("MV Boli",Font.PLAIN,15));
			label1.setIconTextGap(-7);
			label1.addMouseListener(this);

			JLabel label2 = new JLabel();
			label2.setIcon(player.returnHealable(0).returnImage());
			label2.setText("SmallPotion");
			label2.setForeground(Color.white);
			label2.setFont(new Font("MV Boli",Font.PLAIN,15));
			label2.setIconTextGap(-7);
			label2.addMouseListener(this);


			JLabel label4 = new JLabel();
            label4.setIcon(opponent.returnOpponentItem(0).returnImage());
            label4.setText("OpponentSword");
			label4.setForeground(Color.white);
			label4.setFont(new Font("MV Boli",Font.PLAIN,15));
			label4.setIconTextGap(-7);
			label4.addMouseListener(this);

			JLabel label5 = new JLabel();
            label5.setIcon(opponent.returnOpponentItem(1).returnImage());
            label5.setText("OpponentTrident");
			label5.setForeground(Color.white);
			label5.setFont(new Font("MV Boli",Font.PLAIN,15));
			label5.setIconTextGap(-7);
			label5.addMouseListener(this);

			Playerbar = new JProgressBar(0,100);
        	Playerbar.setValue(5);
        	Playerbar.setStringPainted(true);
        	Playerbar.setFont(new Font("MV Boli",Font.BOLD,25));
        	Playerbar.setBackground(Color.BLACK);
        	Playerbar.setForeground(Color.RED);
			Playerbar.setLayout(new GridLayout());
			Playerbar.setPreferredSize(new Dimension(650,50));

			Opponentbar = new JProgressBar(0,100);
        	Opponentbar.setValue(100);
        	Opponentbar.setStringPainted(true);
        	Opponentbar.setFont(new Font("MV Boli",Font.BOLD,25));
        	Opponentbar.setBackground(Color.BLACK);
        	Opponentbar.setForeground(Color.RED);
			Opponentbar.setPreferredSize(new Dimension(650,50));

			PlayerinfoPanel.add(label1);
			PlayerinfoPanel.add(label2);
			PlayerinfoPanel.add(Playerbar);
           
            OpponentInfoPanel.add(label4);
			OpponentInfoPanel.add(label5);
			OpponentInfoPanel.add(Opponentbar);

			pane.add(PlayerinfoPanel);
			pane.add(playerLabel);
			pane.add(opponentLabel);
			pane.add(OpponentInfoPanel);
			pane.add(background);

			this.add(pane);
			this.setLayout(null);
			this.setVisible(true);
			break;

			case 2:
			over = new ImageIcon("images/you lose.png");
			
			JLabel lab = new JLabel();
			lab.setLayout(new BorderLayout());
			lab.setIcon(over);
			lab.setOpaque(true);
			this.add(lab);
			this.pack();
			this.setVisible(true);
			break;

			case 3:
			win = new ImageIcon("images/you win.jpg");
			
			JLabel lab1 = new JLabel();
			lab1.setLayout(new BorderLayout());
			lab1.setIcon(win);
			lab1.setOpaque(true);
			this.add(lab1);
			this.pack();
			this.setVisible(true);
			break;
		}
	}
    
	void opponent_calc() throws InterruptedException
    {
	   Thread.sleep(3000);
       int val;
       Random rand = new Random();
       val = rand.nextInt(1);
       if(val==0)
         Playerbar.setValue(Playerbar.getValue()-5);

       else
         Playerbar.setValue(Playerbar.getValue()-7);
    }
    
	public void mouseClicked(MouseEvent e) 
	{
		if(level == 0)
		{
			this.setVisible(false);
			System.out.println("\nGame started.");
			new GameFrame(++level);
		}

		else if(level == 1)
		{
			
				JLabel l = (JLabel)e.getSource();
				String text = l.getText();
				if(text.equals("PlayerSword"))
				{
					Opponentbar.setValue(Opponentbar.getValue()-player.items[0].damage);
					try{
						opponent_calc();
					}
					catch(Exception E)
					{
						System.out.println("    ");
					}
					//turn = "Opponent";
				}

				else if(text.equals("SmallPotion"))
				{
					Playerbar.setValue(Playerbar.getValue()+2);
					try{
						opponent_calc();
					}
					catch(Exception E)
					{
						System.out.println("    ");
					}
					
					//turn = "Opponent";
				}

				/*else if(turn.equals("Opponent") && text.equals("OpponentSword"))
				{
					Playerbar.setValue(Playerbar.getValue()-5);
					//turn = "Player";
				}*/
			    if(Playerbar.getValue()==0)
				{
					this.setVisible(false);
					new GameFrame(2);
				}
                else if(Opponentbar.getValue()==0)
				{
					this.setVisible(false);
					new GameFrame(3);
				}
			
		}
		
	}

	public void mousePressed(MouseEvent e)
	{
		
	}

	public void mouseReleased(MouseEvent e)
	{
	}

	public void mouseEntered(MouseEvent e)
	{
		
	}

	public void mouseExited(MouseEvent e)
	{
		
	}
}