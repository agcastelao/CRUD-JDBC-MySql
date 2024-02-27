import java.sql.Connection;

public class TestaConexao {
    public static void main(String[] args) throws Exception {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();

        System.out.println("Fechando conexão");

        connection.close();
    }
}
