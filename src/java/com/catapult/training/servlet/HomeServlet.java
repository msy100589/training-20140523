package com.catapult.training.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jvergara <jvergara@gocatapult.com>
 */
public class HomeServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/html");

        if (req.getServletPath().endsWith("/home")) {
            resp.getWriter().write("<h1>Welcome to Basic Servlet Training - May 23, 2014</h1>");
        }
        else {
            resp.getWriter().write("Marlon gwapo!");
        }
    }

}
