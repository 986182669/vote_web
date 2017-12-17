package org.web.vote.dao;

import org.web.vote.util.InputConfigFile;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class UtilDao {
    private static String driver =null;
    private static String url = null;
    private static String name = null;
    private static String pwd = null;
    public Connection conn;
    public PreparedStatement pst = null;
    public ResultSet rs = null;
    public String sql = null;
    public int id = 0;

    public UtilDao() {
        try {
            Properties properties = InputConfigFile.getConfigFile("E:\\vote\\src\\jdbc.properties");
            System.out.println(properties.toString()+"######################");
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            name = properties.getProperty("username");
            pwd = properties.getProperty("pwd");

            Class.forName(driver);
            conn = DriverManager.getConnection(url,name,pwd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ResultSet getUser(String sql) throws SQLException {

        pst = conn.prepareStatement(sql);
        return pst.executeQuery();
    }

    public ResultSet getLisrAll(String sql) throws SQLException {

        pst = conn.prepareStatement(sql);
        return pst.executeQuery();


    }
    public ResultSet query(String sql) throws SQLException {
        pst = conn.prepareStatement(sql);
        return  pst.executeQuery();
    }
    public int insert(String sql) throws SQLException {
        pst  = conn.prepareStatement(sql);
        return pst.executeUpdate();
    }
    public void close(){
        try {
            if(rs != null){
                rs.close();
            }
            if(pst != null){
                pst.close();
            }
            if (conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
