package hu.rics.ponthatar;

import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class GradeImplWithUIFieldsTest {
    private GradeImplWithUIFields gradeImplWithUIFields;
    private TextView minimalPercentageField;
    private TextView maximalPercentageField;

    @Before
    public void setup() {
        gradeImplWithUIFields = new GradeImplWithUIFields();
        minimalPercentageField = mock(TextView.class);
        gradeImplWithUIFields.setMinimalPercentageField(minimalPercentageField);
        maximalPercentageField = mock(TextView.class);
        gradeImplWithUIFields.setMaximalPercentageField(maximalPercentageField);
    }

    @Test
    public void gradeImplWithUIFields_setMinimalPercentage_setsFieldValue() {
        int minimalPercentage = 23;
        gradeImplWithUIFields.setMinimalPercentage(minimalPercentage);
        verify(minimalPercentageField, times(1)).setText(String.format(Locale.US,"%d",minimalPercentage));
    }

    @Test
    public void gradeImplWithUIFields_setMaximalPercentage_setsFieldValue() {
        int maximalPercentage = 23;
        gradeImplWithUIFields.setMaximalPercentage(maximalPercentage);
        verify(maximalPercentageField, times(1)).setText(String.format(Locale.US,"%d",maximalPercentage));
    }

    @Test
    public void gradeImplWithUIFields_calculatePointsFromOverallMaximum_setsFieldValues() {
        TextView minimalPointField = mock(TextView.class);
        TextView maximalPointField = mock(TextView.class);
        gradeImplWithUIFields.setMinimalPointField(minimalPointField);
        gradeImplWithUIFields.setMaximalPointField(maximalPointField);
        gradeImplWithUIFields.setOverallMaximum(100);
        int minimalPercentage = 23;
        int maximalPercentage = 56;
        gradeImplWithUIFields.setMinimalPercentage(minimalPercentage);
        gradeImplWithUIFields.setMaximalPercentage(maximalPercentage);
        gradeImplWithUIFields.calculatePointsFromOverallMaximum();
        verify(minimalPointField, times(1)).setText(String.format(Locale.US,"%d",minimalPercentage));
        verify(maximalPointField, times(1)).setText(String.format(Locale.US,"%d",maximalPercentage));
    }

}
