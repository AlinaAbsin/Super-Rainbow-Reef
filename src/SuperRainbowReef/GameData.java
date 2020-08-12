package SuperRainbowReef;

import java.awt.*;

public abstract class GameData {
    private int yy;
    private int xx;
    private boolean liveing = true;
    private Image image;
    private int width;
    private int height;
    private String type;

    public GameData(int xx, int yy, String type) {
        this.xx = xx;
        this.yy = yy;
        this.type = type;
    }

    public void setYy(int yy) {
        this.yy = yy;
    }

    public int getYy() {
        return yy;
    }

    public void setXx(int xx) {
        this.xx = xx;
    }

    public int getXx() {
        return xx;
    }

    public boolean isLiveing() {
        return liveing;
    }

    public void setLiveing(boolean liveing) {
        this.liveing = liveing;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract void hits(GamePop pop);

    public abstract void draws(Graphics g);
}
