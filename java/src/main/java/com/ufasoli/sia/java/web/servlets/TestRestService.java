package com.ufasoli.sia.java.web.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * User: ufasoli
 * Date: 05/07/13
 * Time: 16:01
 * project : scala-sia
 */


public class TestRestService extends HttpServlet{



    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("CALLING GET");

        PrintWriter out = response.getWriter();
        out.println("Get method called");
        out.println("parameters: " + parameters(request));
        out.println("headers: " + headers(request));
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println("Post method called");
        out.println("parameters : " + parameters(request));
        out.println("headers: " + headers(request));
    }

    public void doDelete(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Delete method called");
    }


    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Post method called");
        out.println("parameters : " + parameters(request));
        out.println("headers: " + headers(request));
    }


    @Override
    protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println("Allow : POST,DELETE,PUT,GET,OPTIONS");


    }

    private String parameters(HttpServletRequest request) {
        StringBuilder builder = new StringBuilder();
        for (Enumeration e = request.getParameterNames(); e.hasMoreElements(); ) {
            String name = (String) e.nextElement();
            builder.append("|" + name + "->" + request.getParameter(name));
        }
        return builder.toString();
    }

    private String headers(HttpServletRequest request) {
        StringBuilder builder = new StringBuilder();
        for (Enumeration e = request.getHeaderNames(); e.hasMoreElements(); ) {
            String name = (String) e.nextElement();
            builder.append("|" + name + "->" + request.getHeader(name));
        }
        return builder.toString();
    }

}


