-- BEGIN
DROP TABLE IF EXISTS products;

CREATE TABLE products (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          title VARCHAR(255) NOT NULL,
                          price VARCHAR(225) NOT NULL
);
-- END
