grammar TQL ;

@header {
	package edu.uci.asterix.stream.parser.gen;
}

parse:
  define_sensor_collections
  define_observation_streams
  (define_sensor_collection)+
  (define_observation_stream)+
  select_stream_stmt;

define_sensor_collections
	: DEFINE SENSOR_COLLECTION sensor_collection_name (',' sensor_collection_name)* ';' ;

define_observation_streams
	: DEFINE OBSERVATION_STREAM observation_stream_name (',' observation_stream_name)* ';' ;

define_sensor_collection
	: sensor_collection_name '='
	   select_stmt ';' ;

define_observation_stream
	: observation_stream_name '=' SENSORS_TO_OBSERVATION_STREAM '(' sensor_collection_name ')' ';' ;

select_stmt
	: select
    from
    (where)?;

select_stream_stmt
	: select
    from_stream
    (where)?
    (group_by)?
    (order_by)?
    (limit)?';';

select:
  SELECT column_list;

column_list:
  '*'|
  result_column ( ',' result_column )*;

from:
  FROM table  ( ',' table)* ;

table:
  table_name (alias_name)?;

from_stream:
  FROM stream_window (',' stream_window)*;

stream_window:
  observation_stream_name (alias_name)? RANGE time_interval SLIDE time_interval;
  
where:
  WHERE logic_expr;

group_by:
  GROUP BY field_access (',' field_access)* (having)?;

having:
  HAVING logic_expr;

order_by:
  ORDER BY field_access (',' field_access)* (ASC | DESC)?;
 
limit:
  LIMIT INT_LITERAL (OFFSET INT_LITERAL)?;
  
time_interval
	:'\'' INT_LITERAL time_unit '\'';

time_unit
	: HOURS
	| MINUTES
	| SECONDS ;

alias_name:
  any_name;

sensor_collection_name
	: any_name ;

observation_stream_name
	: any_name ;

table_name
	: any_name ;

field_name
  :any_name;

column_name
	: any_name ;

function_name
	: any_name ;

any_name
	: IDENTIFIER
	| STRING_LITERAL
	| '(' any_name ')' ;

result_column
	: expr ( AS? column_alias )? ;

column_alias
	: IDENTIFIER;

expr
	: literal_value #literal
	|field_access #fields
	|expr '[' expr ']' #array_get_item
	| '-' expr #negative
	| expr ('*' | '/'| '%' ) expr #arithmetic
	| expr ( '+' | '-' ) expr #arithmetic
	| COUNT '(' '*' ')' #count
	| agg_func '(' expr ')' #aggr
	| function_name '(' parameter_list? ')' #function
	| '(' expr ')' #parentheses;

field_access:
  any_name ('.' any_name)*;

term_expr
	: expr ('<' | '<=' | '>' | '>=' | '=' | '!=') expr #comparison
	| expr NOT? IN expr #in
	| expr NOT_NULL #not_null
	| expr IS_NULL #is_null ;

	
logic_expr
	: term_expr #term
	| NOT logic_expr #not
	| logic_expr AND logic_expr #and
	| logic_expr OR logic_expr #or
	| '(' logic_expr ')' #logic_parentheses;

literal_value
	: 
	INT_LITERAL
	| REAL_LITERAL
	| STRING_LITERAL
	| BOOLEAN_LITERAL ;

agg_func:
  AVG| MIN| MAX| SUM;

parameter_list: expr (',' expr)*;

DEFINE
	: D E F I N E ;

SENSOR_COLLECTION
	: S E N S O R C O L L E C T I O N ;

OBSERVATION_STREAM
	: O B S E R V A T I O N S T R E A M ;

SENSORS_TO_OBSERVATION_STREAM
	: S E N S O R S '_' T O '_' O B S E R V A T I O N '_' S T R E A M ;

SELECT
	: S E L E C T ;

FROM
	: F R O M ;

WHERE
	: W H E R E ;

GROUP
	: G R O U P ;

BY
	: B Y ;

HAVING
	: H A V I N G ;

DISTINCT
	: D I S T I N C T ;

AS
	: A S ;

AND
	: A N D ;

OR
	: O R ;

NOT
	: N O T ;

NOT_NULL
	: N O T N U L L ;

IS_NULL
	: I S N U L L ;

IN
	: I N ;
ORDER:
  O R D E R;

LIMIT:
  L I M I T;

OFFSET:
  O F F S E T;

ASC:
  A S C;

DESC:
  D E S C;

RANGE
	: R A N G E ;

SLIDE
	: S L I D E ;

SECONDS
	: S E C O N D S;

MINUTES
	: M I N U T E S;

HOURS
	: H O U R S;

AVG:
  A V G;

MIN:
  M I N;
  
SUM:
  S U M;

MAX:
  M A X;

COUNT:
  C O U N T;

IDENTIFIER
	:
	| '`' (~'`' | '``')* '`'
	| '[' ~']'* ']'
	| [a-zA-Z_] [a-zA-Z_0-9]* ;

STRING_LITERAL
	: '\"' ( ~'\'' | '\'\'' )* '\"' ;

BOOLEAN_LITERAL
	: T R U E
	| F A L S E ;

INT_LITERAL:
  '-'? DIGIT+;
  
REAL_LITERAL
	: DIGIT+ ( '.' DIGIT* )? ( E [-+]? DIGIT+ )?
	| '.' DIGIT+ ( E [-+]? DIGIT+ )? ;

SINGLE_LINE_COMMENT
	: '//' ~[\r\n]* -> channel(HIDDEN) ;

MULTILINE_COMMENT
	: '/*' .*? ( '*/' | EOF ) -> channel(HIDDEN) ;

SPACES
	: [ \u000B\t\r\n] -> channel(HIDDEN) ;

fragment DIGIT
	: [0-9] ;

fragment A
	: [aA] ;

fragment B
	: [bB] ;

fragment C
	: [cC] ;

fragment D
	: [dD] ;

fragment E
	: [eE] ;

fragment F
	: [fF] ;

fragment G
	: [gG] ;

fragment H
	: [hH] ;

fragment I
	: [iI] ;

fragment J
	: [jJ] ;

fragment K
	: [kK] ;

fragment L
	: [lL] ;

fragment M
	: [mM] ;

fragment N
	: [nN] ;

fragment O
	: [oO] ;

fragment P
	: [pP] ;

fragment Q
	: [qQ] ;

fragment R
	: [rR] ;

fragment S
	: [sS] ;

fragment T
	: [tT] ;

fragment U
	: [uU] ;

fragment V
	: [vV] ;

fragment W
	: [wW] ;

fragment X
	: [xX] ;

fragment Y
	: [yY] ;

fragment Z
	: [zZ] ;

