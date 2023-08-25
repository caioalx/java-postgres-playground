package com.example.escola.dao;

import java.sql.Connection;

public class DAO {
    private Connection conn;
    
    public DAO(Connection conn) {
        this.conn = conn;
    }

    public Connection getConn() {
        return conn;
    }
}
