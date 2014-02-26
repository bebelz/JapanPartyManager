package fr.japanpartymanager.activity;

import fr.japanpartymanager.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class EntreeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_entree);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.entree, menu);
		return true;
	}

}
