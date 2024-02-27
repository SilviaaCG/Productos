package com.example.demo.interceptors;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import java.time.LocalTime;

@Component("horarioInterceptor")
public class HorarioInterceptor implements HandlerInterceptor {

    private static final LocalTime openHour = LocalTime.of(23, 0); // Hora de inicio permitida (22:00)
    private static final LocalTime closeHour = LocalTime.of(6, 0);   // Hora de finalización permitida (6:00)

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        LocalTime horaActual = LocalTime.now();
        if (horaActual.isAfter(openHour) || horaActual.isBefore(closeHour)) {
            // Si la hora actual está dentro del rango restringido, devuelve falso y bloquea el acceso
            response.getWriter().write("La aplicación no está disponible en este momento. Por favor, inténtalo más tarde.");
            return false;
        }
        return true;

    }
}
