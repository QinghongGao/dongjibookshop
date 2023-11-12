package store.dongji.web.servlet;

import store.dongji.pojo.Administrator;
import store.dongji.service.AdministratorService;
import store.dongji.service.impl.AdministratorServiceImpl;
import store.dongji.util.ResultJson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/admin/*")
public class LoginServlet extends BaseServlet{
    private AdministratorService administratorService = new AdministratorServiceImpl();
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO 设置Filter解决编码问题
        req.setCharacterEncoding("UTF-8");

        Administrator source = new Administrator();
        source.setAdministratorname(req.getParameter("administratorname"));
        source.setPassword(req.getParameter("password"));

        Administrator result = administratorService.queryByAdminnameAndPassword(source);

        if(result!=null){
            if(result.getStatus() == 1){
                req.getSession().setAttribute("loginInfo",result);
                resp.getWriter().println(ResultJson.ok());
            }else{
//                resp.getWriter().println(ResultJson.error("该用户已被封禁"));
                resp.getWriter().println(ResultJson.error("该用户已被封禁"));
            }
        }else{
//            resp.getWriter().println(ResultJson.error("用户名或密码不正确"));
            resp.getWriter().println(ResultJson.error("wrong name or password"));
        }
    }

}
