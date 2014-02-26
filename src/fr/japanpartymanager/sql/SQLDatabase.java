package fr.japanpartymanager.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author Benoit
 * Classe qui permet de gérer la table TRANSACTION
 */
public class SQLDatabase extends SQLiteOpenHelper {
	private static final String TABLE_TRANSACTIONS = "table_transactions";
    private static final String COL_ID = "ID";
    private static final String COL_ID_PRODUIT = "ID_PRODUIT";
    private static final String COL_QUANTITE = "QUANTITE";
    private static final String COL_DATE = "DATE";
 
    private static final String CREATE_TABLE_TRANSACTIONS = "CREATE TABLE "
            + TABLE_TRANSACTIONS + " (" 
    		+ COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " 
            + COL_ID_PRODUIT+ " INTEGER NOT NULL, " 
            + COL_QUANTITE + " INTEGER NOT NULL, "
            + COL_DATE + " TEXT NOT NULL);";

	public SQLDatabase(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE_TRANSACTIONS);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		db.execSQL("DROP TABLE " + TABLE_TRANSACTIONS + ";");
		onCreate(db);
	}

}
