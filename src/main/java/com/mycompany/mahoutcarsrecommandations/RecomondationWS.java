/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mahoutcarsrecommandations;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author saif
 */
@Path("recomondation")
public class RecomondationWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RecomondationWS
     */
    public RecomondationWS() {
    }

   @GET
    public String dukes(){

        JsontoCsv a = new JsontoCsv();
        
        String result="{"+MahoutRecommander.execute()+"}"+"\n"+a.readFromFile();
                
        return result;

    }
}
