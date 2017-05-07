package refactor;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.JFrame;

import refactor.button.BoarderButton;
import refactor.button.BombButton;
import refactor.button.IButton;
import refactor.button.SafeButton;

public class Frame extends JFrame {
	private IButton button[][];

	public Frame(int row, int col, int bombs) {
		this.setTitle("Bomb");
		this.setBounds(500, 100, col * 60, row * 60);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new GridLayout(row, col));
		button = new IButton[row + 2][col + 2];

		setButton(row, col, bombs);
		this.setVisible(true);

	}

	private void setButton(int row, int col, int bombs) {
		Random random = new Random();
		Set<Integer> bombPos = new LinkedHashSet<Integer>(bombs);
		while (bombPos.size() < bombs) {
			Integer pos = random.nextInt(row * col);
			bombPos.add(pos);
		}
		for (int i = 0; i < row + 2; i++) {
			for (int j = 0; j < col + 2; j++) {
				int pos = (i - 1) * col + (j - 1);
				if (i != 0 && i != row + 1 && j != 0 && j != col + 1) {
					if (bombPos.contains((Integer) pos)) {
						button[i][j] = new BombButton(button, i, j);
					} else {
						button[i][j] = new SafeButton(button, i, j);
					}
					this.getContentPane().add(button[i][j]);
				} else// border.
				{
					button[i][j] = new BoarderButton(button, i, j);
				}

				// add to pane

			}
		}
	}
}
