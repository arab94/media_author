/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Author;
import Entities.AuthorSpeciality;
import Entities.Country;
import Entities.Media;
import Entities.Speciality;
import darethink.database_connection;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author marce
 */
public class AuthorSpecialityDAO extends database_connection {

    AuthorSpeciality as = new AuthorSpeciality();
    String sql;

    public AuthorSpecialityDAO() throws Exception {
    }

    public AuthorSpeciality getAuthorSpeciality(Integer idAuthor, Integer idTheme, Integer idCountry, Integer idMedia) throws Exception {
        sql = "SELECT * FROM `speciality` WHERE `speciality`.`ID_SPEC` = " + idAuthor + "`speciality`.`ID_THEME`" + idTheme + "`speciality`.`ID_COUNTRY`" + idCountry + "`speciality`.`ID_MEDIA`" + idMedia;
        rs = stm.executeQuery(sql);
        if (rs.next()) {
            as.setAuthor((Author) rs.getObject(1));
            //as.setTheme((Theme) rs.getObject(2));
            as.setCountry((Country) rs.getObject(3));
            as.setMedia((Media) rs.getObject(4));
        }
        return as;
    }

    public List<AuthorSpeciality> listaAuthorSpeciality() throws Exception {
        List<AuthorSpeciality> listaAS = new LinkedList();
        sql = "SELECT * FROM `speciality`";
        rs = stm.executeQuery(sql);
        while (rs.next()) {
            as = new AuthorSpeciality();
            as.setAuthor((Author) rs.getObject(1));
            //as.setTheme((Theme) rs.getObject(2));
            as.setCountry((Country) rs.getObject(3));
            as.setMedia((Media) rs.getObject(4));
            listaAS.add(as);
        }
        return listaAS;
    }

    public List<AuthorSpeciality> listaAuthorSpecialityIdAuthor(Integer idAuthor) throws Exception {
        List<AuthorSpeciality> listaAS = new LinkedList();
        sql = "SELECT * FROM `speciality` WHERE `speciality`.`ID_SPEC` = " + idAuthor;
        rs = stm.executeQuery(sql);
        while (rs.next()) {
            as = new AuthorSpeciality();
            as.setAuthor((Author) rs.getObject(1));
            //as.setTheme((Theme) rs.getObject(2));
            as.setCountry((Country) rs.getObject(3));
            as.setMedia((Media) rs.getObject(4));
            listaAS.add(as);
        }
        return listaAS;
    }

    public List<AuthorSpeciality> listaAuthorSpecialityIdTheme(Integer idTheme) throws Exception {
        List<AuthorSpeciality> listaAS = new LinkedList();
        sql = "SELECT * FROM `speciality` WHERE `speciality`.`ID_THEME`" + idTheme;
        rs = stm.executeQuery(sql);
        while (rs.next()) {
            as = new AuthorSpeciality();
            as.setAuthor((Author) rs.getObject(1));
            //as.setTheme((Theme) rs.getObject(2));
            as.setCountry((Country) rs.getObject(3));
            as.setMedia((Media) rs.getObject(4));
            listaAS.add(as);
        }
        return listaAS;
    }

    public List<AuthorSpeciality> listaAuthorSpecialityIdCountry(Integer idCountry) throws Exception {
        List<AuthorSpeciality> listaAS = new LinkedList();
        sql = "SELECT * FROM `speciality` WHERE `speciality`.`ID_COUNTRY`" + idCountry;
        rs = stm.executeQuery(sql);
        while (rs.next()) {
            as = new AuthorSpeciality();
            as.setAuthor((Author) rs.getObject(1));
            //as.setTheme((SpecificTheme) rs.getObject(2));
            as.setCountry((Country) rs.getObject(3));
            as.setMedia((Media) rs.getObject(4));
            listaAS.add(as);
        }
        return listaAS;
    }

    public List<AuthorSpeciality> listaAuthorSpecialityIdMedia(Integer idMedia) throws Exception {
        List<AuthorSpeciality> listaAS = new LinkedList();
        sql = "SELECT * FROM `speciality` WHERE `speciality`.`ID_MEDIA`" + idMedia;
        rs = stm.executeQuery(sql);
        while (rs.next()) {
            as = new AuthorSpeciality();
            as.setAuthor((Author) rs.getObject(1));
            //as.setTheme((SpecificTheme) rs.getObject(2));
            as.setCountry((Country) rs.getObject(3));
            as.setMedia((Media) rs.getObject(4));
            listaAS.add(as);
        }
        return listaAS;
    }

    public void insertAuthorSpeciality(int idAuthor, int idSpec, int idCountry, int idMedia) throws Exception {
        this.conectar();
        sql = "INSERT INTO author_speciality (ID_AUTHOR, ID_SPEC, ID_COUNTRY, ID_MEDIA) VALUES (" + idAuthor + ", " + idSpec + ", " + idCountry + ", " + idMedia + ")";
        stm.executeUpdate(sql);
        this.connection.close();
    }

    public void changeAuthorSpeciality() throws Exception {
        sql = "";
        stm.executeUpdate(sql);
    }

    public void deleteAuthorSpeciality(Integer idAuthor, Integer idTheme, Integer idCountry, Integer idMedia) throws Exception {
        sql = "DELETE FROM `speciality` WHERE `speciality`.`ID_SPEC` = " + idAuthor + "`speciality`.`ID_THEME`" + idTheme + "`speciality`.`ID_COUNTRY`" + idCountry + "`speciality`.`ID_MEDIA`" + idMedia;
        stm.executeUpdate(sql);
    }
}
