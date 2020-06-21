//
package hftstuttgart;

 // Import log4j classes.
 import org.apache.log4j.Logger;
 import org.apache.log4j.BasicConfigurator;
 import bar.Bar;


import static spark.Spark.*;


public class App {

    static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {

        BasicConfigurator.configure();

        logger.info("Entering application.");
     Bar bar = new Bar();
     bar.doIt();
     logger.info("Exiting application.");
        
        port(8080);
        get("/calc/:method/:op1/:op2", (req, res) -> {
            res.type("application/json");
            Calculator calc = new Calculator();
            int result = 0;
            int op1 = Integer.parseInt(req.params("op1"));
            int op2 = Integer.parseInt(req.params("op2"));
            switch (req.params("method")) {
                case "sum":
                    result = calc.sum(op1, op2);
                    break;
                case "prod":
                    result = calc.prod(op1, op2);
                    break;
                default:
            }
            return "{\"result\": " + result + "\"}";
        });
        
    }
}
