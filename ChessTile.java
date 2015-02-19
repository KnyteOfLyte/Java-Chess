/**Class for Chess
	*@author Ali Jilani
	*/

   import java.awt.*;
   import java.net.*;//for images
   import java.io.*;//image
   import java.lang.*;
   import javax.imageio.*;
   import javax.swing.*;


   public class ChessTile extends JButton
   {
   //Attrubutes
      protected Piece tileHas;
   
   //Constructor
      public ChessTile()
      {
         super();
      }
   
      public ChessTile(ImageIcon i)
      {
         super(i);
      }
   
   //Accessor Methods
   
   /**This will allow the user to get Piece that is on the ChessTile
   	*@return Piece containing the chesspiece on the ChessTile
   	*/
		
      public Piece getPiece()
      {
         return tileHas;
      }
   	
	/**This will assign a new Piece to the ChessTile
		*@param chessP A Piece containing the new piece to be assigned to the ChessTile
		*/
      public void setPiece (Piece chessP)
      {
         tileHas = chessP;
      }
   
   }
