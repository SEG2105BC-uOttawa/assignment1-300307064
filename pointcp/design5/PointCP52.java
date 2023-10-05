package design5;

public class PointCP52 extends PointCP5 {
    public PointCP52(double rho, double theta) {
        super('P', rho, theta);
    }

    public PointCP52 rotatePoint(double rotation) {
        double radRotation = Math.toRadians(rotation);
        double X = getX();
        double Y = getY();

        double newX = (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y);
        double newY = (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y);

        double newXToRho = Math.sqrt(Math.pow(newX, 2) + Math.pow(newY, 2));
        double newYToTheta = Math.toDegrees(Math.atan2(newY, newX));
    
        return new PointCP52(newXToRho, newYToTheta);
    }
}
