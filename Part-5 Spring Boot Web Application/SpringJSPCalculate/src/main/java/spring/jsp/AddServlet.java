package spring.jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Created 27 / 03 / 2020 - 5:56 PM
 * @project SpringJSP
 * @Author Hamdamboy
 */
@WebServlet("/add")
public class AddServlet extends HttpServlet {
    //
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

            int i = Integer.parseInt(request.getParameter("num1"));
            int j = Integer.parseInt(request.getParameter("num2"));

            int k = i + j;

            PrintWriter out = response.getWriter();
            out.println("OutPut:" + k);
        }
}
