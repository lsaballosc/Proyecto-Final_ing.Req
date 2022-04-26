/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import java.text.SimpleDateFormat;

public class getFecha {

    public String getFechaHoraESP(java.util.GregorianCalendar fechaHora) {
        String fecha = "";
        switch (fechaHora.get(java.util.Calendar.DAY_OF_WEEK)) {
            case java.util.Calendar.MONDAY:
                fecha = "Lunes, ";
                break;
            case java.util.Calendar.TUESDAY:
                fecha = "Martes, ";
                break;
            case java.util.Calendar.WEDNESDAY:
                fecha = "Miércoles, ";
                break;
            case java.util.Calendar.THURSDAY:
                fecha = "Jueves, ";
                break;
            case java.util.Calendar.FRIDAY:
                fecha = "Viernes, ";
                break;
            case java.util.Calendar.SATURDAY:
                fecha = "Sabado, ";
                break;
            case java.util.Calendar.SUNDAY:
                fecha = "Domingo, ";
        }
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        fecha = fecha + formatoFecha.format(fechaHora.getTime());
        return fecha;
    }

}
