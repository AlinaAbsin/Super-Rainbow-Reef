package SuperRainbowReef;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameWall extends GameData {
    public GameWall(int xx, int yy, String type) {
        super(xx, yy, type);
    }

    @Override
    public void draws(Graphics g) {
        if (this.isLiveing()) {
            BufferedImage bufferedImage = null;
            try {
                bufferedImage = ImageIO.read(new File("resource\\image\\Wall.png"));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            this.setImage(bufferedImage);
            this.setWidth(bufferedImage.getWidth(null));
            this.setHeight(bufferedImage.getHeight(null));
            g.drawImage(bufferedImage, this.getXx(), this.getYy(), null);
        }
    }

    @Override
    public void hits(GamePop pop) {
        if (pop.getXx() < 20) {
            if (pop.getDirection() == "upToDown-rightToLeft") {
                pop.setDirection("upToDown-leftToRight");
                pop.setAngle(Math.PI - pop.getAngle());
                pop.setSpeed(pop.getSpeed() - 2);
            }
            if (pop.getDirection() == "downToUp-rightToLeft") {
                pop.setDirection("downToUp-leftToRight");
                pop.setAngle(Math.PI - pop.getAngle());
                pop.setSpeed(pop.getSpeed() - 2);
            }
        }
        if (pop.getXx() > 580) {
            if (pop.getDirection() == "upToDown-leftToRight") {
                pop.setAngle(Math.PI - pop.getAngle());
                pop.setDirection("upToDown-rightToLeft");
                pop.setSpeed(pop.getSpeed() - 2);
            }
            if (pop.getDirection() == "downToUp-leftToRight") {
                pop.setAngle(Math.PI - pop.getAngle());
                pop.setDirection("downToUp-rightToLeft");
                pop.setSpeed(pop.getSpeed() - 2);
            }
        }
        if (pop.getYy() < 20) {
            if (pop.getDirection() == "downToUp-leftToRight") {
                pop.setAngle(Math.PI - pop.getAngle());
                pop.setDirection("upToDown-leftToRight");
                pop.setSpeed(pop.getSpeed() - 2);
            }
            if (pop.getDirection() == "downToUp-rightToLeft") {
                pop.setAngle(Math.PI - pop.getAngle());
                pop.setDirection("upToDown-rightToLeft");
                pop.setSpeed(pop.getSpeed() - 2);
            }
        }
    }
}
