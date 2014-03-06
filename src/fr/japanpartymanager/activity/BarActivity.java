package fr.japanpartymanager.activity;

import fr.japanpartymanager.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class BarActivity extends Activity {

	//Déclaration des objets
	ImageButton buttonSodasJus 		= null;
	ImageButton buttonCafeThe		= null;
	ImageButton buttonConfiserie	= null;
	
	EditText editTextCanettes 		= null;
	EditText editTextCafeThe 		= null;
	EditText editTextConfiserie		= null;
	EditText editTextTotal 			= null;
	
	TextView labelFoisPrixSodasJus = null;
	TextView labelFoisPrixCafeThe = null;
	TextView labelFoisPrixConfiserie = null;
	
	//Variables
	int nbreClicCanettes;
	int nbreClicCafeThe;
	int nbreClicConfiserie;
	double nbreTotal;
	
	double prixSodasJus 	= 1.5;
	double prixCafeThe 		= 1;
	double prixConfiserie 	= 1.5;

	//Initialisation de la vue
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bar);
		setTitle("Bar");
		
		buttonSodasJus 		= (ImageButton)findViewById(R.id.imageButtonSodasJus);
        buttonCafeThe 		= (ImageButton)findViewById(R.id.imageButtonCafeThe);
        buttonConfiserie 	= (ImageButton) findViewById(R.id.imageButtonConfiserie);
        
        editTextCanettes 	= (EditText)findViewById(R.id.editTextTotalCanettes);
        editTextCafeThe 	= (EditText)findViewById(R.id.editTextTotalCafeThe);
        editTextConfiserie 	= (EditText)findViewById(R.id.editTextTotalConfiserie);
        editTextTotal 		= (EditText)findViewById(R.id.editTextTotal);
        
        labelFoisPrixSodasJus = (TextView)findViewById(R.id.labelFoisPrixSodasJus);
        labelFoisPrixSodasJus.setText("x "+prixSodasJus+"€");
        
        labelFoisPrixCafeThe = (TextView)findViewById(R.id.labelFoisPrixCafeThe);
        labelFoisPrixCafeThe.setText("x "+prixCafeThe+"€");
        
        labelFoisPrixConfiserie = (TextView)findViewById(R.id.labelFoisPrixConfiserie);
        labelFoisPrixConfiserie.setText("x "+prixConfiserie+"€");
        
        nbreClicCanettes 	= 0;
        nbreClicCafeThe 	= 0;
        nbreClicConfiserie 	= 0;
        nbreTotal			= 0;
        
        buttonSodasJus.setOnClickListener(listenerButtonBar);
        buttonCafeThe.setOnClickListener(listenerButtonBar);
        buttonConfiserie.setOnClickListener(listenerButtonBar);
       
	}
	
private OnClickListener listenerButtonBar = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch(v.getId()) {
			case R.id.imageButtonSodasJus :
				nbreClicCanettes++;
				editTextCanettes.setText(""+nbreClicCanettes);
				nbreTotal = (nbreClicCanettes*prixSodasJus)+(nbreClicCafeThe*prixCafeThe)+(nbreClicConfiserie*prixConfiserie);
				editTextTotal.setText(""+nbreTotal);
				break;
			case R.id.imageButtonCafeThe :
				nbreClicCafeThe++;
				editTextCafeThe.setText(""+nbreClicCafeThe);
				nbreTotal = (nbreClicCanettes*prixSodasJus)+(nbreClicCafeThe*prixCafeThe)+(nbreClicConfiserie*prixConfiserie);
				editTextTotal.setText(""+nbreTotal);
				break;
			case R.id.imageButtonConfiserie:
				nbreClicConfiserie++;
				editTextConfiserie.setText(""+nbreClicConfiserie);
				nbreTotal = (nbreClicCanettes*prixSodasJus)+(nbreClicCafeThe*prixCafeThe)+(nbreClicConfiserie*prixConfiserie);
				editTextTotal.setText(""+nbreTotal);
				break;
			}
		}
	};
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.bar, menu);
		return true;
	}

}
