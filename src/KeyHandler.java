
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

    public boolean isUpPressed, isDownPressed, isLeftPressed, isRightPressed;
        
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        
        if (keyCode == KeyEvent.VK_W){
            isUpPressed = true;
        }
        
        if (keyCode == KeyEvent.VK_S){
            isDownPressed = true;
        }
        
        if (keyCode == KeyEvent.VK_A){
            isLeftPressed = true;
        }
        
        if (keyCode == KeyEvent.VK_D){
            isRightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        
        if (keyCode == KeyEvent.VK_W){
            isUpPressed = false;
        }
        
        if (keyCode == KeyEvent.VK_S){
            isDownPressed = false;
        }
        
        if (keyCode == KeyEvent.VK_A){
            isLeftPressed = false;
        }
        
        if (keyCode == KeyEvent.VK_D){
            isRightPressed = false;
        }
    }
}
