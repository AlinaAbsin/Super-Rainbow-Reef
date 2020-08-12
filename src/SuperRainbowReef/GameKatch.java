package SuperRainbowReef;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameKatch extends GameData {

    private int lifeTimes = 3;

    public void setLifeTimes(int lifeTimes) {
        this.lifeTimes = lifeTimes;
    }

    public int getLifeTimes() {
        return lifeTimes;
    }

    public GameKatch(int xx, int yy, String type) {
        super(xx, yy, type);
    }


    public void checkBorder() {
        if (this.getXx() > 540)
            this.setXx(540);
        if (this.getXx() < 20)
            this.setXx(20);
    }

    @Override
    public void draws(Graphics g) {
        if (this.isLiveing()) {
            BufferedImage bufferedImage = null;
            try {
                bufferedImage = ImageIO.read(new File("resource\\image\\Katch_strip24.png"));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            bufferedImage = bufferedImage.getSubimage(0, 0, 80, 30);
            this.setImage(bufferedImage);
            this.setWidth(bufferedImage.getWidth(null));
            this.setHeight(bufferedImage.getHeight(null));
            this.checkBorder();
            g.drawImage(bufferedImage, this.getXx(), this.getYy(), null);
        }
    }

    // draw lives of katch
    public void drawLife(Graphics g) {
        if (this.isLiveing()) {
            BufferedImage img = null;

            try {
                img = ImageIO.read(new File("resource\\image\\Katch_small.png"));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

            for (int i = 0; i < this.getLifeTimes(); i++)
                g.drawImage(img, i * 40 + 20, 440, null);
        }
    }

    @Override
    public void hits(GamePop pop) {
        // change in x and y coordinate
        int dx = (int) Math.abs(Math.cos(pop.getAngle()) * pop.getSpeed());
        int dy = (int) (Math.sin(pop.getAngle()) * pop.getSpeed());

        if (this.getType() == "katch") {
            // pop hits katch, up
            if (pop.getXx() > this.getXx() - pop.getWidth() && pop.getXx() < this.getXx() + this.getWidth() && pop.getYy() > this.getYy() - pop.getHeight()) {

                // up to down, left to right
                if (pop.getDirection() == "upToDown-leftToRight") {
                    pop.setXx(pop.getXx() + dx);
                    pop.setYy(pop.getYy() - dy);
                    pop.setDirection("downToUp-leftToRight");
                }

                // up to down, right to left
                if (pop.getDirection() == "upToDown-rightToLeft") {
                    pop.setXx(pop.getXx() - dx);
                    pop.setYy(pop.getYy() - dy);
                    pop.setDirection("downToUp-rightToLeft");
                }

                // update angle
                pop.setAngle(Math.PI - pop.getAngle());

                // speed up
                pop.setSpeed(15);
            }
        }

        if (pop.getYy() > 470) {
            if (this.getLifeTimes() == 1) {
                this.setLiveing(false);
                pop.setLiveing(false);
            } else {
                this.setLifeTimes(this.getLifeTimes() - 1);
                pop.setXx(360);
                pop.setYy(380);
                pop.setDirection("downToUp-leftToRight");
            }
        }
    }
}
