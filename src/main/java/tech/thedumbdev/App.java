package tech.thedumbdev;
// /home/aditya/Documents/Coding/projects/logging-notification-system/logging-system/logs/
// mvn clean compile exec:java
import tech.thedumbdev.queryprocessor.QueryProcessor;
import tech.thedumbdev.queryprocessor.QueryProcessorFactory;
import tech.thedumbdev.reader.Reader;
import tech.thedumbdev.reader.ReaderFactory;

import java.util.*;

public class App {
    public static void main(String[] args) {
        System.out.println("██╗      ██████╗  ██████╗ ██╗  ██╗");
        System.out.println("██║     ██╔═══██╗██╔════╝ ╚██╗██╔╝");
        System.out.println("██║     ██║   ██║██║  ███╗ ╚███╔╝ ");
        System.out.println("██║     ██║   ██║██║   ██║ ██╔██╗ ");
        System.out.println("███████╗╚██████╔╝╚██████╔╝██╔╝ ██╗");
        System.out.println("╚══════╝ ╚═════╝  ╚═════╝ ╚═╝  ╚═╝");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter source type (elasticsearch/file): ");
        String source = sc.nextLine();

        List<String> path = switch (source) {
            case "elasticsearch" -> {
                System.out.println("Enter the host URL: "); // TODO: Perform Check
                String host = sc.nextLine();
                System.out.println("Enter the API key: ");
                String apiKey = sc.nextLine();
                yield new ArrayList<>(Arrays.asList(host, apiKey));
            }
            case "file" -> {
                System.out.println("Enter the path to the file: "); // TODO: Perform Check
                String file = sc.nextLine();
                yield new ArrayList<>(Collections.singletonList(file));
            }
            default ->
                    throw new IllegalArgumentException("Invalid source type\nThe source could be either elasticsearch or file");
        };

        Reader reader = new ReaderFactory(path).getReader();

        System.out.println("(Press ? for help)");

        QueryProcessorFactory factory = new QueryProcessorFactory(reader);

        boolean shouldStop = false;
        while(!shouldStop){
            System.out.print("Enter your query: ");
            String query = sc.nextLine();
            query = query.toLowerCase();
            switch (query) {
                case "?":
                    System.out.println("You can select a ranged query, like SELECT .. FROM ..");
                    System.out.println("You can select a find query like FIND .. FROM ..");
                    break;
                case "exit":
                    shouldStop = true;
                    break;
                default:
                    try {
                        QueryProcessor queryProcessor = factory.getQueryProcessor(query);
                        queryHandler(query, queryProcessor);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
            }
        }

        System.out.println("██████╗ ██╗   ██╗███████╗");
        System.out.println("██╔══██╗╚██╗ ██╔╝██╔════╝");
        System.out.println("██████╔╝ ╚████╔╝ █████╗  ");
        System.out.println("██╔══██╗  ╚██╔╝  ██╔══╝  ");
        System.out.println("██████╔╝   ██║   ███████╗");
        System.out.println("╚═════╝    ╚═╝   ╚══════╝");
    }

    public static void queryHandler(String query, QueryProcessor queryProcessor) {
    }
}
