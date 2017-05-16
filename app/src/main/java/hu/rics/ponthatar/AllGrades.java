package hu.rics.ponthatar;

import lombok.Getter;
import lombok.Setter;

import static hu.rics.ponthatar.R.string.grade;

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

    AllGrades() {
        grade2 = new GradeImpl();
        grade3 = new GradeImpl();
        grade4 = new GradeImpl();
        grade5 = new GradeImpl();
    }

    void setTestPaperTypeAndDefaultGradePercentages(TestPaperType testPaperType) {
        this.testPaperType = testPaperType;
        setDefaultGradePercentages();
    }

    void setDefaultGradePercentages() {
        grade2.setMinimalPercentage(testPaperType.grade2MinimalPercentage);
        grade2.setMaximalPercentage(testPaperType.grade3MinimalPercentage - 1);
        grade3.setMinimalPercentage(testPaperType.grade3MinimalPercentage);
        grade3.setMaximalPercentage(testPaperType.grade4MinimalPercentage - 1);
        grade4.setMinimalPercentage(testPaperType.grade4MinimalPercentage);
        grade4.setMaximalPercentage(testPaperType.grade5MinimalPercentage - 1);
        grade5.setMinimalPercentage(testPaperType.grade5MinimalPercentage);
        grade5.setMaximalPercentage(100);
    }

    void setGrade2MinimalPercentage(int percentage) {
        grade2.setMinimalPercentage(percentage);
    }

    void setGrade3MinimalPercentage(int percentage) {
        grade3.setMinimalPercentage(percentage);
        grade2.setMaximalPercentage(percentage-1);
    }

    void setGrade4MinimalPercentage(int percentage) {
        grade4.setMinimalPercentage(percentage);
        grade3.setMaximalPercentage(percentage-1);
    }

    void setGrade5MinimalPercentage(int percentage) {
        grade5.setMinimalPercentage(percentage);
        grade4.setMaximalPercentage(percentage-1);
    }

    public void calculatePointsFromOverallMaximum(int overallMaximalPoint) {
        grade2.calculatePointsFromOverallMaximum(overallMaximalPoint);
        grade3.calculatePointsFromOverallMaximum(overallMaximalPoint);
        grade4.calculatePointsFromOverallMaximum(overallMaximalPoint);
        grade5.calculatePointsFromOverallMaximum(overallMaximalPoint);
    }

}
