import spark.Request;

import static spark.Spark.get;
import static spark.Spark.port;

public class Main {

    public static void main(String[] args) {
        port(80);
        get("*", (req, res) -> {
            String redirect = convertRequestURL(req);
            res.redirect(redirect);
            return "";
        });
    }

    private static String convertRequestURL(Request request) {
        String rURL = request.url();
        return rURL.replace("http://", "https://");
    }
}
