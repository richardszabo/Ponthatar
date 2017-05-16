package hu.rics.ponthatar;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

public class PonthatarActivity extends Activity {
	
    private EditText overallMaximalPointField;
    private Spinner testPaperTypeField;
    private EditText grade5MinimalPercentageField;
    private TextView grade5MinimalPointField;
    private EditText grade5MaximalPercentageField;
    private TextView grade5MaximalPointField;
    private EditText grade4MinimalPercentageField;
    private TextView grade4MinimalPointField;
    private EditText grade4MaximalPercentageField;
    private TextView grade4MaximalPointField;
    private EditText grade3MinimalPercentageField;
    private TextView grade3MinimalPointField;
    private EditText grade3MaximalPercentageField;
    private TextView grade3MaximalPointField;
    private EditText grade2MinimalPercentageField;
    private TextView grade2MinimalPointField;
    private EditText grade2MaximalPercentageField;
    private TextView grade2MaximalPointField;
	GradeImplWithUIFields grade2, grade3, grade4, grade5;
	AllGrades allGrades;
	boolean inRecalculation;

	void initFields() {
		overallMaximalPointField = (EditText) findViewById(R.id.overallMaximalPoint);
		testPaperTypeField = (Spinner) findViewById(R.id.testPaperType);
		grade2MinimalPercentageField = (EditText) findViewById(R.id.grade2MinimalPercentage);
		grade2MinimalPointField = (TextView) findViewById(R.id.grade2MinimalPoint);
		grade2MaximalPercentageField = (EditText) findViewById(R.id.grade2MaximalPercentage);
		grade2MaximalPointField = (TextView) findViewById(R.id.grade2MaximalPoint);
		grade3MinimalPercentageField = (EditText) findViewById(R.id.grade3MinimalPercentage);
		grade3MinimalPointField = (TextView) findViewById(R.id.grade3MinimalPoint);
		grade3MaximalPercentageField = (EditText) findViewById(R.id.grade3MaximalPercentage);
		grade3MaximalPointField = (TextView) findViewById(R.id.grade3MaximalPoint);
		grade4MinimalPercentageField = (EditText) findViewById(R.id.grade4MinimalPercentage);
		grade4MinimalPointField = (TextView) findViewById(R.id.grade4MinimalPoint);
		grade4MaximalPercentageField = (EditText) findViewById(R.id.grade4MaximalPercentage);
		grade4MaximalPointField = (TextView) findViewById(R.id.grade4MaximalPoint);
		grade5MinimalPercentageField = (EditText) findViewById(R.id.grade5MinimalPercentage);
		grade5MinimalPointField = (TextView) findViewById(R.id.grade5MinimalPoint);
		grade5MaximalPercentageField = (EditText) findViewById(R.id.grade5MaximalPercentage);
		grade5MaximalPointField = (TextView) findViewById(R.id.grade5MaximalPoint);
	}

	void initGrades() {
		allGrades = new AllGrades();
		grade2 = new GradeImplWithUIFields();
		grade2.setMinimalPercentageField(grade2MinimalPercentageField);
		grade2.setMaximalPercentageField(grade2MaximalPercentageField);
		grade2.setMinimalPointField(grade2MinimalPointField);
		grade2.setMaximalPointField(grade2MaximalPointField);
		allGrades.setGrade2(grade2);
		grade3 = new GradeImplWithUIFields();
		grade3.setMinimalPercentageField(grade3MinimalPercentageField);
		grade3.setMaximalPercentageField(grade3MaximalPercentageField);
		grade3.setMinimalPointField(grade3MinimalPointField);
		grade3.setMaximalPointField(grade3MaximalPointField);
		allGrades.setGrade3(grade3);
		grade4 = new GradeImplWithUIFields();
		grade4.setMinimalPercentageField(grade4MinimalPercentageField);
		grade4.setMaximalPercentageField(grade4MaximalPercentageField);
		grade4.setMinimalPointField(grade4MinimalPointField);
		grade4.setMaximalPointField(grade4MaximalPointField);
		allGrades.setGrade4(grade4);
		grade5 = new GradeImplWithUIFields();
		grade5.setMinimalPercentageField(grade5MinimalPercentageField);
		grade5.setMaximalPercentageField(grade5MaximalPercentageField);
		grade5.setMinimalPointField(grade5MinimalPointField);
		grade5.setMaximalPointField(grade5MaximalPointField);
		allGrades.setGrade5(grade5);
		allGrades.setTestPaperTypeAndDefaultGradePercentages(TestPaperType.SZODOLGOZAT);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ponthatar);
		initFields();
		initGrades();
		testPaperTypeField.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
				switch( pos ) {
				case 1: // Témazáró
					allGrades.setTestPaperTypeAndDefaultGradePercentages(TestPaperType.TEMAZARO);
					break;
				case 0:	// Szódolgozat
				default:
					allGrades.setTestPaperTypeAndDefaultGradePercentages(TestPaperType.SZODOLGOZAT);
					break;
				}
				allGrades.setDefaultGradePercentages();
				recalculateAllFields();
			  }
			 
			  @Override
			  public void onNothingSelected(AdapterView<?> arg0) {
			  }	
		});
		overallMaximalPointField.addTextChangedListener(new OwnTextWatcher());
		grade5MinimalPercentageField.addTextChangedListener(new OwnTextWatcher());
    	grade4MinimalPercentageField.addTextChangedListener(new OwnTextWatcher());
    	grade3MinimalPercentageField.addTextChangedListener(new OwnTextWatcher());
		grade2MinimalPercentageField.addTextChangedListener(new OwnTextWatcher());
	}
	
	class OwnTextWatcher implements TextWatcher {
	    public void onTextChanged(CharSequence s, int start, int before, int count) {  }
	    public void beforeTextChanged(CharSequence s, int start, int count, int after) {  }
	    public void afterTextChanged(Editable s) {
			if( !inRecalculation ) {
				recalculateAllFields();
			}
	    }
	}

	void recalculatePercentages() {
		allGrades.setGrade2MinimalPercentage(Integer.valueOf(grade2MinimalPercentageField.getText().toString()));
		allGrades.setGrade3MinimalPercentage(Integer.valueOf(grade3MinimalPercentageField.getText().toString()));
		allGrades.setGrade4MinimalPercentage(Integer.valueOf(grade4MinimalPercentageField.getText().toString()));
		allGrades.setGrade5MinimalPercentage(Integer.valueOf(grade5MinimalPercentageField.getText().toString()));
	}

	public void recalculateAllFields() {
		inRecalculation = true;
		String max = overallMaximalPointField.getText().toString();
		if( max != null && !"".equals(max.trim())) {
			recalculatePercentages();
			int overallMaximum = getNumber(overallMaximalPointField);
			allGrades.calculatePointsFromOverallMaximum(overallMaximum);
		}
		inRecalculation = false;
	}

	public int getNumber(EditText text) {
		int myNum = 0;
		if( text.getText() != null && !"".equals(text.getText().toString()) ) {
			try {
			    myNum = Integer.parseInt(text.getText().toString());
			} catch(NumberFormatException nfe) {
			   System.out.println("Could not parse " + nfe);
			} 
		}
		return myNum;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ponthatar, menu);
		return true;
	}

}
