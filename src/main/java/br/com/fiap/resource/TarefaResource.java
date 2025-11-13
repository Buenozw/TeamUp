package br.com.fiap.resource;

import br.com.fiap.beans.Tarefa;
import br.com.fiap.bo.TarefaBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/tarefa")
public class TarefaResource {

    private TarefaBO tarefaBO = new TarefaBO();

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Tarefa> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Tarefa>) tarefaBO.selecionarBo();
    }

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Tarefa tarefa, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        tarefaBO.inserirBo(tarefa);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(tarefa.getId_tarefa()));
        return Response.created(builder.build()).build();
    }

    // Atualizar
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Tarefa tarefa) throws ClassNotFoundException, SQLException {
        tarefaBO.atualizarBo(tarefa);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{idTarefa}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("idTarefa") int idTarefa) throws ClassNotFoundException, SQLException {
        tarefaBO.deletarBo(idTarefa);
        return Response.ok().build();
    }
}
