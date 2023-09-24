package servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/firstServlet")
public class FirstServlet extends HttpServlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            System.out.println(req.getHeader(header));
        }

        resp.setContentType("text/html; charset=UTF-8");
        resp.setHeader("token", "1234567");
        try (PrintWriter writer = resp.getWriter()) {
            writer.write("Hello from first servlet");
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
