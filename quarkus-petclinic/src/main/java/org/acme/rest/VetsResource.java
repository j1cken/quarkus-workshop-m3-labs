package org.acme.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.service.VetsService;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

@Path("vets")
public class VetsResource {

    // TODO: Inject CDI Bean

    @Inject
    Template vets;

    @Inject 
    VetsService service; 

    // TODO: Inject RestClient Bean

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        return vets.data("active", "vets")
                .data("vets", service.getAll());
    }
}