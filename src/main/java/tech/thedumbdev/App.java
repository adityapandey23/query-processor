package tech.thedumbdev;
// /home/aditya/Documents/Coding/projects/logging-notification-system/logging-system/logs/
import tech.thedumbdev.queryprocessor.QueryProcessor;
import tech.thedumbdev.queryprocessor.QueryProcessorFactory;
import tech.thedumbdev.reader.ElasticReader;
import tech.thedumbdev.reader.FileReader;
import tech.thedumbdev.reader.Reader;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
                System.out.println("Enter the host URL: "); // TODO: CHECKS
                String host = sc.nextLine();
                System.out.println("Enter the API key: ");
                String apiKey = sc.nextLine();
                yield new ArrayList<>(Arrays.asList(host, apiKey));
            }
            case "file" -> {
                System.out.println("Enter the path to the file: "); // TODO: CHECKS
                String file = sc.nextLine();
                yield new ArrayList<>(Arrays.asList(file));
            }
            default ->
                    throw new IllegalArgumentException("Invalid source type\nThe source could be either elasticsearch or file");
        };

        Reader reader = (source.equals("elasticsearch")) ? new ElasticReader(path.get(0), path.get(1)) : new FileReader(path.get(0));

        System.out.println("(Press ? for help)");

        QueryProcessorFactory factory = new QueryProcessorFactory(reader);

        while(true){
            System.out.print("Enter your query: ");
            String query = sc.nextLine();
            query = query.toLowerCase();
            try {
                QueryProcessor queryProcessor = factory.getQueryProcessor(query);
                boolean shouldStop = queryHandler(query);
                if(shouldStop) break;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("██████╗ ██╗   ██╗███████╗");
        System.out.println("██╔══██╗╚██╗ ██╔╝██╔════╝");
        System.out.println("██████╔╝ ╚████╔╝ █████╗  ");
        System.out.println("██╔══██╗  ╚██╔╝  ██╔══╝  ");
        System.out.println("██████╔╝   ██║   ███████╗");
        System.out.println("╚═════╝    ╚═╝   ╚══════╝");
    }

    public static boolean queryHandler(String query) {
        switch (query) {
            case "?":
                System.out.println("You can select a ranged query, like SELECT .. FROM ..");
                System.out.println("You can select a find query like FIND .. FROM ..");
                break;
            case "exit":
                return true;
            default:
                try {
                    System.out.println();
                } catch (Exception e) {
                    throw new IllegalArgumentException(e);
                }
        }
        return false;
    }
}
