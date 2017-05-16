package hu.rics.ponthatar;

import lombok.Getter;
import lombok.Setter;

public class AllGrades {

    @Getter
    TestPaperType testPaperType;
    @Setter
    Grade grade2;
    @Setter
    Grade grade3;
    @Setter
    Grade grade4;
    @Setter
    Grade grade5;

    void setTestPaperTypeAndGradePercentages(TestPaperType testPaperType) {
        this.testPaperType = testPaperType;
        setGradePercentages();
    }

    void setGradePercentages() {
        if( grade2 != null ) {
            grade2.setMinimalPercentage(testPaperType.grade2MinimalPercentage);
            grade2.setMaximalPercentage(testPaperType.grade3MinimalPercentage - 1);
        }
        if( grade3 != null ) {
            grade3.setMinimalPercentage(testPaperType.grade3MinimalPercentage);
            grade3.setMaximalPercentage(testPaperType.grade4MinimalPercentage - 1);
        }
        if( grade4 != null ) {
            grade4.setMinimalPercentage(testPaperType.grade4MinimalPercentage);
            grade4.setMaximalPercentage(testPaperType.grade5MinimalPercentage - 1);
        }
        if( grade5 != null ) {
            grade5.setMinimalPercentage(testPaperType.grade5MinimalPercentage);
            grade5.setMaximalPercentage(100);
        }
    }

    public void calculatePointsFromOverallMaximum(int overallMaximalPoint) {
        grade2.calculatePointsFromOverallMaximum(overallMaximalPoint);
        grade3.calculatePointsFromOverallMaximum(overallMaximalPoint);
        grade4.calculatePointsFromOverallMaximum(overallMaximalPoint);
        grade5.calculatePointsFromOverallMaximum(overallMaximalPoint);
    }

}
