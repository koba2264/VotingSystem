package tool;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter(urlPatterns={"/*"})
public class EncodingFilter implements Filter {

	public void doFilter(
		ServletRequest request, ServletResponse response,
		FilterChain chain
	) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            String uri = httpRequest.getRequestURI();
            if (uri.endsWith(".html") || uri.endsWith(".action") || uri.equals("/")) {
                response.setContentType("text/html; charset=UTF-8");
            } else if (uri.endsWith(".css")) {
            	response.setContentType("text/css; charset=UTF-8");
            } else if (uri.endsWith(".js")) {
            	response.setContentType("application/javascript; charset=UTF-8");
            }
        };

//		response.setContentType("text/html; charset=UTF-8");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) {}
	public void destroy() {}

}
