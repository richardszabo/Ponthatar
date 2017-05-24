package hu.rics.ponthatar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GradeWithNeighborImplTest {
    GradeWithNeighborImpl gradeWithNeighborImpl;
    GradeImpl neighborGrade;

    @Before
    public void setup() {
        gradeWithNeighborImpl = new GradeWithNeighborImpl();
        neighborGrade = new GradeImpl();
        gradeWithNeighborImpl.setLowerNeighbor(neighborGrade);
    }

    @Test
    public void gradeWithNeighborImpl_setMinimalPercentage_lowerNeighbor() {
        int TEST_PERCENTAGE = 23;
        gradeWithNeighborImpl.setMinimalPercentage(TEST_PERCENTAGE);
        assertEquals(TEST_PERCENTAGE-1,neighborGrade.getMaximalPercentage());
    }

}
