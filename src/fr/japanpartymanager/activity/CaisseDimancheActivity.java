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

public class CaisseDimancheActivity extends Activity {

	//Déclaration des objets
	ImageButton buttonBilletPayantDimanche 		= null;
	ImageButton buttonBilletGratuitDimanche		= null;
	ImageButton buttonTombola	= null;
	ImageButton buttonPoster 	= null;
	ImageButton buttonTicketBoisson = null;
	ImageButton buttonTicketRepas   = null;
	
	Button buttonSupprBilletPayantDimanche 		= null;
	Button buttonSupprBilletGratuitDimanche 		= null;
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
	Button buttonRetour             = null;
	
	EditText editTextBilletPayantDimanche 		= null;
	EditText editTextBilletGratuitDimanche 		= null;
	EditText editTextTombola		= null;
	EditText editTextPoster		= null;
	EditText editTextTicketBoisson  = null;
	EditText editTextTicketRepas    = null;
	EditText editTextTotal 			= null;
	
	TextView labelFoisPrixBilletPayantDimanche 		= null;
	TextView labelFoisPrixBilletGratuitDimanche 		= null;
	TextView labelFoisPrixTombola 	= null;
	TextView labelFoisPrixPoster 	= null;
	TextView labelFoisPrixTicketBoisson = null;
	TextView labelFoisPrixTicketRepas   = null;
	
	AlertDialog alertDialog       = null;
	
	//Variables
	int nbreClicBilletPayantDimanche;
	int nbreClicBilletGratuitDimanche;
	int nbreClicTombola;
	int nbreClicPoster;
	int nbreClicTicketBoisson;
	int nbreClicTicketRepas;
	double nbreTotal;
	
	double prixBilletPayantDimanche 	 = MainActivity.transacManager.getPrixProduit(14);
	double prixBilletGratuitDimanche 		 = MainActivity.transacManager.getPrixProduit(15);
	double prixTombola 	 = MainActivity.transacManager.getPrixProduit(12);
	double prixPoster	 = MainActivity.transacManager.getPrixProduit(13);
	double prixTicketBoisson = MainActivity.transacManager.getPrixProduit(8);
	double prixTicketRepas   = MainActivity.transacManager.getPrixProduit(9);

