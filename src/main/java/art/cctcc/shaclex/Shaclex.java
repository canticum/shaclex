/*
 * Copyright 2026 Jonathan Chang, Chun-yien <ccy@musicapoetica.org>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package art.cctcc.shaclex;

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
