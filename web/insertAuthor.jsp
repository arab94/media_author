<%-- 
    Document   : telaInicial
    Created on : 23/05/2016, 15:55:23
    Author     : alex
--%>
<%@page import="Entities.Theme"%>
<%@page import="DAO.ThemeDAO"%>
<%@page import="Entities.Speciality"%>
<%@page import="DAO.SpecialityDAO"%>
<%@page import="Entities.Media"%>
<%@page import="DAO.MediaDAO"%>
<%@page import="Entities.Country"%>
<%@page import="DAO.CountryDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entities.Region"%>
<%@page import="java.util.List"%>
<%@page import="DAO.RegionDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DARE-THINK: Insert Author</title>
        <link rel='stylesheet' href='style.css' type='text/css'>
    </head>
    <body>
        
        <div id="header1">
            <div class="logo"><a href="home.jsp"><img id="logo" src="img/medthor.png" alt="pinguim" /></a></div>
        </div>
	<div id="header2"></div>
        <br>
	<div id="mainbody">
            <div class="content" style="width:25%; float:left">
		<div class="title">Menu</div>
                <ul>
                    <li style="border-bottom: 5px solid #dfdfdf"><a href="author.jsp">Back</a></li>
                </ul>         
            </div>
            <div class="content" style="width:70%; float:right; margin-right: 7px">
		<div class="title">Insert Author</div>
                </br></br>
                <form id="simpleform" action="/Media_author/InsertAuthor" method="post">
                    <fieldset>
                        <legend>Personal</legend>
                        <div>
                            <label>Name:</label>
                            <input type="text" name="NAME_AUTHOR" size="auto"/>
                        </div>
                        <div>                             
                            <label>Country:</label>
                            <select name="NAME_COUNTRY">
                                <%
                                    RegionDAO region = new RegionDAO();
                                    List<Region> regions = new ArrayList();
                                    regions = region.listaRegion();
                                    for (int i = 0; i < regions.size(); i++) {
                                        out.println("<optgroup");
                                        out.println(" label='"+ regions.get(i).getNameRegion()+"'>");
                                        out.print("<div> "+regions.get(i).getNameRegion()+"</div>");
                                        CountryDAO country = new CountryDAO();
                                        List<Country> countries = new ArrayList();
                                        countries = country.listaCountry(regions.get(i).getIdRegion());
                                        for (int j = 0; j < countries.size(); j++) {
                                            out.println("<option>");
                                            out.println(countries.get(j).getNameCountry());
                                            out.println("</option>");
                                        }
                                        out.println("</optgroup>");
                                    }
                                %>    
                            </select>
                        </div>
                    </fieldset>
                    <br>
                    <input class="button" type="button" value="Cancel" style="font-size: 16px;" onclick="window.location.href='author.jsp';"/>
                    <input class="button" type="reset" value="Clean" style="font-size: 16px;">
                    <input class="button" type="submit" value="Insert" style="font-size: 16px;">
                </form>	
            </div>
	</div>
        <br>
        <div id="footer"></div>
    </body>
</html>
</c:if>
