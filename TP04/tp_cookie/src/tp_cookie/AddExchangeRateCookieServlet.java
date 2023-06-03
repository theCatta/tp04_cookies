package tp_cookie;

/*
 * Gabriel Ferreira de Souza
 * Guilherme Ferreira Santos
 */

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;

@WebServlet(name = "saveExchangeRatesServlet",
        urlPatterns = {"/save-exchange-rates-pair"},
        loadOnStartup = 1)
public class AddExchangeRateCookieServlet extends HttpServlet {
     static final String currencyPairKey = "currencyPair";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String thePair = req.getParameter(currencyPairKey);
        if (thePair != null) {
            Cookie cookie = new Cookie(currencyPairKey, thePair);
            cookie.setMaxAge(30 * 24 * 60 * 60);// for 30 days
            resp.addCookie(cookie);
            //better to redirect a post request
            resp.sendRedirect("/tp_cookie/exchange-rate");
        }
    }
}