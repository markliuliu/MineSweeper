
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BombButton extends JButton
{
	public final static int	BOMB	= -1;
	private int				number;
	public final int		row;
	public final int		col;
	private boolean			flag	= false;
	private boolean			clicked	= false;

	public BombButton(BombButton[][] addr, int row, int col)
	{
		super();
		this.row = row;
		this.col = col;
		this.setVisible(true);
		this.addMouseListener(new MyButtonListener(addr, this, row, col));
	}

	public BombButton(String s, BombButton[][] addr, int row, int col)
	{

		super(s);
		this.row = row;
		this.col = col;
		this.setVisible(true);
		this.addMouseListener(new MyButtonListener(addr, this, row, col));
	}
	
	
	public void setNumber(int n)
	{
		this.number = n;
	}

	public int getNumber()
	{
		return this.number;
	}

	public void numberAddOne()
	{
		if (number != BOMB)
			number++;
	}



	public void setFlag()
	{
		(this.flag) = !(this.flag);
		if (flag == true)
		{

			this.setForeground(Color.red);
		} else
		{
			this.setForeground(Color.black);
		}
	}

	public boolean getFlag()
	{
		return this.flag;
	}

	public void setClicked()
	{
		(this.clicked) = true;
	}

	public boolean getClicked()
	{
		return this.clicked;
	}

	public void singleClick(BombButton[][] addr, int row, int col)// but there
																	// is no
																	// method to
	// handle double click
	{
		this.getModel().setPressed(true);
		System.out.println("single click");
		if ((!addr[row][col].getClicked()) && (!addr[row][col].getFlag()))
		{
			addr[row][col].setClicked();
			if (addr[row][col].number == 0)
			{
				System.out.println("0");
				addr[row][col].setText("" + addr[row][col].getNumber());
				singleClick(addr, row - 1, col - 1);
				singleClick(addr, row - 1, col);
				singleClick(addr, row - 1, col + 1);
				singleClick(addr, row, col - 1);
				singleClick(addr, row, col + 1);
				singleClick(addr, row + 1, col - 1);
				singleClick(addr, row + 1, col);
				singleClick(addr, row + 1, col + 1);

			} else if (addr[row][col].number > 0)
			{
				System.out.println(">0");
				addr[row][col].setText("" + addr[row][col].getNumber());

			} else
			{
				System.out.println("BOMB");
				JOptionPane.showMessageDialog(null, "you lose.");
				System.out.println("you lose.");

			}
		}
	}
}

class MyButtonListener implements MouseListener
{
	private BombButton	addr[][];
	private BombButton	button;
	private int			row;
	private int			col;

	MyButtonListener(BombButton a[][], BombButton b, int row, int col)
	{
		addr = a;
		button = b;
		this.row = row;
		this.col = col;
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getButton() == MouseEvent.BUTTON1)
		{

			addr[row][col].singleClick(addr, row, col);

		} else if (e.getButton() == MouseEvent.BUTTON3)
		{
			button.setFlag();
			if (button.getFlag())
			{
				button.setText("P");

			} else if (button.getClicked())
			{
				button.setText("" + button.getNumber());
			} else
			{
				button.setText("");
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

}
