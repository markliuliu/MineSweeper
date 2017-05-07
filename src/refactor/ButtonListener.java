package refactor;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Timer;

import refactor.button.IButton;

public class ButtonListener implements MouseListener, ActionListener {

	private IButton[][] board;
	private int i;
	private int j;
	private Timer timer;
	private MouseEvent lastEvent;

	public ButtonListener(IButton[][] board, int i, int j) {
		this(board, i, j, 150);

	}

	public ButtonListener(IButton[][] board, int i, int j, int delay) {
		this.board = board;
		this.i = i;
		this.j = j;
		timer = new Timer(delay, this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if(timer.isRunning() && arg0.getButton() == lastEvent.getButton())return;
		lastEvent = arg0;

		if (timer.isRunning()) {
			Component c = arg0.getComponent();
			if (c instanceof IButton) {
				IButton b = (IButton) c;
				b.doubleClick();
			}
			timer.stop();
		} else {
			//is first click
			timer.restart();
		}

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.stop();
		Component c = lastEvent.getComponent();
		if (c instanceof IButton) {
			IButton b = (IButton) c;
			if (lastEvent.getButton() == MouseEvent.BUTTON1) {
				b.leftClick();
			}else if (lastEvent.getButton() == MouseEvent.BUTTON3)
			{
				b.rightClick();
			}
		}
	}

}
