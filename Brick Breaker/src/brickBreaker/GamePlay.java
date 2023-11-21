package brickBreaker;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import javax.swing.JPanel;
import java.awt.Graphics2D;

public class GamePlay extends JPanel implements KeyListener, ActionListener {
	
	private boolean play = false; // When game ends, it should not continue by itself. 
	private int score = 0; // Starting score to start at zero.
	
	private int totalBricks = 21; // The amount of bricks that the game will have. 
	
	private Timer timer; // How fast the ball should move
	private int delay = 8; // The speed of the ball 
	
	private int playerX = 310; // Starting position of slider
	
	private int ballposX = 120; // Starting position of the ball
	private int ballposY = 350; // Starting position of the ball
	private int ballXdir = -1; // The direction of the ball
	private int ballYdir = -2; // The direction of the ball. 
	
	private MapGenerator map; 
	
	public GamePlay() {
		map = new MapGenerator(3,7); 
		addKeyListener(this); 
		setFocusable(true);
		setFocusTraversalKeysEnabled(false); 
		timer = new Timer(delay, this); 
		timer.start();
	}
	
	public void paint(Graphics g) {
		// background
		g.setColor(Color.black);
		g.fillRect(1, 1, 692, 592);
		
		// drawing map
		map.draw((Graphics2D)g);
		
		//Borders
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);
		
		//Scores
		g.setColor(Color.white);
		g.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		g.drawString("" +score, 590, 30);
		//Paddle
		g.setColor(Color.green);
		g.fillRect(playerX, 550, 100, 8);
		
		// Ball
		g.setColor(Color.cyan);
		g.fillOval(ballposX, ballposY, 20, 20);
		
		if(totalBricks <= 0) {
			play = false; 
			ballXdir = 0;
			ballYdir = 0; 
			g.setColor(Color.red);
			g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
			g.drawString("You win, lucky", 190,30); 
			
			g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
			g.drawString("Press Enter To Play Again", 230,350);
		}
		
		if(ballposY > 570) {
			play = false; 
			ballXdir = 0;
			ballYdir = 0; 
			g.setColor(Color.red);
			g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
			g.drawString("Game Over Loser! Your Score was " + score, 190,30); 
			
			g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
			g.drawString("Press Enter To Play Again", 230,350);
		}
		
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start(); //Starts timer
		
		if (play) {
			if(new Rectangle(ballposX, ballposY,20,20).intersects(new Rectangle(playerX, 550, 100, 8))); {
				ballYdir = -ballYdir; 
			}
			
		A:	for (int i = 0; i < map.map.length; i++) {
				for(int j = 0; j<map.map[0].length; j++) {
					if(map.map[i][j] > 0 ) {
						int brickX = j * map.brickWidth + 80;
						int brickY = i * map.brickHeight + 50;
						int brickWidth = map.brickWidth;
						int brickHeight = map.brickHeight; 
						
						Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
						Rectangle ballRect = new Rectangle (ballposX, ballposY, 20,20); 
						Rectangle brickRect = rect; 
						
						if(ballRect.intersects(brickRect)) {
							map.setBrickValue(0, i, j);
							totalBricks--;
							score += 10; 
							
							if (ballposX + 19 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width) {
								ballXdir = -ballXdir;
							} else {
								ballYdir = -ballYdir; 
							}
							
							break A; 
						}
					}
				}
			}
			
			ballposX += ballXdir;
			ballposY += ballYdir; 
			if (ballposX < 0) {
				ballXdir = -ballXdir;
			}
			if (ballposY < 0) {
				ballYdir = -ballYdir;
			}
			if (ballposX > 670) {
				ballXdir = -ballXdir;
			}
		}
		
		repaint(); // re-calls the paint method to do all of the methods inside it again. 
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(playerX >= 600) {
				playerX = 600;
			}else {
				moveRight();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(playerX < 10) {
				playerX = 10;
			}else {
				moveLeft();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (!play) {
				play = true; 
				ballposX = 120;
				ballposY=350;
				ballXdir = -1;
				ballYdir = -2; 
				playerX = 310;
				score = 0; 
				totalBricks = 21; 
				map = new MapGenerator(3,7); 
				
				repaint(); 
			}
		}
		
	}

	public void moveRight() {
		play = true; 
		playerX+=20;
	}
	
	public void moveLeft() {
		play = true; 
		playerX-=20;
	}

}
