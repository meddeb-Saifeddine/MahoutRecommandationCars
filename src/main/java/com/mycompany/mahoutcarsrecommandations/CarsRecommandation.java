/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mahoutcarsrecommandations;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.JSONException;
import org.json.simple.parser.ParseException;

/**
 *
 * @author saif
 */
public class CarsRecommandation {
    public static void main (String args []) throws IOException, FileNotFoundException, ParseException, JSONException{
        
        System.out.println(MahoutRecommander.execute());
        JsontoCsv jsonp = new JsontoCsv();
        //jsonp.jsonParsing();
       // jsonp.jsonTocsv();
       // jsonp.parseJson();
        
        
       
    }
}
