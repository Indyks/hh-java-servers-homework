package servlet;

import counter.Counter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/counter")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.print("value = " + Counter.get());
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        Counter.increment();
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException {
        try {
            Counter.decrease(Integer.parseInt(request.getHeader("Subtraction-Value")));
        } catch (NumberFormatException e) {
            System.out.println("Неверный заголовок \"Subtraction-Value\"");
        }
    }
}
