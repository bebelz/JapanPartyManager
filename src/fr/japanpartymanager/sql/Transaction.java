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
	private int modePaiment;
	private String date;
	
	public Transaction() {
		super();
	}
	
	public Transaction(int id_produit, int quantite, int modePaiment, String date) {
		super();
		this.id_produit = id_produit;
		this.quantite = quantite;
		this.modePaiment = modePaiment;
		this.date = date;
	}


	public int getModePaiment() {
		return modePaiment;
	}

	public void setModePaiment(int modePaiment) {
		this.modePaiment = modePaiment;
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
		return "[PRODUIT] : " + id_produit + " ; " + "[QUANTITE] : " + quantite + " ; " + "[MODE DE PAIMENT]  : " + modePaiment + " ; " + "[DATE] : " + date.toString(); 
	}
}
