package tech.thedumbdev.ast;

import java.util.List;

// This might need to change, as I am supporting multiple search things, so might become List<String>
public record SelectBetween(List<String> search, String logfile, String fromTs, String toTs) implements ASTQuery {
}
