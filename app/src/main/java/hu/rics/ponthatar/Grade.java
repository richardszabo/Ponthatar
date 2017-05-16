package hu.rics.ponthatar;

/**
 * Created by rics on 2017.05.16..
 */

public interface Grade {
    int getMinimalPercentage();
    void setMinimalPercentage(int minimalPercentage);
    int getMaximalPercentage();
    void setMaximalPercentage(int maximalPercentage);
    int getMinimalPoint();
    int getMaximalPoint();
    boolean checkiIfPercentagesAreValid();
    void calculatePointsFromOverallMaximum(int overallMaximalPoint);
}
