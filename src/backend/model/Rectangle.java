package backend.model;

import java.util.Objects;

public class Rectangle extends Figure {

    private  Point topLeft, bottomRight;



    public Rectangle(Point topLeft, Point bottomRight) {
        super(new Point[]{topLeft});
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
        System.out.println(small());
    }

    public boolean small()
    {
        double SMALLDELTA = 30;
        return topLeft.getDistance(bottomRight) < SMALLDELTA;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    @Override
    public String toString() {
        return String.format("Rectángulo [ %s , %s ]", topLeft, bottomRight);
    }

    @Override
    public boolean contains(Point eventPoint) {
        return eventPoint.getX() > this.getTopLeft().getX() && eventPoint.getX() < this.getBottomRight().getX() &&
        eventPoint.getY() > this.getTopLeft().getY() && eventPoint.getY() < this.getBottomRight().getY();
    }

    @Override
    public boolean isFullContained(Rectangle rectangle) {
       // return this.contains(rectangle.getBottomRight()) && this.contains(rectangle.getTopLeft()); // todo test this
        return rectangle.contains(getBottomRight()) && rectangle.contains(getTopLeft());
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Rectangle aux)){
            return false;
        }
        return this.topLeft.equals(aux.getTopLeft()) && this.bottomRight.equals(aux.getBottomRight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, bottomRight);
    }

    @Override
    public void move(double deltaX, double deltaY) {
        getTopLeft().move(deltaX,deltaY);
        getBottomRight().move(deltaX,deltaY);
    }


    @Override
    public void moveHorizontal(){
        double diffx = getBase();
        getTopLeft().move(diffx, 0);
        getBottomRight().move(diffx, 0);
    }

    @Override
    public void moveVertical(){
        double heigth = getHeigth();
        getTopLeft().move(0,heigth);
        getBottomRight().move(0, heigth );
    }

    @Override
    public void turnR(){
        Point centerPoint = getCenterPoint();
        Point newTopLeft = new Point(centerPoint.getX() - ((getBottomRight().getY() - getTopLeft().getY())/2) , centerPoint.getY() - ((getBottomRight().getX() - getTopLeft().getX())/2));
        Point newBottomRight = new Point(centerPoint.getX() + ((getBottomRight().getY() - getTopLeft().getY())/2), centerPoint.getY() + ((getBottomRight().getX() - getTopLeft().getX())/2));
        topLeft.setXY(newTopLeft);
        bottomRight.setXY(newBottomRight);
        move(0,0);
    }

    @Override
    public void scaleUp(){

        double originalbase = getBase();
        double originalheigh = getHeigth();
        double multiplier = 0.25;
        getTopLeft().move(-originalbase * multiplier, -originalheigh * multiplier);
        getBottomRight().move(originalbase * multiplier, originalheigh * multiplier);
    }

    @Override
    public void scaleDown(){

        System.out.println("ScaleDOwn");
        //falta implementar, era para testear que se llamen bien los metodos
        double originalbase = getBase();
        double originalheigh = getHeigth();
        double multiplier = 0.25;
        getTopLeft().move(-originalbase * multiplier, -originalheigh * multiplier);
        getBottomRight().move(originalbase * multiplier, originalheigh * multiplier);
    }

    private double getBase(){
        return Math.abs(getTopLeft().getX()-getBottomRight().getX());
    }
    private double getHeigth(){
        return Math.abs(getTopLeft().getY()-getBottomRight().getY());
    }

    private Point getCenterPoint(){
        return new Point((getTopLeft().getX() + getBottomRight().getX())/2 , (getBottomRight().getY() + getTopLeft().getY())/2);
    }

}
