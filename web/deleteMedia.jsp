<%-- 
    Document   : deleteMedia
    Created on : 17-jun-2016, 15:59:41
    Media     : marce
--%>

<%@page import="Entities.Media"%>
<%@page import="DAO.MediaDAO"%>
<%@page import="Entities.Country"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entities.Region"%>
<%@page import="DAO.CountryDAO"%>
<%@page import="java.util.List"%>
<%@page import="DAO.RegionDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DARE-THINK: Delete Media</title>
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
                    <li style="border-bottom: 5px solid #dfdfdf"><a href="media.jsp">Back</a></li>
                </ul>         
            </div>
            <div class="content" style="width:70%; float:right; margin-right: 7px">
                <div class="title">Delete Media</div>
                </br></br>
                <form id="simpleform" action="/Media_author/DeleteMedia" method="post">
                    <fieldset>
                        <legend>Media</legend>
                        <div>
                            <label>Name:</label>
                            <select name="NAME_COUNTRY"/>
                            <%
                                CountryDAO country = new CountryDAO();
                                List<Country> countries = new ArrayList();
                                countries = country.listaCountry();
                                for(int i = 0; i < countries.size(); i++){
                                    out.println("<option>");
                                    out.print(countries.get(i).getNameCountry());
                                    out.println("</option>");
                                }
                            %>
                            </select>
                            <select name="NAME_MEDIA"/>
                            <%
                                String msg = (String) request.getSession().getAttribute("N_COUNTRY"); 
                                MediaDAO media = new MediaDAO();
                                List<Media> medias = new ArrayList();
                                CountryDAO daoc = new CountryDAO();
                                int id_country = daoc.getCountryId(request.getParameter("N_COUNTRY"));
                                medias = media.listaMediaRef(id_country);
                                for (int k = 0; k < medias.size(); k++) {
                                    out.println("<option>");
                                    out.println(medias.get(k).getNameMedia());
                                    out.println("</option>");
                                }
                            %>
                            </select>
                        </div>
                    </fieldset>
                    <br>
                    <input class="button" type="button" value="Cancel" style="font-size: 16px;" onclick="window.location.href = 'media.jsp';"/>
                    <input class="button" type="submit" value="Delete" style="font-size: 16px;">
                </form>	
            </div>
        </div>
        <br>
        <div id="footer"></div>
    </body>
</html>
