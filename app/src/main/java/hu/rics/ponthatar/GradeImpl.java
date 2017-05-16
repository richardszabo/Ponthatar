package hu.rics.ponthatar;

import lombok.Getter;
import lombok.Setter;

public class GradeImpl implements Grade {
    @Getter @Setter
    int minimalPercentage;

    @Getter @Setter
    int maximalPercentage;

    @Getter
    int minimalPoint;

    @Getter
    int maximalPoint;

    public boolean checkiIfPercentagesAreValid() {
        return minimalPercentage >= 0 &&
                minimalPercentage <= maximalPercentage &&
                maximalPercentage <= 100;
    }

    public void calculatePointsFromOverallMaximum(int overallMaximalPoint) {
        minimalPoint = Math.round((float)(overallMaximalPoint * minimalPercentage) / 100);
        maximalPoint = Math.round((float)(overallMaximalPoint * maximalPercentage) / 100);
    }
}
