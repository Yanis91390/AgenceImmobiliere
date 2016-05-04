package com.Controlleur;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.Model.*;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Controler extends HttpServlet 
{
	 //Operation op =new Operation();
	ApplicationContext context = 
				new ClassPathXmlApplicationContext("Beans.xml");
	Operation op = (Operation) context.getBean("operation");
	
	public Commercial commercial;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
	{
        response.setContentType("text/html;charset=UTF-8");
      
    }

	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException 
	 {
	        processRequest(request, response);
	        
	        String action =request.getPathInfo();
	        String method =request.getMethod();
	        
	        if(action.equals("/chercher") && method.toLowerCase().equals("get"))
	        {
	        	chercher(request,response);
	        	System.out.println("BOUTON OK");
	        } 
	        
	 }
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException 
	 {
		 	processRequest(request, response);
	        
	        String action =request.getPathInfo();
	        String method =request.getMethod();
	        
	        if(action.equals("/SeConnecter") && method.toLowerCase().equals("post"))
	        {
	            SeConnecter(request, response);
	        }
	        
	        if(action.equals("/AjouterBien") && method.toLowerCase().equals("post"))
	        {
	        	ajouterBienImmobilier(request, response);
	        }
	        
	        if(action.equals("/SupprimerBien") && method.toLowerCase().equals("post"))
	        {
	        	supprimerBienImmobilier(request, response);
	        }
	        
	        if(action.equals("/ModifierBien") && method.toLowerCase().equals("post"))
	        {
	        	modifierBienImmobilier(request, response);
	        }
	        
	        if(action.equals("/GenererListeClient") && method.toLowerCase().equals("post"))
	        {
	        	genererListeClient(request, response);
	        }     
	   
	        if(action.equals("/AjouterCommercial") && method.toLowerCase().equals("post"))
	        {
	        	ajouterCommercial(request,response);
	        }
	        
	        // A FAAAAAAAAIREEEEEEEEEEEEEEEEE
	        if(action.equals("/SupprimerCommercial") && method.toLowerCase().equals("post"))
	        {
	        	
	        }
	        
	        // A FAAAAAAAAAAAAAAAAAAIREEEEEEEEEEEEEEEEEEEE
	        if(action.equals("/ModifierCommercial") && method.toLowerCase().equals("post"))
	        {
	        	modifierCommercial(request,response);
	        	System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
	        }
	        
	        if(action.equals("/AjouterRendezVous") && method.toLowerCase().equals("post"))
	        {
	        	ajouterRendezVous(request,response);
	        }
	        
	        if(action.equals("/ModifierRendezVous") && method.toLowerCase().equals("post"))
	        {
	        	modifierRendezVous(request,response);
	        }
	        
	        if(action.equals("/SupprimerRendezVous") && method.toLowerCase().equals("post"))
	        {
	        	try {
					supprimerRendezVous(request, response);
				} catch (SQLException e) {
					System.out.println("ERREUR ZEEEEEEEEEEEEEER");
					e.printStackTrace();
				}
	        }
	        
	        if(action.equals("/RechercherRendezVous")&& method.toLowerCase().equals("post")){
	            rechercherRendezVous(request, response);
	        }
	        
	        if(action.equals("/RechercherBien")&& method.toLowerCase().equals("post")){
	            rechercherBien(request, response);
	        }
	        
	        if(action.equals("/GestionLocation") && method.toLowerCase().equals("get"))
	        {
	        	gestionLocation(request,response);
	        	System.out.println("BOUTON OK");
	        }
	        
	        if(action.equals("/getCompte")&& method.toLowerCase().equals("post")){
	            getCompte(request, response);
	        }
	          if(action.equals("/getRep")&& method.toLowerCase().equals("post")){
	            getRep(request, response);
	        }
	        
	        
	        		 
	  }


	private void SeConnecter(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		HttpSession session =request.getSession(true);
		//HttpSession session2 = request.getSession();
        String login =request.getParameter("login");
        String pass =request.getParameter("pass");
        commercial =new Commercial();
        commercial.setLogin(login);
        commercial.setPassword(pass);
       
        //administrateur.setCommercial(administrateur.getCommercial());
       //Administrateur administrateur1 = new Administrateur(administrateur1.getCommercial());
		
        
        try{
            if(op.isExiste(commercial)){
               
            	Administrateur administrateur = new Administrateur();
                System.out.println("A la connexion : " + administrateur.getCommercial().size());
                request.getSession().setAttribute("commercial", commercial);
                request.getSession().setAttribute("administrateur", administrateur);
                //request.getSession().setAttribute("n", null);
                
                
                request.getSession().setAttribute("rep", null);
                //session2.setAttribute(arg0, arg1);
                
                response.sendRedirect("../Accueil.jsp"); 
               
                
            }else{
                 
            	 response.sendRedirect("../Connexion.jsp");
                 //request.getSession().setAttribute("commercial", commercial);
                 request.getSession().setAttribute("rep", "Utilisateur ou mot de pass incorect");
                 
            }
            
            
        }catch(SQLException ex){
            
        }
      
		
	}
	
	public void chercher(HttpServletRequest request, HttpServletResponse response)
	{
		
	}
	
	/*--------------------------BIEN IMMOBILIER----------------------------------*/
	protected void ajouterBienImmobilier(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
	{
             processRequest(request, response);
             
           //Commercial commercial =(Commercial) request.getSession().getAttribute("commercial");
             //ArrayList<BienImmobilier> list =(ArrayList<BienImmobilier>)request.getSession().getAttribute("list")
              
             String type =request.getParameter("typebien");
              String disponible = request.getParameter("disponible");
      	      String statut = request.getParameter("statutbien");
      		  String etat = request.getParameter("etatbien");
      		  String prix = request.getParameter("prixbien");
      		  String loyer = request.getParameter("loyerbien");
      		  String charge = request.getParameter("chargebien");
      		  String adresse = request.getParameter("adressebien");
      		  String superficie = request.getParameter("superficiebien");
      		  
      		  BienImmobilier bien = new BienImmobilier();
    		  bien.setTypeBien(TypeBien.valueOf(type));
    		  bien.setDisponible(Boolean.valueOf(disponible));
    		  bien.setStatutBien(StatutBien.valueOf(statut));
    		  bien.setEtatBien(EtatBien.valueOf(etat));
    		  bien.setPrixAchat(Double.valueOf(prix));
    		  bien.setLoyer(Double.valueOf(loyer));
    		  bien.setCharge(Double.valueOf(charge));
    		  bien.setAdresse(adresse);
    		  bien.setSuperficie(Integer.valueOf(superficie));
              
            try 
            {
            	
            	op.addBI(bien);
            	//request.getSession().setAttribute("not", "<span style=\"color:green\">Succes</span>");
               	//op.addBienImmobilier(bien);
              	response.sendRedirect("../vueBienImmobilier.jsp");
            } 
            
            catch (Exception ex) 
            {
            	response.sendRedirect("../vueBienImmobilier.jsp");
            	request.getSession().setAttribute("not", "<span style=\"color:red\">"+ex.getMessage()+"</span>");
            	//System.out.println(ex.getErrorCode()+" " + ex.getSQLState()+" " +ex.getMessage());
            }
              
    }
	
	private void modifierBienImmobilier(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException  
	{
		processRequest(request, response);
		
		String idbien = request.getParameter("id");
		String type = request.getParameter("type");
		String disponible = request.getParameter("disponible");
		String statut = request.getParameter("statut");
		String etat = request.getParameter("etat");
		String prix = request.getParameter("prix");
		String loyer = request.getParameter("loyer");
		String charge = request.getParameter("charge");
		String adresse = request.getParameter("adresse");
		String superficie = request.getParameter("superficie");
		
		BienImmobilier bien = new BienImmobilier();
		bien.setIDBienImmobilier(strToInt(idbien));
		bien.setTypeBien(TypeBien.valueOf(type));
		bien.setDisponible(Boolean.valueOf(disponible));
		bien.setStatutBien(StatutBien.valueOf(statut));
		bien.setEtatBien(EtatBien.valueOf(etat));
		bien.setPrixAchat(Double.valueOf(prix));
		bien.setLoyer(Double.valueOf(loyer));
		bien.setCharge(Double.valueOf(charge));
		bien.setAdresse(adresse);
		bien.setSuperficie(Integer.valueOf(superficie));
		
		try
		{
			op.modifierBienImmobilier(bien);
			response.sendRedirect("../vueBienImmobilier.jsp");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			response.sendRedirect("../vueBienImmobilier.jsp");
		}
		
	}
	
	private void supprimerBienImmobilier(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException  
	{
		try {
			
			BienImmobilier bien = op.getBienImmobiliers(request.getParameter("n"));
			op.deleteBienImmobilier(bien);
			response.sendRedirect("../vueBienImmobilier.jsp");
		
		} catch (SQLException e) {
			
			response.sendRedirect("../vueBienImmobilier.jsp");
			e.printStackTrace();
		}
		
	}
	
	private void genererListeClient(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
		
		try
		{
			op.genererListeClient(request.getParameter("idbien"));
			System.out.println("Passage dans le try !!" + "");
			response.sendRedirect("../vueClientGenere.jsp");
		}
				
		
		catch(Exception ex)
		{
			
		}
		
	}

	
	
	
	/*-------------------------- COMMERCIAL ----------------------------------*/
	private void ajouterCommercial(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException 
	{
		processRequest(request, response);
		String login = request.getParameter("login");
		String password = request.getParameter("pass");
		String email = request.getParameter("email");
		String questionSecrete = request.getParameter("question");
		String reponseSecrete = request.getParameter("reponse");
		
		Commercial commercial = new Commercial(login,password,email,questionSecrete,reponseSecrete);
		/*commercial.setLogin(login);
		commercial.setPassword(password);
		commercial.setEmail(email);
		commercial.setQuesSecret(questionSecrete);
		commercial.setRepSecret(reponseSecrete);*/
		//commercial.setIDCommercial(commercial.getIDCommercial());
		
		try
		{
			op.addCommercial(commercial);
			response.sendRedirect("../vueCommerciaux.jsp");
			request.getSession().setAttribute("not", "<span style=\"color:green\">Succes</span>");
		}
		catch(Exception e)
		{
			System.out.println("ERREUUUUUUUUUUUUUUUUUUR" +e.getMessage() + e.toString() + e.getLocalizedMessage());
			response.sendRedirect("../formulaireInscription.jsp");
		}
		
	}
	
	private void modifierCommercial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		processRequest(request, response);
		
		String id = request.getParameter("idcom");
		String login = request.getParameter("login");
		String password = request.getParameter("pass");
		String email = request.getParameter("email");
		String quest = request.getParameter("quest");
		String rep = request.getParameter("rep");
		
		Commercial commercial = new Commercial(strToInt(id),login,password,email,quest,rep);
		
		try
		{
			op.modifierCommercial(commercial);
			response.sendRedirect("../vueCommerciaux.jsp");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			response.sendRedirect("../vueCommerciaux.jsp");
		}
	}
	
	/*-------------------------- RENDEZ-VOUS ----------------------------------*/
	/*Fonctionne*/
	private void ajouterRendezVous(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		processRequest(request, response);
		
		//Commercial commercialConnecte = (Commercial) request.getSession().getAttribute("commercial");
		
		//commercialConnecte.getIDCommercial(commercialConnecte.getLogin());
		
		commercial = (Commercial) request.getSession().getAttribute("commercial");
		int id = commercial.getIDCommercial(commercial.getLogin());
		
		String titre = request.getParameter("titre");
		String contenu = request.getParameter("contenu");
		String dateAjout = request.getParameter("dateAjout");
		
		RendezVous rdv = new RendezVous();
		rdv.setIDCommercial(id);
		rdv.setTitre(titre);
		rdv.setDateAjout(dateAjout);
		rdv.setContenu(contenu);
		
		try
		{
			op.addRendezVous(rdv);
			response.sendRedirect("../Accueil.jsp");
			request.getSession().setAttribute("not", "<span style=\"color:green\">Succes</span>");
			System.out.println("Succes");
		}
		
		catch (Exception e)
		{
			System.out.println("ERREUUUUUUUUUUUUUUUUUUR" +e.getMessage() + e.toString() + e.getLocalizedMessage());
			response.sendRedirect("../Accueil.jsp");
		}
	}
	
	/*Fonctionne*/
	private void modifierRendezVous(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
		
		String idrdv= request.getParameter("idrdv");
		
		String titre = request.getParameter("titre1");
		String contenu = request.getParameter("contenu1");
		String dateAjout = request.getParameter("dateAjout1");
		
		RendezVous rdv = new RendezVous();
		rdv.setIdRendezVous(strToInt(idrdv));
		rdv.setTitre(titre);
		rdv.setContenu(contenu);
		rdv.setDateAjout(dateAjout);
		
		try
		{
			op.modifierRendezVous(rdv);
			System.out.println("SUCCES MODIFIER RENDEZ VOUS");
			request.getSession().setAttribute("n1", "<span style=\"color:green\">Modification avec Succes</span>");
			response.sendRedirect("../Accueil.jsp");
		
		}
		
		catch (SQLException ex) 
		{
          response.sendRedirect("../Accueil.jsp");
          System.out.println("ERREUR MODIFIER RENDEZ VOUS");
          request.getSession().setAttribute("n1", "<span style=\"color:red\">"+ex.getMessage()+"</span>");
		}
		
		
	}
	
	/*Fonctionne*/
	private void supprimerRendezVous(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, SQLException
	{
		try{
			RendezVous rendezvous = op.getRendezVous(request.getParameter("n"));
			op.deleteRendezVous(rendezvous);
			response.sendRedirect("../Accueil.jsp");
		}
		
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	private void rechercherRendezVous(HttpServletRequest request, HttpServletResponse response) 
			throws IOException 
	{
		request.getSession().setAttribute("err", "");
        request.getSession().setAttribute("n", null);
       
        String crit=request.getParameter("crit");
        String rech=request.getParameter("rech");
       
       
        try 
        {
    	   if(crit.equals("titre"))
    	   {
                ArrayList<RendezVous> n= op.chercherRendezVousTitre(rech);
                request.getSession().setAttribute("err", n.size()+"");
                request.getSession().setAttribute("n", n);
                //response.sendRedirect("../rech.jsp");
                response.sendRedirect("../rechercheRendezVous.jsp");
    	   }
    	   else if(crit.equals("date"))
    	   {
              
                ArrayList<RendezVous> n=op.chercherRendezVousDate(rech);
                request.getSession().setAttribute("n", n);
                response.sendRedirect("../rechercheRendezVous.jsp");
           
    	   }
    	   else if(crit.equals("contenu"))
    	   {
              
                ArrayList<RendezVous> n=op.chercherRendezVousContenu(rech);
                request.getSession().setAttribute("n", n);
                response.sendRedirect("../rechercheRendezVous.jsp");
           
    	   }
       
    	   else 
    	   {
    		   request.getSession().setAttribute("err", "Veuillez choisir un crit");
    		   //response.sendRedirect("../rech.jsp");
    		   response.sendRedirect("../rechercheRendezVous.jsp");
    	   }
         
       } 
       catch (SQLException ex) 
       {
            request.getSession().setAttribute("err",ex.getMessage());
            //response.sendRedirect("../rech.jsp");
            response.sendRedirect("../rechercheRendezVous.jsp");
       }
		
	}
	
	private void rechercherBien(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
		request.getSession().setAttribute("err", "");
        request.getSession().setAttribute("n", null);
       
        String crit=request.getParameter("crit");
        String rech=request.getParameter("rech");
       
       
        try 
        {
    	   if(crit.equals("id"))
    	   {
                ArrayList<BienImmobilier> n= op.chercherBienID(rech);
                request.getSession().setAttribute("err", n.size()+"");
                request.getSession().setAttribute("n", n);
                //response.sendRedirect("../rech.jsp");
                response.sendRedirect("../rechercheBien.jsp");
    	   }
    	   else if(crit.equals("disponible"))
    	   {
              
                ArrayList<BienImmobilier> n=op.chercherBienDisponible(rech);
                request.getSession().setAttribute("n", n);
                response.sendRedirect("../rechercheBien.jsp"); 
           
    	   }
    	   else if(crit.equals("statut"))
    	   {
              
                ArrayList<BienImmobilier> n=op.chercherBienStatut(rech);
                request.getSession().setAttribute("n", n);
                response.sendRedirect("../rechercheBien.jsp");
           
    	   }
    	   
    	   else if(crit.equals("etat"))
    	   {
              
                ArrayList<BienImmobilier> n=op.chercherBienEtat(rech);
                request.getSession().setAttribute("n", n);
                response.sendRedirect("../rechercheBien.jsp");
           
    	   }
    	   
    	   else if(crit.equals("prixmax"))
    	   {
              
                ArrayList<BienImmobilier> n=op.chercherBienPrixmax(rech);
                request.getSession().setAttribute("n", n);
                response.sendRedirect("../rechercheBien.jsp");
           
    	   }
       
    	   else 
    	   {
    		   request.getSession().setAttribute("err", "Veuillez choisir un crit");
    		   //response.sendRedirect("../rech.jsp");
    		   response.sendRedirect("../rechercheBien.jsp");
    	   }
         
       } 
       catch (SQLException ex) 
       {
            request.getSession().setAttribute("err",ex.getMessage());
            //response.sendRedirect("../rech.jsp");
            response.sendRedirect("../rechercheBien.jsp");
       }
		
		
	}
	
	 private void gestionLocation(HttpServletRequest request, HttpServletResponse response) 
			 throws IOException 
	 {
		 	request.getSession().setAttribute("err", "");
	        request.getSession().setAttribute("n", null);
	       
	        String rech=request.getParameter("rech");
	        
	        try
	        {
	        	ArrayList<BienImmobilier> n=op.chercherBienDisponible(rech);
	        	request.getSession().setAttribute("n", n);
	        	response.sendRedirect("../vuGestionLocation.jsp"); 
	        }
	        catch(SQLException e)
	        {
	        	e.printStackTrace();
	        }
			
		}
	 
	 protected void getCompte(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException {
	        processRequest(request, response);
	        String log=request.getParameter("log");
	        String mail=request.getParameter("mail");
	        Commercial us=new Commercial();
	      try {
	          String q=op.getQuestion(log, mail);
	          us.setLogin(log);
	          us.setEmail(mail);
	          us.setQuesSecret(q);
	          if(!q.equals("")){
	              
	              request.getSession().setAttribute("commercial", us);
	              response.sendRedirect("../reponse.jsp");
	          }else {
	              response.sendRedirect("../recuper.jsp");
	          }
	      } catch (SQLException ex) {
	          Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
	      }
	      
	     
	    }
	     
	        
	        
	          protected void getRep(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	             processRequest(request, response);
	              PrintWriter out=response.getWriter();
	            
	              Commercial us=(Commercial)request.getSession().getAttribute("commercial");
	             String rep=request.getParameter("reps");
	             us.setRepSecret(rep);
	      try {
	          String rep1=op.verifierep(us);
	          if(!rep1.equals("")){
	           
	              out.write("<html>"
	                      + "<head></head>"
	                      + "<body>"
	                      + "<p>Votre mot de passe est :"+rep1
	                      +"<br> <br> <a href=\"http://localhost:8080/TestAgence/Connexion.jsp\"> Retour à la page d'accueil</a>"
	                      + "</p>"
	                      + ""
	                      + "</body></html>");
	              
	              
	          }else {
	              request.getSession().setAttribute("commercial", us);
	              response.sendRedirect("../reponse.jsp");
	          }
	      } catch (SQLException ex) {
	          Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
	      }
	          }
	
	/*----------------------------------AUTRE---------------------------------------------*/
	public static int strToInt(String s)
	{
		Integer ger = new Integer(s);
		int i = ger.intValue();
		return i;
	}
	
	public static String intToStr(int i)
	{
	String texte = new String();
	texte = texte.valueOf(i);
	return texte;
	}
}