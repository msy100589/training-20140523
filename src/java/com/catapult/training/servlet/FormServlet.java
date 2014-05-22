package com.catapult.training.servlet;

import java.io.IOException;
import java.io.Writer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jvergara <jvergara@gocatapult.com>
 */
@WebServlet("/form")
public class FormServlet extends HttpServlet
{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/html");
        Writer writer = resp.getWriter();
        writer.write("<html>");
        writer.write("<body>");
        writer.write(" <form method='post'>");
        writer.write(" <input type='text' name='name' placeholder='Type your name' size='50'>");
        writer.write(" <button type='submit'>Post</button>");
        writer.write(" </form>");

        String name = req.getParameter("name");
        if (name != null && !name.isEmpty()) {
            writer.write("<h3>Hi ");
            writer.write(name);
            writer.write("!</h3>");
        }

        writer.write("</body>");
        writer.write("</html>");
    }

}
