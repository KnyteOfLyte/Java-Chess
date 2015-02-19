   class Play
   {
      public static void main ( String[] args )
      {
         Chess game  = new Chess( "Chess by AJ Studios" ) ;
      
         game.setResizable(false);
         game.setSize( 500, 500 );     
         game.setVisible( true );
         game.setLocationRelativeTo(null);      
      }
   }