	//Initialisation de la vue
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_caisse_dimanche);
		setTitle("Caisse Dimanche");
		
		buttonBilletPayantDimanche 			= (ImageButton)findViewById(R.id.imageButtonBilletPayantDimanche);
        buttonBilletGratuitDimanche 			= (ImageButton)findViewById(R.id.imageButtonBilletGratuitDimanche);
        buttonTombola 		= (ImageButton) findViewById(R.id.imageButtonTombolaDimanche);
        buttonPoster 		= (ImageButton) findViewById(R.id.imageButtonPosterDimanche);
        buttonTicketBoisson     = (ImageButton) findViewById(R.id.imageButtonTicketBoissonDimanche);
        buttonTicketRepas       = (ImageButton) findViewById(R.id.imageButtonTicketRepasDimanche);
        
        buttonSupprBilletPayantDimanche 	 = (Button)findViewById(R.id.buttonSupprBilletPayantDimanche);
        buttonSupprBilletGratuitDimanche		 = (Button)findViewById(R.id.buttonSupprBilletGratuitDimanche);
        buttonSupprTombola 	 = (Button)findViewById(R.id.buttonSupprTombolaDimanche);
        buttonSupprPoster 	 = (Button)findViewById(R.id.buttonSupprPosterDimanche);
        buttonSupprTicketBoisson = (Button)findViewById(R.id.buttonSupprTicketBoissonDimanche);
        buttonSupprTicketRepas   = (Button)findViewById(R.id.buttonSupprTicketRepasDimanche);
        
        buttonAnnulerCommande	= (Button)findViewById(R.id.buttonAnnulerCommandeDimanche);
        buttonValiderCommande	= (Button)findViewById(R.id.buttonValiderCommandeDimanche);
        
        editTextBilletPayantDimanche 		= (EditText)findViewById(R.id.editTextTotalBilletPayantDimanche);
        editTextBilletGratuitDimanche 		= (EditText)findViewById(R.id.editTextTotalBilletGratuitDimanche);
        editTextTombola 		= (EditText)findViewById(R.id.editTextTotalTombolaDimanche);
        editTextPoster		= (EditText)findViewById(R.id.editTextTotalPosterDimanche);
        editTextTicketBoisson   = (EditText)findViewById(R.id.editTextTotalTicketBoissonDimanche);
        editTextTicketRepas     = (EditText)findViewById(R.id.editTextTotalTicketRepasDimanche);
        editTextTotal 			= (EditText)findViewById(R.id.editTextTotalDimanche);
        
        labelFoisPrixBilletPayantDimanche = (TextView)findViewById(R.id.labelFoisPrixBilletPayantDimanche);
        labelFoisPrixBilletPayantDimanche.setText("x "+prixBilletPayantDimanche+"€");
        
        labelFoisPrixBilletGratuitDimanche = (TextView)findViewById(R.id.labelFoisPrixBilletGratuitDimanche);
        labelFoisPrixBilletGratuitDimanche.setText("x "+prixBilletGratuitDimanche+"€");
        
        labelFoisPrixTombola = (TextView)findViewById(R.id.labelFoisPrixTombolaDimanche);
        labelFoisPrixTombola.setText("x "+prixTombola+"€");
        
        labelFoisPrixPoster = (TextView)findViewById(R.id.labelFoisPrixPosterDimanche);
        labelFoisPrixPoster.setText("x "+prixPoster+"€");
        
        labelFoisPrixTicketBoisson = (TextView)findViewById(R.id.labelFoisPrixTicketBoissonDimanche);
        labelFoisPrixTicketBoisson.setText("x "+prixTicketBoisson+"€");
        
        labelFoisPrixTicketRepas = (TextView)findViewById(R.id.labelFoisPrixTicketRepasDimanche);
        labelFoisPrixTicketRepas.setText("x "+prixTicketRepas+"€");
        
        nbreClicBilletPayantDimanche 	  = 0;
        nbreClicBilletGratuitDimanche 	  = 0;
        nbreClicTombola 	  = 0;
        nbreClicPoster 	  = 0;
        nbreClicTicketBoisson = 0;
        nbreClicTicketRepas   = 0;
        nbreTotal			  = 0;
        
        buttonBilletPayantDimanche.setOnClickListener(listenerButtonAjoutBar);
        buttonBilletGratuitDimanche.setOnClickListener(listenerButtonAjoutBar);
        buttonTombola.setOnClickListener(listenerButtonAjoutBar);
        buttonPoster.setOnClickListener(listenerButtonAjoutBar);
        buttonTicketBoisson.setOnClickListener(listenerButtonAjoutBar);
        buttonTicketRepas.setOnClickListener(listenerButtonAjoutBar);
        
        
        buttonSupprBilletPayantDimanche.setOnClickListener(listenerButtonSupprBar);
        buttonSupprBilletGratuitDimanche.setOnClickListener(listenerButtonSupprBar);
        buttonSupprTombola.setOnClickListener(listenerButtonSupprBar);
        buttonSupprPoster.setOnClickListener(listenerButtonSupprBar);
        buttonSupprTicketBoisson.setOnClickListener(listenerButtonSupprBar);
        buttonSupprTicketRepas.setOnClickListener(listenerButtonSupprBar);
        
        buttonAnnulerCommande.setOnClickListener(listenerButtonAnnulerCommande);
        buttonValiderCommande.setOnClickListener(listenerButtonValiderCommande);
	}
	
	private void resetCommande() {
		//mise à 0 du champ Sodas/Jus
		nbreClicBilletPayantDimanche = 0;
		editTextBilletPayantDimanche.setText(""+nbreClicBilletPayantDimanche);
		//mise à 0 du champ Cafe/The
		nbreClicBilletGratuitDimanche = 0;
		editTextBilletGratuitDimanche.setText(""+nbreClicBilletGratuitDimanche);
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
			case R.id.imageButtonBilletPayantDimanche :
				nbreClicBilletPayantDimanche++;
				editTextBilletPayantDimanche.setText(""+nbreClicBilletPayantDimanche);
				break;
			case R.id.imageButtonBilletGratuitDimanche :
				nbreClicBilletGratuitDimanche++;
				editTextBilletGratuitDimanche.setText(""+nbreClicBilletGratuitDimanche);
				break;
			case R.id.imageButtonTombolaDimanche:
				nbreClicTombola++;
				editTextTombola.setText(""+nbreClicTombola);
				break;
			case R.id.imageButtonPosterDimanche:
				nbreClicPoster++;
				editTextPoster.setText(""+nbreClicPoster);
				break;
			case R.id.imageButtonTicketBoissonDimanche:
				nbreClicTicketBoisson++;
				editTextTicketBoisson.setText(""+nbreClicTicketBoisson);
				break;
			case R.id.imageButtonTicketRepasDimanche:
				nbreClicTicketRepas++;
				editTextTicketRepas.setText(""+nbreClicTicketRepas);
				break;
			}
			nbreTotal = (nbreClicBilletPayantDimanche*prixBilletPayantDimanche)+(nbreClicBilletGratuitDimanche*prixBilletGratuitDimanche)
					+(nbreClicTombola*prixTombola)+(nbreClicPoster*prixPoster)
					+(nbreClicTicketBoisson*prixTicketBoisson)+(nbreClicTicketRepas*prixTicketRepas);
			editTextTotal.setText(""+nbreTotal);
		}
	};
	
	private OnClickListener listenerButtonSupprBar = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch(v.getId()) {
			case R.id.buttonSupprBilletPayantDimanche :
				if(nbreClicBilletPayantDimanche>0){
					nbreClicBilletPayantDimanche--;
				}
				editTextBilletPayantDimanche.setText(""+nbreClicBilletPayantDimanche);
				break;
			case R.id.buttonSupprBilletGratuitDimanche :
				if(nbreClicBilletGratuitDimanche >0){
					nbreClicBilletGratuitDimanche--;
				}
				editTextBilletGratuitDimanche.setText(""+nbreClicBilletGratuitDimanche);
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
			case R.id.buttonSupprTicketBoissonDimanche:
				if(nbreClicTicketBoisson>0){
					nbreClicTicketBoisson--;
				}
				editTextTicketBoisson.setText(""+nbreClicTicketBoisson);
				break;
			case R.id.buttonSupprTicketRepasDimanche:
				if(nbreClicTicketRepas>0){
					nbreClicTicketRepas--;
				}
				editTextTicketRepas.setText(""+nbreClicTicketRepas);
				break;
		}
			nbreTotal = (nbreClicBilletPayantDimanche*prixBilletPayantDimanche)+(nbreClicBilletGratuitDimanche*prixBilletGratuitDimanche)
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
	    LayoutInflater layoutMoyenDePaiement = LayoutInflater.from(CaisseDimancheActivity.this);
	    final View viewAlertDialogMoyenDePaiement 	= layoutMoyenDePaiement.inflate(R.layout.activity_moyen_de_paiement, null);
		//Création de l'AlertDialog
        AlertDialog.Builder alertDialogMoyenDePaiement = new AlertDialog.Builder(CaisseDimancheActivity.this);
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
        buttonRetour = (Button)viewAlertDialogMoyenDePaiement.findViewById(R.id.buttonRetour);
        
        buttonCB.setOnClickListener(listenerButtonChoixPaiment);
        buttonEspece.setOnClickListener(listenerButtonChoixPaiment);
        buttonTickets.setOnClickListener(listenerButtonChoixPaiment);
        buttonCheque.setOnClickListener(listenerButtonChoixPaiment);
        
        buttonRetour.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				alertDialog.cancel();
			}
		});
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
			if(nbreClicBilletPayantDimanche > 0) {
				MainActivity.transacManager.venteProduit(14, nbreClicBilletPayantDimanche, modePaiment);
			}
			
			if(nbreClicBilletGratuitDimanche > 0) {
				MainActivity.transacManager.venteProduit(15, nbreClicBilletGratuitDimanche, modePaiment);
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
