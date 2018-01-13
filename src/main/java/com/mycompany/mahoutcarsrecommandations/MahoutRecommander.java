/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mahoutcarsrecommandations;

import java.io.File;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;


/**
 *
 * @author saif
 */
public class MahoutRecommander {
    public static String execute()  {
 
     try {
      DataModel model = new FileDataModel(new File("/home/saif/mahout/input.csv"));
 UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
 UserNeighborhood neighborhood = new NearestNUserNeighborhood(2, similarity, model);
 Recommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
 
 List recommendations = recommender.recommend(1,1);
 if (recommendations.isEmpty()==true)
         {
             System.out.println("no recommendations for user number = 1");
             return "no recommendations for user number = 1";
             
         }
 else 
 {
     for (Object recommendation : recommendations) {
     System.out.println(" recommendation: " + recommendation);

     return ((String)recommendation+"");

     
 }
 }
 
 }
 catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());

}
        return "";
       
}
    
}
