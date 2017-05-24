package hu.rics.ponthatar;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
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

    void setMinimalPercentageField(TextView minimalPercentageField) {
        this.minimalPercentageField = minimalPercentageField;
        this.minimalPercentageField.setOnFocusChangeListener(new MinimalPercentageFieldFocusChangeListener());
    }

    class MinimalPercentageFieldFocusChangeListener implements View.OnFocusChangeListener {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (!hasFocus) {
                String minimalPercentageString = minimalPercentageField.getText().toString();
                try {
                    int minimalPercentageProbe = Integer.parseInt(minimalPercentageString);
                    if( checkIfPercentagesAreValid() ) {
                        setMinimalPercentage(minimalPercentageProbe);
                    } else {
                        minimalPercentageField.setText(Integer.toString(minimalPercentage));
                    }
                } catch(NumberFormatException nfe) {
                    Log.d("Ponthatar","Could not parse " + nfe);
                }
            }
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
