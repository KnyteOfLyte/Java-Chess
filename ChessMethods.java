 	/**
		*Class MyMethods
		*@author Ali Jilani
	*/  
	import java.awt.*;
   import javax.swing.*;

   public class ChessMethods
   {
		/** To Check if the player is trying to legitimately castle
			*@ param chessboard the entire 2D ChessTile Array representing the current board
						initLocationX the X coordinate of the initial piece
						initLocationY the Y coordinate of the initial piece
						finLocationX the X coordinate of the final piece
						finLocationY the Y coordinate of the final piece
			*@return true  if the castling took place
			*/
      public static boolean CastleCheck (ChessTile[][] chessboard, int initLocationX, int initLocationY, int finLocationX, int finLocationY)
      {
      	//White piece Castle
         rookW Rookw = new rookW();
         kingW Kingw = new kingW();
      
      	//Black piece Castle
         rookB Rookb = new rookB();
         kingB Kingb = new kingB();
			  
         boolean castle = true;
         placeholderPiece temp = new placeholderPiece();
      	
         if(initLocationX == 0 && initLocationY == 4 || initLocationX == 7 && initLocationY == 4) //Checks if the initial locaitons match with the location of the kings
         {
            try
            {
               if((chessboard[initLocationX][initLocationY].getPiece()).Count() == 0 )//makes sure the king has not moved
               {
                  if(initLocationX == 0) // Black King
                  {
                     if(finLocationX == 0 && finLocationY == 2 || finLocationX == 0 && finLocationY == 6) // Check the if final locations match with the allowed castling locations
                     {
                        if(finLocationY == 2)
                        {
                           try
                           {
                              if((chessboard[0][0].getPiece()).Count() == 0) //Make sure rook has not moved
                              {
                                 for(int i = 3; i>0; i--) //Check to make sure no pieces in between
                                 {
                                    if(chessboard[0][i].getPiece() != null)
                                    {
                                       if((chessboard[0][i].getPiece()).Face() != null)
                                       {
                                          castle = false;
                                       }
                                    }
                                 }
                                                
                                 if(castle)//if clear then preform the castle
                                 {
                                    
                                    chessboard[0][0].setPiece(temp);
                                    chessboard[0][3].setPiece(Rookb);
                                    chessboard[0][4].setPiece(temp);
                                    chessboard[0][2].setPiece(Kingb);
                                    return true;
                                 	
                                 }
                              }
                           }
                              catch(AbstractMethodError a)
                              {
                              }
                        }
                        else //finLocationY == 6
                        {
                           try
                           {
                              if((chessboard[0][7].getPiece()).Count() == 0)//Make Sure rook has not moved
                              {
                                 for(int i = 5; i<7; i++)//Check to make sure no pieces in between
                                 {
                                    if(chessboard[0][i].getPiece() != null)
                                    {
                                       if((chessboard[0][i].getPiece()).Face() != null)
                                       {
                                          castle = false;
                                       }
                                    }
                                 }
                                                
                                 if(castle)//if clear then preform the castle
                                 {
                                    
                                    chessboard[0][7].setPiece(temp);
                                    chessboard[0][4].setPiece(temp);
                                    chessboard[0][5].setPiece(Rookb);
                                    chessboard[0][6].setPiece(Kingb);
                                    return true;
                                 	
                                 }
                              }
                           }
                              catch(AbstractMethodError a)
                              {
                              }
                        
                        }
                     }
                  }
                                    
                  else //initLocationX == 7 // White King
                  {
                     if(finLocationX == 7 && finLocationY == 2 || finLocationX == 7 && finLocationY == 6) // Check the if final locations match with the allowed castling locations
                     {
                        if(finLocationY == 2)
                        {
                           try
                           {
                              if((chessboard[7][0].getPiece()).Count() == 0) //Make sure rook has not moved
                              {
                                 for(int i = 3; i>0; i--)//Check to make sure no pieces in between
                                 {
                                    if(chessboard[7][i].getPiece() != null)
                                    {
                                       if((chessboard[7][i].getPiece()).Face() != null)
                                       {
                                          castle = false;
                                       }
                                    }
                                 }
                                                
                                 if(castle)//if clear then preform the castle
                                 {
                                    
                                    chessboard[7][0].setPiece(temp);
                                    chessboard[7][3].setPiece(Rookw);
                                    chessboard[7][4].setPiece(temp);
                                    chessboard[7][2].setPiece(Kingw);
                                    return true;
                                 	
                                 }
                              }
                           }
                              catch(AbstractMethodError a)
                              {
                              }
                        }
                        else //finLocationY == 6
                        {
                           try
                           {
                              if((chessboard[7][7].getPiece()).Count() == 0) //Make sure rook has not moved
                              {
                                 for(int i = 5; i<7; i++)//Check to make sure no pieces in between
                                 {
                                    if(chessboard[7][i].getPiece() != null)
                                    {
                                       if((chessboard[7][i].getPiece()).Face() != null)
                                       {
                                          castle = false;
                                       }
                                    }
                                 }
                                                
                                 if(castle)//if clear then preform the castle
                                 {
                                    
                                    chessboard[7][7].setPiece(temp);
                                    chessboard[7][4].setPiece(temp);
                                    chessboard[7][5].setPiece(Rookw);
                                    chessboard[7][6].setPiece(Kingw);
                                    return true;
                                 	
                                 }
                              }
                           }
                              catch(AbstractMethodError a)
                              {
                              }
                        
                        }
                     }
                  }
               }
            }
               catch(AbstractMethodError e)
               {
               }
         }
      
      	else
      	{
      		return false;
      	}
      	
      	return false;
      }
      
   }