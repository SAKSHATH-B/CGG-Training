package cgg.attr;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/s1")
public class S1 extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    String n1 = req.getParameter("n1");
    String n2 = req.getParameter("n2");

    int nn1 = Integer.parseInt(n1);
    int nn2 = Integer.parseInt(n2);

    int sum = nn1 + nn2;

    req.setAttribute("s", sum);
    RequestDispatcher rd = req.getRequestDispatcher("/s2");
    rd.forward(req, resp);
  }
}
