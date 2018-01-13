/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mahoutcarsrecommandations;

import com.github.opendevl.JFlat;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import static java.lang.System.out;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;





/**
 *
 * @author saif
 */
public class JsontoCsv {
    
   public String data;
    
   public void jsonParsing() throws FileNotFoundException, IOException 
            
    { 
          String data ; 
        data = readFromFile();
        System.out.println(data);
  
    } 
    
   
    public String readFromFile()
    {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("/home/saif/mahout/jsonFile.json")))
        {
 
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
            {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage()); 
        }
        return contentBuilder.toString();
    }
    
    public void jsonTocsv() throws FileNotFoundException, FileNotFoundException, IOException
           
    {
        String str = new String(Files.readAllBytes(Paths.get("/home/saif/mahout/sss.json")));

        JFlat flatMe = new JFlat(str);

//get the 2D representation of JSON document
List<Object[]> json2csv = flatMe.json2Sheet().getJsonAsSheet();
     

       try {
           //write the 2D representation in csv format
           flatMe.write2csv("/home/saif/mahout/resultcsv.csv");
       } catch (FileNotFoundException ex) {
           Logger.getLogger(JsontoCsv.class.getName()).log(Level.SEVERE, null, ex);
       } catch (UnsupportedEncodingException ex) {
           Logger.getLogger(JsontoCsv.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public void parseJson() throws FileNotFoundException, IOException, JSONException
    {

            JsonReader jsonReader = new JsonReader(new FileReader("jsonFile.json"));

    }
}
