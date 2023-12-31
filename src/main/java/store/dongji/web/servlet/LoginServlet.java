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
        //获取前端输入的账号密码
        Administrator source = new Administrator();
        source.setAdministratorName(req.getParameter("administratorName"));
        source.setPassword(req.getParameter("password"));
        //获取数据库中查询的管理员账户
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
