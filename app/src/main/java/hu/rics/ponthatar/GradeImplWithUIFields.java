package hu.rics.ponthatar;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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
            this.minimalPercentageField.addTextChangedListener(new MinimalPercentageFieldWatcher());
        }

    class MinimalPercentageFieldWatcher implements TextWatcher {
        public void onTextChanged(CharSequence s, int start, int before, int count) {  }
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {  }
        public void afterTextChanged(Editable s) {
            String minimalPercentageString = minimalPercentageField.getText().toString();
            try {
                int minimalPercentageProbe = Integer.parseInt(minimalPercentageString);
                minimalPercentageField.removeTextChangedListener(this);
                if( checkIfPercentagesAreValid() ) {
                    setMinimalPercentage(minimalPercentageProbe);
                } else {
                    minimalPercentageField.setText(Integer.toString(minimalPercentage));
                }
                minimalPercentageField.addTextChangedListener(this);
            } catch(NumberFormatException nfe) {
                Log.d("Ponthatar","Could not parse " + nfe);
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
