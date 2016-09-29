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
import edu.eci.pdsw.samples.services.ServiciosForoStub;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Set;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author hcadavid
 */
@javax.faces.bean.ManagedBean(name="beanRegistroForosBean")

@SessionScoped
public class RegistroForosBean implements Serializable{
    
    //@ManagedProperty(value="#{param.pageId}")
    
    private String pageid="1";
    
    ServiciosForo sp=ServiciosForo.getInstance();
    private EntradaForo seleccionado;
    
    
    
    public String showPage(){
  
      if(pageid.equals("1")){
         return "RegistroForo";
      }
      else{
         return "RegistroRespuesta";
      }
    
    }

    public int getNewidentificador() {
        return newidentificador;
    }

    public void setNewidentificador(int newidentificador) {
        this.newidentificador = newidentificador;
    }

    public Usuario getNewautor() {
        return newautor;
    }

    public void setNewautor(Usuario newautor) {
        this.newautor = newautor;
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

    public Date getNewfechayHora() {
        return newfechayHora;
    }

    public void setNewfechayHora(Date newfechayHora) {  // puede que se totee por el tipo de fecha , entra un string
        this.newfechayHora = newfechayHora;
    }
    public EntradaForo getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(EntradaForo seleccionado) {
        pageid="2";
        this.seleccionado = seleccionado;
    }

    public List<EntradaForo> getSp() throws ExcepcionServiciosForos {
        return sp.consultarEntradasForo();
    }
    public void setSp(ServiciosForo sp) {
        this.sp = sp;
    }
    
    public void add() throws ExcepcionServiciosForos{
        EntradaForo ef = new EntradaForo(newidentificador,newautor,newcomentario,newtitulo,newfechayHora);
        sp.registrarNuevaEntradaForo(ef);
    }
    
    private int newidentificador;
    private Usuario newautor;
    private String newcomentario;
    private String newtitulo;
    private Date newfechayHora;

    public RegistroForosBean() {
        
    }

    
    
    
    
    
}
