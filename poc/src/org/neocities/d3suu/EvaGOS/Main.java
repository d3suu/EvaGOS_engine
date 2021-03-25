package org.neocities.d3suu.EvaGOS;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        JFrame gameFrame = new JFrame("Evangelion: Iron Maiden");
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.add(new BackgroundPainter());
        gameFrame.setSize(1024,768+30);
        gameFrame.setVisible(true);

        ScenePainter currentScene = new ScenePainter();
        gameFrame.add(currentScene);

        AudioPlayer player = new AudioPlayer();

        // Game loop (PoC)
        /*
        currentScene.updateScene("C001");
        player.playSingle("001");
        TimeUnit.SECONDS.sleep(3);
        currentScene.updateScene("C002");
        player.playSingle("002");
        TimeUnit.SECONDS.sleep(4);
        currentScene.updateScene("C003");
        player.playSingle("003");
         */
        currentScene.scrollScene("C004",40,0,0);
    }
}