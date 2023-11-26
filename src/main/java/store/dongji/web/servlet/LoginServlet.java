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
    private final AdministratorService administratorService = new AdministratorServiceImpl();
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO 设置Filter解决编码问题
//        req.setCharacterEncoding("UTF-8");
//        resp.setCharacterEncoding("UTF-8");


        Administrator source = new Administrator();
        source.setAdministratorName(req.getParameter("administratorName"));
        source.setPassword(req.getParameter("password"));
        System.out.println("账号："+req.getParameter("administratorName")+"密码："+req.getParameter("password"));

        Administrator result = administratorService.queryByAdministratorNameAndPassword(source);

        //查询到的管理员不为空
        if(result!=null){
            //查询到的管理员启用状态，可以登录
            if(result.getStatus() == 1){
                req.getSession().setAttribute("loginInfo",result);
                resp.getWriter().println(ResultJson.ok());
            }else{
                resp.getWriter().println(ResultJson.error("该用户已被封禁"));
            }
        }else{
            resp.getWriter().println(ResultJson.error("用户名或密码不正确"));
        }
    }

}
