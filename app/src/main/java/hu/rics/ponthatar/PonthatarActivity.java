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

import static android.R.attr.value;
import static android.content.ContentValues.TAG;
import static java.math.RoundingMode.HALF_UP;

public class PonthatarActivity extends Activity {
	
    private EditText maximumText;	
    private Spinner phtype;	
    private EditText min5pText;
    private TextView min5vText;
    private EditText max5pText;
    private TextView max5vText;
    private EditText min4pText;
    private TextView min4vText;
    private EditText max4pText;
    private TextView max4vText;
    private EditText min3pText;
    private TextView min3vText;
    private EditText max3pText;
    private TextView max3vText;
    private EditText min2pText;
    private TextView min2vText;
    private EditText max2pText;
    private TextView max2vText;
	private DecimalFormat df;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ponthatar);
		maximumText = (EditText) findViewById(R.id.maximumText);		
		phtype = (Spinner) findViewById(R.id.phtype);		
		phtype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
				switch( pos ) {
				case 1: // Témazáró
					min5pText.setText("85");
					min4pText.setText("70");
					min3pText.setText("55");
					min2pText.setText("40");
					max5pText.setText("100");
					max4pText.setText("84");
					max3pText.setText("69");
					max2pText.setText("54");
					break;
				case 0:	// Szódolgozat
				default:	
					min5pText.setText("90");
					min4pText.setText("77");
					min3pText.setText("64");
					min2pText.setText("51");
					max5pText.setText("100");
					max4pText.setText("89");
					max3pText.setText("76");
					max2pText.setText("63");
					break;
				}
				recalc();
			  }
			 
			  @Override
			  public void onNothingSelected(AdapterView<?> arg0) {
			  }	
		});
		maximumText.addTextChangedListener(new OwnTextWatcher());
		
		min5pText = (EditText) findViewById(R.id.min5pText);
		min5pText.addTextChangedListener(new OwnTextWatcher());
    	min5vText = (TextView) findViewById(R.id.min5vText);    	
    	max5pText = (EditText) findViewById(R.id.max5pText);
    	max5vText = (TextView) findViewById(R.id.max5vText);
    	min4pText = (EditText) findViewById(R.id.min4pText);
    	min4pText.addTextChangedListener(new OwnTextWatcher());
    	min4vText = (TextView) findViewById(R.id.min4vText);
    	max4pText = (EditText) findViewById(R.id.max4pText);
    	max4vText = (TextView) findViewById(R.id.max4vText);
    	min3pText = (EditText) findViewById(R.id.min3pText);
    	min3pText.addTextChangedListener(new OwnTextWatcher());
    	min3vText = (TextView) findViewById(R.id.min3vText);
    	max3pText = (EditText) findViewById(R.id.max3pText);
    	max3vText = (TextView) findViewById(R.id.max3vText);
    	min2pText = (EditText) findViewById(R.id.min2pText);
		min2pText.addTextChangedListener(new OwnTextWatcher());
    	min2vText = (TextView) findViewById(R.id.min2vText);
    	max2pText = (EditText) findViewById(R.id.max2pText);
    	max2vText = (TextView) findViewById(R.id.max2vText);
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
		String max = maximumText.getText().toString();
		if( max != null && !"".equals(max.trim())) {
			// percents
			try {
				max4pText.setText(Integer.toString(Integer.valueOf(min5pText.getText().toString()) - 1));
				max3pText.setText(Integer.toString(Integer.valueOf(min4pText.getText().toString()) - 1));
				max2pText.setText(Integer.toString(Integer.valueOf(min3pText.getText().toString()) - 1));
			} catch(NumberFormatException nfe) {
				Log.d(TAG,"Invalid number");
			}
			// values
			max5vText.setText(maximumText.getText());
			calcValue(maximumText, min5pText, min5vText, max4vText);
			calcValue(maximumText, min4pText, min4vText, max3vText);
			calcValue(maximumText, min3pText, min3vText, max2vText);
			calcValue(maximumText, min2pText, min2vText, null);
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
