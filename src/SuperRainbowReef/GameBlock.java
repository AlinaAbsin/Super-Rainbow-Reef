package SuperRainbowReef;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameBlock extends GameData {

    public GameBlock(int xx, int yy, String type) {
        super(xx, yy, type);
    }

    @Override
    public void draws(Graphics graphics) {
        if (this.isLiveing()) {
            BufferedImage bufferedImage = null;
            try {
                if (this.getType().equals("purpleBlock"))
                    bufferedImage = ImageIO.read(new File("resource\\image\\Block1.png"));
                if (this.getType().equals("solidBlock"))
                    bufferedImage = ImageIO.read(new File("resource\\image\\Block_solid.png"));
                if (this.getType().equals("yellowBlock"))
                    bufferedImage = ImageIO.read(new File("resource\\image\\Block2.png"));
                if (this.getType().equals("lifeBlock"))
                    bufferedImage = ImageIO.read(new File("resource\\image\\Block_life.png"));
                if (this.getType().equals("redBlock"))
                    bufferedImage = ImageIO.read(new File("resource\\image\\Block3.png"));
                if (this.getType().equals("cyanBlock"))
                    bufferedImage = ImageIO.read(new File("resource\\image\\Block5.png"));
                if (this.getType().equals("blueBlock"))
                    bufferedImage = ImageIO.read(new File("resource\\image\\Block6.png"));
                if (this.getType().equals("splitBlock"))
                    bufferedImage = ImageIO.read(new File("resource\\image\\Block_split.png"));
                if (this.getType().equals("greenBlock"))
                    bufferedImage = ImageIO.read(new File("resource\\image\\Block4.png"));
                if (this.getType().equals("grayBlock"))
                    bufferedImage = ImageIO.read(new File("resource\\image\\Block7.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            this.setHeight(bufferedImage.getHeight(null));
            this.setWidth(bufferedImage.getWidth(null));
            this.setImage(bufferedImage);
            graphics.drawImage(bufferedImage, this.getXx(), this.getYy(), null);
        }
    }

    @Override
    public void hits(GamePop pop) {
        Rectangle RBlock = new Rectangle(this.getXx(), this.getYy(), this.getWidth(), this.getHeight());
        Rectangle RPop = new Rectangle(pop.getXx(), pop.getYy(), pop.getWidth(), pop.getHeight());
        if (RBlock.intersects(RPop)) {
            if (pop.getYy() + pop.getHeight() - this.getYy() < 0.00001) {
                this.setLiveing(false);
                if (pop.getDirection() == "upToDown-leftToRight") {
                    pop.setDirection("downToUp-leftToRight");
                    pop.setAngle(Math.PI - pop.getAngle());
                    pop.setSpeed(15);
                    return;
                }
                if (pop.getDirection() == "upToDown-rightToLeft") {
                    pop.setDirection("downToUp-rightToLeft");
                    pop.setAngle(Math.PI - pop.getAngle());
                    pop.setSpeed(15);
                    return;
                }
            }
            if (this.getYy() - pop.getYy() < 0.00001) {
                this.setLiveing(false);
                if (pop.getDirection() == "downToUp-leftToRight") {
                    pop.setDirection("upToDown-leftToRight");
                    pop.setAngle(Math.PI - pop.getAngle());
                    pop.setSpeed(15);
                    return;
                }
                if (pop.getDirection() == "downToUp-rightToLeft") {
                    pop.setDirection("upToDown-rightToLeft");
                    pop.setAngle(Math.PI - pop.getAngle());
                    pop.setSpeed(15);
                    return;
                }
            }

            if (pop.getDirection() == "downToUp-leftToRight") {
                pop.setDirection("downToUp-rightToLeft");
                pop.setAngle(Math.PI - pop.getAngle());
                pop.setSpeed(15);
                return;
            }
            if (pop.getXx() + pop.getWidth() - this.getXx() < 0.00001) {
                this.setLiveing(false);
                if (pop.getDirection() == "upToDown-leftToRight") {
                    pop.setDirection("upToDown-rightToLeft");
                    pop.setAngle(Math.PI - pop.getAngle());
                    pop.setSpeed(15);
                    return;
                }
            }
            if (this.getXx() + this.getWidth() - pop.getXx() < 0.00001) {
                this.setLiveing(false);
                if (pop.getDirection() == "upToDown-rightToLeft") {
                    pop.setDirection("upToDown-leftToRight");
                    pop.setAngle(Math.PI - pop.getAngle());
                    pop.setSpeed(15);
                    return;
                }
                if (pop.getDirection() == "downToUp-rightToLeft") {
                    pop.setDirection("downToUp-leftToRight");
                    pop.setAngle(Math.PI - pop.getAngle());
                    pop.setSpeed(15);
                    return;
                }
            }
        }
    }
}
