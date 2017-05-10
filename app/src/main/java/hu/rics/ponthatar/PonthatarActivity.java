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

import java.math.RoundingMode;
import java.text.DecimalFormat;

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
    private TextView grade3MaimalPointField;
    private EditText grade2MinimalPercentageField;
    private TextView grade2MinimalPointField;
    private EditText grade2MaximalPercentageField;
    private TextView grade2MaximalPointField;
	private DecimalFormat df;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ponthatar);
		overallMaximalPointField = (EditText) findViewById(R.id.overallMaximalPoint);
		testPaperTypeField = (Spinner) findViewById(R.id.testPaperType);
		testPaperTypeField.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
				switch( pos ) {
				case 1: // Témazáró
					grade5MinimalPercentageField.setText("85");
					grade4MinimalPercentageField.setText("70");
					grade3MinimalPercentageField.setText("55");
					grade2MinimalPercentageField.setText("40");
					grade5MaximalPercentageField.setText("100");
					grade4MaximalPercentageField.setText("84");
					grade3MaximalPercentageField.setText("69");
					grade2MaximalPercentageField.setText("54");
					break;
				case 0:	// Szódolgozat
				default:	
					grade5MinimalPercentageField.setText("90");
					grade4MinimalPercentageField.setText("77");
					grade3MinimalPercentageField.setText("64");
					grade2MinimalPercentageField.setText("51");
					grade5MaximalPercentageField.setText("100");
					grade4MaximalPercentageField.setText("89");
					grade3MaximalPercentageField.setText("76");
					grade2MaximalPercentageField.setText("63");
					break;
				}
				recalc();
			  }
			 
			  @Override
			  public void onNothingSelected(AdapterView<?> arg0) {
			  }	
		});
		overallMaximalPointField.addTextChangedListener(new OwnTextWatcher());
		
		grade5MinimalPercentageField = (EditText) findViewById(R.id.grade5MinimalPercentage);
		grade5MinimalPercentageField.addTextChangedListener(new OwnTextWatcher());
    	grade5MinimalPointField = (TextView) findViewById(R.id.grade5MinimalPoint);
    	grade5MaximalPercentageField = (EditText) findViewById(R.id.grade5MaximalPercentage);
    	grade5MaximalPointField = (TextView) findViewById(R.id.grade5MaximalPoint);
    	grade4MinimalPercentageField = (EditText) findViewById(R.id.grade4MinimalPercentage);
    	grade4MinimalPercentageField.addTextChangedListener(new OwnTextWatcher());
    	grade4MinimalPointField = (TextView) findViewById(R.id.grade4MinimalPoint);
    	grade4MaximalPercentageField = (EditText) findViewById(R.id.grade4MaximalPercentage);
    	grade4MaximalPointField = (TextView) findViewById(R.id.grade4MaximalPoint);
    	grade3MinimalPercentageField = (EditText) findViewById(R.id.grade3MinimalPercentage);
    	grade3MinimalPercentageField.addTextChangedListener(new OwnTextWatcher());
    	grade3MinimalPointField = (TextView) findViewById(R.id.grade3MinimalPoint);
    	grade3MaximalPercentageField = (EditText) findViewById(R.id.grade3MaximalPercentage);
    	grade3MaimalPointField = (TextView) findViewById(R.id.grade3MaximalPoint);
    	grade2MinimalPercentageField = (EditText) findViewById(R.id.grade2MinimalPercentage);
		grade2MinimalPercentageField.addTextChangedListener(new OwnTextWatcher());
    	grade2MinimalPointField = (TextView) findViewById(R.id.grade2MinimalPoint);
    	grade2MaximalPercentageField = (EditText) findViewById(R.id.grade2MaximalPercentage);
    	grade2MaximalPointField = (TextView) findViewById(R.id.grade2MaximalPoint);
		df = new DecimalFormat("###");
		df.setRoundingMode(RoundingMode.HALF_DOWN);
	}
	
	class OwnTextWatcher implements TextWatcher {
	    public void onTextChanged(CharSequence s, int start, int before, int count) {

	    }
	    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

	    }

	    public void afterTextChanged(Editable s) {
			recalc();
	    }
	}

	
	public void recalc() {
		String max = overallMaximalPointField.getText().toString();
		if( max != null && !"".equals(max.trim())) {
			// percents
			try {
				grade4MaximalPercentageField.setText(Integer.toString(Integer.valueOf(grade5MinimalPercentageField.getText().toString()) - 1));
				grade3MaximalPercentageField.setText(Integer.toString(Integer.valueOf(grade4MinimalPercentageField.getText().toString()) - 1));
				grade2MaximalPercentageField.setText(Integer.toString(Integer.valueOf(grade3MinimalPercentageField.getText().toString()) - 1));
			} catch(NumberFormatException nfe) {
				Log.d(TAG,"Invalid number");
			}
			// values
			grade5MaximalPointField.setText(overallMaximalPointField.getText());
			calcValue(overallMaximalPointField, grade5MinimalPercentageField, grade5MinimalPointField, grade4MaximalPointField);
			calcValue(overallMaximalPointField, grade4MinimalPercentageField, grade4MinimalPointField, grade3MaimalPointField);
			calcValue(overallMaximalPointField, grade3MinimalPercentageField, grade3MinimalPointField, grade2MaximalPointField);
			calcValue(overallMaximalPointField, grade2MinimalPercentageField, grade2MinimalPointField, null);
		}
	}
	
	public void calcValue(EditText maxPoint, EditText percentText, TextView upperMinValueText, TextView lowerMaxValueText) {
		int maxP = getNumber(maxPoint);
		int percent = getNumber(percentText);
		String value = df.format((float)(maxP * percent) / 100);
		upperMinValueText.setText(value);
		if( lowerMaxValueText != null ) {
			lowerMaxValueText.setText(Integer.toString(Integer.valueOf(value) - 1));
		}
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
