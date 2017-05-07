package refactor.button;

import java.awt.Color;

import javax.swing.JButton;

public class BombButton extends IButton {
	private boolean isOpen;

	public BombButton(IButton[][] board, int i, int j) {
		super(board, i, j);
		// this.setBackground(Color.orange);
		flag = false;
		isOpen = false;
	}

	@Override
	public void rightClick() {
		// TODO Auto-generated method stub
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
		// should game over.
		
		if (!flag) {
			isOpen = true;
			this.setText("*");
			this.getParent().setVisible(false);
			//new Frame(10, 10, 10);
		}
		// this.getParent().dispose();
	}

	@Override
	public void doubleClick() {
		// do nothing.

	}

}
