/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.shaclex;

import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.shacl.ShaclValidator;
import org.apache.jena.shacl.Shapes;

/**
 *
 * @author ccyid
 */
public class Shaclex {

  public static void main(String[] args) {
    
    var dataModel = RDFDataMgr.loadModel("course-affordance.ttl", Lang.TURTLE);
    var shapesModel = RDFDataMgr.loadModel("shapes.ttl", Lang.TURTLE);
    var shapes = Shapes.parse(shapesModel);
    var report = ShaclValidator.get().validate(shapes, dataModel.getGraph());
    RDFDataMgr.write(System.out, report.getModel(), Lang.TURTLE);
  }
}
