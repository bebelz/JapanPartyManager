package fr.japanpartymanager.activity;

import fr.japanpartymanager.R;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class RestauActivity extends Activity {

	//Déclaration des objets
	ImageButton buttonMenu 			= null;
	ImageButton buttonCrepe			= null;
	ImageButton buttonPlat			= null;
	ImageButton buttonSoda 			= null;
	ImageButton buttonCafeThe		= null;
	ImageButton buttonConfiserie 	= null;
	ImageButton buttonEau 			= null;

	Button buttonSupprMenu	 		= null;
	Button buttonSupprCrepe 		= null;
	Button buttonSupprPlat		 	= null;
	Button buttonSupprSoda			= null;
	Button buttonSupprCafeThe 		= null;
	Button buttonSupprConfiserie	= null;
	Button buttonSupprEau			= null;
	Button buttonAnnulerCommande	= null;
	Button buttonValiderCommande 	= null;
	Button buttonCB					= null;
	Button buttonEspece             = null;
	Button buttonTickets            = null;

	EditText editTextMenu			= null;
	EditText editTextCrepe 			= null;
	EditText editTextPlat			= null;
	EditText editTextSoda			= null;
	EditText editTextCafeThe		= null;
	EditText editTextConfiserie		= null;
	EditText editTextEau			= null;
	EditText editTextTotal			= null;

	TextView labelFoisPrixMenu 		= null;
	TextView labelFoisPrixCrepe		= null;
	TextView labelFoisPrixPlat		= null;
	TextView labelFoisPrixSoda 		= null;
	TextView labelFoisPrixCafeThe	= null;
	TextView labelFoisPrixConfiserie= null;
	TextView labelFoisPrixEau 		= null;

	AlertDialog alertDialog       	= null;

	//Variables
	int nbreClicMenu;
	int nbreClicCrepe;
	int nbreClicPlat;
	int nbreClicSoda;
	int nbreClicCafeThe;
	int nbreClicConfiserie;
	int nbreClicEau;
	double nbreTotal;

	double prixSoda 	= MainActivity.transacManager.getPrixProduit(0);
	double prixCafeThe 		= MainActivity.transacManager.getPrixProduit(1);
	double prixConfiserie 	= MainActivity.transacManager.getPrixProduit(2);
	double prixMenu 	= MainActivity.transacManager.getPrixProduit(4);
	double prixCrepe 	= MainActivity.transacManager.getPrixProduit(5);
	double prixPlat 		= MainActivity.transacManager.getPrixProduit(6);
	double prixEau 	= MainActivity.transacManager.getPrixProduit(7);

	//Initialisation de la vue
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_restau);
		setTitle("Restauration");

		buttonMenu 				= (ImageButton)findViewById(R.id.imageButtonMenu);
		buttonCrepe 			= (ImageButton)findViewById(R.id.imageButtonCrepe);
		buttonPlat 				= (ImageButton)findViewById(R.id.imageButtonPlat);
		buttonSoda				= (ImageButton)findViewById(R.id.imageButtonSoda);
		buttonCafeThe 			= (ImageButton)findViewById(R.id.imageButtonCafeThe);
		buttonConfiserie 		= (ImageButton) findViewById(R.id.imageButtonConfiserie);
		buttonEau 				= (ImageButton) findViewById(R.id.imageButtonEau);

		buttonSupprMenu 		= (Button)findViewById(R.id.buttonSupprMenu);
		buttonSupprCrepe		= (Button)findViewById(R.id.buttonSupprCrepe);
		buttonSupprPlat 		= (Button)findViewById(R.id.buttonSupprPlat);
		buttonSupprSoda 		= (Button)findViewById(R.id.buttonSupprSoda);
		buttonSupprCafeThe		= (Button)findViewById(R.id.buttonSupprCafeThe);
		buttonSupprConfiserie	= (Button)findViewById(R.id.buttonSupprConfiserie);
		buttonSupprEau 			= (Button)findViewById(R.id.buttonSupprEau);

		buttonAnnulerCommande	= (Button)findViewById(R.id.buttonAnnulerCommande);
		buttonValiderCommande	= (Button)findViewById(R.id.buttonValiderCommande);

		editTextMenu			= (EditText)findViewById(R.id.editTextTotalMenu);
		editTextCrepe 			= (EditText)findViewById(R.id.editTextTotalCrepe);
		editTextPlat 			= (EditText)findViewById(R.id.editTextTotalPlat);
		editTextSoda			= (EditText)findViewById(R.id.editTextTotalSoda);
		editTextCafeThe 		= (EditText)findViewById(R.id.editTextTotalCafeThe);
		editTextConfiserie 		= (EditText)findViewById(R.id.editTextTotalConfiserie);
		editTextEau				= (EditText)findViewById(R.id.editTextTotalEau);
		editTextTotal 			= (EditText)findViewById(R.id.editTextTotal);

		labelFoisPrixMenu = (TextView)findViewById(R.id.labelFoisPrixMenu);
		labelFoisPrixMenu.setText("x "+prixMenu+"€");

		labelFoisPrixCrepe = (TextView)findViewById(R.id.labelFoisPrixCrepe);
		labelFoisPrixCrepe.setText("x "+prixCrepe+"€");

		labelFoisPrixPlat = (TextView)findViewById(R.id.labelFoisPrixPlat);
		labelFoisPrixPlat.setText("x "+prixPlat+"€");

		labelFoisPrixSoda = (TextView)findViewById(R.id.labelFoisPrixSoda);
		labelFoisPrixSoda.setText("x "+prixSoda+"€");

		labelFoisPrixCafeThe = (TextView)findViewById(R.id.labelFoisPrixCafeThe);
		labelFoisPrixCafeThe.setText("x "+prixCafeThe+"€");

		labelFoisPrixConfiserie = (TextView)findViewById(R.id.labelFoisPrixConfiserie);
		labelFoisPrixConfiserie.setText("x "+prixConfiserie+"€");

		labelFoisPrixEau = (TextView)findViewById(R.id.labelFoisPrixEau);
		labelFoisPrixEau.setText("x "+prixEau+"€");

		nbreClicMenu 		= 0;
		nbreClicCrepe 		= 0;
		nbreClicPlat 		= 0;
		nbreClicSoda 		= 0;
		nbreClicCafeThe 	= 0;
		nbreClicConfiserie 	= 0;
		nbreClicEau 		= 0;
		nbreTotal			= 0;


		buttonMenu.setOnClickListener(listenerButtonAjoutResto);
		buttonCrepe.setOnClickListener(listenerButtonAjoutResto);
		buttonPlat.setOnClickListener(listenerButtonAjoutResto);
		buttonSoda.setOnClickListener(listenerButtonAjoutResto);
		buttonCafeThe.setOnClickListener(listenerButtonAjoutResto);
		buttonConfiserie.setOnClickListener(listenerButtonAjoutResto);
		buttonEau.setOnClickListener(listenerButtonAjoutResto);


		buttonSupprMenu.setOnClickListener(listenerButtonSupprResto);
		buttonSupprCrepe.setOnClickListener(listenerButtonSupprResto);
		buttonSupprPlat.setOnClickListener(listenerButtonSupprResto);
		buttonSupprSoda.setOnClickListener(listenerButtonSupprResto);
		buttonSupprCafeThe.setOnClickListener(listenerButtonSupprResto);
		buttonSupprConfiserie.setOnClickListener(listenerButtonSupprResto);
		buttonSupprEau.setOnClickListener(listenerButtonSupprResto);

		buttonAnnulerCommande.setOnClickListener(listenerButtonAnnulerCommande);
		buttonValiderCommande.setOnClickListener(listenerButtonValiderCommande);

	}

	private void resetCommande() {
		nbreClicMenu = 0;
		editTextMenu.setText(""+nbreClicMenu);

		nbreClicCrepe = 0;
		editTextCrepe.setText(""+nbreClicCrepe);

		nbreClicPlat = 0;
		editTextPlat.setText(""+nbreClicPlat);

		nbreClicSoda = 0;
		editTextSoda.setText(""+nbreClicSoda);

		nbreClicCafeThe = 0;
		editTextCafeThe.setText(""+nbreClicCafeThe);

		nbreClicConfiserie = 0;
		editTextConfiserie.setText(""+nbreClicConfiserie);

		nbreClicEau = 0;
		editTextEau.setText(""+nbreClicEau);

		nbreTotal = 0;
		editTextTotal.setText(""+nbreTotal);
	}

	private OnClickListener listenerButtonAjoutResto = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch(v.getId()) {
			case R.id.imageButtonMenu :
				nbreClicMenu++;
				editTextMenu.setText(""+nbreClicMenu);
				break;
			case R.id.imageButtonCrepe :
				nbreClicCrepe++;
				editTextCrepe.setText(""+nbreClicCrepe);
				break;
			case R.id.imageButtonPlat:
				nbreClicPlat++;
				editTextPlat.setText(""+nbreClicPlat);
				break;
			case R.id.imageButtonSoda:
				nbreClicSoda++;
				editTextSoda.setText(""+nbreClicSoda);
				break;
			case R.id.imageButtonCafeThe :
				nbreClicCafeThe++;
				editTextCafeThe.setText(""+nbreClicCafeThe);
				break;
			case R.id.imageButtonConfiserie:
				nbreClicConfiserie++;
				editTextConfiserie.setText(""+nbreClicConfiserie);
				break;
			case R.id.imageButtonEau:
				nbreClicEau++;
				editTextEau.setText(""+nbreClicEau);
				break;
			}
			nbreTotal = (nbreClicMenu*prixMenu)+(nbreClicCrepe*prixCrepe)
					+(nbreClicPlat*prixPlat)+(nbreClicSoda*prixSoda) 
					+(nbreClicCafeThe*prixCafeThe)+(nbreClicConfiserie*prixConfiserie)
					+(nbreClicEau*prixEau);
			editTextTotal.setText(""+nbreTotal);
		}
	};

	private OnClickListener listenerButtonSupprResto = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch(v.getId()) {
			case R.id.buttonSupprMenu :
				if(nbreClicMenu>0){
					nbreClicMenu--;
				}
				editTextMenu.setText(""+nbreClicMenu);
				break;
			case R.id.buttonSupprCrepe :
				if(nbreClicCrepe >0){
					nbreClicCrepe--;
				}
				editTextCrepe.setText(""+nbreClicCrepe);
				break;
			case R.id.buttonSupprPlat:
				if(nbreClicPlat>0){
					nbreClicPlat--;
				}
				editTextPlat.setText(""+nbreClicPlat);
				break;
			case R.id.buttonSupprSoda:
				if(nbreClicSoda>0){
					nbreClicPlat--;
				}
				editTextSoda.setText(""+nbreClicPlat);
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
			case R.id.buttonSupprEau:
				if(nbreClicEau>0){
					nbreClicEau--;
				}
				editTextEau.setText(""+nbreClicEau);
				break;
			}
			nbreTotal = (nbreClicMenu*prixMenu)+(nbreClicCrepe*prixCrepe)
					+(nbreClicPlat*prixPlat)+(nbreClicSoda*prixSoda) 
					+(nbreClicCafeThe*prixCafeThe)+(nbreClicConfiserie*prixConfiserie)
					+(nbreClicEau*prixEau);
			editTextTotal.setText(""+nbreTotal);
		}
	};

	private OnClickListener listenerButtonAnnulerCommande = new OnClickListener() {

		@Override
		public void onClick(View v) {
			resetCommande();
		}
	};

	private OnClickListener listenerButtonValiderCommande = new OnClickListener() {

		@Override
		public void onClick(View v) {
			creationAlertDialogMoyenDePaiement();
		}
	};

	
