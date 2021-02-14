package com.springbook.view.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "action", value = "/DispatcherServlet",urlPatterns = ".do")
public class DispatcherServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("EUC-KR");
        process(request,response);
    }

    private  void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uri = request.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/"));
        System.out.println(path);

        if(path.equals("/login.do")){
            System.out.println("로그인 처리");
        } else if(path.equals("/logout.do")){
          System.out.println("로그아웃 처리");  
        }else if(path.equals("/insertBoard.do")){
            System.out.println("글 등록 처리");
        }else if(path.equals("/updateBoard.do")){
            System.out.println("글 수정 처리");
        }else if(path.equals("/deleteBoard.do")){
            System.out.println("글 삭제 처리");
        }else if(path.equals("/getBoard.do")){
            System.out.println("글 상세 조회 처리");
        }else if(path.equals("/getBoardList.do")){
            System.out.println("글 목록 검색 처리");
        }
    }




}
