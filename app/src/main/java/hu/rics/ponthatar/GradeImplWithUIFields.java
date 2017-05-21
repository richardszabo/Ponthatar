package hu.rics.ponthatar;

import android.widget.TextView;

import lombok.Getter;
import lombok.Setter;

public class GradeImplWithUIFields extends GradeWithNeighborImpl {
    @Getter @Setter
    TextView minimalPercentageField;
    @Getter @Setter
    TextView maximalPercentageField;
    @Getter @Setter
    TextView minimalPointField;
    @Getter @Setter
    TextView maximalPointField;

    @Override
    public void setMinimalPercentage(int minimalPercentage) {
        super.setMinimalPercentage(minimalPercentage);
        if( minimalPercentageField != null ) {
            minimalPercentageField.setText(Integer.toString(minimalPercentage));
        }
    }

    @Override
    public void setMaximalPercentage(int maximalPercentage) {
        super.setMaximalPercentage(maximalPercentage);
        if( maximalPercentageField != null ) {
            maximalPercentageField.setText(Integer.toString(maximalPercentage));
        }
    }
    
    @Override
    public void calculatePointsFromOverallMaximum(int overallMaximalPoint) {
        super.calculatePointsFromOverallMaximum(overallMaximalPoint);
        if( minimalPointField != null ) {
            minimalPointField.setText(Integer.toString(minimalPoint));
        }
        if( maximalPointField != null ) {
            maximalPointField.setText(Integer.toString(maximalPoint));
        }
    }
}
