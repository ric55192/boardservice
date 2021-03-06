package com.springbook.biz.user.impl;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserVO;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository("userDAO")
public class UserDAO {

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    //sql
    private final String USER_GET = "select * from users where id=? and password=?";

    public UserVO getUser(UserVO vo) {
        UserVO user = null;
        try {
            System.out.println("===> JDBC로 getUser() 기능 처리");


            conn = JDBCUtil.getConnection();//DB연결
            stmt = conn.prepareStatement(USER_GET);//준비
            stmt.setString(1, vo.getId());//setting
            stmt.setString(2, vo.getPassword());
            rs = stmt.executeQuery();//실행

            if (rs.next()) {
                System.out.println("Im in rs");
                user = new UserVO();
                user.setId(rs.getString("ID"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setName(rs.getString("NAME"));
                user.setRole(rs.getString("ROLE"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return user;
    }
}
