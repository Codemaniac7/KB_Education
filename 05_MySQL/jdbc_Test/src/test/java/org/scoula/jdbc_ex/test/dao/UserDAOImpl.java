package org.scoula.jdbc_ex.test.dao;

import com.mysql.cj.protocol.Resultset;
import org.scoula.jdbc_ex.test.domain.UserVO;
import org.scoula.jdbc_test.common.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
////
public class UserDAOImpl implements UserDAO{
    Connection conn = JDBCUtil.getConnection();

    // USER 테이블 관련 SQL 명령어
    private String USER_LIST = "select * from user";
    private String USER_GET = "select * from users where id = ?";
    private String USER_INSERT = "insert into users values('?','?','?','?')";

    // 회원 등록
    @Override
    public int create(UserVO user) throws SQLException {
        try(PreparedStatement stmt = conn.prepareStatement(USER_INSERT)) {
            stmt.setString(1, user.getId());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getName());
            stmt.setString(4, user.getRole());
            return stmt.executeUpdate();
        }
    }

    private UserVO map(ResultSet rs) throws SQLException {
        UserVO user = new UserVO();
        user.setId(rs.getString("ID"));
        user.setPassword(rs.getString("PASSWORD"));
        user.setName(rs.getString("NAME"));
        user.setRole(rs.getString("ROLE"));
        return user;
    }

    // 회원 목록 조회
    @Override
    public List<UserVO> getList() throws SQLException {
        List<UserVO> userList = new ArrayList<UserVO>();
        try(PreparedStatement stmt = conn.prepareStatement(USER_LIST);
            ResultSet rs = stmt.executeQuery()) {
            while(rs.next()) {
                UserVO user = map(rs);
                userList.add(user);
            }
        }
        return userList;
    }

    // 회원 정보 조회
    @Override
    public Optional<UserVO> get(String id) throws SQLException {
        try(PreparedStatement stmt = conn.prepareStatement("select * from where name=?, role=? ")) {
            stmt.setString(1, id);
            try(ResultSet rs = stmt.executeQuery()) {
                if(rs.next()) {
                    return Optional.of(map(rs));
                }
            }
        }

        return Optional.empty();
    }

    // 회원 수정
    @Override
    public int update(UserVO user) throws SQLException {
        try(PreparedStatement stmt = conn.prepareStatement("update users set name=?, role=? where id = ?")) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getRole());
            stmt.setString(3, user.getId());
            return stmt.executeUpdate();
        }
    }

}
