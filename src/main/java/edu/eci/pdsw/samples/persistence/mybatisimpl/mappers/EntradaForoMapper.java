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
package edu.eci.pdsw.samples.persistence.mybatisimpl.mappers;

import edu.eci.pdsw.samples.entities.Comentario;
import edu.eci.pdsw.samples.entities.EntradaForo;
import edu.eci.pdsw.samples.entities.Usuario;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author hcadavid
 */
public interface EntradaForoMapper {
    
    
    public List<EntradaForo> getEntradasForo();
    
    public EntradaForo getEntradaForo(@Param ("id") int id);
    
    public void agregarComentarioAEntradaForo( @Param("idEntradaForo") int idEntradaForo, @Param("c")Comentario c);    
    
    public void registrarNuevaEntradaForo(@Param("f") EntradaForo f);
    
    public Usuario consultarUsuario(@Param("email") String email);
    
}