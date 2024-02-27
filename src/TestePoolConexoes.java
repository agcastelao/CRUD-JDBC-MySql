import java.sql.SQLException;

public class TestePoolConexoes {
    
    public static void main(String[] args) throws SQLException {
        
        ConnectionFactory factory = new ConnectionFactory();

        for (int i = 0; i < 20; i++) {
            factory.recuperarConexao();
            System.out.println("Conexão de número: " + i);
        }
    }
}
