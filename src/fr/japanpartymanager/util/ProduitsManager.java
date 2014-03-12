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
		listeProduits.add((float) 1.5); // SodaJus ; id = 0
		listeProduits.add((float) 1);  // CaféThé ; id = 1
		listeProduits.add((float) 1.5); // Confiserie ; id =2
		listeProduits.add((float) 2.5); // BubbleTea ; id = 3
		listeProduits.add((float) 6.5); // Menu ; id = 4
		listeProduits.add((float) 2); // Crepe ; id = 5
		listeProduits.add((float) 2.5); // Plat ; id = 6
		listeProduits.add((float) 1); // Eau ; id = 7
		listeProduits.add((float) 0.5); // Ticket Boisson ; id = 8
		listeProduits.add((float) 6.5); // Ticket Repas ; id = 9
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
