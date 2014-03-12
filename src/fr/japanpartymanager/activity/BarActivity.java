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

public class BarActivity extends Activity {

	//Déclaration des objets
	ImageButton buttonSodasJus 		= null;
	ImageButton buttonCafeThe		= null;
	ImageButton buttonConfiserie	= null;
	ImageButton buttonBubbleTea 	= null;
	ImageButton buttonTicketBoisson = null;
	ImageButton buttonTicketRepas   = null;
	
	Button buttonSupprSodasJus 		= null;
	Button buttonSupprCafeThe 		= null;
	Button buttonSupprConfiserie 	= null;
	Button buttonSupprBubbleTea		= null;
	Button buttonSupprTicketBoisson = null;
	Button buttonSupprTicketRepas   = null;
	
	Button buttonAnnulerCommande	= null;
	Button buttonValiderCommande 	= null;
	
	Button buttonCB					= null;
	Button buttonEspece             = null;
	Button buttonTickets            = null;
	Button buttonCheque             = null;
	
	EditText editTextSodasJus 		= null;
	EditText editTextCafeThe 		= null;
	EditText editTextConfiserie		= null;
	EditText editTextBubbleTea		= null;
	EditText editTextTicketBoisson  = null;
	EditText editTextTicketRepas    = null;
	EditText editTextTotal 			= null;
	
	TextView labelFoisPrixSodasJus 		= null;
	TextView labelFoisPrixCafeThe 		= null;
	TextView labelFoisPrixConfiserie 	= null;
	TextView labelFoisPrixBubbleTea 	= null;
	TextView labelFoisPrixTicketBoisson = null;
	TextView labelFoisPrixTicketRepas   = null;
	
	AlertDialog alertDialog       = null;
	
	//Variables
	int nbreClicSodasJus;
	int nbreClicCafeThe;
	int nbreClicConfiserie;
	int nbreClicBubbleTea;
	int nbreClicTicketBoisson;
	int nbreClicTicketRepas;
	double nbreTotal;
	
	double prixSodasJus 	 = MainActivity.transacManager.getPrixProduit(0);
	double prixCafeThe 		 = MainActivity.transacManager.getPrixProduit(1);
	double prixConfiserie 	 = MainActivity.transacManager.getPrixProduit(2);
	double prixBubbleTea	 = MainActivity.transacManager.getPrixProduit(3);
	double prixTicketBoisson = MainActivity.transacManager.getPrixProduit(8);
	double prixTicketRepas   = MainActivity.transacManager.getPrixProduit(9);

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
        buttonTicketBoisson     = (ImageButton) findViewById(R.id.imageButtonTicketBoissonBar);
        buttonTicketRepas       = (ImageButton) findViewById(R.id.imageButtonTicketRepasBar);
        
        buttonSupprSodasJus 	 = (Button)findViewById(R.id.buttonSupprSodasJus);
        buttonSupprCafeThe		 = (Button)findViewById(R.id.buttonSupprCafeThe);
        buttonSupprConfiserie 	 = (Button)findViewById(R.id.buttonSupprConfiserie);
        buttonSupprBubbleTea 	 = (Button)findViewById(R.id.buttonSupprBubbleTea);
        buttonSupprTicketBoisson = (Button)findViewById(R.id.buttonSupprTicketBoissonSamedi);
        buttonSupprTicketRepas   = (Button)findViewById(R.id.buttonSupprTicketRepasSamedi);
        
        buttonAnnulerCommande	= (Button)findViewById(R.id.buttonAnnulerCommandeSamedi);
        buttonValiderCommande	= (Button)findViewById(R.id.buttonValiderCommandeSamedi);
        
        editTextSodasJus 		= (EditText)findViewById(R.id.editTextTotalBilletPayantSamedi);
        editTextCafeThe 		= (EditText)findViewById(R.id.editTextTotalCafeThe);
        editTextConfiserie 		= (EditText)findViewById(R.id.editTextTotalConfiserie);
        editTextBubbleTea		= (EditText)findViewById(R.id.editTextTotalBubbleTea);
        editTextTicketBoisson   = (EditText)findViewById(R.id.editTextTotalTicketBoissonSamedi);
        editTextTicketRepas     = (EditText)findViewById(R.id.editTextTotalTicketRepasSamedi);
        editTextTotal 			= (EditText)findViewById(R.id.editTextTotalSamedi);
        
        labelFoisPrixSodasJus = (TextView)findViewById(R.id.labelFoisPrixSodasJus);
        labelFoisPrixSodasJus.setText("x "+prixSodasJus+"€");
        
        labelFoisPrixCafeThe = (TextView)findViewById(R.id.labelFoisPrixCafeThe);
        labelFoisPrixCafeThe.setText("x "+prixCafeThe+"€");
        
        labelFoisPrixConfiserie = (TextView)findViewById(R.id.labelFoisPrixConfiserie);
        labelFoisPrixConfiserie.setText("x "+prixConfiserie+"€");
        
