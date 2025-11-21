package br.com.fiap.resource;

import br.com.fiap.beans.Equipe;
import br.com.fiap.bo.EquipeBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/equipe")
public class EquipeResource {

    private EquipeBO equipeBO = new EquipeBO();

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Equipe> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Equipe>) equipeBO.selecionarBo();
    }

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Equipe equipe, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        equipeBO.inserirBo(equipe);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(equipe.getId_equipe()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/entrar/{idEquipe}")
    public Response entrarEquipe(@PathParam("idEquipe") int idEquipe) throws SQLException, ClassNotFoundException {
        equipeBO.entrarEquipeBo(idEquipe);
        return Response.ok().build();
    }


    // SAIR DA EQUIPE
    @POST
    @Path("/sair/{idEquipe}")
    public Response sairEquipe(@PathParam("idEquipe") int idEquipe) throws ClassNotFoundException, SQLException {
        equipeBO.sairEquipeBo(idEquipe);
        return Response.ok().build();
    }


    // Atualizar
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Equipe equipe) throws ClassNotFoundException, SQLException {
        equipeBO.atualizarBo(equipe);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{idEquipe}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("idEquipe") int idEquipe) throws ClassNotFoundException, SQLException {
        equipeBO.deletarBo(idEquipe);
        return Response.ok().build();
    }
}
