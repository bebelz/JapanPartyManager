package fr.japanpartymanager.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import fr.japanpartymanager.R;

public class RestauActivity extends Activity {

	//Déclaration des objets
	ImageButton buttonCrepe			= null;
	ImageButton buttonPlat			= null;
	ImageButton buttonSoda 			= null;
	ImageButton buttonCafeThe		= null;
	ImageButton buttonConfiserie 	= null;
	ImageButton buttonTicketBoisson = null;
	ImageButton buttonTicketRepas   = null;

	Button buttonSupprCrepe 		= null;
	Button buttonSupprPlat		 	= null;
	Button buttonSupprSoda			= null;
	Button buttonSupprCafeThe 		= null;
	Button buttonSupprConfiserie	= null;
	Button buttonSupprTicketBoisson = null;
	Button buttonSupprTicketRepas   = null;
	
	Button buttonAnnulerCommande	= null;
	Button buttonValiderCommande 	= null;
	
	Button buttonCB					= null;
	Button buttonEspece             = null;
	Button buttonTickets            = null;
	Button buttonCheque             = null;

	EditText editTextCrepe 			= null;
	EditText editTextPlat			= null;
	EditText editTextSoda			= null;
	EditText editTextCafeThe		= null;
	EditText editTextConfiserie		= null;
	EditText editTextTicketBoisson  = null;
	EditText editTextTicketRepas    = null;
	EditText editTextTotal			= null;

	TextView labelFoisPrixCrepe		    = null;
	TextView labelFoisPrixPlat		    = null;
	TextView labelFoisPrixSoda 		    = null;
	TextView labelFoisPrixCafeThe	    = null;
	TextView labelFoisPrixConfiserie    = null;
	TextView labelFoisPrixTicketBoisson = null;
	TextView labelFoisPrixTicketRepas   = null;

	AlertDialog alertDialog       	= null;

	//Variables
	int nbreClicCrepe;
	int nbreClicPlat;
	int nbreClicSoda;
	int nbreClicCafeThe;
	int nbreClicConfiserie;
	int nbreClicTicketBoisson;
	int nbreClicTicketRepas;
	double nbreTotal;

	double prixSoda 		 = MainActivity.transacManager.getPrixProduit(0);
	double prixCafeThe 		 = MainActivity.transacManager.getPrixProduit(1);
	double prixConfiserie 	 = MainActivity.transacManager.getPrixProduit(2);
	double prixCrepe 		 = MainActivity.transacManager.getPrixProduit(5);
	double prixPlat 		 = MainActivity.transacManager.getPrixProduit(6);
	double prixTicketBoisson = MainActivity.transacManager.getPrixProduit(8);
	double prixTicketRepas   = MainActivity.transacManager.getPrixProduit(9);

