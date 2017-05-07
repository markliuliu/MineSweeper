package refactor.button;

import javax.swing.JButton;

import refactor.ButtonListener;

public abstract class IButton extends JButton{
	protected int i;
	protected int j;
	protected IButton[][] board;
	protected boolean flag;
	
	public IButton(IButton[][] board, int i,int j){
		this.board = board;
		this.i = i;
		this.j = j;
		this.setVisible(true);
		this.addMouseListener(new ButtonListener(board, i, j));
		flag =false;
	}
	public boolean getFlag()
	{
		return flag;
	}
	public abstract void rightClick();
	public abstract void leftClick();
	public abstract void doubleClick();
}
