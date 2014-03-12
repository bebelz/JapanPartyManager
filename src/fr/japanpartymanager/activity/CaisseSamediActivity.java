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

public class CaisseSamediActivity extends Activity {

	//Déclaration des objets
	ImageButton buttonBilletPayantSamedi 		= null;
	ImageButton buttonBilletGratuitSamedi		= null;
	ImageButton buttonTombola	= null;
	ImageButton buttonPoster 	= null;
	ImageButton buttonTicketBoisson = null;
	ImageButton buttonTicketRepas   = null;
	
	Button buttonSupprBilletPayantSamedi 		= null;
	Button buttonSupprBilletGratuitSamedi 		= null;
	Button buttonSupprTombola 	= null;
	Button buttonSupprPoster		= null;
	Button buttonSupprTicketBoisson = null;
	Button buttonSupprTicketRepas   = null;
	
	Button buttonAnnulerCommande	= null;
	Button buttonValiderCommande 	= null;
	
	Button buttonCB					= null;
	Button buttonEspece             = null;
	Button buttonTickets            = null;
	Button buttonCheque             = null;
	
	EditText editTextBilletPayantSamedi 		= null;
	EditText editTextBilletGratuitSamedi 		= null;
	EditText editTextTombola		= null;
	EditText editTextPoster		= null;
	EditText editTextTicketBoisson  = null;
	EditText editTextTicketRepas    = null;
	EditText editTextTotal 			= null;
	
	TextView labelFoisPrixBilletPayantSamedi 		= null;
	TextView labelFoisPrixBilletGratuitSamedi 		= null;
	TextView labelFoisPrixTombola 	= null;
	TextView labelFoisPrixPoster 	= null;
	TextView labelFoisPrixTicketBoisson = null;
	TextView labelFoisPrixTicketRepas   = null;
	
	AlertDialog alertDialog       = null;
	
	//Variables
	int nbreClicBilletPayantSamedi;
	int nbreClicBilletGratuitSamedi;
	int nbreClicTombola;
	int nbreClicPoster;
	int nbreClicTicketBoisson;
	int nbreClicTicketRepas;
	double nbreTotal;
	
	double prixBilletPayantSamedi 	 = MainActivity.transacManager.getPrixProduit(10);
	double prixBilletGratuitSamedi 		 = MainActivity.transacManager.getPrixProduit(11);
	double prixTombola 	 = MainActivity.transacManager.getPrixProduit(12);
	double prixPoster	 = MainActivity.transacManager.getPrixProduit(13);
	double prixTicketBoisson = MainActivity.transacManager.getPrixProduit(8);
	double prixTicketRepas   = MainActivity.transacManager.getPrixProduit(9);

