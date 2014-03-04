package fr.japanpartymanager.util;

import java.util.ArrayList;
import java.util.List;


public class ProduitsManager {
	List<Float> listeProduits;
	
	
	/**
	 * /!\Si un changement de prix a lieu, il faut le faire ici /!\
	 * Les id des produits correspondent à leur ordre d'insertion, le produit ayant l'id 0 devra donc être inséré en 1er
	 */
	public ProduitsManager() {
		listeProduits = new ArrayList<Float>();
		
		/* Les Produits */
		listeProduits.add((float) 0.5); // Produit a 50cts ayant l'id 0
		listeProduits.add((float) 1);  // Produit a 1€ ayant l'id 1
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
