package manel.mourelo.colormatch;

public class Style {
    private boolean bolt;
    private int bgColor;
    private int textColor;

    public Style(boolean bolt, int bgColor, int textVolor){
        this.bolt = bolt;
        this.bgColor = bgColor;
        this.textColor = textColor;
    }

    public boolean isBolt() {
        return bolt;
    }

    public void setBolt(boolean bolt) {
        this.bolt = bolt;
    }

    public int getBgColor() {
        return bgColor;
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }
}
