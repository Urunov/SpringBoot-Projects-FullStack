package spring.basic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Created 23 / 03 / 2020 - 4:12 PM
 * @project SpringServletFilter
 * @Author Hamdamboy
 */
public class MyServlet extends HttpServlet {
    //
    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("MyServlet's doGet() method is invoked.");
        doAction(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("MyServlet's doPost() method is invoked.");
        doAction(req, resp);
    }

    private void doAction(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        resp.setContentType("text/plain");
        resp.getWriter().write("Hello " + name + "!");
    }
}
