package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 내가 어떤 DB를 사용하는지를 정해주는 연결 주소
        String connectionString = "jdbc:sqlite:db.sqlite";
        // DB에 연결하고
        try (Connection connection
                     = DriverManager.getConnection(connectionString)) {
            System.out.println("Connection Success!!!");

            // 데이터베이스에 SQL문(SQL Statement)를 전달할 준비를 한다.
            Statement statement = connection.createStatement();
            // 실제 SQL문을 전달한다.
            statement.execute("""
            DROP TABLE IF EXISTS user;
            """);
            statement.execute("""
            CREATE TABLE user (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                username TEXT,
                password TEXT,
                first_name TEXT,
                last_name TEXT,
                email TEXT
            );
            """);
            // 새로운 사용자 주가한다.
            statement.execute("""
            INSERT INTO user(username, password, first_name, last_name, email)
            VALUES ('alex', 'aaaa', 'Alex', 'Rod', 'alex@gmail.com');
            """);

//            String insertSql= """
//                    INSERT INTO user(username, password)
//                    VALUES ('%s', '%s');
//                    """;
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("input username");
//            String username = scanner.nextLine();
//            System.out.println("input password");
//            String password = scanner.nextLine();
//            statement.execute(String.format(insertSql, username, password));

            ResultSet resultSet = statement.executeQuery("""
            SELECT * FROM user;
                       
            """);
            resultSet.next();
            Long id = resultSet.getLong("id");
            System.out.println(id);
            String userName = resultSet.getString("username");
            System.out.println(userName);
        } catch (SQLException e) {
            System.err.println(e.getErrorCode());
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}