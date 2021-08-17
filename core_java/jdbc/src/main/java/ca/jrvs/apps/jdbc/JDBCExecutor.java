package ca.jrvs.apps.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDBCExecutor {

  final static Logger logger = LoggerFactory.getLogger(JDBCExecutor.class);

  public static void main(String[] args) throws SQLException {
    DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "hplussport",
        "postgres", "password");
    try {
      Connection connection = dcm.getConnection();
      OrderDAO orderDAO = new OrderDAO(connection);
      Order order = orderDAO.findById(1000);
      System.out.println(order.toString());

    } catch (SQLException e) {
      logger.error("Connection Error", e);
      throw new RuntimeException(e);
    }
  }
}
