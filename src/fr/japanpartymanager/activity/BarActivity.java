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
	ImageButton buttonBubbleTea 	= null;
	
	Button buttonSupprSodasJus 		= null;
	Button buttonSupprCafeThe 		= null;
	Button buttonSupprConfiserie 	= null;
	Button buttonSupprBubbleTea		= null;
	Button buttonAnnulerCommande	= null;
	
	EditText editTextSodasJus 		= null;
	EditText editTextCafeThe 		= null;
	EditText editTextConfiserie		= null;
	EditText editTextBubbleTea		= null;
	EditText editTextTotal 			= null;
	
	TextView labelFoisPrixSodasJus = null;
	TextView labelFoisPrixCafeThe = null;
	TextView labelFoisPrixConfiserie = null;
	TextView labelFoisPrixBubbleTea = null;
	
	//Variables
	int nbreClicSodasJus;
	int nbreClicCafeThe;
	int nbreClicConfiserie;
	int nbreClicBubbleTea;
	double nbreTotal;
	
	double prixSodasJus 	= 1.50;
	double prixCafeThe 		= 1.00;
	double prixConfiserie 	= 1.50;
	double prixBubbleTea	= 2.50;

	//Initialisation de la vue
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bar);
		setTitle("Bar");
		
		buttonSodasJus 			= (ImageButton)findViewById(R.id.imageButtonSodasJus);
        buttonCafeThe 			= (ImageButton)findViewById(R.id.imageButtonCafeThe);
        buttonConfiserie 		= (ImageButton) findViewById(R.id.imageButtonConfiserie);
        buttonBubbleTea 		= (ImageButton) findViewById(R.id.imageButtonBubbleTea);
        
        buttonSupprSodasJus 	= (Button)findViewById(R.id.buttonSupprSodasJus);
        buttonSupprCafeThe		= (Button)findViewById(R.id.buttonSupprCafeThe);
        buttonSupprConfiserie 	= (Button)findViewById(R.id.buttonSupprConfiserie);
        buttonSupprBubbleTea 	= (Button)findViewById(R.id.buttonSupprBubbleTea);
        
        buttonAnnulerCommande	= (Button)findViewById(R.id.buttonAnnulerCommande);
        
        editTextSodasJus 		= (EditText)findViewById(R.id.editTextTotalSodasJus);
        editTextCafeThe 		= (EditText)findViewById(R.id.editTextTotalCafeThe);
        editTextConfiserie 		= (EditText)findViewById(R.id.editTextTotalConfiserie);
        editTextBubbleTea		= (EditText)findViewById(R.id.editTextTotalBubbleTea);
        editTextTotal 			= (EditText)findViewById(R.id.editTextTotal);
        
        labelFoisPrixSodasJus = (TextView)findViewById(R.id.labelFoisPrixSodasJus);
        labelFoisPrixSodasJus.setText("x "+prixSodasJus+"€");
        
        labelFoisPrixCafeThe = (TextView)findViewById(R.id.labelFoisPrixCafeThe);
        labelFoisPrixCafeThe.setText("x "+prixCafeThe+"€");
        
        labelFoisPrixConfiserie = (TextView)findViewById(R.id.labelFoisPrixConfiserie);
        labelFoisPrixConfiserie.setText("x "+prixConfiserie+"€");
        
        labelFoisPrixBubbleTea = (TextView)findViewById(R.id.labelFoisPrixBubbleTea);
        labelFoisPrixBubbleTea.setText("x "+prixBubbleTea+"€");
        
        nbreClicSodasJus 	= 0;
        nbreClicCafeThe 	= 0;
        nbreClicConfiserie 	= 0;
        nbreClicBubbleTea 	= 0;
        nbreTotal			= 0;
        
        buttonSodasJus.setOnClickListener(listenerButtonAjoutBar);
        buttonCafeThe.setOnClickListener(listenerButtonAjoutBar);
        buttonConfiserie.setOnClickListener(listenerButtonAjoutBar);
        buttonBubbleTea.setOnClickListener(listenerButtonAjoutBar);
        
        
        buttonSupprSodasJus.setOnClickListener(listenerButtonSupprBar);
        buttonSupprCafeThe.setOnClickListener(listenerButtonSupprBar);
        buttonSupprConfiserie.setOnClickListener(listenerButtonSupprBar);
        buttonSupprBubbleTea.setOnClickListener(listenerButtonSupprBar);
        
        buttonAnnulerCommande.setOnClickListener(listenerButtonAnnulerCommande);
	}
	
	private OnClickListener listenerButtonAjoutBar = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch(v.getId()) {
			case R.id.imageButtonSodasJus :
				nbreClicSodasJus++;
				editTextSodasJus.setText(""+nbreClicSodasJus);
				break;
			case R.id.imageButtonCafeThe :
				nbreClicCafeThe++;
				editTextCafeThe.setText(""+nbreClicCafeThe);
				break;
			case R.id.imageButtonConfiserie:
				nbreClicConfiserie++;
				editTextConfiserie.setText(""+nbreClicConfiserie);
				break;
			case R.id.imageButtonBubbleTea:
				nbreClicBubbleTea++;
				editTextBubbleTea.setText(""+nbreClicBubbleTea);
				
				break;
			}
			nbreTotal = (nbreClicSodasJus*prixSodasJus)+(nbreClicCafeThe*prixCafeThe)
					+(nbreClicConfiserie*prixConfiserie)+(nbreClicBubbleTea*prixBubbleTea);
			editTextTotal.setText(""+nbreTotal);
		}
	};
	
	private OnClickListener listenerButtonSupprBar = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch(v.getId()) {
			case R.id.buttonSupprSodasJus :
				if(nbreClicSodasJus>0){
					nbreClicSodasJus--;
				}
				editTextSodasJus.setText(""+nbreClicSodasJus);
				break;
			case R.id.buttonSupprCafeThe :
				if(nbreClicCafeThe >0){
					nbreClicCafeThe--;
				}
				editTextCafeThe.setText(""+nbreClicCafeThe);
				break;
			case R.id.buttonSupprConfiserie:
				if(nbreClicConfiserie>0){
					nbreClicConfiserie--;
				}
				editTextConfiserie.setText(""+nbreClicConfiserie);
				break;
			case R.id.buttonSupprBubbleTea:
				if(nbreClicBubbleTea>0){
					nbreClicBubbleTea--;
				}
				editTextBubbleTea.setText(""+nbreClicBubbleTea);
				break;
			}
			nbreTotal = (nbreClicSodasJus*prixSodasJus)+(nbreClicCafeThe*prixCafeThe)
					+(nbreClicConfiserie*prixConfiserie)+(nbreClicBubbleTea*prixBubbleTea);
			editTextTotal.setText(""+nbreTotal);
		}
	};
	
	private OnClickListener listenerButtonAnnulerCommande = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			nbreClicSodasJus = 0;
			editTextSodasJus.setText(""+nbreClicSodasJus);
			nbreClicCafeThe = 0;
			editTextCafeThe.setText(""+nbreClicCafeThe);
			nbreClicConfiserie = 0;
			editTextConfiserie.setText(""+nbreClicConfiserie);
			nbreClicBubbleTea = 0;
			editTextBubbleTea.setText(""+nbreClicBubbleTea);
			nbreTotal = 0;
			editTextTotal.setText(""+nbreTotal);
		}
	};
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.bar, menu);
		return true;
	}

}
