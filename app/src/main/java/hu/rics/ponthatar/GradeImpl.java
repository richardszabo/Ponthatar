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

    @Setter
    int overallMaximum;

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

    public void calculatePointsFromOverallMaximum() {
        minimalPoint = Math.round((float)(overallMaximum * minimalPercentage) / 100);
        maximalPoint = Math.round((float)(overallMaximum * maximalPercentage) / 100);
    }
}
