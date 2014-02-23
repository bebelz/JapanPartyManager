package fr.japanpartymanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	Button buttonRestau = null;
	Button buttonBar = null;
	Button buttonEntree = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("HOME");
        
        buttonRestau = (Button)findViewById(R.id.buttonRestau);
        buttonBar = (Button)findViewById(R.id.buttonBar);
        buttonEntree = (Button) findViewById(R.id.buttonEntree);
        
        buttonRestau.setOnClickListener(listenerMain);
        buttonBar.setOnClickListener(listenerMain);
        buttonEntree.setOnClickListener(listenerMain);
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
			case R.id.buttonEntree :
				Intent entreeActivity = new Intent(getApplicationContext(), EntreeActivity.class);
				startActivity(entreeActivity);
				break;
			}
		}
	};

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
