package hu.rics.ponthatar;

import lombok.Getter;
import lombok.Setter;

class GradeImpl implements Grade {
    @Getter @Setter
    int minimalPercentage;

    @Getter @Setter
    int maximalPercentage;

    @Getter
    int minimalPoint;

    @Getter
    int maximalPoint;

    boolean checkIfMinimalPercentageIsValid() {
        return minimalPercentage >= 0;
    }

    boolean checkIfMaximalPercentageIsValid() {
        return maximalPercentage <= 100;
    }

    public boolean checkIfPercentagesAreValid() {
        return checkIfMinimalPercentageIsValid() &&
                checkIfMaximalPercentageIsValid() &&
                minimalPercentage <= maximalPercentage;
    }

    public void calculatePointsFromOverallMaximum(int overallMaximalPoint) {
        minimalPoint = Math.round((float)(overallMaximalPoint * minimalPercentage) / 100);
        maximalPoint = Math.round((float)(overallMaximalPoint * maximalPercentage) / 100);
    }
}
