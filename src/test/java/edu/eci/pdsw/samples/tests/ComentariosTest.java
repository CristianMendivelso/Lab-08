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
import edu.eci.pdsw.samples.services.ServiciosForo;
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
    
     /*
     *Agregar a un foro una respuesta sin usuario asociado
     * @throws ExcepcionServiciosForos si el comentario no tiene asociado un
     * usuario
     */
    @Test
    public void agregarUnaRespuestaSinUsuario() throws ExcepcionServiciosForos {
        ServiciosForo Sf = ServiciosForo.getInstance();
        Comentario C = new Comentario ();
        try{
            Sf.agregarRespuestaForo(0,C);
            assertTrue("No se esta arrojando la excepcion de agregar un arespuesta sin usuario",false);
        }
        catch(ExcepcionServiciosForos esf){
            assertEquals("No se pueden agregar respuestas sin un Usuario Asociado",true);
        }
    }
       
    /*
     * Consulta un usuario registrado
     * @throws ExcepcionServiciosForos si no hay usuarios asociados al correo
     * indicado
     */
    @Test
    public void consultarUnEmailSinUsuario() throws ExcepcionServiciosForos {
        ServiciosForo Sf = ServiciosForo.getInstance();
        
        try{
            Sf.consultarUsuario("emailSinUsuario@mail");
            assertTrue("No se esta arrojando la excepcion de un email sin usuairo",false);
        }
        catch(ExcepcionServiciosForos esf){
            assertEquals("el email no tiene un usuario asociado",true);
        }

    }
     /*
     * Dado un identificador, consulta una entrada a foro especifica
     * @throws ExcepcionServiciosForos si el identificador no corresponde a 
     * un entrada a foro existente
     */
        @Test
    public void consultarUnIdSinForo() throws ExcepcionServiciosForos {
        ServiciosForo Sf = ServiciosForo.getInstance();
        try{
            Sf.consultarEntradaForo(-10);
            assertTrue("No se esta arrojando la excepcion de un id sin un foro",false);
        }
        catch(ExcepcionServiciosForos esf){
            assertEquals("el id no tiene un foro asociado",true);
        }

    }
}

