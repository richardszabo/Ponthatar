package hu.rics.ponthatar;

public interface Grade {
    int getMinimalPercentage();
    void setMinimalPercentage(int minimalPercentage);
    int getMaximalPercentage();
    void setMaximalPercentage(int maximalPercentage);
    int getMinimalPoint();
    int getMaximalPoint();
    boolean checkIfPercentagesAreValid();
    void calculatePointsFromOverallMaximum(int overallMaximalPoint);
}
