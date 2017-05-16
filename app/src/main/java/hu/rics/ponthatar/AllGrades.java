package hu.rics.ponthatar;

import lombok.Getter;

public class AllGrades {

    @Getter
    TestPaperType testPaperType;
    GradeImpl grade5;
    GradeImpl grade4;
    GradeImpl grade3;
    GradeImpl grade2;

    AllGrades() {
        grade5 = new GradeImpl();
        grade4 = new GradeImpl();
        grade3 = new GradeImpl();
        grade2 = new GradeImpl();
        setTestPaperTypeAndGradePercentages(TestPaperType.SZODOLGOZAT);
    }

    void setTestPaperTypeAndGradePercentages(TestPaperType testPaperType) {
        this.testPaperType = testPaperType;
        setGradePercentages();
    }

    void setGradePercentages() {
        grade2.setMinimalPercentage(testPaperType.grade2MinimalPercentage);
        grade2.setMaximalPercentage(testPaperType.grade3MinimalPercentage-1);
        grade3.setMinimalPercentage(testPaperType.grade3MinimalPercentage);
        grade3.setMaximalPercentage(testPaperType.grade4MinimalPercentage-1);
        grade4.setMinimalPercentage(testPaperType.grade4MinimalPercentage);
        grade4.setMaximalPercentage(testPaperType.grade5MinimalPercentage-1);
        grade5.setMinimalPercentage(testPaperType.grade5MinimalPercentage);
        grade5.setMaximalPercentage(100);
    }

}