        labelFoisPrixBubbleTea = (TextView)findViewById(R.id.labelFoisPrixBubbleTea);
        labelFoisPrixBubbleTea.setText("x "+prixBubbleTea+"€");
        
        labelFoisPrixTicketBoisson = (TextView)findViewById(R.id.labelFoisPrixTicketBoissonSamedi);
        labelFoisPrixTicketBoisson.setText("x "+prixTicketBoisson+"€");
        
        labelFoisPrixTicketRepas = (TextView)findViewById(R.id.labelFoisPrixTicketRepasSamedi);
        labelFoisPrixTicketRepas.setText("x "+prixTicketRepas+"€");
        
        nbreClicSodasJus 	  = 0;
        nbreClicCafeThe 	  = 0;
        nbreClicConfiserie 	  = 0;
        nbreClicBubbleTea 	  = 0;
        nbreClicTicketBoisson = 0;
        nbreClicTicketRepas   = 0;
        nbreTotal			  = 0;
        
        buttonSodasJus.setOnClickListener(listenerButtonAjoutBar);
        buttonCafeThe.setOnClickListener(listenerButtonAjoutBar);
        buttonConfiserie.setOnClickListener(listenerButtonAjoutBar);
        buttonBubbleTea.setOnClickListener(listenerButtonAjoutBar);
        buttonTicketBoisson.setOnClickListener(listenerButtonAjoutBar);
        buttonTicketRepas.setOnClickListener(listenerButtonAjoutBar);
        
        
        buttonSupprSodasJus.setOnClickListener(listenerButtonSupprBar);
        buttonSupprCafeThe.setOnClickListener(listenerButtonSupprBar);
        buttonSupprConfiserie.setOnClickListener(listenerButtonSupprBar);
        buttonSupprBubbleTea.setOnClickListener(listenerButtonSupprBar);
        buttonSupprTicketBoisson.setOnClickListener(listenerButtonSupprBar);
        buttonSupprTicketRepas.setOnClickListener(listenerButtonSupprBar);
        
        buttonAnnulerCommande.setOnClickListener(listenerButtonAnnulerCommande);
        buttonValiderCommande.setOnClickListener(listenerButtonValiderCommande);
	}
	
	private void resetCommande() {
		//mise à 0 du champ Sodas/Jus
		nbreClicSodasJus = 0;
		editTextSodasJus.setText(""+nbreClicSodasJus);
		//mise à 0 du champ Cafe/The
		nbreClicCafeThe = 0;
		editTextCafeThe.setText(""+nbreClicCafeThe);
		//mise à 0 du champ Confiserie
		nbreClicConfiserie = 0;
		editTextConfiserie.setText(""+nbreClicConfiserie);
		//mise à 0 du champ BubbleTea
		nbreClicBubbleTea = 0;
		editTextBubbleTea.setText(""+nbreClicBubbleTea);
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
			case R.id.imageButtonTicketBoissonBar:
				nbreClicTicketBoisson++;
				editTextTicketBoisson.setText(""+nbreClicTicketBoisson);
				break;
			case R.id.imageButtonTicketRepasBar:
				nbreClicTicketRepas++;
				editTextTicketRepas.setText(""+nbreClicTicketRepas);
				break;
			}
			nbreTotal = (nbreClicSodasJus*prixSodasJus)+(nbreClicCafeThe*prixCafeThe)
					+(nbreClicConfiserie*prixConfiserie)+(nbreClicBubbleTea*prixBubbleTea)
					+(nbreClicTicketBoisson*prixTicketBoisson)+(nbreClicTicketRepas*prixTicketRepas);
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
			nbreTotal = (nbreClicSodasJus*prixSodasJus)+(nbreClicCafeThe*prixCafeThe)
					+(nbreClicConfiserie*prixConfiserie)+(nbreClicBubbleTea*prixBubbleTea)
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
	    LayoutInflater layoutMoyenDePaiement = LayoutInflater.from(BarActivity.this);
	    final View viewAlertDialogMoyenDePaiement 	= layoutMoyenDePaiement.inflate(R.layout.activity_moyen_de_paiement, null);
		//Création de l'AlertDialog
        AlertDialog.Builder alertDialogMoyenDePaiement = new AlertDialog.Builder(BarActivity.this);
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
			if(nbreClicSodasJus > 0) {
				MainActivity.transacManager.venteProduit(0, nbreClicSodasJus, modePaiment);
			}
			
			if(nbreClicCafeThe > 0) {
				MainActivity.transacManager.venteProduit(1, nbreClicCafeThe, modePaiment);
			}
			
			if(nbreClicConfiserie > 0) {
				MainActivity.transacManager.venteProduit(2, nbreClicConfiserie, modePaiment);
			}
			
			if(nbreClicBubbleTea > 0) {
				MainActivity.transacManager.venteProduit(3, nbreClicBubbleTea, modePaiment);
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
