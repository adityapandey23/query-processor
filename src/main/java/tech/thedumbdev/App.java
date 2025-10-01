package tech.thedumbdev;
// /home/aditya/Documents/Coding/projects/logging-notification-system/logging-system/logs/
// mvn clean compile exec:java

// For the generation
// /home/aditya/Documents/Coding/projects/logging-notification-system/query-processor/src/main/java
// tech.thedumbdev.gen
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import tech.thedumbdev.ast.ASTQuery;
import tech.thedumbdev.gen.QueryLexer;
import tech.thedumbdev.gen.QueryParser;
import tech.thedumbdev.parser.ASTBuilder;
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
                System.out.println("Enter the host URL: ");
                String host = sc.nextLine();
                System.out.println("Enter the API key: ");
                String apiKey = sc.nextLine();
                yield new ArrayList<>(Arrays.asList(host, apiKey));
            }
            case "file" -> {
                yield new ArrayList<>();
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
            switch (query) {
                case "?":
                    System.out.println("You can select a ranged query, like SELECT .. FROM ..");
                    System.out.println("You can select a find query like FIND .. IN ..");
                    break;
                case "exit": // THIS FKING THING IS CASE SENSITIVEEEEE
                    shouldStop = true;
                    break;
                default:
                    try {
                        ParseTree tree = treeGenerator(query);
                        ASTBuilder visitor = new ASTBuilder();
                        ASTQuery astQuery = visitor.visit(tree);
                        QueryProcessor queryProcessor = factory.getQueryProcessor(astQuery);
                        if (queryProcessor == null) throw new IllegalArgumentException("Invalid query");

                        queryProcessor.process(astQuery);
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

    public static ParseTree treeGenerator(String query) {
        try {
            CharStream charStream = CharStreams.fromString(query);

            QueryLexer lexer = new QueryLexer(charStream);
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            QueryParser parser = new QueryParser(tokenStream);

            parser.removeErrorListeners();
            parser.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                    throw new RuntimeException("Parse error at " + line + ":" + charPositionInLine + " - " + msg);
                }
            });

            ParseTree tree = parser.query();

            if(parser.getNumberOfSyntaxErrors() > 0) {
                throw new RuntimeException("Syntax errors found");
            }

            System.out.println("Parse tree: " + tree.toStringTree(parser));
            return tree;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
