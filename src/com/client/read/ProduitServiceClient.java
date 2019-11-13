package com.client.read;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.List;

import com.common.gustaveeiffel.upem.Demande;
import com.common.gustaveeiffel.upem.Produit;
import com.common.gustaveeiffel.upem.ProduitService;
import com.common.gustaveeiffel.upem.Utilisateur;

public class ProduitServiceClient implements ProduitService {
	ProduitService produitservice;
	public  ProduitServiceClient() throws MalformedURLException, RemoteException, NotBoundException {
		System.setProperty("java.security.policy",
				"src/java.policy");
		//classpath
		String codebase = "file:/C:\\Users\\ayoub\\OneDrive\\Desktop\\Lab\\JustLearn\\Java\\ShareApp-Spring-2ed\\bin\\";
		System.setProperty("java.rmi.server.codebase",codebase);
		if(System.getSecurityManager() == null) {
			System.setSecurityManager(new 
					RMISecurityManager());
		}
		produitservice= (ProduitService) Naming.lookup("produitservice");

	}

	@Override
	public boolean Ajouter(Produit p) throws RemoteException {

		return produitservice.Ajouter(p);
	}

	@Override
	public List<Produit> chercherProduitParcle(String motcle) throws RemoteException {
		return produitservice.chercherProduitParcle(motcle);
	}

	@Override
	public Produit chercherProduitParId(int id) throws RemoteException {
		return produitservice.chercherProduitParId(id);
	}

	@Override
	public boolean modifierProduit(int id, Produit p) throws RemoteException {
		return produitservice.modifierProduit(id, p);
	}

	@Override
	public void restituer(Produit p, Utilisateur u) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean deleteProduct(String id) throws RemoteException {
		return produitservice.deleteProduct(id);
	}

	@Override
	public List<Produit> listeProduit() throws RemoteException {
		return produitservice.listeProduit();
	}

	@Override
	public void ajouterEnAttente(Produit p, int utilisateurid) throws RemoteException {
		produitservice.ajouterEnAttente(p, utilisateurid);

	}

	@Override
	public boolean ajouterDemande(Demande d, int produit, int utilisateurid) throws RemoteException {
		return produitservice.ajouterDemande(d, produit, utilisateurid);
	}

	@Override
	public boolean modifierDemande(int produit, int utilisateurid, int priorite) throws RemoteException {
		return produitservice.modifierDemande(produit, utilisateurid, priorite);
	}

	@Override
	public List<Demande> listeDemandes(int produitid) throws RemoteException {
		return listeDemandes(produitid);
	}

	@Override
	public boolean Emprunter(int produitid, int utilisateurid, Date dateRetour) throws RemoteException {
		return produitservice.Emprunter(produitid, utilisateurid, dateRetour);
	}

	@Override
	public boolean Emprunter(int produitid, int utilisateurid) throws RemoteException {
		return false;
	}

}