	//Initialisation de la vue
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_restau);
		setTitle("Restauration");

		buttonCrepe 			= (ImageButton)findViewById(R.id.imageButtonCrepe);
		buttonPlat 				= (ImageButton)findViewById(R.id.imageButtonPlat);
		buttonSoda				= (ImageButton)findViewById(R.id.imageButtonSoda);
		buttonCafeThe 			= (ImageButton)findViewById(R.id.imageButtonCafeThe);
		buttonConfiserie 		= (ImageButton)findViewById(R.id.imageButtonConfiserie);
		buttonTicketBoisson     = (ImageButton)findViewById(R.id.imageButtonTicketBoissonRestau);
		buttonTicketRepas       = (ImageButton)findViewById(R.id.imageButtonTicketRepasRestau);

		buttonSupprCrepe		 = (Button)findViewById(R.id.buttonSupprCrepe);
		buttonSupprPlat 		 = (Button)findViewById(R.id.buttonSupprPlat);
		buttonSupprSoda 		 = (Button)findViewById(R.id.buttonSupprSoda);
		buttonSupprCafeThe		 = (Button)findViewById(R.id.buttonSupprCafeThe);
		buttonSupprConfiserie	 = (Button)findViewById(R.id.buttonSupprConfiserie);
		buttonSupprTicketBoisson = (Button)findViewById(R.id.buttonSupprTicketBoissonRestau);
		buttonSupprTicketRepas   = (Button)findViewById(R.id.buttonSupprTicketRepasRestau);

		buttonAnnulerCommande	= (Button)findViewById(R.id.buttonAnnulerCommande);
		buttonValiderCommande	= (Button)findViewById(R.id.buttonValiderCommande);

		editTextCrepe 			= (EditText)findViewById(R.id.editTextTotalCrepe);
		editTextPlat 			= (EditText)findViewById(R.id.editTextTotalPlat);
		editTextSoda			= (EditText)findViewById(R.id.editTextTotalSoda);
		editTextCafeThe 		= (EditText)findViewById(R.id.editTextTotalCafeThe);
		editTextConfiserie 		= (EditText)findViewById(R.id.editTextTotalConfiserie);
		editTextTicketBoisson   = (EditText)findViewById(R.id.editTextTotalTicketBoissonRestau);
		editTextTicketRepas     = (EditText)findViewById(R.id.editTextTotalTicketRepasRestau);
		editTextTotal 			= (EditText)findViewById(R.id.editTextTotal);

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

		labelFoisPrixTicketBoisson = (TextView)findViewById(R.id.labelFoisPrixTicketBoissonRestau);
		labelFoisPrixTicketBoisson.setText("x "+prixTicketBoisson+"€");
		
		labelFoisPrixTicketRepas = (TextView)findViewById(R.id.labelFoisPrixTicketRepasRestau);
		labelFoisPrixTicketRepas.setText("x "+prixTicketRepas+"€");
		
		nbreClicCrepe 		  = 0;
		nbreClicPlat 		  = 0;
		nbreClicSoda 		  = 0;
		nbreClicCafeThe 	  = 0;
		nbreClicConfiserie 	  = 0;
		nbreClicTicketBoisson = 0;
		nbreClicTicketRepas   = 0;
		nbreTotal			  = 0;

		buttonCrepe.setOnClickListener(listenerButtonAjoutResto);
		buttonPlat.setOnClickListener(listenerButtonAjoutResto);
		buttonSoda.setOnClickListener(listenerButtonAjoutResto);
		buttonCafeThe.setOnClickListener(listenerButtonAjoutResto);
		buttonConfiserie.setOnClickListener(listenerButtonAjoutResto);
		buttonTicketBoisson.setOnClickListener(listenerButtonAjoutResto);
		buttonTicketRepas.setOnClickListener(listenerButtonAjoutResto);

		buttonSupprCrepe.setOnClickListener(listenerButtonSupprResto);
		buttonSupprPlat.setOnClickListener(listenerButtonSupprResto);
		buttonSupprSoda.setOnClickListener(listenerButtonSupprResto);
		buttonSupprCafeThe.setOnClickListener(listenerButtonSupprResto);
		buttonSupprConfiserie.setOnClickListener(listenerButtonSupprResto);
		buttonSupprTicketBoisson.setOnClickListener(listenerButtonSupprResto);
		buttonSupprTicketRepas.setOnClickListener(listenerButtonSupprResto);

		buttonAnnulerCommande.setOnClickListener(listenerButtonAnnulerCommande);
		buttonValiderCommande.setOnClickListener(listenerButtonValiderCommande);

	}

	private void resetCommande() {
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

		nbreClicTicketBoisson = 0;
		editTextTicketBoisson.setText(""+nbreClicTicketBoisson);
		
		nbreClicTicketRepas = 0;
		editTextTicketRepas.setText(""+nbreClicTicketRepas);

		nbreTotal = 0;
		editTextTotal.setText(""+nbreTotal);
	}

	private OnClickListener listenerButtonAjoutResto = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch(v.getId()) {
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
			case R.id.imageButtonTicketBoissonRestau:
				nbreClicTicketBoisson++;
				editTextTicketBoisson.setText(""+nbreClicTicketBoisson);
				break;
			case R.id.imageButtonTicketRepasRestau:
				nbreClicTicketRepas++;
				editTextTicketRepas.setText(""+nbreClicTicketRepas);
				break;
			}
			nbreTotal = (nbreClicCrepe*prixCrepe)+(nbreClicPlat*prixPlat)
					+(nbreClicSoda*prixSoda)+(nbreClicCafeThe*prixCafeThe)+(nbreClicConfiserie*prixConfiserie)
					+(nbreClicTicketBoisson*prixTicketBoisson)+(nbreClicTicketRepas*prixTicketRepas);
			editTextTotal.setText(""+nbreTotal);
		}
	};

	private OnClickListener listenerButtonSupprResto = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch(v.getId()) {
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
					nbreClicSoda--;
				}
				editTextSoda.setText(""+nbreClicSoda);
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
			case R.id.buttonSupprTicketBoissonRestau:
				if(nbreClicTicketBoisson>0){
					nbreClicTicketBoisson--;
				}
				editTextTicketBoisson.setText(""+nbreClicTicketBoisson);
				break;
			case R.id.buttonSupprTicketRepasRestau:
				if(nbreClicTicketRepas>0){
					nbreClicTicketRepas--;
				}
				editTextTicketRepas.setText(""+nbreClicTicketRepas);
				break;
			}
			nbreTotal = (nbreClicCrepe*prixCrepe)
					+(nbreClicPlat*prixPlat)+(nbreClicSoda*prixSoda) 
					+(nbreClicCafeThe*prixCafeThe)+(nbreClicConfiserie*prixConfiserie)
					+(nbreClicTicketBoisson*prixTicketBoisson)+(nbreClicTicketRepas*prixTicketRepas);
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
        buttonCheque = (Button) viewAlertDialogMoyenDePaiement.findViewById(R.id.idButtonCheque);
        
        buttonCB.setOnClickListener(listenerButtonChoixPaiment);
        buttonEspece.setOnClickListener(listenerButtonChoixPaiment);
        buttonTickets.setOnClickListener(listenerButtonChoixPaiment);
        buttonCheque.setOnClickListener(listenerButtonChoixPaiment);
	}
	
