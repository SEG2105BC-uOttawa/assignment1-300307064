package design5;

public abstract class PointCP5 {
    private double xOrRho, yOrTheta;
    private char typeCoord;

    public PointCP5(char typeCoord, double xOrRho, double yOrTheta) {
        if (typeCoord != 'C' && typeCoord != 'P') throw new IllegalArgumentException();

        this.xOrRho = xOrRho;
        this.yOrTheta = yOrTheta;
        this.typeCoord = typeCoord;
    }

    public char getTypeCoord() {
        return typeCoord;
    }

    public double getX() {
        return (typeCoord == 'C') ? xOrRho : (Math.cos(Math.toRadians(yOrTheta)) * xOrRho);
    }
    
    public double getY() {
        return (typeCoord == 'C') ? yOrTheta : (Math.sin(Math.toRadians(yOrTheta)) * xOrRho);
    }
    
    public double getRho() {
        return (typeCoord == 'P') ? xOrRho : (Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(yOrTheta, 2)));
    }
    
    public double getTheta() {
        return (typeCoord == 'P') ? yOrTheta : (Math.toDegrees(Math.atan2(yOrTheta, xOrRho)));
    }

    public void convertStorageToCartesian() {
        if (typeCoord != 'C') {
            double temp = getX();
            yOrTheta = getY();
            xOrRho = temp;
      
            typeCoord = 'C';
          }
    }

    public void convertStorageToPolar() {
        if (typeCoord != 'P') {
            double temp = getRho();
            yOrTheta = getTheta();
            xOrRho = temp;
      
            typeCoord = 'P';
          }
    }

    public double getDistance(PointCP5 pointB) {
        double deltaX = getX() - pointB.getX();
        double deltaY = getY() - pointB.getY();

        return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
    }

    public abstract PointCP5 rotatePoint(double rotation);

    public String toString() {
        return "Stored as " + (typeCoord == 'C' ? "Cartesian (" + getX() + ", " + getY() + ")" : "Polar [" + getRho() + ", " + getTheta() + "]") + "\n";
    }
}