	//Initialisation de la vue
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_caisse_samedi);
		setTitle("Caisse Samedi");
		
		buttonBilletPayantSamedi 			= (ImageButton)findViewById(R.id.imageButtonBilletPayantSamedi);
        buttonBilletGratuitSamedi 			= (ImageButton)findViewById(R.id.imageButtonBilletGratuitSamedi);
        buttonTombola 		= (ImageButton) findViewById(R.id.imageButtonTombolaSamedi);
        buttonPoster 		= (ImageButton) findViewById(R.id.imageButtonPosterSamedi);
        buttonTicketBoisson     = (ImageButton) findViewById(R.id.imageButtonTicketBoissonSamedi);
        buttonTicketRepas       = (ImageButton) findViewById(R.id.imageButtonTicketRepasSamedi);
        
        buttonSupprBilletPayantSamedi 	 = (Button)findViewById(R.id.buttonSupprBilletPayantSamedi);
        buttonSupprBilletGratuitSamedi		 = (Button)findViewById(R.id.buttonSupprBilletGratuitSamedi);
        buttonSupprTombola 	 = (Button)findViewById(R.id.buttonSupprTombolaDimanche);
        buttonSupprPoster 	 = (Button)findViewById(R.id.buttonSupprPosterDimanche);
        buttonSupprTicketBoisson = (Button)findViewById(R.id.buttonSupprTicketBoissonSamedi);
        buttonSupprTicketRepas   = (Button)findViewById(R.id.buttonSupprTicketRepasSamedi);
        
        buttonAnnulerCommande	= (Button)findViewById(R.id.buttonAnnulerCommandeSamedi);
        buttonValiderCommande	= (Button)findViewById(R.id.buttonValiderCommandeSamedi);
        
        editTextBilletPayantSamedi 		= (EditText)findViewById(R.id.editTextTotalBilletPayantSamedi);
        editTextBilletGratuitSamedi 		= (EditText)findViewById(R.id.editTextTotalBilletGratuitSamedi);
        editTextTombola 		= (EditText)findViewById(R.id.editTextTotalTombolaDimanche);
        editTextPoster		= (EditText)findViewById(R.id.editTextTotalPosterDimanche);
        editTextTicketBoisson   = (EditText)findViewById(R.id.editTextTotalTicketBoissonSamedi);
        editTextTicketRepas     = (EditText)findViewById(R.id.editTextTotalTicketRepasSamedi);
        editTextTotal 			= (EditText)findViewById(R.id.editTextTotalSamedi);
        
        labelFoisPrixBilletPayantSamedi = (TextView)findViewById(R.id.labelFoisPrixBilletPayantSamedi);
        labelFoisPrixBilletPayantSamedi.setText("x "+prixBilletPayantSamedi+"€");
        
        labelFoisPrixBilletGratuitSamedi = (TextView)findViewById(R.id.labelFoisPrixBilletGratuitSamedi);
        labelFoisPrixBilletGratuitSamedi.setText("x "+prixBilletGratuitSamedi+"€");
        
        labelFoisPrixTombola = (TextView)findViewById(R.id.labelFoisPrixTombolaDimanche);
        labelFoisPrixTombola.setText("x "+prixTombola+"€");
        
        labelFoisPrixPoster = (TextView)findViewById(R.id.labelFoisPrixPosterDimanche);
        labelFoisPrixPoster.setText("x "+prixPoster+"€");
        
        labelFoisPrixTicketBoisson = (TextView)findViewById(R.id.labelFoisPrixTicketBoissonSamedi);
        labelFoisPrixTicketBoisson.setText("x "+prixTicketBoisson+"€");
        
        labelFoisPrixTicketRepas = (TextView)findViewById(R.id.labelFoisPrixTicketRepasSamedi);
        labelFoisPrixTicketRepas.setText("x "+prixTicketRepas+"€");
        
        nbreClicBilletPayantSamedi 	  = 0;
        nbreClicBilletGratuitSamedi 	  = 0;
        nbreClicTombola 	  = 0;
        nbreClicPoster 	  = 0;
        nbreClicTicketBoisson = 0;
        nbreClicTicketRepas   = 0;
        nbreTotal			  = 0;
        
        buttonBilletPayantSamedi.setOnClickListener(listenerButtonAjoutBar);
        buttonBilletGratuitSamedi.setOnClickListener(listenerButtonAjoutBar);
        buttonTombola.setOnClickListener(listenerButtonAjoutBar);
        buttonPoster.setOnClickListener(listenerButtonAjoutBar);
        buttonTicketBoisson.setOnClickListener(listenerButtonAjoutBar);
        buttonTicketRepas.setOnClickListener(listenerButtonAjoutBar);
        
        
        buttonSupprBilletPayantSamedi.setOnClickListener(listenerButtonSupprBar);
        buttonSupprBilletGratuitSamedi.setOnClickListener(listenerButtonSupprBar);
        buttonSupprTombola.setOnClickListener(listenerButtonSupprBar);
        buttonSupprPoster.setOnClickListener(listenerButtonSupprBar);
        buttonSupprTicketBoisson.setOnClickListener(listenerButtonSupprBar);
        buttonSupprTicketRepas.setOnClickListener(listenerButtonSupprBar);
        
        buttonAnnulerCommande.setOnClickListener(listenerButtonAnnulerCommande);
        buttonValiderCommande.setOnClickListener(listenerButtonValiderCommande);
	}
	
	private void resetCommande() {
		//mise à 0 du champ Sodas/Jus
		nbreClicBilletPayantSamedi = 0;
		editTextBilletPayantSamedi.setText(""+nbreClicBilletPayantSamedi);
		//mise à 0 du champ Cafe/The
		nbreClicBilletGratuitSamedi = 0;
		editTextBilletGratuitSamedi.setText(""+nbreClicBilletGratuitSamedi);
		//mise à 0 du champ Tombola
		nbreClicTombola = 0;
		editTextTombola.setText(""+nbreClicTombola);
		//mise à 0 du champ Poster
		nbreClicPoster = 0;
		editTextPoster.setText(""+nbreClicPoster);
		//
		nbreClicTicketBoisson = 0;
		editTextTicketBoisson.setText(""+nbreClicTicketBoisson);
		//
		nbreClicTicketRepas = 0;
		editTextTicketRepas.setText(""+nbreClicTicketRepas);
		//mise à 0 du champ Total
		nbreTotal = 0;
		editTextTotal.setText(""+nbreTotal);
	}
	
	private OnClickListener listenerButtonAjoutBar = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch(v.getId()) {
			case R.id.imageButtonBilletPayantSamedi :
				nbreClicBilletPayantSamedi++;
				editTextBilletPayantSamedi.setText(""+nbreClicBilletPayantSamedi);
				break;
			case R.id.imageButtonBilletGratuitSamedi :
				nbreClicBilletGratuitSamedi++;
				editTextBilletGratuitSamedi.setText(""+nbreClicBilletGratuitSamedi);
				break;
			case R.id.imageButtonTombolaSamedi:
				nbreClicTombola++;
				editTextTombola.setText(""+nbreClicTombola);
				break;
			case R.id.imageButtonPosterSamedi:
				nbreClicPoster++;
				editTextPoster.setText(""+nbreClicPoster);
				break;
			case R.id.imageButtonTicketBoissonSamedi:
				nbreClicTicketBoisson++;
				editTextTicketBoisson.setText(""+nbreClicTicketBoisson);
				break;
			case R.id.imageButtonTicketRepasSamedi:
				nbreClicTicketRepas++;
				editTextTicketRepas.setText(""+nbreClicTicketRepas);
				break;
			}
			nbreTotal = (nbreClicBilletPayantSamedi*prixBilletPayantSamedi)+(nbreClicBilletGratuitSamedi*prixBilletGratuitSamedi)
					+(nbreClicTombola*prixTombola)+(nbreClicPoster*prixPoster)
					+(nbreClicTicketBoisson*prixTicketBoisson)+(nbreClicTicketRepas*prixTicketRepas);
			editTextTotal.setText(""+nbreTotal);
		}
	};
	
	private OnClickListener listenerButtonSupprBar = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch(v.getId()) {
			case R.id.buttonSupprBilletPayantSamedi :
				if(nbreClicBilletPayantSamedi>0){
					nbreClicBilletPayantSamedi--;
				}
				editTextBilletPayantSamedi.setText(""+nbreClicBilletPayantSamedi);
				break;
			case R.id.buttonSupprBilletGratuitSamedi :
				if(nbreClicBilletGratuitSamedi >0){
					nbreClicBilletGratuitSamedi--;
				}
				editTextBilletGratuitSamedi.setText(""+nbreClicBilletGratuitSamedi);
				break;
			case R.id.buttonSupprTombolaDimanche:
				if(nbreClicTombola>0){
					nbreClicTombola--;
				}
				editTextTombola.setText(""+nbreClicTombola);
				break;
			case R.id.buttonSupprPosterDimanche:
				if(nbreClicPoster>0){
					nbreClicPoster--;
				}
				editTextPoster.setText(""+nbreClicPoster);
				break;
			case R.id.buttonSupprTicketBoissonSamedi:
				if(nbreClicTicketBoisson>0){
					nbreClicTicketBoisson--;
				}
				editTextTicketBoisson.setText(""+nbreClicTicketBoisson);
				break;
			case R.id.buttonSupprTicketRepasSamedi:
				if(nbreClicTicketRepas>0){
					nbreClicTicketRepas--;
				}
				editTextTicketRepas.setText(""+nbreClicTicketRepas);
				break;
		}
			nbreTotal = (nbreClicBilletPayantSamedi*prixBilletPayantSamedi)+(nbreClicBilletGratuitSamedi*prixBilletGratuitSamedi)
					+(nbreClicTombola*prixTombola)+(nbreClicPoster*prixPoster)
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
	    LayoutInflater layoutMoyenDePaiement = LayoutInflater.from(CaisseSamediActivity.this);
	    final View viewAlertDialogMoyenDePaiement 	= layoutMoyenDePaiement.inflate(R.layout.activity_moyen_de_paiement, null);
		//Création de l'AlertDialog
        AlertDialog.Builder alertDialogMoyenDePaiement = new AlertDialog.Builder(CaisseSamediActivity.this);
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
			if(nbreClicBilletPayantSamedi > 0) {
				MainActivity.transacManager.venteProduit(10, nbreClicBilletPayantSamedi, modePaiment);
			}
			
			if(nbreClicBilletGratuitSamedi > 0) {
				MainActivity.transacManager.venteProduit(11, nbreClicBilletGratuitSamedi, modePaiment);
			}
			
			if(nbreClicTombola > 0) {
				MainActivity.transacManager.venteProduit(12, nbreClicTombola, modePaiment);
			}
			
			if(nbreClicPoster > 0) {
				MainActivity.transacManager.venteProduit(13, nbreClicPoster, modePaiment);
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
