package SuperRainbowReef;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bigleg extends GameData {

    private String direction;
    private int speed = 12;

    public Bigleg(int x, int y, String type) {
        super(x, y, type);
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public void draws(Graphics g) {
        if (this.isLiveing()) {
            BufferedImage img = null;
            try {
                if (this.getType() == "largeBigleg1" || this.getType() == "largeBigleg2") {
                    img = ImageIO.read(new File("resource\\image\\Bigleg_strip24.png"));
                    img = img.getSubimage(0, 0, 80, 80);
                }
                if (this.getType() == "smallBigleg") {
                    img = ImageIO.read(new File("resource\\image\\Bigleg_small_strip24.png"));
                    img = img.getSubimage(0, 0, 40, 40);
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            this.setImage(img);
            this.setHeight(img.getHeight(null));
            this.setWidth(img.getWidth(null));
            g.drawImage(img, this.getXx(), this.getYy(), null);
        }
    }

    @Override
    public void hits(GamePop pop) {
        Rectangle RPop = new Rectangle(pop.getXx(), pop.getYy(), pop.getWidth(), pop.getHeight());
        Rectangle RBigleg = new Rectangle(this.getXx(), this.getYy(), this.getWidth(), this.getHeight());
        if (this.getType() == "largeBigleg2") {
            if (this.getXx() > 540)
                this.setDirection("left");
            if (this.getXx() < 380)
                this.setDirection("right");
            if (this.direction == "right")
                this.setXx(this.getXx() + this.getSpeed());
            if (this.direction == "left")
                this.setXx(this.getXx() - this.getSpeed());
        }
        if (this.getType() == "largeBigleg1") {
            if (this.getXx() > 180)
                this.setDirection("left");
            if (this.getXx() < 20)
                this.setDirection("right");
            if (this.direction == "right")
                this.setXx(this.getXx() + this.getSpeed());
            if (this.direction == "left")
                this.setXx(this.getXx() - this.getSpeed());
        }
        if (RBigleg.intersects(RPop)) {
            this.setLiveing(false);
        }
    }
}
