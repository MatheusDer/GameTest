import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
    //botar os finals em caixa alta
    final int tile = 32;
    final int scale = 2;

    final int tileSize = scale * tile;

    final int maxScreenCol = 16;
    final int maxScreenRow = 12;

    final int screenW = tileSize * maxScreenCol;
    final int screenH = tileSize * maxScreenRow;
    
    final int fps = 60;
    
    //criar uma classe player depois
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 6;

    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenW, screenH));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void start() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        long drawCount = 0;
        
        while(gameThread != null){
            currentTime = System.nanoTime();
            
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            
            if(delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;
            }
            
            if(timer >= 1000000000){
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        if (keyHandler.isUpPressed){
            playerY -= playerSpeed;
        }
        
        if (keyHandler.isDownPressed){
            playerY += playerSpeed;
        }
        
        if (keyHandler.isLeftPressed){
            playerX -= playerSpeed;
        }
        
        if (keyHandler.isRightPressed){
            playerX += playerSpeed;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        var g2 = (Graphics2D)g;
        
        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        
        g2.dispose();
    }
}
