package filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;



//como o front e back funcionam em portas e hosts diferentes, o CORS bloqueia o front do back isso n pode ocorrer para isso usamos essa classe que permite o front de acessar pelo navegador
@WebFilter("/*")
public class CorsFilter implements Filter {

    private static final Set<String> IPS_PERMITIDOS = new HashSet<>(Arrays.asList(
            "127.0.0.1",
            "189.57.250.90",
            "10.10.9.141",
            "0:0:0:0:0:0:0:1"
    ));

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {





        //response e request
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        String clienteIp = getClienteIp(httpRequest);
        System.out.println("Clinte tentando conexão: "+clienteIp);
        if (!isIpPermitido(clienteIp)) {
            httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
            httpResponse.setContentType("application/json");
            httpResponse.getWriter().write("{\"error\": \"IP não autorizado\"}");
            return;
        }

        //header principaç, permite filtrar a origem da requisição
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");

        // Adiciona os filtros necessarios no header da requisção para permitir o front passar
        httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST");
        httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept");
        httpResponse.setHeader("Access-Control-Max-Age", "3600");


        //permite usar options, n me pergunte o pq ou como
        if ("OPTIONS".equalsIgnoreCase(httpRequest.getMethod())) {
            httpResponse.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        //tipo o do get do servlet normal
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}



    //esse método pega um monte de IFs pq o ip pode tar em varios locais da req
    private String getClienteIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    private boolean isIpPermitido(String ip) {
        // ve se o ip é permitido
        if (IPS_PERMITIDOS.isEmpty()) {
            return true;
        }
        return IPS_PERMITIDOS.contains(ip);
    }
}