package design2;

/**
 * Polar coordinates
 */

public class PointCP2 {
    private char typeCoord;
    private double rho;
    private double theta;

    public PointCP2(char typeCoord, double rho, double theta) {
        if (typeCoord != 'C' || typeCoord != 'P') throw new IllegalArgumentException();
        
        this.rho = rho;
        this.theta = theta;
        this.typeCoord = typeCoord;
    }

    public double getX() {
        return (typeCoord == 'C') ? rho : (Math.cos(Math.toRadians(theta)) * rho);
      }
    
      public double getY() {
        return (typeCoord == 'C') ? theta : (Math.sin(Math.toRadians(theta)) * rho);
      }
    
      public double getRho() {
        return (typeCoord == 'P') ? rho : (Math.sqrt(Math.pow(rho, 2) + Math.pow(theta, 2)));
      }
    
      public double getTheta() {
        return (typeCoord == 'P') ? theta : (Math.toDegrees(Math.atan2(theta, rho)));
      }

    public void convertStorageToCartesian() {
        if (typeCoord != 'C') {
            double temp = getX();
            theta = getY();
            rho = temp;
      
            typeCoord = 'C';
          }
    }

    public void convertStorageToPolar() {
        if (typeCoord != 'P') {
            double temp = getRho();
            theta = getTheta();
            rho = temp;
      
            typeCoord = 'P';
          }
    }

    public double getDistance(PointCP2 pointB) {
        double deltaX = getX() - pointB.getX();
        double deltaY = getY() - pointB.getY();

        return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
    }

    public PointCP2 rotatePoint(double rotation) {
        double radRotation = Math.toRadians(rotation);
        double X = getX();
        double Y = getY();
    
        return new PointCP2('P',
          (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
          (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y)
        );
    }

    public String toString() {
        return "Stored as " + (typeCoord == 'C' ? "Cartesian (" + getX() + ", " + getY() + ")" : "Polar [" + getRho() + ", " + getTheta() + "]") + "\n";
    }
}
