package fr.japanpartymanager.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import fr.japanpartymanager.R;
import fr.japanpartymanager.util.RequeteHttpBillet;

public class EntreeActivity extends Activity {
	String codeBillet;
	
	Button buttonValidationEntree;
	EditText editTextEntree;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_entree);
		
		buttonValidationEntree = (Button) findViewById(R.id.buttonValidationEntree);
		editTextEntree = (EditText) findViewById(R.id.editTextEntree);
		
		buttonValidationEntree.setOnClickListener(listenerButtonEntreeValider);
	}

	private OnClickListener listenerButtonEntreeValider = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				codeBillet = editTextEntree.getText().toString();
				new RequeteHttpBillet() {
					@Override
				    protected void onPostExecute(String result) {
						String title = "Erreur";
						String message = "";
						// On défini le message a afficher
						if(result.equals("OK")) {
							title = "OK";
							message = "Billet Valide";
						} else if (result.equals("ERREUR:BILLETINTROUVABLE")) {
							message = "Billet Introuvable";
						} else if (result.equals("COMMANDEINTROUVABLE")) {
							message = "Commande Introuvable";
						} else if (result.equals("COMMANDENONPAYEE")) {
							message = "Commande Non Payée";
						} else if (result.equals("BILLETTYPEINTROUVABLE")) {
							message = "Billet Type Introuvable";
						} else if (result.equals("PASCORRESPONDANCE")) {
							message = "Pas de Correspondance";
						} else if (result.equals("ALREADY")) {
							message = "Billet Déjà Utilisé";
						} else if (result.equals("ALREADY")) {
							message = "Billet Déjà Utilisé";
						} else if (result.equals("HOR_NO")) {
							message = "Ce Billet n'est pas pour cette journée";
						} else {
							message = "Erreur Non Référencée";
						}
						
						// On affiche un AlertDialog contenant le message d'erreur
						new AlertDialog.Builder(EntreeActivity.this)
					    .setTitle(title)
					    .setMessage(message)
					    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
					        public void onClick(DialogInterface dialog, int which) { 
					            dialog.dismiss();
					            editTextEntree.setText("");
					        }
					     }).show();
				    }
				}.execute(codeBillet);
			}
	};

}
