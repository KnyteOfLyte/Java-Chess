import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;

public abstract class Piece
{

	public abstract boolean Move(ChessTile[][] board, int initX, int initY, int finX, int finY);
	public abstract void Capture();
	public abstract ImageIcon Face();
	public abstract String Colour();
	public abstract int Count();
	public abstract String toString();

}