private OnClickListener listenerButtonChoixPaiment = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			/* On fixe le moyen de paiment selon le bouton choisi */
			int modePaiment = 0;
			switch(v.getId()) {
			case R.id.idButtonCB :
				modePaiment = 0;
				break;
				
			case R.id.idButtonEspece :
				modePaiment = 1;
				break;
				
			case R.id.idButtonTickets :
				modePaiment = 2;
				break;
				
			case R.id.idButtonCheque :
				modePaiment = 3;
				break;
			}
			
			/* On stocke les données en base */
			if(nbreClicCrepe > 0) {
				MainActivity.transacManager.venteProduit(5, nbreClicCrepe, modePaiment);
			}
			
			if(nbreClicPlat >0) {
				MainActivity.transacManager.venteProduit(6, nbreClicPlat, modePaiment);
			}
			
			if(nbreClicSoda > 0) {
				MainActivity.transacManager.venteProduit(0, nbreClicSoda, modePaiment);
			}
			
			if(nbreClicCafeThe > 0) {
				MainActivity.transacManager.venteProduit(1, nbreClicCafeThe, modePaiment);
			}
			
			if(nbreClicConfiserie > 0) {
				MainActivity.transacManager.venteProduit(2, nbreClicConfiserie, modePaiment);
			}
			
			if(nbreClicTicketBoisson > 0) {
				MainActivity.transacManager.venteProduit(8, nbreClicTicketBoisson, modePaiment);
			}
			
			if(nbreClicTicketRepas > 0) {
				MainActivity.transacManager.venteProduit(9, nbreClicTicketRepas, modePaiment);
			}
			
			/* On remet l'affichage à zéro et on ferme la fenêtre */
			resetCommande();
			Toast.makeText(getApplicationContext(), "Commande Enregistrée ! ", Toast.LENGTH_SHORT).show();
			alertDialog.cancel();
	    }
	};
}
