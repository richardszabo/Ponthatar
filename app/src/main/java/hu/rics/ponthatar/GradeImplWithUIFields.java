package hu.rics.ponthatar;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

import lombok.Getter;
import lombok.Setter;

class GradeImplWithUIFields extends GradeWithNeighborImpl {
    @Getter
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
            minimalPercentageField.setText(String.format(Locale.US,"%d",minimalPercentage));
        }
    }

    @Override
    public void setMaximalPercentage(int maximalPercentage) {
        super.setMaximalPercentage(maximalPercentage);
        if( maximalPercentageField != null ) {
            maximalPercentageField.setText(String.format(Locale.US,"%d",maximalPercentage));
        }
    }

    void setMinimalPercentageField(TextView minimalPercentageField) {
        this.minimalPercentageField = minimalPercentageField;
        this.minimalPercentageField.setOnFocusChangeListener(new MinimalPercentageFieldFocusChangeListener());
    }

    private class MinimalPercentageFieldFocusChangeListener implements View.OnFocusChangeListener {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (!hasFocus) {
                String minimalPercentageString = minimalPercentageField.getText().toString();
                try {
                    int minimalPercentageProbe = Integer.parseInt(minimalPercentageString);
                    if( checkIfPercentagesAreValid() ) {
                        setMinimalPercentage(minimalPercentageProbe);
                        calculatePointsFromOverallMaximum();
                    } else {
                        minimalPercentageField.setText(String.format(Locale.US,"%d",minimalPercentage));
                    }
                } catch(NumberFormatException nfe) {
                    Log.d("Ponthatar","Could not parse " + nfe);
                }
            }
        }
    }

    @Override
    public void calculatePointsFromOverallMaximum() {
        super.calculatePointsFromOverallMaximum();
        if( minimalPointField != null ) {
            minimalPointField.setText(String.format(Locale.US,"%d",minimalPoint));
        }
        if( maximalPointField != null ) {
            maximalPointField.setText(String.format(Locale.US,"%d",maximalPoint));
        }
    }
}
