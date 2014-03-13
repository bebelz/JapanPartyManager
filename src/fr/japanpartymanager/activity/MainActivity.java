package fr.japanpartymanager.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import fr.japanpartymanager.R;
import fr.japanpartymanager.manager.TransactionsManager;

public class MainActivity extends Activity {
	static TransactionsManager transacManager = null; // Va permettre de gérer toutes les requêtes DB dans l'appli
	Button buttonRestau = null;
	Button buttonBar = null;
	Button buttonStats = null;
	Button buttonCaisseSamedi = null;
	Button buttonCaisseDimanche = null;
	Button buttonEntree = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("HOME");
        
        buttonRestau = (Button)findViewById(R.id.buttonRestau);
        buttonBar = (Button)findViewById(R.id.buttonBar);
        buttonStats = (Button)findViewById(R.id.buttonStats);
        buttonCaisseSamedi = (Button)findViewById(R.id.buttonCaisseSamedi);
        buttonCaisseDimanche = (Button)findViewById(R.id.buttonCaisseDimanche);
        buttonEntree = (Button) findViewById(R.id.buttonEntree);
        
        buttonRestau.setOnClickListener(listenerMain);
        buttonBar.setOnClickListener(listenerMain);
        buttonStats.setOnClickListener(listenerMain);
        buttonCaisseSamedi.setOnClickListener(listenerMain);
        buttonCaisseDimanche.setOnClickListener(listenerMain);
        buttonEntree.setOnClickListener(listenerMain);
        
        // On instancie l'objet qui va gérer la DB
        transacManager = new TransactionsManager(this);
    }

    private OnClickListener listenerMain = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch(v.getId()) {
			case R.id.buttonRestau :
				Intent restauActivity = new Intent(getApplicationContext(), RestauActivity.class);
				startActivity(restauActivity);
				break;
			case R.id.buttonBar :
				Intent barActivity = new Intent(getApplicationContext(), BarActivity.class);
				startActivity(barActivity);
				break;
			case R.id.buttonStats :
				Intent statActivity = new Intent(getApplicationContext(), StatsActivity.class);
				startActivity(statActivity);
				break;
			case R.id.buttonCaisseSamedi :
				Intent samediActivity = new Intent(getApplicationContext(), CaisseSamediActivity.class);
				startActivity(samediActivity);
				break;
			case R.id.buttonCaisseDimanche :
				Intent dimancheActivity = new Intent(getApplicationContext(), CaisseDimancheActivity.class);
				startActivity(dimancheActivity);
				break;
			case R.id.buttonEntree :
				Intent entreeActivity = new Intent(getApplicationContext(), EntreeActivity.class);
				startActivity(entreeActivity);
				break;
			}
		}
	};
}
