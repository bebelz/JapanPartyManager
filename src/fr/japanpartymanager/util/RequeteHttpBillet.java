package fr.japanpartymanager.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.AsyncTask;

/**
 * @author Benoit
 * Effectue les requêtes sur le serveur dans une AsynTask afin de ne pas impacter sur le Thread UI
 */
public class RequeteHttpBillet extends AsyncTask<String, Void, String>{
	String addrServeur = "http://shop.japan-party.net/bip.php?nohtml";

	@Override
	protected String doInBackground(String... params) {
		return requeteHttpBillet(params[0]);
	}
	
	/**
	 * Effectue une requête sur le serveur des billets
	 * @param codeBillet
	 * @return String message de retour du serveur
	 */
	private String requeteHttpBillet(String codeBillet) {
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(addrServeur);
		HttpResponse response = null;
			
		List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();
		nameValuePair.add(new BasicNameValuePair("billet", codeBillet));
		
		// Url Encoding the POST parameters
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
 
        // Making HTTP Request
        try {
            response = httpClient.execute(httpPost);
            
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // On récupère le contenu de la requête
        try {
			return inputStreamToString(response.getEntity().getContent());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        return "This shouldn't happend!";
	}
	
	/**
	 * @param is
	 * @return String le message du serveur
	 */
	private String inputStreamToString(InputStream is) {
	    String line = "";
	    StringBuilder total = new StringBuilder();
	    
	    // Wrap a BufferedReader around the InputStream
	    BufferedReader rd = new BufferedReader(new InputStreamReader(is));

	    // Read response until the end
	    try {
			while ((line = rd.readLine()) != null) { 
			    total.append(line); 
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    // Return full string
	    return total.toString();
	}
}
