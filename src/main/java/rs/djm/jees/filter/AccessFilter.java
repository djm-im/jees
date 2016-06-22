package rs.djm.jees.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author djm.rs
 */
public class AccessFilter implements Filter {

    private static final List<String> NO_AUTH_URLS
            = Arrays.asList("/index.jsp", "/login", "/logout");

    private boolean checkAuthForUrl(String url) {
        if (AccessFilter.NO_AUTH_URLS.contains(url)) {
            return false;
        }

        return true;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String url = httpRequest.getServletPath();

        if (checkAuthForUrl(url)) {
            if (httpRequest.getSession().getAttribute("user") == null) {
                final String[] errorMessages = new String[]{"You are not authorized to access."};
                httpRequest.setAttribute("errors", errorMessages);

                httpRequest.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig fc) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}
