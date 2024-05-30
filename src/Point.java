public class Point {
    private int x;
    private int y;

    public Point(){
        this.x = 0;
        this.y = 0;
    }
    public Point(int x, int y) {
        // truncates values according to grid size - (150, 80) becomes (1,0)
        this.x = x / 81;
        this.y = y / 81;
    }
    //for testing purposes
    public Point(boolean holder, int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x / 81;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y / 81;
    }

    public String toString() {
        return  "X: " + this.x + ", Y: " + this.y;
    }
}
