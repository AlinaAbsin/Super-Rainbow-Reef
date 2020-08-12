package SuperRainbowReef;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GamePop extends GameData {

    public double angle = Math.PI / 4;
    public int score = 0;
    public double speed = 12.0;
    public String direction = "downToUp-leftToRight";
    public int level = 1;

    public GamePop(int xx, int yy, String type) {
        super(xx, yy, type);
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public int getLevel() {
        return level;
    }

    public double getAngle() {
        return angle;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public String getDirection() {
        return direction;
    }


    @Override
    public void hits(GamePop pop) {
        int dx = (int) Math.abs(Math.cos(pop.getAngle()) * pop.getSpeed());
        int dy = (int) (Math.sin(pop.getAngle()) * pop.getSpeed());
        if (pop.getDirection() == "downToUp-leftToRight") {
            pop.setXx(pop.getXx() + dx);
            pop.setYy(pop.getYy() - dy);
        }
        if (pop.getDirection() == "downToUp-rightToLeft") {
            pop.setXx(pop.getXx() - dx);
            pop.setYy(pop.getYy() - dy);
        }
        if (pop.getDirection() == "upToDown-leftToRight") {
            pop.setXx(pop.getXx() + dx);
            pop.setYy(pop.getYy() + dy);
        }
        if (pop.getDirection() == "upToDown-rightToLeft") {
            pop.setXx(pop.getXx() - dx);
            pop.setYy(pop.getYy() + dy);
        }
    }

    @Override
    public void draws(Graphics g) {
        if (this.isLiveing()) {
            BufferedImage img = null;
            try {
                img = ImageIO.read(new File("resource\\image\\Pop_strip45.png"));
                img = img.getSubimage(0, 0, 35, 35);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            this.setImage(img);
            this.setWidth(img.getWidth(null));
            this.setHeight(img.getHeight(null));
            g.drawImage(img, this.getXx(), this.getYy(), null);
        }
    }

}
