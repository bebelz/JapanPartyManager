package fr.japanpartymanager.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import fr.japanpartymanager.R;
import fr.japanpartymanager.sql.Transaction;

public class StatsActivity extends Activity {
	EditText editTextBilletPayantSamedi = null;
	EditText editTextBilletGratuitSamedi = null;
	EditText editTextBilletPayantDimanche = null;
	EditText editTextBilletGratuitDimanche = null;
	EditText editTextTicketBoisson = null;
	EditText editTextTicketRepas = null;
	EditText editTextSodasJus = null;
	EditText editTextCafeThe = null;
	EditText editTextConfiserie = null;
	EditText editTextBubbleTea = null;
	EditText editTextPlat = null;
	EditText editTextCrepe = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stats);
		setTitle("Stats");
		
		editTextBilletPayantSamedi = (EditText)findViewById(R.id.editTextBilletPayantSamedi);
		editTextBilletGratuitSamedi = (EditText)findViewById(R.id.editTextBilletGratuitSamedi);
		editTextBilletPayantDimanche = (EditText)findViewById(R.id.editTextBilletPayantDimanche);
		editTextBilletGratuitDimanche = (EditText)findViewById(R.id.editTextBilletGratuitDimanche);
		editTextTicketBoisson = (EditText)findViewById(R.id.editTextTicketBoisson);
		editTextTicketRepas = (EditText)findViewById(R.id.editTextTicketRepas);
		editTextSodasJus = (EditText)findViewById(R.id.editTextSodasJus);
		editTextCafeThe = (EditText)findViewById(R.id.editTextCafeThe);
		editTextConfiserie = (EditText)findViewById(R.id.editTextConfiserie);
		editTextBubbleTea = (EditText)findViewById(R.id.editTextBubbleTea);
		editTextPlat = (EditText)findViewById(R.id.editTextPlat);
		editTextCrepe = (EditText)findViewById(R.id.editTextCrepe);
		
		editTextBilletPayantSamedi.setText(MainActivity.transacManager.getNombreVenteProduit(10)+"");
		editTextBilletGratuitSamedi.setText(MainActivity.transacManager.getNombreVenteProduit(11)+"");
		editTextBilletPayantDimanche.setText(MainActivity.transacManager.getNombreVenteProduit(14)+"");
		editTextBilletGratuitDimanche.setText(MainActivity.transacManager.getNombreVenteProduit(15)+"");
		editTextTicketBoisson.setText(MainActivity.transacManager.getNombreVenteProduit(8)+"");
		editTextTicketRepas.setText(MainActivity.transacManager.getNombreVenteProduit(9)+"");
		editTextSodasJus.setText(MainActivity.transacManager.getNombreVenteProduit(0)+"");
		editTextCafeThe.setText(MainActivity.transacManager.getNombreVenteProduit(1)+"");
		editTextConfiserie.setText(MainActivity.transacManager.getNombreVenteProduit(2)+"");
		editTextBubbleTea.setText(MainActivity.transacManager.getNombreVenteProduit(3)+"");
		editTextPlat.setText(MainActivity.transacManager.getNombreVenteProduit(6)+"");
		editTextCrepe.setText(MainActivity.transacManager.getNombreVenteProduit(5)+"");
	}

}
