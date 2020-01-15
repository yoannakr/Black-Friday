package filter;

import models.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebFilter(urlPatterns = {
        "/*"
})
public class AuthFilter implements Filter {
    private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(
            Arrays.asList("", "/index", "/users/login", "/users/register","/css/style.css","/css/flower.jpg")));
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String path = request.getRequestURI().substring(request.getContextPath().length()).replaceAll("[/]+$", "");
        boolean allowedPath = ALLOWED_PATHS.contains(path);

        Object username = request.getSession()
                .getAttribute("user");
        if(allowedPath || username != null){
            filterChain.doFilter(request, response);
        }else if(username == null) {
            response.sendRedirect("/users/login");
        }
    }

}
