package com.example.pruebaBackend;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ProductServiceInterceptor  implements HandlerInterceptor {

    //se utiliza para realizar operaciones antes de enviar la solicitud al controlador.
    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("Entra al interceptor");

        return true;
    }
    //se utiliza para realizar operaciones antes de enviar la respuesta al cliente.
    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {}


    //se utiliza para realizar operaciones después de completar la solicitud y la respuesta.
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception exception) throws Exception {}
}
