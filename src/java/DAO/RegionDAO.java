/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Region;
import darethink.database_connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marce
 */
public class RegionDAO extends database_connection{
    Region r = new Region();
    String sql;
    
    public RegionDAO() throws Exception{
    }
    
    public Region getRegion(String nameRegion) throws Exception{
        this.conectar();
        sql = "SELECT * FROM region WHERE UPPER(NAME_REGION) LIKE UPPER('" +nameRegion+  "')";
        rs = stm.executeQuery(sql);
        if(rs.next()){
            r.setIdRegion(rs.getInt(1));
            r.setNameRegion(rs.getString(2));
        }
        this.connection.close();
        return r;
    }
    
    public Region getRegionbyID(Integer idRegion) throws Exception{
        this.conectar();
        sql = "SELECT  * FROM region WHERE ID_REGION = " + idRegion;
        rs = stm.executeQuery(sql);
        if(rs.next()){
            r.setIdRegion(rs.getInt(1));
            r.setNameRegion(rs.getString(2));
        }
        this.connection.close();
        return r;
    }
    
    public String getRegionNameById(Integer idRegion) throws Exception{
        this.conectar();
        sql = "SELECT * FROM region WHERE ID_REGION = " + idRegion;
        rs = stm.executeQuery(sql);
        String name = null;
        if(rs.next()){
            r.setIdRegion(rs.getInt(1));
            r.setNameRegion(rs.getString(2));
        }
        name = r.getNameRegion();
        this.connection.close();
        return name;
    }
    
    public int getRegionId(String nameRegion) throws Exception{
        this.conectar();
        sql = "SELECT ID_REGION FROM region WHERE NAME_REGION ='"+nameRegion+"'";
        rs = stm.executeQuery(sql);
        int id;
        if(rs.next()){
            r.setIdRegion(rs.getInt(1));
        }
        id = r.getIdRegion();
        this.connection.close();
        return id;
    }
    
    public List<Region> listaRegion() throws Exception{
        this.conectar();
        List<Region> listaRegion = new ArrayList();
        sql = "SELECT  * FROM  region";
        rs = stm.executeQuery(sql);
        while (rs.next()){
            r = new Region();
            r.setIdRegion(rs.getInt(1));
            r.setNameRegion(rs.getString(2));
            listaRegion.add(r);
        }
        this.connection.close();
        return listaRegion;
    }
    
    public List<Region> listaRegionRef() throws Exception{
        this.conectar();
        List<Region> listaRegion = new ArrayList();
        sql = "SELECT  * FROM  region WHERE ID_REGION NOT IN (SELECT ID_REGION FROM country)";
        rs = stm.executeQuery(sql);
        while (rs.next()){
            r = new Region();
            r.setIdRegion(rs.getInt(1));
            r.setNameRegion(rs.getString(2));
            listaRegion.add(r);
        }
        this.connection.close();
        return listaRegion;
    }
    
    public void insertRegion(String nameRegion) throws Exception{
        this.conectar();
        sql = "SELECT * FROM `region` WHERE `region`.`NAME_REGION` = '" + nameRegion+"'";
        rs = stm.executeQuery(sql);
        if(!rs.next()){
            sql = "INSERT INTO region (NAME_REGION) values (UPPER('" +nameRegion+  "'))";
            stm.executeUpdate(sql);
        }                
        this.connection.close();
    }
    
    public void updateRegion(String nameRegionOld, String nameRegion) throws Exception{
        this.conectar();
        sql = "UPDATE `region` SET NAME_REGION = (UPPER('"+nameRegion+"')) WHERE `region`.`NAME_REGION` =(UPPER('"+nameRegionOld+"'))";
        stm.executeUpdate(sql);
        this.connection.close();
    }
    
    public void deleteRegionName(String nameRegion) throws Exception{
        this.conectar();
        sql = "DELETE FROM `region` WHERE `region`.`NAME_REGION` = '" + nameRegion+"'";
        stm.executeUpdate(sql);
        this.connection.close();
    }
    
    public void deleteRegionId(Integer idRegion) throws Exception{
        this.conectar();
        sql = "DELETE FROM `region` WHERE `region`.`ID_REGION` = " + idRegion;
        stm.executeUpdate(sql);
        this.connection.close();
    }
    
    public List<Region> searchRegion(String nameRegion) throws Exception{
        this.conectar();
        List<Region> regions = new ArrayList();
        sql = "SELECT * FROM region WHERE NAME_REGION CONTAINS UPPER('" +nameRegion+ "')";
        rs = stm.executeQuery(sql);
        while(rs.next()){
            r = new Region();
            r.setIdRegion(rs.getInt(1));
            r.setNameRegion(rs.getString(2));
            regions.add(r);
        }
        this.connection.close();
        return regions;
    }
}
