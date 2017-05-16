package hu.rics.ponthatar;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GradeImplTest {
    GradeImpl gradeImpl;

    @Before
    public void setup() {
        gradeImpl = new GradeImpl();
    }

    @Test
    public void gradeImpl_checkIfMinimalPercentageIsValid_positiveReturnsTrue() {
        gradeImpl.setMinimalPercentage(23);
        assertThat(gradeImpl.checkIfMinimalPercentageIsValid(),is(true));
    }

    @Test
    public void gradeImpl_checkIfMinimalPercentageIsValid_zeroReturnsTrue() {
        gradeImpl.setMinimalPercentage(0);
        assertThat(gradeImpl.checkIfMinimalPercentageIsValid(),is(true));
    }

    @Test
    public void gradeImpl_checkIfMinimalPercentageIsValid_negativeReturnsFalse() {
        gradeImpl.setMinimalPercentage(-1);
        assertThat(gradeImpl.checkIfMinimalPercentageIsValid(),is(false));
    }

    @Test
    public void gradeImpl_checkIfMaximalPercentageIsValid_lessThan100ReturnsTrue() {
        gradeImpl.setMaximalPercentage(23);
        assertThat(gradeImpl.checkIfMaximalPercentageIsValid(),is(true));
    }

    @Test
    public void gradeImpl_checkIfMaximalPercentageIsValid_100ReturnsTrue() {
        gradeImpl.setMaximalPercentage(100);
        assertThat(gradeImpl.checkIfMaximalPercentageIsValid(),is(true));
    }

    @Test
    public void gradeImpl_checkIfMaximalPercentageIsValid_moreThan100ReturnsFalse() {
        gradeImpl.setMaximalPercentage(101);
        assertThat(gradeImpl.checkIfMaximalPercentageIsValid(),is(false));
    }

    @Test
    public void gradeImpl_checkIfPercentagesAreValid_correctReturnsTrue() {
        gradeImpl.setMinimalPercentage(23);
        gradeImpl.setMaximalPercentage(77);
        assertThat(gradeImpl.checkIfPercentagesAreValid(),is(true));
    }

    @Test
    public void gradeImpl_checkIfPercentagesAreValid_correctEqualReturnsTrue() {
        gradeImpl.setMinimalPercentage(23);
        gradeImpl.setMaximalPercentage(23);
        assertThat(gradeImpl.checkIfPercentagesAreValid(),is(true));
    }

    @Test
    public void gradeImpl_checkIfPercentagesAreValid_incorrectReturnsFalse() {
        gradeImpl.setMinimalPercentage(23);
        gradeImpl.setMaximalPercentage(22);
        assertThat(gradeImpl.checkIfPercentagesAreValid(),is(false));
    }

    @Test
    public void gradeImpl_calculatePointsFromOverallMaximum_correctMinimalPoint() {
        gradeImpl.setMinimalPercentage(23);
        gradeImpl.calculatePointsFromOverallMaximum(100);
        assertThat(gradeImpl.getMinimalPoint(),is(23));
    }

    @Test
    public void gradeImpl_calculatePointsFromOverallMaximum_correctMaximalPoint() {
        gradeImpl.setMaximalPercentage(77);
        gradeImpl.calculatePointsFromOverallMaximum(100);
        assertThat(gradeImpl.getMaximalPoint(),is(77));
    }

}
