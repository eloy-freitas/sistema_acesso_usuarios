
package com.ufes.sistemaacessousuarios.conexao;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoSQLite {
    
    public static Connection getConnection() throws SQLException{
        Connection conexao = null;
        try {
            Dotenv env = Dotenv.configure()
                    .directory("./resources")
                    .filename(".env")
                    .load();
            conexao = DriverManager.getConnection(
                    env.get("DB_URL")
            );
        } catch (SQLException ex) {
            throw new SQLException("Falha na conexão com banco.\n" 
                    + ex.getMessage());
        }
        
        return conexao;
    }
    
    public static void closeConnection(Connection conexao) throws SQLException{
        if(conexao != null){
            try {
                conexao.close();
            } catch (SQLException ex) {
                throw new SQLException("Erro ao encerrar conexão.\n" + ex);
            }
        }
    }
    
    public static void closeConnection(Connection conexao, Statement statement) throws SQLException, SQLException{
        if(conexao != null){
            try {
                conexao.close();
            } catch (SQLException ex) {
                throw new SQLException("Erro ao encerrar conexão.\n" + ex);
            }
        }
        if(statement != null){
            statement.close();
        }
    }
    
    public static void closeConnection(Connection conexao, Statement statement,
            ResultSet resultSet) throws SQLException{
        if(conexao != null){
            try {
                conexao.close();
            } catch (SQLException ex) {
                throw new SQLException("Erro ao encerrar conexão.\n" + ex);
            }
        }
        if(statement != null){
            statement.close();
        }
        if(resultSet != null){
            resultSet.close();
        }
    }
    
}

