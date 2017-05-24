package hu.rics.ponthatar;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AllGradesTest {
    private AllGrades allGrades;

    @Before
    public void setup() {
        allGrades = new AllGrades();
        Grade grade2 = new GradeImpl();
        allGrades.setGrade2(grade2);
        Grade grade3 = new GradeImpl();
        allGrades.setGrade3(grade3);
        Grade grade4 = new GradeImpl();
        allGrades.setGrade4(grade4);
        Grade grade5 = new GradeImpl();
        allGrades.setGrade5(grade5);
    }

    @Test
    public void AllGrades_setGradePercentages_szodolgozatGradeMinimalPercentage() {
        allGrades.setTestPaperTypeAndDefaultGradePercentages(TestPaperType.SZODOLGOZAT);
        assertThat(allGrades.grade2.getMinimalPercentage(),is(TestPaperType.SZODOLGOZAT.grade2MinimalPercentage));
        assertThat(allGrades.grade3.getMinimalPercentage(),is(TestPaperType.SZODOLGOZAT.grade3MinimalPercentage));
        assertThat(allGrades.grade4.getMinimalPercentage(),is(TestPaperType.SZODOLGOZAT.grade4MinimalPercentage));
        assertThat(allGrades.grade5.getMinimalPercentage(),is(TestPaperType.SZODOLGOZAT.grade5MinimalPercentage));
    }

    /*@Test
    public void AllGrades_setGradePercentages_szodolgozatGradeMaximalPercentage() {
        allGrades.setTestPaperTypeAndDefaultGradePercentages(TestPaperType.SZODOLGOZAT);
        assertThat(allGrades.grade2.getMaximalPercentage(),is(TestPaperType.SZODOLGOZAT.grade3MinimalPercentage-1));
        assertThat(allGrades.grade3.getMaximalPercentage(),is(TestPaperType.SZODOLGOZAT.grade4MinimalPercentage-1));
        assertThat(allGrades.grade4.getMaximalPercentage(),is(TestPaperType.SZODOLGOZAT.grade5MinimalPercentage-1));
        assertThat(allGrades.grade5.getMaximalPercentage(),is(100));
    }*/

    @Test
    public void AllGrades_setGradePercentages_temazaroGradeMinimalPercentage() {
        allGrades.setTestPaperTypeAndDefaultGradePercentages(TestPaperType.TEMAZARO);
        assertThat(allGrades.grade2.getMinimalPercentage(),is(TestPaperType.TEMAZARO.grade2MinimalPercentage));
        assertThat(allGrades.grade3.getMinimalPercentage(),is(TestPaperType.TEMAZARO.grade3MinimalPercentage));
        assertThat(allGrades.grade4.getMinimalPercentage(),is(TestPaperType.TEMAZARO.grade4MinimalPercentage));
        assertThat(allGrades.grade5.getMinimalPercentage(),is(TestPaperType.TEMAZARO.grade5MinimalPercentage));
    }

    /*@Test
    public void AllGrades_setGradePercentages_temazaroGradeMaximalPercentage() {
        allGrades.setTestPaperTypeAndDefaultGradePercentages(TestPaperType.TEMAZARO);
        assertThat(allGrades.grade2.getMaximalPercentage(),is(TestPaperType.TEMAZARO.grade3MinimalPercentage-1));
        assertThat(allGrades.grade3.getMaximalPercentage(),is(TestPaperType.TEMAZARO.grade4MinimalPercentage-1));
        assertThat(allGrades.grade4.getMaximalPercentage(),is(TestPaperType.TEMAZARO.grade5MinimalPercentage-1));
        assertThat(allGrades.grade5.getMaximalPercentage(),is(100));
    }*/
}
