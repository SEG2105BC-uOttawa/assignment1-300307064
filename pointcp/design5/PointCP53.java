package design5;

public class PointCP53 extends PointCP5 {
    public PointCP53(double X, double Y) {
        super('C', X, Y);
    }

    public PointCP53 rotatePoint(double rotation) {
        double radRotation = Math.toRadians(rotation);
        double X = getX();
        double Y = getY();
    
        return new PointCP53(
          (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
          (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y)
        );
    }
}
