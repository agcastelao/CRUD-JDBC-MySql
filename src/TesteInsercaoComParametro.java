import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsercaoComParametro {
    public static void main(String[] args) throws SQLException{

        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.recuperarConexao();

        connection.setAutoCommit(false);

        try {
            PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            adicionarVariavel("SmartTV", "45 polegadas", stm);
            adicionarVariavel("Radio", "Movido a bateria", stm);

            connection.commit(); 

            stm.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ROLLBACK EXECUTADO");
            connection.rollback();
        }
        

        

    }

    private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
        
        stm.setString(1, nome);
        stm.setString(2, descricao);

        // if(nome.equals("Radio")) {
        //     throw new RuntimeException("Não foi possivel adicionar o produto");
        // }
        
        stm.execute();

        ResultSet rst = stm.getGeneratedKeys();

        while(rst.next()) {
            Integer id = rst.getInt(1);
            System.out.println("O id criado foi " + id);
        }
    }
}
