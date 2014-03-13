package fr.japanpartymanager.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
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
		editTextEntree.setOnKeyListener(new OnKeyListener() {
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER || keyCode == KeyEvent.KEYCODE_DPAD_CENTER)) {
					codeBillet = editTextEntree.getText().toString();
					new RequeteHttpBillet() {
						@Override
					    protected void onPostExecute(String result) {
							afficherDialog(result);
					    }
					}.execute(codeBillet);
		            return true;
		        }
				return false;
			}
		});
		
		buttonValidationEntree.setOnClickListener(listenerButtonEntreeValider);
	}

	private OnClickListener listenerButtonEntreeValider = new OnClickListener() {
			@Override
			public void onClick(View v) {
				codeBillet = editTextEntree.getText().toString();
				new RequeteHttpBillet() {
					@Override
				    protected void onPostExecute(String result) {
						afficherDialog(result);
				    }
				}.execute(codeBillet);
			}
	};
	
	private void afficherDialog(String result) {
		String title = "";
		String message = "";
		result = result.replace("<br>", "\n");
		
		if(result.contains("ERREUR")) {
			title = "Erreur";
			message = result.substring(7);
		} else if(result.contains("OK")) {
			title = "OK";
			message = result.substring(3);
		} else {
			title = "???";
			message = result;
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

}
