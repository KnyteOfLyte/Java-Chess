/**Class for Chess Black Rook
	*@author Ali Jilani
	*/
import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;

public class rookW extends Piece
{
	protected ImageIcon face;
	protected String color = "white";
	protected int moveCounter = 0;
	protected String name = "rookW";
	
	public rookW ()
	{
		face = new ImageIcon("Piece Images/rookW.png");
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
		if(initX == finX || initY == finY)
		{
			if(initX == finX)
			{
				if(finY>initY)
				{
					for(int y = initY+1; y < finY; y++)
					{
						if(board[initX][y].getPiece() != null)
						{
							if( (board[initX][y].getPiece()).Face() != null)
							{
								return false;
							}

						}
					}
				}
				
				else
				{
					for(int y = initY-1; y > finY; y--)
					{
						if(board[initX][y].getPiece() != null)
						{
							if(board[initX][y].getPiece().Face() != null)
							{
								return false;
							}
						}
					}
				}
			}
			
			else
			{
				if(finX>initX)
				{
					for(int x = initX+1; x < finX; x++)
					{
						if(board[x][initY].getPiece() != null)
						{
							if((board[x][initY].getPiece()).Face() != null)
							{
								return false;
							}
						}
					}
				}
				
				else
				{
					for(int x = initX-1; x > finX; x--)
					{
						if(board[x][initY].getPiece() != null)
						{
							if((board[x][initY].getPiece()).Face() != null)
							{
								return false;
							}
						}
					}
				}
			}
			
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
	
	/**This will allow the user to get the name of the Piece
		*@return String containing the name of the Piece
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