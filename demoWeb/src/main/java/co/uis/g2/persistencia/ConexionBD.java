package co.uis.g2.persistencia;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {

    private String DB_driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/biblioteca?serverTimezone=UTC";
    private String username = "root";
    private String password = "MYSQLCentic";
    private Connection con = null;

    public ConexionBD() {
        try {
            Class.forName(DB_driver);
            con = DriverManager.getConnection(url, username, password);
            con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            System.out.println("Conectado");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        return con;
    }

    public void closeConnection() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ResultSet consultarBD(String sentencia) {
        try (Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            return stmt.executeQuery(sentencia);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean insertarBD(String sentencia) {
        try (Statement stmt = con.createStatement()) {
            stmt.execute(sentencia);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean borrarBD(String sentencia) {
        try (Statement stmt = con.createStatement()) {
            stmt.execute(sentencia);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean actualizarBD(String sentencia) {
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate(sentencia);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean setAutoCommitBD(boolean parametro) {
        try {
            con.setAutoCommit(parametro);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean commitBD() {
        try {
            con.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean rollbackBD() {
        try {
            con.rollback();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static void main(String[] args) {
        ConexionBD c = new ConexionBD();
        c.closeConnection();
    }
}
