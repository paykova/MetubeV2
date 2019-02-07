package metube.web.servlets;

import metube.domain.models.binding.UserRegisterBindingModel;
import metube.domain.models.service.UserServiceModel;
import metube.service.MappingService;
import metube.service.UserService;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class UserRegisterServlet extends HttpServlet {

    private final UserService userService;
    private final MappingService mappingService;

    @Inject
    public UserRegisterServlet(UserService userService, MappingService mappingService) {
        this.userService = userService;
        this.mappingService = mappingService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRegisterBindingModel userRegisterBindingModel = (UserRegisterBindingModel) req.getAttribute("model");

        if(!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())){
            req.getRequestDispatcher("/jsp/register.jsp").forward(req, resp);
            return;
        }

        this.userService.registerUser(this.mappingService.map(userRegisterBindingModel, UserServiceModel.class));

        resp.sendRedirect("/login");
    }
}
