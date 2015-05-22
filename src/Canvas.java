/**
* PacPong
* Canvas
*/
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
public class Canvas extends JPanel {
private int height = 0;
private int width = 0;
private boolean game=true;
private int ballX, ballY, p1X, p1Y, p2X, p2Y, girth, pLength;
private int move;
private int ballspeed;
private int score1,score2;
File oneScore = new File("src/finish images/0.png");
Image p1score = null;
File twoScore = new File("src/finish images/0.png");
Image p2score = null;
public Canvas(int x, int y) {
height = y;
width = x;
move = height/40;
ballspeed = width/150;
ballX = width/2;
ballY = height/2;
p1Y = height/2;
p2Y = height/2;
p1X = width/40;
p2X = (width /40)*38;
pLength=height/10;
girth=width/120;
game=true;
score1=0;
score2=0;
}
public int getPLength(){
return pLength;
}
public int getGirth(){
return girth;
}
public int getSpeed(){
return ballspeed;
}
public void setSpeed(int s){
ballspeed=s;
}
public void run(){
repaint();
}
public void setScore1(int s){
score1=s;
}
public void setScore2(int s){
score2=s;
}
public int getMove(){
return move;
}
public int getWidth(){
return width;
}
public int getHeight(){
return height;
}
public int ballX(){
return ballX;
}
public void over(){
game=false;
repaint();
}
public int ballY(){
return ballY;
}
// Draw ball and ships
public void paintComponent(Graphics g) {
		setOpaque(true);
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.WHITE);
		int boun = height/30;
		int leng = boun/2;
			
		for(int i=0; i<31; i++){
				g.fillRect(width/2, boun*i, width/500, leng);
				}
		g.fillRect(ballX, ballY, width/165, height/95 );
		// Draw paddles
		g.fillRect(p1X, p1Y, girth, pLength);
		g.fillRect(p2X, p2Y, girth, pLength);
		
		//Draw scores and calculate for X locations

	oneScore = new File("src/finish images/" + score1 + ".png");
    try{
    	p1score = ImageIO.read(oneScore);
    	}catch(IOException e){
    		System.err.println("Could not find image");
    	}
    		
	twoScore = new File("src/finish images/" + score2 + ".png");
    try{
    	p2score = ImageIO.read(twoScore);
    	}catch(IOException q){
    		System.err.println("Could not find image");
    	}
g.drawImage(p1score, width/4, height/10, null);
g.drawImage(p2score, (width/4)*3, height/10, null);

	//displays help
	if(Run.shouldHelp()==true) {
		g.drawString("HELP:", 0, java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight()-200);
		g.drawString("Left Paddle - 'W' and 'S'", 0, java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight()-175);
		g.drawString("Right Paddle - UP and DOWN arrows", 0, java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight()-150);
		g.drawString("Pause game - 'P'", 0, java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight()-125);
		g.drawString("Exit game - ESC key", 0, java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight()-100);
		g.drawString("To access this menu at any time, press 'H'", 0, java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight()-50);
		g.drawString("To begin, press the 'F' key", 0, java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight()-25);
	}

	if ( !game ) {
			File endGame = new File("src/finish images/game_over.png");
			Image end = null;
				try {
					end = ImageIO.read(endGame);
				} catch (IOException e) {
					e.printStackTrace();
					}
					g.drawImage(end, width/5, (height/2)-150, null);
					}
    	}    

public boolean getGame(){
	return game;
}
// end paintComponent
// Positions on X and Y for the ball
public void moveBall (int nx, int ny) {
ballX = nx;
ballY = ny;
repaint();
} // end moveBall
public void movePlayer1UP(){
if(p1Y>0){
p1Y-=move;
}
repaint();
}
// Position on Y for the player 2
public void movePlayer2UP(){
if(p2Y>0){
p2Y-=move;
}
repaint();
}
public void movePlayer1D(){
if(p1Y<(height-pLength)){
p1Y+=move;
}
repaint();
}
public void movePlayer2D(){
if(p2Y<(height-pLength)){
p2Y+=move;
}
repaint();
}
public void movePlayer3UP () {
	if ( p3Y > 0 ) {
		p3Y -= move;
	}
	repaint();
}
public void movePlayer3D () {
	if ( p3Y < height ) {
		p3Y += move;
	}
	repaint();
}
public void movePlayer3L() {
	if ( p3X > 0 ) {
		p3X -= move;
	}
	repaint();
}
public void movePlayer3R() {
	if ( p3X < width ) {
		p3X += move;
	}
}

public int getp1X () {
return p1X;
}
public int getp1Y () {
return p1Y;
}
public int getp2X () {
return p2X;
}
public int getp2Y () {
return p2Y;
}
public int getp3X() {
	return p3X;
}
public int getp3Y() {
	return p3Y;
}
}
