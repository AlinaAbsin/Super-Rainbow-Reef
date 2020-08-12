package SuperRainbowReef;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class GamePanel extends JPanel implements KeyListener, Runnable {
    public Vector<GameBlock> gameBlocks1;
    public boolean flag = false;
    public Vector<GameBlock> blocks2;
    public Vector<Bigleg> biglegs2;
    public Vector<Bigleg> biglegs1;
    public GameKatch katch;
    public Font font;
    public GamePop pop;
    public Vector<GameWall> walls;

    public GamePanel() {
        gameBlocks1 = new Vector<>();
        blocks2 = new Vector<>();
        biglegs1 = new Vector<>();
        biglegs2 = new Vector<>();
        font = new Font("Arial", Font.BOLD, 20);
        katch = new GameKatch(320, 420, "katch");
        pop = new GamePop(360, 380, "pop");
        walls = new Vector<>();
        this.generateBigleg2();
        this.generateBlock1();
        this.generateBlock2();
        this.generateBigleg1();
        this.generateGameWall();
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }

    public void changeLevel() {
        if (biglegs1.size() == 0) {
            if (pop.getLevel() == 1) {
                this.setFlag(true);
                pop.setLevel(2);
            }
        }
    }

    public void resetPop() {
        if (this.isFlag()) {
            if (pop.getLevel() == 2) {
                pop.setYy(380);
                pop.setXx(360);
                pop.setDirection("downToUp-leftToRight");
                this.setFlag(false);
            }
        }
    }

    public void drawBlock(Graphics g) {
        if (pop.getLevel() == 2) {
            for (int i = 0; i < blocks2.size(); i++) {
                if (blocks2.get(i).isLiveing()) {
                    blocks2.get(i).hits(pop);
                    blocks2.get(i).draws(g);
                }
            }
        }
        if (pop.getLevel() == 1) {
            for (int i = 0; i < gameBlocks1.size(); i++) {
                if (gameBlocks1.get(i).isLiveing()) {
                    gameBlocks1.get(i).hits(pop);
                    gameBlocks1.get(i).draws(g);
                }
            }
        }
    }

    public void generateBlock1() {
        for (int i = 0; i < 12; i++) {
            GameBlock block2 = new GameBlock(220, i * 20 + 20, "solidBlock");
            GameBlock block1 = new GameBlock(100, i * 20 + 20, "solidBlock");
            GameBlock block3 = new GameBlock(380, i * 20 + 20, "solidBlock");
            GameBlock block4 = new GameBlock(500, i * 20 + 20, "solidBlock");
            gameBlocks1.add(block2);
            gameBlocks1.add(block1);
            gameBlocks1.add(block4);
            gameBlocks1.add(block3);

        }
        for (int i = 0; i < 2; i++) {
            GameBlock block1 = new GameBlock(i * 40 + 20, 20, "lifeBlock");
            GameBlock block2 = new GameBlock(640 - (i + 1) * 40 - 20, 20, "lifeBlock");
            gameBlocks1.add(block1);
            gameBlocks1.add(block2);
        }
        for (int i = 0; i < 11; i++) {
            GameBlock block1 = new GameBlock(260, (i + 1) * 20, "purpleBlock");
            GameBlock block2 = new GameBlock(340, (i + 1) * 20, "purpleBlock");
            gameBlocks1.add(block1);
            gameBlocks1.add(block2);
        }
        for (int i = 0; i < 9; i++) {
            GameBlock block1 = new GameBlock(140, (i + 1) * 20 + 60, "yellowBlock");
            GameBlock block2 = new GameBlock(460, (i + 1) * 20 + 60, "yellowBlock");
            gameBlocks1.add(block1);
            gameBlocks1.add(block2);
        }
        for (int i = 0; i < 11; i++) {
            GameBlock block1 = new GameBlock(60, (i + 2) * 20, "redBlock");
            GameBlock block2 = new GameBlock(540, (i + 2) * 20, "redBlock");
            gameBlocks1.add(block2);
            gameBlocks1.add(block1);

        }
        for (int i = 0; i < 9; i++) {
            GameBlock block = new GameBlock(300, i * 20 + 60, "grayBlock");
            gameBlocks1.add(block);
        }
        for (int i = 0; i < 11; i++) {
            GameBlock block2 = new GameBlock(420, (i + 1) * 20, "greenBlock");
            GameBlock block1 = new GameBlock(180, (i + 1) * 20, "greenBlock");
            gameBlocks1.add(block2);
            gameBlocks1.add(block1);
        }
        for (int i = 0; i < 11; i++) {
            GameBlock block1 = new GameBlock(20, (i + 2) * 20, "blueBlock");
            GameBlock block2 = new GameBlock(580, (i + 2) * 20, "blueBlock");
            gameBlocks1.add(block1);
            gameBlocks1.add(block2);
        }
        for (int i = 0; i < 2; i++) {
            GameBlock block1 = new GameBlock(140 + i * 320, 60, "splitBlock");
            GameBlock block2 = new GameBlock(180 + i * 240, 240, "splitBlock");
            gameBlocks1.add(block1);
            gameBlocks1.add(block2);
        }
        for (int i = 0; i < gameBlocks1.size(); i++)
            gameBlocks1.get(i).hits(pop);
    }

    public void generateBlock2() {
        for (int i = 0; i < 4; i++) {
            GameBlock block1 = new GameBlock(260, i * 20 + 20, "solidBlock");
            GameBlock block2 = new GameBlock(300, i * 20 + 20, "solidBlock");
            GameBlock block3 = new GameBlock(340, i * 20 + 20, "solidBlock");
            blocks2.add(block1);
            blocks2.add(block2);
            blocks2.add(block3);
        }

        for (int i = 0; i < 15; i++) {
            GameBlock block1 = new GameBlock(i * 40 + 20, 100, "solidBlock");
            GameBlock block2 = new GameBlock(i * 40 + 20, 120, "solidBlock");
            GameBlock block3 = new GameBlock(i * 40 + 20, 140, "solidBlock");
            blocks2.add(block1);
            blocks2.add(block2);
            blocks2.add(block3);
        }
        for (int i = 0; i < 2; i++) {
            GameBlock block1 = new GameBlock(260, i * 20 + 160, "lifeBlock");
            blocks2.add(block1);
            GameBlock block2 = new GameBlock(340, i * 20 + 160, "lifeBlock");
            blocks2.add(block2);
        }
        for (int i = 0; i < 5; i++) {
            GameBlock block1 = new GameBlock(140, i * 20 + 160, "yellowBlock");
            GameBlock block2 = new GameBlock(460, i * 20 + 160, "yellowBlock");
            blocks2.add(block1);
            blocks2.add(block2);
        }
        for (int i = 0; i < 5; i++) {
            GameBlock block1 = new GameBlock(180, i * 20 + 160, "greenBlock");
            blocks2.add(block1);
            GameBlock block2 = new GameBlock(420, i * 20 + 160, "greenBlock");
            blocks2.add(block2);
        }
        for (int i = 0; i < 3; i++) {
            GameBlock block1 = new GameBlock(260, i * 20 + 200, "purpleBlock");
            blocks2.add(block1);
            GameBlock block2 = new GameBlock(340, i * 20 + 200, "purpleBlock");
            blocks2.add(block2);
        }
        for (int i = 0; i < 5; i++) {
            GameBlock block1 = new GameBlock(60, i * 20 + 160, "redBlock");
            blocks2.add(block1);
            GameBlock block2 = new GameBlock(540, i * 20 + 160, "redBlock");
            blocks2.add(block2);
        }
        for (int i = 0; i < 4; i++) {
            GameBlock block1 = new GameBlock(220, i * 20 + 160, "cyanBlock");
            GameBlock block2 = new GameBlock(380, i * 20 + 160, "cyanBlock");
            blocks2.add(block1);
            blocks2.add(block2);
        }
        for (int i = 0; i < 3; i++) {
            GameBlock block1 = new GameBlock(100, i * 20 + 180, "cyanBlock");
            GameBlock block2 = new GameBlock(500, i * 20 + 180, "cyanBlock");
            blocks2.add(block1);
            blocks2.add(block2);
        }
        for (int i = 0; i < 5; i++) {
            GameBlock block1 = new GameBlock(20, i * 20 + 160, "blueBlock");
            blocks2.add(block1);
            GameBlock block2 = new GameBlock(580, i * 20 + 160, "blueBlock");
            blocks2.add(block2);
        }
        for (int i = 0; i < 5; i++) {
            GameBlock block = new GameBlock(300, i * 20 + 160, "grayBlock");
            blocks2.add(block);
        }
        for (int i = 0; i < 2; i++) {
            GameBlock block = new GameBlock(i * 400 + 100, 160, "splitBlock");
            blocks2.add(block);
        }
        for (int i = 0; i < blocks2.size(); i++)
            blocks2.get(i).hits(pop);
    }

    public void generateBigleg1() {
        for (int i = 0; i < 3; i++) {
            Bigleg bigleg = new Bigleg(i * 160 + 140, 20, "smallBigleg");
            biglegs1.add(bigleg);
        }
    }

    public void generateBigleg2() {
        Bigleg bigleg1 = new Bigleg(20, 20, "largeBigleg1");
        Bigleg bigleg2 = new Bigleg(540, 20, "largeBigleg2");
        bigleg1.setDirection("right");
        bigleg2.setDirection("left");
        biglegs2.add(bigleg1);
        biglegs2.add(bigleg2);
    }

    public void drawBigleg(Graphics g) {
        if (pop.getLevel() == 1) {
            for (int i = 0; i < biglegs1.size(); i++) {
                if (biglegs1.get(i).isLiveing()) {
                    biglegs1.get(i).hits(pop);
                    biglegs1.get(i).draws(g);
                }
            }
        }
        if (pop.getLevel() == 2) {
            for (int i = 0; i < biglegs2.size(); i++) {
                if (biglegs2.get(i).isLiveing()) {
                    biglegs2.get(i).hits(pop);
                    biglegs2.get(i).draws(g);
                }
            }
        }
    }

    public void drawPop(Graphics g) {
        pop.hits(pop);
        pop.draws(g);
    }

    public void drawKatch(Graphics g) {
        katch.draws(g);
        katch.drawLife(g);
        katch.hits(pop);
    }

    public void drawWall(Graphics g) {
        for (int i = 0; i < walls.size(); i++) {
            walls.get(i).hits(pop);
            walls.get(i).draws(g);
        }
    }

    public void generateGameWall() {
        for (int i = 0; i < 32; i++) {
            GameWall wall = new GameWall(i * 20, 0, "wall");
            walls.add(wall);
        }
        for (int i = 0; i < 23; i++) {
            GameWall wall = new GameWall(0, (i + 1) * 20, "wall");
            walls.add(wall);
        }
        for (int i = 0; i < 23; i++) {
            GameWall wall = new GameWall(620, (i + 1) * 20, "wall");
            walls.add(wall);
        }
    }

    public void drawObjects(Graphics g) {
        if (pop.isLiveing()) {
            this.drawBigleg(g);
            this.drawBlock(g);
            this.drawKatch(g);
            this.drawPop(g);
            this.drawWall(g);
        }
    }

    public void setBackground(Graphics g) {
        BufferedImage bufferedImage;
        if (pop.getLevel() == 1) {
            try {
                if (pop.isLiveing())
                    bufferedImage = ImageIO.read(new File("resource\\image\\Background1.png"));
                else
                    bufferedImage = ImageIO.read(new File("resource\\image\\Title1.png"));
                g.drawImage(bufferedImage, 0, 0, null);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        if (pop.getLevel() == 2) {
            try {
                if (pop.isLiveing())
                    bufferedImage = ImageIO.read(new File("resource\\image\\Background2.png"));
                else
                    bufferedImage = ImageIO.read(new File("resource\\image\\Title2.png"));
                g.drawImage(bufferedImage, 0, 0, null);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        if (biglegs2.size() == 0) {
            pop.setLiveing(false);
            try {
                bufferedImage = ImageIO.read(new File("resource\\image\\Congratulation.png"));
                g.drawImage(bufferedImage, 0, 0, null);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void showScore(Graphics graphics) {
        graphics.setFont(font);
        graphics.drawString("Score " + pop.getScore(), 25, 420);
        for (int i = 0; i < gameBlocks1.size(); i++) {
            if (!gameBlocks1.get(i).isLiveing()) {
                if (gameBlocks1.get(i).getType() == "solidBlock")
                    pop.setScore(pop.getScore() + 10);
                if (gameBlocks1.get(i).getType() == "lifeBlock")
                    katch.setLifeTimes(katch.getLifeTimes() + 1);
                if (gameBlocks1.get(i).getType() == "purpleBlock")
                    pop.setScore(pop.getScore() + 20);
                if (gameBlocks1.get(i).getType() == "yellowBlock")
                    pop.setScore(pop.getScore() + 30);
                if (gameBlocks1.get(i).getType() == "redBlock")
                    pop.setScore(pop.getScore() + 40);
                if (gameBlocks1.get(i).getType() == "greenBlock")
                    pop.setScore(pop.getScore() + 50);
                if (gameBlocks1.get(i).getType() == "cyanBlock")
                    pop.setScore(pop.getScore() + 60);
                if (gameBlocks1.get(i).getType() == "blueBlock")
                    pop.setScore(pop.getScore() + 70);
                if (gameBlocks1.get(i).getType() == "grayBlock")
                    pop.setScore(pop.getScore() + 80);
                if (gameBlocks1.get(i).getType() == "splitBlock")
                    pop.setScore(pop.getScore() + 100);
                gameBlocks1.remove(i);
            }
        }
        for (int i = 0; i < biglegs1.size(); i++) {
            if (!biglegs1.get(i).isLiveing()) {
                pop.setScore(pop.getScore() + 200);
                biglegs1.remove(i);
            }
        }
        for (int i = 0; i < blocks2.size(); i++) {
            if (!blocks2.get(i).isLiveing()) {
                if (blocks2.get(i).getType() == "solidBlock")
                    pop.setScore(pop.getScore() + 10);
                if (blocks2.get(i).getType() == "lifeBlock")
                    katch.setLifeTimes(katch.getLifeTimes() + 1);
                if (blocks2.get(i).getType() == "purpleBlock")
                    pop.setScore(pop.getScore() + 20);
                if (blocks2.get(i).getType() == "yellowBlock")
                    pop.setScore(pop.getScore() + 30);
                if (blocks2.get(i).getType() == "redBlock")
                    pop.setScore(pop.getScore() + 40);
                if (blocks2.get(i).getType() == "greenBlock")
                    pop.setScore(pop.getScore() + 50);
                if (blocks2.get(i).getType() == "blueBlock")
                    pop.setScore(pop.getScore() + 60);
                if (blocks2.get(i).getType() == "grayBlock")
                    pop.setScore(pop.getScore() + 70);
                if (blocks2.get(i).getType() == "splitBlock")
                    pop.setScore(pop.getScore() + 100);
                blocks2.remove(i);
            }
        }
        for (int i = 0; i < biglegs2.size(); i++) {
            if (!biglegs2.get(i).isLiveing()) {
                pop.setScore(pop.getScore() + 400);
                biglegs2.remove(i);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(g);
        this.changeLevel();
        this.resetPop();
        this.drawObjects(g);
        this.showScore(g);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT)
            katch.setXx(katch.getXx() - 15);
        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT)
            katch.setXx(katch.getXx() + 15);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }
}
