/**
 * PacPong
 * Runner
*/
class PacPong {
  private int p1Y = 
  public static void main ( String[] args ) {
    Listener listen = new Listener();
    PacPong ppgame = new PacPong ( listen );
  }
  public PacPong( Listener listen ) {
    boolean gameRunning = true;
    while ( gameRunning ) {
      Canvas canvas = new Canvas ( listen );

  if ( game ) {
        // The ball move from left to right
        if ( ballright ) {
          ballX += right;
          if (ballX >= (width - 8))
            ballright= false;
          } else {
            ballX += left;
            if ( ballX <= 0) {
              ballright = true;
            }
          }
          // The ball moves from up to down
          if ( ballup ) {
            // go up
            ballY += up;
            if (ballY >= (length - 8)) {
              ballup= false;
            }
          } else {
            // go down
            ballY += down;
            if ( ballY <= 0 ) {
              ballup = true;
            }
          }
          moveBall(ballX, ballY);
          // Move player 1
          shouldMovePlayer1();
          // Move player 2
          shouldMovePlayer2();
          // The score of the player 1 increase
          if (ballX >= (width - 8)) {
            score1++;
          }
          // The score of the player 2 increase
          if ( ballX == 0 ) {
            score2++;
          }



    }
  }
}


