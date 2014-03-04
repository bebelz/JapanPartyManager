package fr.japanpartymanager.activity;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import fr.japanpartymanager.R;
import fr.japanpartymanager.sql.Transaction;
import fr.japanpartymanager.sql.TransactionDB;

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
        
        TransactionDB dbTransaction = new TransactionDB(this);
        
        dbTransaction.open();
        
        /*Transaction tr = new Transaction(2, 3, System.currentTimeMillis()+"");
        Transaction trr = new Transaction(2, 3, System.currentTimeMillis()+"");
        Transaction trrr = new Transaction(2, 3, System.currentTimeMillis()+"");
        
        System.out.println(dbTransaction.insertTransaction(tr));
        System.out.println(dbTransaction.insertTransaction(trr));
        System.out.println(dbTransaction.insertTransaction(trrr));*/
        
        /*Transaction tempAlone;
        tempAlone = dbTransaction.getTransactionById("1");
        if (tempAlone == null) System.out.println("NULL");
        else System.out.println(tempAlone);*/
        
        List<Transaction> temp = dbTransaction.getTransactionByIdProduit("2");
        
        if(temp.size() == 0) System.out.println("NULL");
        else {
        	for(Transaction t : temp) {
        		System.out.println(t.toString());
        	}
        }
        
        dbTransaction.close();
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
