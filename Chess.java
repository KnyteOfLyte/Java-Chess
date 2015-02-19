/**Class for Play
	*@author Ali Jilani
	*/
		
	import java.awt.*; 
   import java.awt.event.*;
   import javax.swing.*;
   import javax.swing.ImageIcon;
   import java.util.Random;; 

   public class Chess extends JFrame implements ActionListener
   {	
      ChessTile [][] chessboard = new ChessTile[8][8]; //2D Array of Custom JButtons called ChessTile
      Color whiteTile = new Color(255, 204, 153);//A light Tan colour for Chess Board
      Color blackTile = new Color(198, 142, 63);//A Dark brown colour for Chess Board
      String location;//saves location of button
      String locationChecker;
      boolean initialSelection = true; //boolean true if it is the users 'Initial Selection', false for second selection
      int turn = 1; //if turn%2 =! 0 then White players turn else Black players turn
      int initLocationX; // initial
      int initLocationY;
      int finLocationX; // final
      int finLocationY;
      boolean gameEnd = false; // boolean true if a king has been taken ie. Game Over
      boolean whiteKingStatus = true;
      boolean blackKingStatus = true;
      placeholderPiece temp = new placeholderPiece();
   
      //White pieces
      pawnW Pawnw = new pawnW();
      rookW Rookw1 = new rookW();
      rookW Rookw2 = new rookW();
      knightW Knightw = new knightW();
      bishopW Bishopw = new bishopW();
      queenW Queenw = new queenW();
      kingW Kingw = new kingW();
   
   //Black pieces
      pawnB Pawnb = new pawnB();
      rookB Rookb1 = new rookB();
      rookB Rookb2 = new rookB();
      knightB Knightb = new knightB();
      bishopB Bishopb= new bishopB();
      queenB Queenb = new queenB();
      kingB Kingb = new kingB();
   
   // constructor for Chess board
      public Chess(String title)                           
      {
         super( title );
      
      //create the board
      
         for(int i=0; i<8; i++)
         {
            for(int j=0; j<8; j++)
            {  
               location = i + " " + j;
               chessboard[i][j] = new ChessTile();		
               chessboard[i][j].setPreferredSize(new Dimension(50, 50));
               chessboard[i][j].setActionCommand(location);
               chessboard[i][j].addActionListener( this );
               chessboard[i][j].setVisible(true);
            }
         } 
      
      // Color the board
         for(int y=0; y<8; y++)
         {
            for(int x = 0; x<8; x++)
            {
               if(y%2 == 0)
               {
                  if(x%2 == 0)
                  {
                     chessboard[y][x].setBackground(whiteTile);
                  }
                  else
                  {
                     chessboard[y][x].setBackground(blackTile);
                  }
               }
               else
               {
                  if(x%2 == 0)
                  {
                     chessboard[y][x].setBackground(blackTile);
                  }
                  else
                  {
                     chessboard[y][x].setBackground(whiteTile);
                  }
               }
            }
         }
      
      	//Set up the board
         for(int i=0; i<8; i++)
         {
            for(int j=0; j<8; j++)
            {
             
            //Black Rook
               if(i==0 && j==0)
               {
                  chessboard[i][j].setPiece(Rookb1);
               }
            	
               if(i==0 && j==7)
               {
                  chessboard[i][j].setPiece(Rookb2);
               }
            
            //Black Knight
               if(i==0 && j==1 || i==0 && j==6)
               {
                  chessboard[i][j].setPiece(Knightb);
               }
            
            //Black Bishop
               if(i==0 && j == 2 || i ==0 && j == 5)
               {
                  chessboard[i][j].setPiece(Bishopb);
               }
            
            //Black Queen
               if(i == 0 && j == 3)
               {
                  chessboard[i][j].setPiece(Queenb);
               }
            
            //Black King
               if(i == 0 && j == 4)
               {
                  chessboard[i][j].setPiece(Kingb);
               }
            
            //Black Pawns
               if(i == 1)
               {
                  chessboard[i][j].setPiece(Pawnb);
               }
            
            //White Pawns
               if(i == 6)
               {
                  chessboard[i][j].setPiece(Pawnw);
               }
            
            //White Rook
               if(i==7 && j==0)
               {
                  chessboard[i][j].setPiece(Rookw1);
               }
            	
               if(i==7 && j==7)
               {
                  chessboard[i][j].setPiece(Rookw2);
               }
            
            //White Knight
               if(i==7 && j==1 || i==7 && j==6)
               {
                  chessboard[i][j].setPiece(Knightw);
               }
            
            //White Bishop
               if(i==7 && j == 2 || i ==7 && j == 5)
               {
                  chessboard[i][j].setPiece(Bishopw);
               }
            
            //White King
               if(i == 7 && j == 4)
               {
                  chessboard[i][j].setPiece(Kingw);
               }
            
            //White Queen
               if(i == 7 && j == 3)
               {
                  chessboard[i][j].setPiece(Queenw);
               }
            
				//Set Icon, if there is a piece on the ChessTile
               if(chessboard[i][j].getPiece() != null)
               {
                  chessboard[i][j].setIcon((chessboard[i][j].getPiece()).Face());
               }
            
            }
         }
      
         for(int i=0; i<8; i++)
         {
            for(int j=0; j<8; j++)
            {
               add( 	chessboard[i][j] );
            }
         }
      
         System.out.println("White's Turn");//White always starts
      
         setLayout( new GridLayout(8,8) );
         setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );   
      }
   
      public void actionPerformed( ActionEvent evt)
      {
         if(gameEnd)
         {
            System.out.println("Game Over");
         }
         
         else
         {
            if(initialSelection == true)
            {	
               for(int x = 0; x < 8; x++)
               {
                  for(int y = 0; y < 8; y++)
                  {
                     locationChecker = x + " " + y; //Find the button that is clicked
                  
                     if(evt.getActionCommand().equals( locationChecker ))
                     {
                        initLocationX = x;
                        initLocationY = y;
                     
                        if(chessboard[initLocationX][initLocationY].getPiece() != null) // Make sure it's not a blank spot
                        {
                           if(chessboard[initLocationX][initLocationY].getPiece().Face() != null)
                           {
                              if(turn%2 != 0)//make sure it's the correct player playing
                              {
                                 if((chessboard[initLocationX][initLocationY].getPiece().Colour()).equals("white"))
                                 {
                                    initialSelection = false; // valid initialSelection
                                    turn++;
                                 }
                                 
                                 else
                                 {
                                    initialSelection = true;
                                 }
                              }
                              
                              else
                              {
                                 if((chessboard[initLocationX][initLocationY].getPiece().Colour()).equals("black"))
                                 {
                                    initialSelection = false;
                                    turn++;
                                 }
                                 
                                 else
                                 {
                                    initialSelection = true;
                                 }
                              }
                           
                           
                           }
                           else
                           {
                              initialSelection = true;
                           }
                        
                        }
                        else
                        {
                           initialSelection = true;
                        }
                     }
                  
                  }
               }
            }
            
            else // initialSelection == false
            {
               for(int x = 0; x < 8; x++)
               {
                  for(int y = 0; y < 8; y++)
                  {
                     locationChecker = x + " " + y;
                  
                     if(evt.getActionCommand().equals( locationChecker ))
                     {
                        finLocationX = x;
                        finLocationY = y;
                     
                        if(finLocationX == initLocationX && finLocationY == initLocationY)
                        {
                           initialSelection = true;
                           System.out.println("Illegal Move");
                           turn--;
                        }
                        else
                        {
                        
                        
                           if((chessboard[initLocationX][initLocationY].getPiece()).Move(chessboard, initLocationX, initLocationY, finLocationX, finLocationY) == true) // call the move method to confirm if the move is legitamate for that piece
                           {
                              chessboard[finLocationX][finLocationY].setPiece(chessboard[initLocationX][initLocationY].getPiece());//move the piece
                              chessboard[initLocationX][initLocationY].setPiece(temp);
                           
                           }
                           else
                           {
                              if(ChessMethods.CastleCheck(chessboard, initLocationX, initLocationY, finLocationX, finLocationY) == true)//Check to see if the player castled
                              {
                                 System.out.println("Castled");
                              }
                              else
                              {
                                 System.out.println("Illegal Move");
                                 turn--; 
                              }  
                           
                           }
                        
                           for(int i=0; i<8; i++)
                           {
                              for(int j=0; j<8; j++)
                              {
                                 if(chessboard[i][j].getPiece() != null)
                                 {
                                    chessboard[i][j].setIcon((chessboard[i][j].getPiece()).Face()); //Redraw the icons on the board
                                 }
                              
                              
                              }
                           }
                        }
                     
                        initialSelection = true;
                     }
                  
                  }
               }
            	
					///////////////Check to see if the game is over ie. A king has been taken
               blackKingStatus = false;
               whiteKingStatus = false;
            
               for(int x = 0; x < 8; x++)
               {
                  for(int y = 0; y < 8; y++)
                  {
                     if(chessboard[x][y].getPiece() != null)
                     {
                        if((chessboard[x][y].getPiece().toString()).equals("kingB"))
                        {
                           blackKingStatus = true;
                        }
                     
                        if((chessboard[x][y].getPiece().toString()).equals("kingW"))
                        {
                           whiteKingStatus = true;
                        }
                     }
                  }
               }
            
               if(blackKingStatus == false || whiteKingStatus == false)
               {
						if(blackKingStatus == false)
						{
							System.out.println("The Black King has been Taken!");
							System.out.println("Game Over");
						}
						else
						{
							System.out.println("The White King has been Taken!");
							System.out.println("Game Over");
						}
                  gameEnd = true;
               }
            
				if(gameEnd == false)
				{
               if(turn%2 != 0)
               {
                  System.out.println("White's Turn");
               }
               else
               {
                  System.out.println("Black's Turn");
               }
            }
            }
         }
      }
		}