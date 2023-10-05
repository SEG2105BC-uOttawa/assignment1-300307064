package design5;

import design1.PointCP;
import design2.PointCP2;
import design3.PointCP3;

import java.util.Random;

public class PerformanceAnalysis {
    private int DEFAULT_RUNS = 1_000_000;

    public void measureAverageExecutionTime(String designName, String methodName) {
        long start, end, elapsed;
        long totalExecutionTime = 0;
        
        for (int i = 0; i < DEFAULT_RUNS; i++) {
            // System.out.println("Run no. " + (i + 1));
            // System.out.println("Current execution time: " + totalExecutionTime);

            start = System.nanoTime();

            runDesign(designName, methodName);
            
            end = System.nanoTime();

            elapsed = end - start;

            totalExecutionTime += elapsed;
        }

        long average = totalExecutionTime/DEFAULT_RUNS;

        System.out.println("Total execution time: " + totalExecutionTime + " nanoseconds");
        System.out.println("Average execution time: " + average + " nanoseconds");
        
    }

    public void runDesign(String designName, String methodName) {
        Random rd = new Random();

        char typeCoord = rd.nextInt(2) == 0 ? 'C' : 'P';

        double a = rd.nextDouble();
        double b = rd.nextDouble();
        double c = rd.nextDouble();
        double d = rd.nextDouble();

        double rotation = rd.nextDouble();

        switch(designName) {
            case "Design 1":
                PointCP design1 = new PointCP(typeCoord, a, b);
                switch(methodName) {
                    case "toCartesian":
                        design1.convertStorageToCartesian();
                        break;
                    case "toPolar":
                        design1.convertStorageToPolar();
                        break;
                    case "getDistance":
                        char newTypeCoord = rd.nextInt(2) == 0 ? 'C' : 'P';
                        PointCP pointB = new PointCP(newTypeCoord, c, d);

                        design1.getDistance(pointB);

                        break;
                    case "rotatePoint":
                        design1.rotatePoint(rotation);
                        break;
                    default:
                        System.out.println("Invalid method name");
                        break;
                }
                break;
            case "Design 2":
                PointCP2 design2 = new PointCP2(typeCoord, a, b);
                switch(methodName) {
                    case "toCartesian":
                        design2.convertStorageToCartesian();
                        break;
                    case "toPolar":
                        design2.convertStorageToPolar();
                        break;
                    case "getDistance":
                        char newTypeCoord = rd.nextInt(2) == 0 ? 'C' : 'P';
                        PointCP2 pointB = new PointCP2(newTypeCoord, c, d);

                        design2.getDistance(pointB);

                        break;
                    case "rotatePoint":
                        design2.rotatePoint(rotation);
                        break;
                    default:
                        System.out.println("Invalid method name");
                        break;
                }
                break;
            case "Design 3":
                PointCP3 design3 = new PointCP3(typeCoord, a, b);
                switch(methodName) {
                    case "toCartesian":
                        design3.convertStorageToCartesian();
                        break;
                    case "toPolar":
                        design3.convertStorageToPolar();
                        break;
                    case "getDistance":
                        char newTypeCoord = rd.nextInt(2) == 0 ? 'C' : 'P';
                        PointCP3 pointB = new PointCP3(newTypeCoord, c, d);

                        design3.getDistance(pointB);

                        break;
                    case "rotatePoint":
                        design3.rotatePoint(rotation);
                        break;
                    default:
                        System.out.println("Invalid method name");
                        break;
                }
                break;
            case "Design 5_2":
                PointCP5 design52 = new PointCP52(a, b);
                switch(methodName) {
                    case "toCartesian":
                        design52.convertStorageToCartesian();
                        break;
                    case "toPolar":
                        design52.convertStorageToPolar();
                        break;
                    case "getDistance":
                        PointCP52 pointB = new PointCP52(c, d);

                        design52.getDistance(pointB);

                        break;
                    case "rotatePoint":
                        design52.rotatePoint(rotation);
                        break;
                    default:
                        System.out.println("Invalid method name");
                        break;
                }
                break;
            case "Design 5_3":
                PointCP5 design53 = new PointCP52(a, b);
                switch(methodName) {
                    case "toCartesian":
                        design53.convertStorageToCartesian();
                        break;
                    case "toPolar":
                        design53.convertStorageToPolar();
                        break;
                    case "getDistance":
                        PointCP53 pointB = new PointCP53(c, d);

                        design53.getDistance(pointB);

                        break;
                    case "rotatePoint":
                        design53.rotatePoint(rotation);
                        break;
                    default:
                        System.out.println("Invalid method name");
                        break;
                }
                break;
        }
    }
}
