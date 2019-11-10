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

public class Client {

	public Client() {

	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

		try {
			System.setProperty("java.security.policy",
					"src/java.policy");

			//String codebase="file:/C:\\Users\\ayoub\\OneDrive\\Desktop\\Lab\\JustLearn\\Java\\ShareApp-Spring-JEE-master\\build\\classes\\";
			String codebase = "file:/C:\\Users\\ayoub\\OneDrive\\Desktop\\Lab\\JustLearn\\Java\\ShareApp-Spring-2ed\\bin\\";
			System.setProperty("java.rmi.server.codebase",codebase);
			if(System.getSecurityManager() == null) {
				System.setSecurityManager(new 
						RMISecurityManager());
				UtilisateurService serv = (UtilisateurService) Naming.lookup("utilservice");
				ProduitService produitservice = (ProduitService) Naming.lookup("produitservice");
				
				System.out.println(produitservice.chercherProduitParId(2));
			}	
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}

}
