import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Frame extends JFrame
{
	// private JFrame frame;
	private BombButton button[][];

	Frame()
	{
	}

	Frame(int row, int col, int bombs)
	{
		this.setTitle("cute Joanne <3");
		this.setBounds(500, 100, row * 60, col * 60);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new GridLayout(row, col));
		button = new BombButton[row + 2][col + 2];
		for (int i = 0; i < row + 2; i++)
		{
			for (int j = 0; j < col + 2; j++)
			{
				button[i][j] = new BombButton(button, i, j);
				if (i != 0 && i != row + 1 && j != 0 && j != col + 1)
				{
					this.getContentPane().add(button[i][j]);
				} else
				{
					button[i][j].setNumber(1);
				}
			}
		}
		setBomb(row, col, bombs);
		this.setVisible(true);
	}

	public void setBomb(int row, int col, int bombs)
	{
		int count = 0;
		int pos = 0;

		int i;
		int j;
		while (count < bombs)
		{
			pos = (int) (Math.random() * (row * col));
			i = (pos / col) + 1;
			j = (pos % col) + 1;
			if (button[i][j].getNumber() != BombButton.BOMB)
			{
				button[i][j].setNumber(BombButton.BOMB);

				/////////////////////////
				button[i - 1][j - 1].numberAddOne();
				button[i - 1][j].numberAddOne();
				button[i - 1][j + 1].numberAddOne();

				button[i][j - 1].numberAddOne();
				button[i][j + 1].numberAddOne();

				button[i + 1][j - 1].numberAddOne();
				button[i + 1][j].numberAddOne();
				button[i + 1][j + 1].numberAddOne();
				////////////////////////

				/*
				 * if (i != 0 && i != row-1)//set others number { button[i -
				 * 1][j].numberAddOne(); button[i + 1][j].numberAddOne(); if(j
				 * != 0 && j != col-1) { button[i][j - 1].numberAddOne();
				 * button[i][j + 1].numberAddOne();
				 * 
				 * button[i - 1][j - 1].numberAddOne(); button[i - 1][j +
				 * 1].numberAddOne(); button[i + 1][j - 1].numberAddOne();
				 * button[i + 1][j + 1].numberAddOne();
				 * 
				 * }else if (j ==0) { button[i][j + 1].numberAddOne(); button[i
				 * - 1][j + 1].numberAddOne(); button[i + 1][j +
				 * 1].numberAddOne(); }else if (j ==col-1) { button[i][j -
				 * 1].numberAddOne(); button[i - 1][j - 1].numberAddOne();
				 * button[i + 1][j - 1].numberAddOne(); }
				 * 
				 * } else if (i == 0) { button[i + 1][j].numberAddOne();
				 * 
				 * if(j != 0 && j != col-1) { button[i][j - 1].numberAddOne();
				 * button[i][j + 1].numberAddOne();
				 * 
				 * button[i + 1][j - 1].numberAddOne(); button[i + 1][j +
				 * 1].numberAddOne(); }else if (j ==0) { button[i][j +
				 * 1].numberAddOne(); button[i + 1][j + 1].numberAddOne(); }else
				 * if (j ==col-1) { button[i][j - 1].numberAddOne(); button[i +
				 * 1][j - 1].numberAddOne(); } } else if (i == row-1) { button[i
				 * - 1][j].numberAddOne();
				 * 
				 * if(j != 0 && j != col-1) { button[i][j - 1].numberAddOne();
				 * button[i][j + 1].numberAddOne();
				 * 
				 * button[i - 1][j - 1].numberAddOne(); button[i - 1][j +
				 * 1].numberAddOne(); }else if (j ==0) { button[i][j +
				 * 1].numberAddOne(); button[i - 1][j + 1].numberAddOne(); }else
				 * if (j ==col-1) { button[i][j - 1].numberAddOne(); button[i -
				 * 1][j - 1].numberAddOne(); } }
				 */

				count++;
			}
		}

	}

}
