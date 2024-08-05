package org.scoula.jdbc_ex.test.dao;

import org.scoula.jdbc_ex.test.domain.UserVO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserDAO {
    int create(UserVO user) throws SQLException;

    List<UserVO> getList() throws SQLException;

    Optional<UserVO> get (String id) throws SQLException;

    int update(UserVO user) throws SQLException;

    int delete(String id) throws SQLException;
}
