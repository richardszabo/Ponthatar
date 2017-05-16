package hu.rics.ponthatar;

import android.widget.TextView;

import lombok.Getter;
import lombok.Setter;

public class GradeImplWithUIFields extends GradeImpl {
    @Getter @Setter
    TextView minimalPercentageField;
    @Getter @Setter
    TextView maximalPercentageField;
    @Getter @Setter
    TextView minimalValueField;
    @Getter @Setter
    TextView maximalValueField;
}
