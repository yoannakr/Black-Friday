package web;

import models.view.BlackFridayViewModel;
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

@WebServlet("/products/add/blackFriday")
public class ProductsAddBlackFridayServlet extends HttpServlet {

    private final ProductsService productsService;
    private final ModelMapper mapper;
    int id;

    @Inject
    public ProductsAddBlackFridayServlet(ProductsService productsService, ModelMapper mapper) {
        this.productsService = productsService;
        this.mapper = mapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id = Integer.parseInt(req.getParameter("id"));

        req.getRequestDispatcher("/products-add-blackFriday.jsp")
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double discount = Double.parseDouble(req.getParameter("discount"));

        try {
            productsService.updateDiscountOfProduct(id,discount);
            resp.sendRedirect("/home");
        } catch (Exception e) {
            resp.sendRedirect("/users/register");
        }
    }
}
