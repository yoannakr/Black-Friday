package web;

import models.entity.User;
import models.view.ProductViewModel;
import org.modelmapper.ModelMapper;
import services.ProductsService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/products/update")
public class ProductsUpdateServlet extends HttpServlet {

    private final ProductsService productsService;
    private final ModelMapper mapper;

    @Inject
    public ProductsUpdateServlet(ProductsService productsService,
                              ModelMapper mapper){
        this.productsService = productsService;
        this.mapper = mapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/products-update.jsp")
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        double price = Double.parseDouble(req.getParameter("price"));
        double minPrice = Double.parseDouble(req.getParameter("minPrice"));
        String username = req.getParameter("username");

        User user = productsService.getUser(username);

        try {
            productsService.updateProduct(name,quantity,price,minPrice,user);
            resp.sendRedirect("/home");
        } catch (Exception e) {
            resp.sendRedirect("/users/register");
        }
    }
}
