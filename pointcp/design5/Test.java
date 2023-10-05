package design5;

public class Test {
    public static void main(String[] args) {
        PerformanceAnalysis analysis = new PerformanceAnalysis();

        String[] designNames = {"Design 1", "Design 2", "Design 3", "Design 5_2", "Design 5_3"};
        String[] methodNames = {"toCartesian", "toPolar", "getDistance", "rotatePoint"};

        for (int i = 0; i < designNames.length; i++) {
            for (int j = 0; j < methodNames.length; j++) {
                System.out.println(designNames[i] + "." + methodNames[j]);
                analysis.measureAverageExecutionTime(designNames[i], methodNames[j]);
                System.out.println();
            }
        }
    }
}
