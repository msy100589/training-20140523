package com.catapult.training.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jvergara <jvergara@gocatapult.com>
 */
@WebServlet("/todo")
public class TodoServlet extends HttpServlet
{

    private static final String PAGE_LIST = "/jsp/todo/list.jsp";
    private static final String PAGE_FORM = "/jsp/todo/form.jsp";

    private static final List<String> list = new ArrayList();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        if (req.getParameter("add") != null) {
            String task = req.getParameter("task");
            if (task != null && !task.isEmpty()) {
                list.add(req.getParameter("task"));
                resp.sendRedirect("todo");
            }
            else {
                getServletContext().getRequestDispatcher(PAGE_FORM)
                        .forward(req, resp);
            }

            return;
        }

        req.setAttribute("taskList", list);
        getServletContext().getRequestDispatcher(PAGE_LIST)
                .forward(req, resp);
    }

}
