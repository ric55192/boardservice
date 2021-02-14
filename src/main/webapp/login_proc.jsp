<%--
  Created by IntelliJ IDEA.
  User: Taewoo
  Date: 2021-02-10(010)
  Time: 오후 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.springbook.biz.user.impl.UserDAO"%>
<%@page import="com.springbook.biz.user.UserVO"%>
<%@ page contentType="text/html;charset=EUC-KR"%>
<%
    //1. 사용자 입력 정보 추출
    String id = request.getParameter("id");
    String password = request.getParameter("password");

    //2. DB 연동
    UserVO vo = new UserVO();
    vo.setId(id);
    vo.setPassword(password);

    UserDAO userDAO = new UserDAO();
    UserVO user = userDAO.getUser(vo);

    if(user != null){
        System.out.println("user isn't null");
        response.sendRedirect("getBoardList.jsp");
    }else{
        System.out.println("user is null");
        response.sendRedirect("login.jsp");

    }
%>
