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
package edu.eci.pdsw.samples.tests;

import static com.sun.org.apache.regexp.internal.RETest.test;
import edu.eci.pdsw.samples.entities.Comentario;
import edu.eci.pdsw.samples.entities.EntradaForo;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.services.ExcepcionServiciosForos;
import edu.eci.pdsw.samples.services.ServiciosForoStub;
import java.sql.Date;
import static jdk.nashorn.internal.objects.NativeRegExp.test;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hcadavid
 */
public class ComentariosTest {

    
    @Before
    public void setUp() {
    }
        /*
    Clase de equivalencia1 : Foro existente y un comentario No vacio
    */
    @Test
    public void ComentariosTest1() throws ExcepcionServiciosForos {
        
        ServiciosForoStub Sfs = new ServiciosForoStub();
        Usuario Us = Sfs.consultarUsuario("luisa.perez@gmail.com");
        Comentario C = new Comentario (Us,"Comentario para el foro", java.sql.Date.valueOf("2000-01-01") );
        Sfs.agregarRespuestaForo(0,C);
        
        assertEquals("No agrego la respuesta al foro.",Sfs.consultarEntradaForo(0).getRespuestas().size(),1);
    }
    /*
    Clase de equivalencia2 : Foro existente y un comentario vacio
    */
    @Test
    public void  ComentariosTest2() throws ExcepcionServiciosForos {
        ServiciosForoStub Sfss = new ServiciosForoStub();
        Usuario Us = Sfss.consultarUsuario("luisa.perez@gmail.com");
        Comentario C = new Comentario (Us,"", java.sql.Date.valueOf("2000-01-01") );
        Sfss.agregarRespuestaForo(1,C);
        assertEquals("Agrego una respuesta sin comentario.",Sfss.consultarEntradaForo(1).getRespuestas().size(),0);
    }

    /*
    Clase de equivalencia : agregar una nueva entrada al foro
    */
    @Test
    public void  ComentariosTest3() throws ExcepcionServiciosForos {
        Usuario autor = new Usuario("Chrisitan@hotmail.com","Christian Soto");
        EntradaForo Ef = new EntradaForo(6,autor,"comentario","titulo",java.sql.Date.valueOf("2000-01-01"));
        ServiciosForoStub Sfs = new ServiciosForoStub();
        Sfs.registrarNuevaEntradaForo(Ef);
        assertEquals("Agrego una respuesta sin comentario.",Sfs.consultarEntradasForo().size(),2);
    }
    
    
    
    @Test
    public void registroPacienteTest(){
        
    }
    
    
}
