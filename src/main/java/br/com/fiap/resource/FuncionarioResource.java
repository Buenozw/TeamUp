package br.com.fiap.resource;

import br.com.fiap.beans.Funcionario;
import br.com.fiap.bo.FuncionarioBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/funcionario")
public class FuncionarioResource {

    private FuncionarioBO funcionarioBO = new FuncionarioBO();

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Funcionario> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Funcionario>) funcionarioBO.selecionarBo();
    }

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Funcionario funcionario, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        funcionarioBO.inserirBo(funcionario);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(funcionario.getId_usuario())); // herdado de Usuario
        return Response.created(builder.build()).build();
    }

    // Atualizar
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        funcionarioBO.atualizarBo(funcionario);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{idFuncionario}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("idFuncionario") int idFuncionario) throws ClassNotFoundException, SQLException {
        funcionarioBO.deletarBo(idFuncionario);
        return Response.ok().build();
    }
}
