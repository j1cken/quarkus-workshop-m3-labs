package org.acme.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.client.VetsRestClient;
import org.acme.model.Vet;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

@Path("vets")
public class VetsResource {

    // TODO: Inject CDI Bean

    @Inject
    Template vets;

    // @Inject 
    // VetsService service; 

    // TODO: Inject RestClient Bean

    @Inject
    @RestClient
    VetsRestClient vetsRestClient;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        List<Vet> data = vetsRestClient.getAll();
        return vets.data("active", "vets")
                .data("vets", data);
                // .data("vets", service.getAll());
    }
}