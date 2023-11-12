package store.dongji.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{
    public void test(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("测试BaseServlet");
    }
}
