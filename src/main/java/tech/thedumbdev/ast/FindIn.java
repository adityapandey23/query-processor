package tech.thedumbdev.ast;

import java.util.List;

public record FindIn(List<String> search, String logfile) implements ASTQuery {
}
