package org.neocities.d3suu.EvaGOS;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackgroundPainter extends JPanel {
    // Static images
    public BufferedImage backgroundImage;
    public BufferedImage sceneFrameImage;
    public BufferedImage optionsFrameImage; // Actually set of textures
    public BufferedImage optionA; // Inputs for testing


    public BackgroundPainter(){
        super();
        try{
            backgroundImage = ImageIO.read(new File("C:\\eva\\kabegami\\WP01.BMP"));
            sceneFrameImage = ImageIO.read(new File("C:\\eva\\grp\\FRM.BMP"));
        }catch (IOException e){
            System.out.println("Painter exception: " + e.toString());
        }
    }

    public void paintComponent(Graphics g){
        g.drawImage(backgroundImage,0,0,null);
        g.drawImage(sceneFrameImage,0,0,null);
        g.setColor(Color.BLACK);
        g.fillRect(143,81,740,400); // Scene black background

        g.setColor(Color.WHITE);
        g.drawString("WORK IN PROGRESS", 150, 100);

        //repaint(); // Remove for final game loop
    }
}
