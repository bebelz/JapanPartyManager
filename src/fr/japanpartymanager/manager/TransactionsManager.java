package fr.japanpartymanager.manager;

import java.util.List;

import android.content.Context;
import fr.japanpartymanager.sql.Transaction;
import fr.japanpartymanager.sql.TransactionDB;
import fr.japanpartymanager.util.ProduitsManager;

/**
 * @author Benoit
 * Cette classe va permettre de gérer de manière autonome les insertions et lectures en base des transactions
 * @warning Le nom de classe est un échec total, il faut remédier à cela
 */
public class TransactionsManager {
	TransactionDB dbTransaction;
	ProduitsManager produits;
	
	public TransactionsManager(Context context) {
		dbTransaction = new TransactionDB(context);
		produits = new ProduitsManager();
	}
	
	/**
	 * @param id_produit
	 * @param quantite
	 * @return l'id de la Transaction
	 * @PostC Si return -1, erreur d'insertion !
	 */
	public long venteProduit(int id_produit, int quantite, int modePaiement) {
		long toReturn;
		Transaction toAdd = new Transaction(id_produit, quantite, modePaiement, System.currentTimeMillis()+""); // Cast en String pas beau
		
		dbTransaction.open();
		toReturn = dbTransaction.insertTransaction(toAdd);
		dbTransaction.close();
		
		return toReturn;
	}
	
	/**
	 * @param id_produit
	 * @return int nombre de produits id_produit vendus
	 */
	public int getNombreVenteProduit(int id_produit) {
		List<Transaction> temp;
		int toReturn = 0;
		
		dbTransaction.open();
		temp = dbTransaction.getTransactionByIdProduit(id_produit+"");
		dbTransaction.close();
		
		if(temp != null) {
			for(Transaction tr : temp) {
				toReturn += tr.getQuantite();
			}
			
			return toReturn;
		} else {
			return 0;
		}
	}
	
	/**
	 * @param id_produit
	 * @return float argent issus des ventes du produit id_produit
	 */
	public float getRevenusProduit(int id_produit) {
		int nombreVentesProduit;
		float prixProduit;
		
		nombreVentesProduit = getNombreVenteProduit(id_produit);
		prixProduit = produits.getPrixProduit(id_produit);
		
		return nombreVentesProduit * prixProduit;
	}
	
	/**
	 * @param id
	 * @return
	 */
	public Transaction getTransaction(int id) {
		Transaction toReturn;
		
		dbTransaction.open();
		toReturn = dbTransaction.getTransactionById(id+"");
		dbTransaction.close();
		
		return toReturn;
	}
	
	/**
	 * @param id_produit
	 * @return
	 */
	public List<Transaction> getTransactionsProduit(int id_produit) {
		List<Transaction> toReturn;
		
		dbTransaction.open();
		toReturn = dbTransaction.getTransactionByIdProduit(id_produit+"");
		dbTransaction.close();
		
		return toReturn;
	}
	
	public float getPrixProduit(int id_produit) {
		return produits.getPrixProduit(id_produit);
	}
}
