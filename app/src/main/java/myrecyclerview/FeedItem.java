package myrecyclerview;

import android.app.Activity;

/**
 * Created by DARWIN Morocho
 */
public class FeedItem {

    private String titulo;
    private Class actividad;
    public FeedItem(String titulo, Class actividad) {
        this.titulo = titulo;
        this.actividad = actividad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Class getActividad() {
        return actividad;
    }

    public void setActividad(Class actividad) {
        this.actividad = actividad;
    }
}
