package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String servletPath= ((HttpServletRequest) request).getServletPath();
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr + " client request to " + servletPath );
        long s = System.currentTimeMillis();
        chain.doFilter(request, response);
        long e = System.currentTimeMillis();
        System.out.println("request resolved time : " + (e - s) + "ms");
    }
}
