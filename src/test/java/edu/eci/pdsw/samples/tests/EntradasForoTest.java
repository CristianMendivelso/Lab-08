/*
 * Copyright (C) 2015 hcadavid
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

import edu.eci.pdsw.samples.entities.EntradaForo;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.services.ExcepcionServiciosForos;
import edu.eci.pdsw.samples.services.ServiciosForoStub;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hcadavid
 */
public class EntradasForoTest {
    
        /*
    Clase de equivalencia1 : agregar un Foro existente
    */
    @Test
    public void  ComentariosTest1() throws ExcepcionServiciosForos {
        Usuario autor = new Usuario("cfms@hotmail.com","Christian Mendivelso");
        EntradaForo ef = new EntradaForo(5,autor,"bienvenidos","foro de salud",java.sql.Date.valueOf("2000-01-01"));
        ServiciosForoStub sfs = new ServiciosForoStub();
        sfs.registrarNuevaEntradaForo(ef);
        assertEquals("no se agrego una nueva entrada al foro",sfs.consultarEntradasForo().size(),2);
    }
    
    
    public EntradasForoTest() {
    }
    
    
    
    @Before
    public void setUp() {
    }
    
    
    
}