/* Choix modePaiment */
	
	public void creationAlertDialogMoyenDePaiement(){
		
		//On instancie notre layout en tant que View
	    LayoutInflater layoutMoyenDePaiement = LayoutInflater.from(RestauActivity.this);
	    final View viewAlertDialogMoyenDePaiement 	= layoutMoyenDePaiement.inflate(R.layout.activity_moyen_de_paiement, null);
		//Création de l'AlertDialog
        AlertDialog.Builder alertDialogMoyenDePaiement = new AlertDialog.Builder(RestauActivity.this);
        //On affecte la vue personnalisé que l'on a crée à notre AlertDialog
        alertDialogMoyenDePaiement.setView(viewAlertDialogMoyenDePaiement);
        //On donne un titre à l'AlertDialog
        alertDialogMoyenDePaiement.setTitle("Moyen de paiement");
        //On modifie l'icône de l'AlertDialog pour le fun ;)
        alertDialogMoyenDePaiement.setIcon(android.R.drawable.ic_dialog_alert);
        
        alertDialog = alertDialogMoyenDePaiement.create();
        alertDialog.show();
		
        buttonCB = (Button) viewAlertDialogMoyenDePaiement.findViewById(R.id.idButtonCB);
        buttonEspece = (Button) viewAlertDialogMoyenDePaiement.findViewById(R.id.idButtonEspece);
        buttonTickets = (Button) viewAlertDialogMoyenDePaiement.findViewById(R.id.idButtonTickets);
        
//        buttonCB.setOnClickListener(listenerButtonChoixPaiment);
//        buttonEspece.setOnClickListener(listenerButtonChoixPaiment);
//        buttonTickets.setOnClickListener(listenerButtonChoixPaiment);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.restau, menu);
		return true;
	}

}
