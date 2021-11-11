package com.aetebexams.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Pool {

    Connection con;
    String db_username;
    String db_password;
    String host = "localhost";
    String schema;

    public Pool() {

    }

    public Pool(String user, String pass) {
        this.db_username = user;
        this.db_password = pass;
    }

    public Pool(String user, String pass, String db) {
        this.db_username = user;
        this.db_password = pass;
        this.schema = db;
    }

    public Connection connect(){

        String db_url = "jdbc:mysql://"+host+":3306/"+schema;

        try {


            con = DriverManager.getConnection(db_url, db_username, db_password);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }


        return con;
    }

    public boolean connectTwo(){

        String db_url = "jdbc:mysql://"+host+":3306/"+schema;

        boolean connected = true;

        try {

            con = DriverManager.getConnection(db_url, db_username, db_password);

            connected = true;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

            connected = false;
        }

        return connected;
    }

}