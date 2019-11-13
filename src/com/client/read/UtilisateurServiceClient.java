package com.client.read;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.List;

import com.common.gustaveeiffel.upem.ProduitService;
import com.common.gustaveeiffel.upem.Utilisateur;
import com.common.gustaveeiffel.upem.UtilisateurService;

public class UtilisateurServiceClient implements UtilisateurService {
UtilisateurService utilisateurService;

@SuppressWarnings("deprecation")
public UtilisateurServiceClient() throws MalformedURLException, RemoteException, NotBoundException {
	System.setProperty("java.security.policy",
			"src/java.policy");
	//classpath
	String codebase = "file:/C:\\Users\\ayoub\\OneDrive\\Desktop\\Lab\\JustLearn\\Java\\ShareApp-Spring-2ed\\bin\\";
	System.setProperty("java.rmi.server.codebase",codebase);
	if(System.getSecurityManager() == null) {
		System.setSecurityManager(new 
				RMISecurityManager());
	}
	 utilisateurService= (UtilisateurService) Naming.lookup("utilservice");
}

	@Override
	public boolean NouveauUtilisateur(Utilisateur u) throws RemoteException {
		return utilisateurService.NouveauUtilisateur(u);
	}

	@Override
	public void informerUtilisateur(Utilisateur u) throws RemoteException {
		
	}

	@Override
	public boolean supprimerUtilisateur(int id) throws RemoteException {
		return utilisateurService.supprimerUtilisateur(id);
	}

	@Override
	public boolean modifierUtilisateur(int id, Utilisateur u) throws RemoteException {
		return utilisateurService.modifierUtilisateur(id, u);
	}

	@Override
	public List<Utilisateur> cherchercherUtilisateurParPseudo(String pseudo) throws RemoteException {
		return utilisateurService.cherchercherUtilisateurParPseudo(pseudo);
	}

	@Override
	public List<Utilisateur> chercherUtilisateurParNom(String nom) throws RemoteException {
		return utilisateurService.chercherUtilisateurParNom(nom);
	}

	@Override
	public Utilisateur chercherUtilisateurParId(int id) throws RemoteException {
		return utilisateurService.chercherUtilisateurParId(id);
	}

	@Override
	public List<Utilisateur> listeUtilisateurs() throws RemoteException {
		return utilisateurService.listeUtilisateurs();
	}

	@Override
	public String testRMI() throws RemoteException {
		return null;
	}

}
