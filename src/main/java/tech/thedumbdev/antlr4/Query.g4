grammar Query;

query: (selectStatement | findStatement) EOF;

selectStatement: SELECT selectList FROM tableName BETWEEN timeStamp AND timeStamp';';
findStatement: FIND selectList IN tableName ';';

selectList: IDENTIFIER (',' IDENTIFIER)*;
tableName: TIMESTAMP '.log';
timeStamp: TIMESTAMP;

SELECT: 'SELECT';
FIND: 'FIND';
FROM: 'FROM';
IN: 'IN';
BETWEEN: 'BETWEEN';
AND: 'AND';
TIMESTAMP: [0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9];

STRING: '"' ~["]* '"';
IDENTIFIER: [a-zA-Z_][a-zA-Z0-9_]* ;

WS: [ \t\r\n]+ -> skip ;
