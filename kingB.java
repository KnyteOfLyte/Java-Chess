/**Class for Chess Black King
	*@author Ali Jilani
	*/
import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;

public class kingB extends Piece
{
	//Attributes
	protected ImageIcon face;
	protected String color = "black";
	protected int moveCounter = 0;
	protected String name = "kingB";
	
	//Constructor
	public kingB ()
	{
		face = new ImageIcon("Piece Images/kingB.png");
	}
	
	/**This will allow the user to get the image attached to this Piece
		*@return ImageIcon the image representing the piece
		*/
	public ImageIcon Face()
	{
		return face;
	}
	
	/**This will check to see whether the move made by the player is valid
		*@return boolean
		*/
	public boolean Move(ChessTile[][] board, int initX, int initY, int finX, int finY)
	{
		if(/*down*/finX == initX+1 && finY == initY || /*diagonal down right*/finX == initX+1 && finY == initY+1 || /*right*/ finX == initX && finY == initY+1 || /*diagonal up right*/finX == initX-1 && finY == initY+1 || /*up*/finX == initX-1 && finY == initY ||/*diagonal up left*/finX == initX-1 && finY == initY-1 ||/*left*/ finX == initX && finY == initY-1 || /*diagonal down left*/finX == initX+1 && finY == initY-1 )
		{
			if(board[finX][finY].getPiece() == null || board[finX][finY].getPiece().Face() == null)
			{
				moveCounter++;
				return true;
			}
			else
			{
				if(((board[initX][initY].getPiece()).Colour()).equals((board[finX][finY].getPiece()).Colour()))
				{
					return false;
				}
				else
				{
					moveCounter++;
					return true;
				}
			}

		}
		else
		{
			return false;
		}
	}
		public void Capture()
	{
	}
	
	/**This will allow the user to get the colour of the Piece
		*@return String containing the colour of the piece black or white
		*/	
	public String Colour()
	{
		return color;
	}
	
	/**This will allow the user to get the number of times this Piece has moved
		*@return int
		*/
	public int Count()
	{
		return moveCounter;
	}
	
	/**This will allow the user to get the name of the Piece
		*@return String containing the name of the Piece
		*/	
	public String toString()
	{
		return name;
	}
}