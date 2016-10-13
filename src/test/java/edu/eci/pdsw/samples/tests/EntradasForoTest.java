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
import edu.eci.pdsw.samples.services.ServiciosForo;
import edu.eci.pdsw.samples.services.ServiciosForoStub;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author hcadavid
 */
public class EntradasForoTest {
    
        /*
    Clase de equivalencia1 : el foro que se va a agregar no tiene un usuario
    */
    
    private ServiciosForo sfs;
    
    
    @Before
    public void setUp() {
        sfs = sfs.getInstance();
    }
  
    
    //@Test
    public void EntradasForoTest1() throws ExcepcionServiciosForos {
        EntradaForo ef = new EntradaForo();
        
        try{
            sfs.registrarNuevaEntradaForo(ef);
            assertTrue("No entro a la Excepcion",false);
        }
        catch (ExcepcionServiciosForos esf) {
            assertTrue("Entra a la ExcepcionServiciosForos ",true);
        }
        

       
        
    }
    
    
    public void EntradasForoTest2() throws ExcepcionServiciosForos{
        
    
    
    }
    
    
    
    
    
    
    
}
