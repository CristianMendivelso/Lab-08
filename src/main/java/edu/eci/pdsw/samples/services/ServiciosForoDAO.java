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
package edu.eci.pdsw.samples.services;

import edu.eci.pdsw.samples.entities.Comentario;
import edu.eci.pdsw.samples.entities.EntradaForo;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.persistence.DaoFactory;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author hcadavid
 */
public class ServiciosForoDAO extends ServiciosForo{

    private SqlSession currentSession=null;
    Properties properties;
    DaoFactory daof;

    public ServiciosForoDAO() {
        try {
            properties=new PropertiesLoader().readProperties("applicationconfig.properties");
        } catch (IOException ex) {
            Logger.getLogger(ServiciosForoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        daof=DaoFactory.getInstance(properties);
    }

    @Override
    public List<EntradaForo> consultarEntradasForo() throws ExcepcionServiciosForos{
        List<EntradaForo> entradasForos=null;
        try {
            daof.beginSession();
            entradasForos= daof.getDaoEntradaForo().loadAll();
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosForos("Error al consultar las entradas al foro",ex); 
            
        }
        return entradasForos;
    }

    @Override
    public EntradaForo consultarEntradaForo(int id) throws ExcepcionServiciosForos {
        EntradaForo entradaForo;
        
        try {
            daof.beginSession();
            entradaForo= daof.getDaoEntradaForo().load(id);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosForos("Error al consultar la entrada al foro con id="+id,ex);
            
        }
        if (entradaForo==null){
            throw new ExcepcionServiciosForos("Error al consultar la entrada al foro con id="+id);
        }
        return entradaForo;
    }

    @Override
    public void registrarNuevaEntradaForo(EntradaForo f) throws ExcepcionServiciosForos {
        if (f.getAutor()==null) {
            throw new ExcepcionServiciosForos("el foro no tiene un usuario asociado"+f);
        }
        
        try {
            daof.beginSession();
            System.out.println("22222222222222222222222222222");
            System.out.println(f.getAutor().getEmail()+"----"+f.getAutor().getNombre());
            daof.getDaoUsuario().save(f.getAutor());
            daof.getDaoEntradaForo().save(f);
            
        } 
        catch (PersistenceException ex) {
            throw new ExcepcionServiciosForos("Error al registrar el nuevo foro",ex);
            
        }
        
    }

    @Override
    public void agregarRespuestaForo(int idforo, Comentario c) throws ExcepcionServiciosForos {
        
        if(c.getAutor()==null){
            throw new ExcepcionServiciosForos("El comentario no tiene autor");
        }
        
        try {
            daof.beginSession();
            daof.getDaoEntradaForo().addToForo(idforo, c);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosForos("Error al agregar la respuesta al foro",ex);
            
        }
    }

    @Override
    public Usuario consultarUsuario(String email) throws ExcepcionServiciosForos {
        Usuario u = null;
        
        try {
            daof.beginSession();
            u=daof.getDaoUsuario().load(email);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosForos("Error consultar el usuario",ex);
            
        }
        if (u==null){
            throw new ExcepcionServiciosForos("Este usuario no existe");
        }
        return u; 
    }
}
class PropertiesLoader {

    public Properties readProperties(String fileName) throws IOException {
        InputStream input = null;
        Properties properties = new Properties();
        input = this.getClass().getClassLoader().getResourceAsStream(fileName);
        properties.load(input);
        return properties;
    }
}