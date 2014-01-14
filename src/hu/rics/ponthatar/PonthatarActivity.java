package hu.rics.ponthatar;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class PonthatarActivity extends Activity {
	
    private EditText maximumText;	
    private Spinner phtype;	
    private EditText min5pText;
    private EditText min5vText;
    private EditText max5pText;
    private EditText max5vText;
    private EditText min4pText;
    private EditText min4vText;
    private EditText max4pText;
    private EditText max4vText;
    private EditText min3pText;
    private EditText min3vText;
    private EditText max3pText;
    private EditText max3vText;
    private EditText min2pText;
    private EditText min2vText;
    private EditText max2pText;
    private EditText max2vText;

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
    	min5pText = (EditText) findViewById(R.id.min5pText);
    	min5vText = (EditText) findViewById(R.id.min5vText);
    	max5pText = (EditText) findViewById(R.id.max5pText);
    	max5vText = (EditText) findViewById(R.id.max5vText);
    	min4pText = (EditText) findViewById(R.id.min4pText);
    	min4vText = (EditText) findViewById(R.id.min4vText);
    	max4pText = (EditText) findViewById(R.id.max4pText);
    	max4vText = (EditText) findViewById(R.id.max4vText);
    	min3pText = (EditText) findViewById(R.id.min3pText);
    	min3vText = (EditText) findViewById(R.id.min3vText);
    	max3pText = (EditText) findViewById(R.id.max3pText);
    	max3vText = (EditText) findViewById(R.id.max3vText);
    	min2pText = (EditText) findViewById(R.id.min2pText);
    	min2vText = (EditText) findViewById(R.id.min2vText);
    	max2pText = (EditText) findViewById(R.id.max2pText);
    	max2vText = (EditText) findViewById(R.id.max2vText);
    	
		maximumText.addTextChangedListener(new TextWatcher() {
		    public void onTextChanged(CharSequence s, int start, int before, int count) {

		    }
		    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

		    }

		    public void afterTextChanged(Editable s) {
		    	recalc();
		    }
		});
	}
	
	public void recalc() {
    	calcValue(maximumText,min5pText,min5vText);
    	calcValue(maximumText,max5pText,max5vText);
    	calcValue(maximumText,min4pText,min4vText);
    	calcValue(maximumText,max4pText,max4vText);
    	calcValue(maximumText,min3pText,min3vText);
    	calcValue(maximumText,max3pText,max3vText);
    	calcValue(maximumText,min2pText,min2vText);
    	calcValue(maximumText,max2pText,max2vText);		
	}
	
	public void calcValue(EditText maxPoint, EditText percentText, EditText valueText) {
		int maxP = getNumber(maxPoint);
		int percent = getNumber(percentText);
	    valueText.setText(String.format("%s",((float)(maxP * percent) / 100)));
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
