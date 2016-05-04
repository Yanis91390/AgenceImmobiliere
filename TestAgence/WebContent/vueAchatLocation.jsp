<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="Header.jsp" %>

	
<section id="top-b" class="grid-block">
	<div class="grid-box width100 grid-h">
				<div class="module mod-box mod-box-default encartAccueilInfo deepest">

<form method="post" action="rechercheBien.jsp">

	<label for="bien_imm">Region du bien immobilier :</label>
       <input type="text" name="departement"/><br><br>
       
    <label for="loyers">Loyer :</label>
       <input type="text" name="loyer"/><br><br>
 
 	<input type="radio" name="achat" value="achat"/>Achat - 
    <input type="radio" name="louer" value="louer"/>Location<br /><br />
   
    <label for="budget">Budget compris entre :</label>
       <input type="text" name="budget_min"/>

       <label for="pass"> et </label>
       <input type="text" name="budget_max"/><br><br>
   <fieldset>
   
       <legend>Type de Bien</legend> <!-- Titre du fieldset --> 

        <p>
       <input type="radio" name="maison" value="masion"/>Maison - 
       <input type="radio" name="apartement" value="apartement" />Apartment - 
       <input type="radio" name="terrain" value="terrain" />Terrain - 
       <input type="radio" name="studio" value="studio"/>Studio - 
       <input type="radio" name="entrepot" value="entrepot"/>Entrepot
   </p>

   </fieldset>
 
   <fieldset>
       <legend>Nombre de pièce et chambre</legend> <!-- Titre du fieldset -->

       <select name="pays" id="pays">
           <option value="default">-- Nombre de pièce --</option>
           <option value="1">1</option>
           <option value="2">2</option>
           <option value="3">3</option>
           <option value="4">4</option>
           <option value="5">5</option>
           <option value="6">6</option>

       </select>

       <select name="pays" id="pays">
           <option value="default">-- Nombre de chambre --</option>
           <option value="1">1</option>
           <option value="2">2</option>
           <option value="3">3</option>
           <option value="4">4</option>
           <option value="5">5</option>
           <option value="6">6</option>
       </select>
       
   </fieldset>
   
   <fieldset>
       <legend>Commodité</legend> <!-- Titre du fieldset --> 

       <p>
       <input type="checkbox" name="climatisation" />Climatisation -
       <input type="checkbox" name="alarme" />Alarme -
       <input type="checkbox" name="placard" />Placard - 
       <input type="checkbox" name="digicode" />Digicode - 
       <input type="checkbox" name="chemine" />Chemine -
       <input type="checkbox" name="ascenceur" />Ascenceur
   </p>

   </fieldset>
   <br><input type="submit" value="Rechercher" >
</form>

</div></div></section>

<%@include file="Footer.jsp" %>