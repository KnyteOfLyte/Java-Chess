/**Class for Chess White Pawn
	*@author Ali Jilani
	*/ 
import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;

public class pawnW extends Piece
{
	protected ImageIcon face;
	protected String color = "white";
	protected String name = "pawnW";
	
	public pawnW ()
	{
		face = new ImageIcon("Piece Images/pawnW.png");
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
		queenW Queenw = new queenW();
		if(/*normal move*/initY == finY && finX == initX-1 ||/*initial double jump*/ initY == finY && initX == 6 && finX == initX-2 )
		{
			if(initY == finY && initX == 6 && finX == initX-2)
			{
				if(board[initX-1][initY].getPiece() != null)
				{
					if((board[initX-1][initY].getPiece()).Face() != null)
					{
						return false;
					}
				}
			}
			
			if(board[finX][finY].getPiece() == null || board[finX][finY].getPiece().Face() == null)
			{
				if(finX == 0)
				{
					board[initX][initY].setPiece(Queenw);
					return true;
				}
				else
				{
					return true;
				}
			}
			else
			{
				return false;
			}

		}
		else
		{
			if(finY == initY-1 && finX == initX-1 || finY == initY+1 && finX == initX-1)
			{
				if(board[finX][finY].getPiece() == null || board[finX][finY].getPiece().Face() == null)
				{
					return false;
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