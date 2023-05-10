package kosarayu;

public class Vertex {

    private char label;  // метка А, например

    public boolean isGreen;
    public boolean isRed;

    public Vertex(final char label) {
        this.label = label;
        this.isGreen = false;
        this.isRed = false;
    }

    public char getLabel() {
        return this.label;
    }

    public void setLabel(char label) {
        this.label = label;
    }

    public boolean isGreen() {
        return isGreen;
    }

    public void setGreen(boolean green) {
        isGreen = green;
    }

    public boolean isRed() {
        return isRed;
    }

    public void setRed(boolean red) {
        isRed = red;
    }
}
