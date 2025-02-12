package src;

class Brick {
    int x, y, width, height;
    boolean isVisible;

    public Brick(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isVisible = true; // Start synlig
    }
}
