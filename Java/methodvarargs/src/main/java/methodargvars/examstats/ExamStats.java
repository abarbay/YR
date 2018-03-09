package methodargvars.examstats;

public class ExamStats {
    private int maxPoints;

    public ExamStats(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public int getNumberOfTopGrades(int limitInPercent, int... results){
        int sum=0;
        if( results==null || results.length==0){
            throw new IllegalArgumentException("Number of results must not be empty!");
        }else {
            for (int result : results) {
                if (result > limitInPercent) {
                    sum++;
                }
            }
            return sum;
        }

    }

    public boolean hasAnyFailed(int limitInPercent, int... results){
        boolean failed=false;
        if( results==null || results.length==0){
            throw new IllegalArgumentException("Number of results must not be empty!");
        }else {
            for (int result : results) {
                if (result < limitInPercent) {
                    failed = true;
                }
            }
            return failed;
        }

    }
}
