package web;

import models.entity.User;
import org.modelmapper.ModelMapper;
import services.ProductsService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/products/create")
public class ProductCreateServlet extends HttpServlet {

    private final ProductsService productsService;
    private final ModelMapper mapper;
    private final EntityManager entityManager;

    @Inject
    public ProductCreateServlet(ProductsService productsService,
                                ModelMapper mapper,
                                EntityManager entityManager) {
        this.productsService = productsService;
        this.mapper = mapper;
        this.entityManager = entityManager;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/products-create.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        double price = Double.parseDouble(req.getParameter("price"));
        double minPrice = Double.parseDouble(req.getParameter("minPrice"));
        String username = req.getSession().getAttribute("user").toString();


        User user = productsService.getUser(username);

        try {

            productsService.createProduct(name, quantity, price, minPrice, user);
            resp.sendRedirect("/home");

        } catch (Exception e) {
            resp.sendRedirect("/users/register");
        }
    }
}
