package hackaton;

public class Robot {
    private int currentX;
    private int currentY;
    private int previousX;
    private int previousY;

    public Robot() {
    }

    public Robot(int currentX, int currentY) {
        this.currentX = currentX;
        this.currentY = currentY;
    }

    public int getCurrentX() {
        return currentX;
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }

    public int getPreviousX() {
        return previousX;
    }

    public void setPreviousX(int previousX) {
        this.previousX = previousX;
    }

    public int getPreviousY() {
        return previousY;
    }

    public void setPreviousY(int previousY) {
        this.previousY = previousY;
    }

    void moveX(int x){
        int tmp = x+previousX;
        previousX = currentX;
        currentX = tmp;
    }

    void moveY(int y){
        int tmp = y+currentY;
        previousY = currentY;
        currentX = tmp;
    }

    void printCurrentCoordinates(){
        System.out.println(this.getCurrentX()+ " " + this.getCurrentY());
    }

    void printLastCoordinates(){
        System.out.println(this.getPreviousX()+ " " + this.getPreviousY());
    }

    void printLastMove(int x, int y){
        if(this.currentX != previousX){
            System.out.println("Previous x " + this.getPreviousY());
        }
        if(this.currentY != previousY){
            System.out.println("Previous y " + this.getPreviousY());

        }
    }
}
