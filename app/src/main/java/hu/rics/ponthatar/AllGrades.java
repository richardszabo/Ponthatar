package hu.rics.ponthatar;

import lombok.Getter;
import lombok.Setter;

class AllGrades {

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
        grade3.setMinimalPercentage(testPaperType.grade3MinimalPercentage);
        grade4.setMinimalPercentage(testPaperType.grade4MinimalPercentage);
        grade5.setMinimalPercentage(testPaperType.grade5MinimalPercentage);
        grade5.setMaximalPercentage(100);
    }

    void calculatePointsFromOverallMaximum(int overallMaximalPoint) {
        grade2.setOverallMaximum(overallMaximalPoint);
        grade3.setOverallMaximum(overallMaximalPoint);
        grade4.setOverallMaximum(overallMaximalPoint);
        grade5.setOverallMaximum(overallMaximalPoint);
        grade5.calculatePointsFromOverallMaximum();
    }

}
