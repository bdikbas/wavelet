import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    int num = 11;

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format("Burak's Number: %d", num);
        } else if (url.getPath().equals("/increment")) {
            num += 1;
            return String.format("Number incremented!");
        } else {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/add")) {
                String[] parameters = url.getQuery().split("=s");
                if (parameters[0].equals("pineapple")) {                    
                    return String("pineapple");
                }
                else if(parameters[0].equals("apple")) {
                  return String("apple");
                }
                else if(parameters[0].equals("anewstringtoadd")) {
                  return String("A new string to add!");
            }
            return "404 Not Found!";
        }
    }
}

class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
