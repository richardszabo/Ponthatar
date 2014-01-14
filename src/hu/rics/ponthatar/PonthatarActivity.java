package hu.rics.ponthatar;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.EditText;

public class PonthatarActivity extends Activity {
	
    private EditText maximumText;	
    private EditText min5pText;
    private EditText min5vText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ponthatar);
		maximumText = (EditText) findViewById(R.id.maximumText);		
    	min5pText = (EditText) findViewById(R.id.min5pText);
    	min5vText = (EditText) findViewById(R.id.min5vText);
    	
		maximumText.addTextChangedListener(new TextWatcher() {
		    public void onTextChanged(CharSequence s, int start, int before, int count) {

		    }
		    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

		    }

		    public void afterTextChanged(Editable s) {
		    	calcValue(maximumText,min5pText,min5vText);
		    }
		});
    	min5pText.setText("81");
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
