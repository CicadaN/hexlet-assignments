package exercise.repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import exercise.model.Product;

import java.sql.SQLException;
import java.sql.Statement;

public class ProductsRepository extends BaseRepository {

    // BEGIN
    public static void save(Product product) throws SQLException {
        String sql = "INSERT INTO products (title, price) VALUES (?, ?)";
        try (var conn = dataSource.getConnection();
             var preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, product.getTitle());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.executeUpdate();
            var generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                product.setId(generatedKeys.getLong(1));
            } else {
                throw new SQLException("DB did not return an id after saving an entity");
            }
        }
    }

    //    public static List<Product> find(int id) throws SQLException {
//        String sql = "SELECT * FROM products WHERE id = ?";
//        try (var conn = dataSource.getConnection();
//        var preparedStatement = conn.prepareStatement(sql)) {
//            preparedStatement.setInt(1, id);
//            preparedStatement.execute();
//        }
//    }
public static Optional<Product> find(Long id) throws SQLException {
    var sql = "SELECT * FROM products WHERE id = ?";
    try (var conn = dataSource.getConnection();
         var stmt = conn.prepareStatement(sql)) {
        stmt.setLong(1, id);
        var resultSet = stmt.executeQuery();
        if (resultSet.next()) {
            var title = resultSet.getString("title");
            var price = resultSet.getInt("price");
            var product = new Product(title, price);
            product.setId(id);
            return Optional.of(product);
        }
        return Optional.empty();
    }
}

    // Метод получения всех товаров
    public static List<Product> getEntities() throws SQLException {
        var sql = "SELECT * FROM products";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            var resultSet = stmt.executeQuery();
            var result = new ArrayList<Product>();
            while (resultSet.next()) {
                var id = resultSet.getLong("id");
                var title = resultSet.getString("title");
                var price = resultSet.getInt("price");
                var product = new Product(title, price);
                product.setId(id);
                result.add(product);
            }
            return result;
        }
    }
    // END
}
