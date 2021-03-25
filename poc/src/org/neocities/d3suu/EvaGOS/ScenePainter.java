package org.neocities.d3suu.EvaGOS;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ScenePainter extends JPanel {

    // Dynamic images
    public BufferedImage sceneImage;
    public BufferedImage scrollingSceneImage;

    public ScenePainter(){
        super();
    }

    public void updateScene(String sceneID){
        try{
            this.sceneImage = ImageIO.read(new File("C:\\eva\\bmp\\" + sceneID + ".BMP"));
        }catch (IOException e){
            System.out.println("Paint Scene exception: " + e.toString());
        }
    }

    private void updateSceneCut(BufferedImage image, int x, int y){
        this.sceneImage = image.getSubimage(x,y,740,400);
    }

    public void scrollScene(String sceneID, int speed, int startX, int startY){
        try{
            this.scrollingSceneImage = ImageIO.read(new File("C:\\eva\\bmp\\" + sceneID + ".BMP"));
        }catch (IOException e){
            System.out.println("Scrolling scene exception: " + e.toString());
        }
        while(true){
            updateSceneCut(scrollingSceneImage, startX, startY);
            startX += speed;
            if(startX+speed+740>this.scrollingSceneImage.getWidth()){
                break;
            }
            try {
                TimeUnit.MILLISECONDS.sleep(40);
            }catch (Exception e){
                System.out.println("Scrolling scene time exception: " + e.toString());
            }
        }
    }

    public void paintComponent(Graphics g){
        if(sceneImage != null){
            g.drawImage(sceneImage,143,81,null);
        }
        repaint();
    }
}
