/*
 * Copyright (C) 2016 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.samples.managedbeans;


import edu.eci.pdsw.samples.entities.Comentario;
import edu.eci.pdsw.samples.entities.EntradaForo;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.services.ExcepcionServiciosForos;
import edu.eci.pdsw.samples.services.ServiciosForo;
import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author hcadavid
 */
@ManagedBean(name="beanRegistroForosBean")

@SessionScoped
public class RegistroForosBean implements Serializable{
    
    
    static ServiciosForo sp=ServiciosForo.getInstance();
    
    
    private int newidentificador=10;
    private String newautor;
    private int idComentario=0;
    private String newcomentario;
    private String newtitulo;
    private String correo;
    private String autor2;
    private String correo2;
    private String contenido;
    private EntradaForo seleccionado;

    public String getAutor2() {
        return autor2;
    }

    public void setAutor2(String autor2) {
        this.autor2 = autor2;
    }

    public String getCorreo2() {
        return correo2;
    }

    public void setCorreo2(String correo2) {
        this.correo2 = correo2;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

   

    public String getNewautor() {
        return newautor;
    }

    public void setNewautor(String newautor) {
        this.newautor = newautor;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNewcomentario() {
        return newcomentario;
    }

    public void setNewcomentario(String newcomentario) {
        this.newcomentario = newcomentario;
    }
    public String getNewtitulo() {
        return newtitulo;
    }

    public void setNewtitulo(String newtitulo) {
        this.newtitulo = newtitulo;
    }

    public EntradaForo getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(EntradaForo seleccionado) {
        
        if (seleccionado!=null){
            this.seleccionado = seleccionado;
        }
        
    }

    public List<EntradaForo> getSp() throws ExcepcionServiciosForos {
        return sp.consultarEntradasForo();
    }
    public void setSp(ServiciosForo sp) {
        this.sp = sp;
    }
    
    public void add() throws ExcepcionServiciosForos{
        
        if(!correo.equals("") && !newautor.equals("") && !newcomentario.equals("") && !newtitulo.equals("")) {
     
            Usuario u= new Usuario(correo,newautor);
            EntradaForo ef = new EntradaForo(newidentificador,u,newcomentario,newtitulo,new Date(Calendar.getInstance().getTime().getTime()));
            System.out.println(ef+"AAAAAAAAAAAAAAAAAAAAA");
            sp.registrarNuevaEntradaForo(ef);
        newidentificador++;
        }
    }
    
    public void addrespuesta() throws ExcepcionServiciosForos{
        if(!correo2.equals("") && !autor2.equals("") && !contenido.equals("") ) {

            try{
                Usuario u= new Usuario(correo2,autor2);
                Comentario c= new Comentario(idComentario,u,contenido,new Date(Calendar.getInstance().getTime().getTime()));
                idComentario++;
                sp.agregarRespuestaForo(seleccionado.getIdentificador(),c);
            }catch(NullPointerException e){

            }
        }
    }
    
    
    public RegistroForosBean() {
        
    }
}
