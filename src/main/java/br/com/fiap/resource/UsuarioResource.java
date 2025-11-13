package br.com.fiap.resource;

import br.com.fiap.beans.Usuario;
import br.com.fiap.bo.UsuarioBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/usuario")
public class UsuarioResource {

    private UsuarioBO usuarioBO = new UsuarioBO();

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Usuario> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Usuario>) usuarioBO.selecionarBo();
    }

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Usuario usuario, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        usuarioBO.inserirBo(usuario);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(usuario.getId_usuario()));
        return Response.created(builder.build()).build();
    }

    // Atualizar
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Usuario usuario) throws ClassNotFoundException, SQLException {
        usuarioBO.atualizarBo(usuario);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{idUsuario}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("idUsuario") int idUsuario) throws ClassNotFoundException, SQLException {
        usuarioBO.deletarBo(idUsuario);
        return Response.ok().build();
    }
}
