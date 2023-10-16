package helloworld;

/**
 * Handler for requests to Lambda function.
 */
public class App {

    public String invoke(String content) {
        return "returning response from lambda and here is the content\n" + content;
    }
}
