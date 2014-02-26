package fr.japanpartymanager.sql;


/**
 * @author Benoit
 * 
 * Classe représentant les transactions
 * 
 */
public class Transaction {
	private int id;
	private int id_produit;
	private int quantite;
	private String date;
	
	public Transaction() {
		super();
	}
	
	public Transaction(int id_produit, int quantite, String date) {
		super();
		this.id_produit = id_produit;
		this.quantite = quantite;
		this.date = date;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getId_produit() {
		return id_produit;
	}


	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}


	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}
	
	public String toString() {
		return "[PRODUIT] : " + id_produit + " ; " + "[QUANTITE] : " + quantite + " ; " + "[DATE] : " + date.toString(); 
	}
}
