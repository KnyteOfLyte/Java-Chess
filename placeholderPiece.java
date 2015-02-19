import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;

public class placeholderPiece extends Piece
{
	
	public placeholderPiece ()
	{
	}
	
	public ImageIcon Face()
	{
		return null;
	}
	
	public boolean Move(ChessTile[][] board, int initX, int initY, int finX, int finY)
	{
		return false;
	}
	
	public void Capture()
	{
	}
	
	public String Colour()
	{
		return "no";
	}
	
	public int Count()
	{
		return 1;
	}
		
	public String toString()
	{
		return "no";
	}
}