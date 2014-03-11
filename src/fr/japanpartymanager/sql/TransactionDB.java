package fr.japanpartymanager.sql;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TransactionDB {
	private static final int VERSION_DB = 1; // ATTENTION : Changer ce chiffre vide la base !
	
    private static final String NOM_DB = "transactions.db";
    private static final String TABLE_TRANSACTIONS = "table_transactions";
    
    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;
    private static final String COL_ID_PRODUIT = "ID_PRODUIT";
    private static final int NUM_COL_ID_PRODUIT = 1;
    private static final String COL_QUANTITE = "QUANTITE";
    private static final int NUM_COL_QUANTITE = 2;
    private static final String COL_MODE_PAIMENT = "MODE_PAIMENT";
    private static final int NUM_COL_MODE_PAIMENT = 3;
    private static final String COL_DATE = "DATE";
    private static final int NUM_COL_DATE = 4;
    
    private final String[] allCollumns = new String[] {COL_ID, COL_ID_PRODUIT, COL_QUANTITE, COL_MODE_PAIMENT, COL_DATE};
    
    private SQLiteDatabase db; // Pointeur vers la base
 
    private SQLDatabase mySQLiteDB;
 
    /* INIT & UTIL */
    public TransactionDB(Context context) {
    	mySQLiteDB = new SQLDatabase(context, NOM_DB, null, VERSION_DB);
    }
 
    // Ouvre la BDD en écriture
    public void open() {
        db = mySQLiteDB.getWritableDatabase();
    }
 
    // Ferme l'accès à la BDD
    public void close() {
        db.close();
    }
 
    // Getter
    public SQLiteDatabase getDB() {
        return db;
    }
    
    /* REQUEST */
    
    /**
     * @param transaction la transaction a insérer en base
     * @return long l'id de la ligne créée
     */
    public long insertTransaction(Transaction transaction) {
        ContentValues values = new ContentValues();
        
        // On rempli l'objet que l'on va entrer en base
        values.put(COL_ID_PRODUIT, transaction.getId_produit());
        values.put(COL_QUANTITE, transaction.getQuantite());
        values.put(COL_MODE_PAIMENT, transaction.getModePaiment());
        values.put(COL_DATE, transaction.getDate().toString());
 
        return db.insert(TABLE_TRANSACTIONS, null, values);
    }

    /** 
     * @param id 
     * @return Transaction 
     */ 
    public Transaction getTransactionById(String id) {
    	Cursor c = db.query(TABLE_TRANSACTIONS, allCollumns, 
    				COL_ID + " LIKE \"" + id +"\"", 
    				null, null, null, null);
    	
    	c.moveToFirst();
    	Transaction toReturn = cursorToTransaction(c);
    	
    	c.close();
		return toReturn;
    }
    
    /**
     * @return List<Transaction>
     */
    public List<Transaction> getAllTransaction() {
    	List<Transaction> toReturn = new ArrayList<Transaction>();
    	
    	Cursor c = db.query(TABLE_TRANSACTIONS, allCollumns, 
				null, null, null, null, null);
    	
    	c.moveToFirst();
    	do {
    		toReturn.add(cursorToTransaction(c));
    		c.moveToNext();
    	}
    	while (!c.isAfterLast());
    	
    	c.close();
    	return toReturn;
    }
    
    public List<Transaction> getTransactionByIdProduit(String id_produit) {
    	List<Transaction> toReturn = new ArrayList<Transaction>();
    	Cursor c = db.query(TABLE_TRANSACTIONS, allCollumns,
    			COL_ID_PRODUIT + " = " + id_produit,
    			null, null, null, null);
    	
    	c.moveToFirst();
    	do {
    		toReturn.add(cursorToTransaction(c));
    		c.moveToNext();
    	}
    	while (!c.isAfterLast());
    	
    	c.close();
    	return toReturn;
    }
    
    /**
     * @param c
     * @return Transaction pointeur vers l'objet Transaction correspond
     */
    private Transaction cursorToTransaction(Cursor c){
		//si aucun élément n'a été retourné dans la requête, on renvoie null
		if (c.getCount() == 0)
			return null;
 
		//Sinon on se place sur le premier élément
		//c.moveToFirst();
		//On créé un livre
		Transaction toReturn = new Transaction();
		//on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
		toReturn.setId(c.getInt(NUM_COL_ID));
		toReturn.setId_produit(c.getInt(NUM_COL_ID_PRODUIT));
		toReturn.setQuantite(c.getInt(NUM_COL_QUANTITE));
		toReturn.setModePaiment(c.getInt(NUM_COL_MODE_PAIMENT));
		toReturn.setDate(c.getString(NUM_COL_DATE));
 
		//On retourne le livre
		return toReturn;
	}
}
