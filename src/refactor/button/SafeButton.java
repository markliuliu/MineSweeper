package refactor.button;

import java.awt.Color;

import javax.swing.JButton;

public class SafeButton extends IButton {
	private boolean isOpen;
	private int counter;

	public SafeButton(IButton[][] borad, int i, int j) {
		super(borad, i, j);

		counter = 0;
	}

	@Override
	public void rightClick() {
		if (!isOpen) {
			flag = !flag;
			if (flag == true) {
				this.setText("P");
			} else {
				this.setText(" ");
			}
		}

	}

	@Override
	public void leftClick() {
		if (!isOpen) {
			isOpen = true;
			this.setBackground(Color.GRAY);
			for (int x = i - 1; x <= i + 1; x++) {
				for (int y = j - 1; y <= j + 1; y++) {
					if (x == i && y == j)
						continue;
					if (board[x][y] instanceof BombButton)
						counter++;
				}
			}
			if (counter == 0) {
				openSurround(i, j);
			}
			if (counter != 0) {
				this.setText("" + counter);
			}
		}
		System.out.println("left");
	}

	@Override
	public void doubleClick() {
		System.out.println("double");
		int flagCounter = 0;
		if (counter == 0)
			return;
		else {
			for (int x = i - 1; x <= i + 1; x++) {
				for (int y = j - 1; y <= j + 1; y++) {
					if (x == i && y == j)
						continue;
					if (board[x][y].getFlag())
						flagCounter++;
				}
			}
			if (flagCounter == counter) {
				openSurround(i, j);
			}
		}
	}

	private void openSurround(int i, int j) {
		for (int x = i - 1; x <= i + 1; x++) {
			for (int y = j - 1; y <= j + 1; y++) {
				if (x == i && y == j)
					continue;
				if (!board[x][y].getFlag()) {
					board[x][y].leftClick();
				}
			}
		}
	}

}
