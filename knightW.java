/**Class for Chess White Knight
	*@author Ali Jilani
	*/  
import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;

public class knightW extends Piece
{
	//Attributes
	protected ImageIcon face;
	protected String color = "white";
	protected String name = "knightW";
	
	//Constructor
	public knightW ()
	{
		face = new ImageIcon("Piece Images/knightW.png");
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
		if( /* up */finX == initX+2 && finY == initY-1 || finX == initX+2 && finY == initY+1 || finX == initX+1 && finY == initY-2 || finX == initX+1 && finY == initY+2 || /*down*/ finX == initX-2 && finY == initY-1 || finX == initX-2 && finY == initY+1 || finX == initX-1 && finY == initY-2 || finX == initX-1 && finY == initY+2)
		{
			if(board[finX][finY].getPiece() == null || board[finX][finY].getPiece().Face() == null)
			{
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
	
			
	/**This will allow the user to get the number 1
		*@return int
		*/	
	public int Count()
	{
		return 1;
	}
	
	/**This will allow the user to get the name of the Piece
		*@return String containing the name of the Piece
		*/		
	public String toString()
	{
		return name;
	}
}