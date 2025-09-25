grammar Query;

query
    : stmt EOF
    ;

stmt
    : selectStmt
    | findStmt
    ;

selectStmt
    : SELECT STRING FROM logfile BETWEEN STRING AND STRING SEMI?
    ;

findStmt
    : FIND STRING IN logfile SEMI?
    ;

logfile
    : IDENT ('.' IDENT)* ('.' IDENT)?   // simple support for names like something.log or path.to.something.log
    ;

/* Lexer */
SELECT  : [sS][eE][lL][eE][cC][tT];
FIND    : [fF][iI][nN][dD];
FROM    : [fF][rR][oO][mM];
IN      : [iI][nN];
BETWEEN : [bB][eE][tT][wW][eE][nN];
AND     : [aA][nN][dD];
SEMI    : ';';

IDENT   : [a-zA-Z_][a-zA-Z0-9_/-]* ;
STRING  : '"' ( ~["\\] | '\\' . )* '"' ;

WS : [ \t\r\n]+ -> skip ;
