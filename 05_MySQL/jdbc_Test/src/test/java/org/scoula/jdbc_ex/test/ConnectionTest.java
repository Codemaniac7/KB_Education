package org.scoula.jdbc_ex.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.scoula.jdbc_test.common.JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

        @Test
    @DisplayName("jdbc_Test에 접속한다.(자동 닫기)")
    public void testConnection2() throws SQLException {
        try(Connection conn = JDBCUtil.getConnection()) {
            System.out.println("DB연결 성공");
        }
    }

//    @Test
//    @DisplayName("jdbc_Test 데이터베이스에 접속한다.")
//    public void testConnection() throws SQLException, ClassNotFoundException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        String url = "jdbc:mysql://localhost:3306/jdbc_Test";
//        String id = "jdbc_Test";
//        String password = "jdbc_Test";
//        Connection conn = DriverManager.getConnection(url, id, password);
//        System.out.println("DB 연결 성공");
//        conn.close();
//    }


}
