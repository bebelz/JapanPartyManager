package fr.japanpartymanager.util;

import java.util.ArrayList;
import java.util.List;


public class ProduitsManager {
	List<Float> listeProduits;
	
	
	/**
	 * /!\Si un changement de prix a lieu, il faut le faire ici /!\
	 * Les id des produits correspondent � leur ordre d'insertion, le produit ayant l'id 0 devra donc �tre ins�r� en 1er
	 */
	public ProduitsManager() {
		listeProduits = new ArrayList<Float>();
		
		/* Les Produits */
		listeProduits.add((float) 1.5); // SodaJus ; id = 0
		listeProduits.add((float) 1);  // Caf�Th� ; id = 1
		listeProduits.add((float) 1.5); // Confiserie ; id =2
		listeProduits.add((float) 2.5); // BubbleTea ; id = 3
	}
	
	/**
	 * @param id l'id du produit dont on cherche le prix
	 * @return Le prix du produit ou -1 si l'id est non conforme
	 */
	public float getPrixProduit(int id) {
		try {
			return listeProduits.get(id);
		} catch(IndexOutOfBoundsException e) {
			return -1;
		}
	}
}
