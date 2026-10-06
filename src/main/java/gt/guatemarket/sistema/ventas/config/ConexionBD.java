/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.guatemarket.sistema.ventas.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author omary
 */
public class ConexionBD {

    private static final String URL
            = "jdbc:mysql://192.168.1.19:3306/sistema-ventas";

    private static final String USUARIO = "sistema";
    private static final String PASSWORD = "proyprogra";
 
    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(
                URL,
                USUARIO,
                PASSWORD
        );
    }
}
