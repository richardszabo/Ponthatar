package hu.rics.ponthatar;

import lombok.Getter;

public class AllGrades {

    @Getter
    TestPaperType testPaperType;
    Grade grade5;
    Grade grade4;
    Grade grade3;
    Grade grade2;

    AllGrades() {
        grade5 = new Grade();
        grade4 = new Grade();
        grade3 = new Grade();
        grade2 = new Grade();
        setTestPaperType(TestPaperType.SZODOLGOZAT);
    }

    void setTestPaperType(TestPaperType testPaperType) {
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
