package com.client.read;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.List;

import com.common.gustaveeiffel.upem.Produit;
import com.common.gustaveeiffel.upem.ProduitService;
import com.common.gustaveeiffel.upem.Utilisateur;
import com.common.gustaveeiffel.upem.UtilisateurService;

public class Client {

	public Client() {

	}
	
	public void CreerCompte() throws RemoteException, MalformedURLException, NotBoundException {
		//3@param is the Role
		Utilisateur u = new Utilisateur("Abderaffi","Errazki",0,2,"Errazki","motdepasse","Masculin","abderafi@gmail.com");
		UtilisateurService Userserv = (UtilisateurService) Naming.lookup("utilservice");

		if(Userserv.NouveauUtilisateur(u)) {
			System.out.println("utilisateur "+u.getNom()+" est inscris");
		}
		else {
			System.out.println("Erreur inscription");

		}

	}

	
	
	
	
	public static void ajoutAttente() throws MalformedURLException, RemoteException, NotBoundException {
		
		ProduitService produitservice = (ProduitService) Naming.lookup("produitservice");
       //what is the targeted product?
		Produit p = produitservice.chercherProduitParId(2);
		
		//who is the current user?
		UtilisateurService serviceuser = (UtilisateurService) Naming.lookup("utilservice");
		Utilisateur util_test = serviceuser.chercherUtilisateurParId(9);// what is current id?
	     if(p==null) {
	    	 System.out.println("There was an error generating your demand");
	     }
		produitservice.ajouterEnAttente(p,util_test.getUserid());
	}
	
	
	
	
	
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

		try {
			System.setProperty("java.security.policy",
					"src/java.policy");
			//classpath
			String codebase = "file:/C:\\Users\\ayoub\\OneDrive\\Desktop\\Lab\\JustLearn\\Java\\ShareApp-Spring-2ed\\bin\\";
			System.setProperty("java.rmi.server.codebase",codebase);
			if(System.getSecurityManager() == null) {
				System.setSecurityManager(new 
						RMISecurityManager());
				//UtilisateurService Userserv = (UtilisateurService) Naming.lookup("utilservice");
				//ProduitService produitservice = (ProduitService) Naming.lookup("produitservice");
				ajoutAttente();
			}	
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}

}
