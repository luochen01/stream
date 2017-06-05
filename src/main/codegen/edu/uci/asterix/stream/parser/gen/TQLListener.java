// Generated from TQL.g4 by ANTLR 4.4

	package edu.uci.asterix.stream.parser.gen;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TQLParser}.
 */
public interface TQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TQLParser#select}.
	 * @param ctx the parse tree
	 */
	void enterSelect(@NotNull TQLParser.SelectContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#select}.
	 * @param ctx the parse tree
	 */
	void exitSelect(@NotNull TQLParser.SelectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code not_null}
	 * labeled alternative in {@link TQLParser#term_expr}.
	 * @param ctx the parse tree
	 */
	void enterNot_null(@NotNull TQLParser.Not_nullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code not_null}
	 * labeled alternative in {@link TQLParser#term_expr}.
	 * @param ctx the parse tree
	 */
	void exitNot_null(@NotNull TQLParser.Not_nullContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arithmetic}
	 * labeled alternative in {@link TQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic(@NotNull TQLParser.ArithmeticContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arithmetic}
	 * labeled alternative in {@link TQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic(@NotNull TQLParser.ArithmeticContext ctx);
	/**
	 * Enter a parse tree produced by the {@code array_get_item}
	 * labeled alternative in {@link TQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArray_get_item(@NotNull TQLParser.Array_get_itemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code array_get_item}
	 * labeled alternative in {@link TQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArray_get_item(@NotNull TQLParser.Array_get_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull TQLParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull TQLParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#time_interval}.
	 * @param ctx the parse tree
	 */
	void enterTime_interval(@NotNull TQLParser.Time_intervalContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#time_interval}.
	 * @param ctx the parse tree
	 */
	void exitTime_interval(@NotNull TQLParser.Time_intervalContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#table_name}.
	 * @param ctx the parse tree
	 */
	void enterTable_name(@NotNull TQLParser.Table_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#table_name}.
	 * @param ctx the parse tree
	 */
	void exitTable_name(@NotNull TQLParser.Table_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#from_stream}.
	 * @param ctx the parse tree
	 */
	void enterFrom_stream(@NotNull TQLParser.From_streamContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#from_stream}.
	 * @param ctx the parse tree
	 */
	void exitFrom_stream(@NotNull TQLParser.From_streamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cast}
	 * labeled alternative in {@link TQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCast(@NotNull TQLParser.CastContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cast}
	 * labeled alternative in {@link TQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCast(@NotNull TQLParser.CastContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#literal_value}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_value(@NotNull TQLParser.Literal_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#literal_value}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_value(@NotNull TQLParser.Literal_valueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code function}
	 * labeled alternative in {@link TQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFunction(@NotNull TQLParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code function}
	 * labeled alternative in {@link TQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFunction(@NotNull TQLParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#limit}.
	 * @param ctx the parse tree
	 */
	void enterLimit(@NotNull TQLParser.LimitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#limit}.
	 * @param ctx the parse tree
	 */
	void exitLimit(@NotNull TQLParser.LimitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#time_unit}.
	 * @param ctx the parse tree
	 */
	void enterTime_unit(@NotNull TQLParser.Time_unitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#time_unit}.
	 * @param ctx the parse tree
	 */
	void exitTime_unit(@NotNull TQLParser.Time_unitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#from}.
	 * @param ctx the parse tree
	 */
	void enterFrom(@NotNull TQLParser.FromContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#from}.
	 * @param ctx the parse tree
	 */
	void exitFrom(@NotNull TQLParser.FromContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parentheses}
	 * labeled alternative in {@link TQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParentheses(@NotNull TQLParser.ParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parentheses}
	 * labeled alternative in {@link TQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParentheses(@NotNull TQLParser.ParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#having}.
	 * @param ctx the parse tree
	 */
	void enterHaving(@NotNull TQLParser.HavingContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#having}.
	 * @param ctx the parse tree
	 */
	void exitHaving(@NotNull TQLParser.HavingContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparison}
	 * labeled alternative in {@link TQLParser#term_expr}.
	 * @param ctx the parse tree
	 */
	void enterComparison(@NotNull TQLParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparison}
	 * labeled alternative in {@link TQLParser#term_expr}.
	 * @param ctx the parse tree
	 */
	void exitComparison(@NotNull TQLParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code like}
	 * labeled alternative in {@link TQLParser#term_expr}.
	 * @param ctx the parse tree
	 */
	void enterLike(@NotNull TQLParser.LikeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code like}
	 * labeled alternative in {@link TQLParser#term_expr}.
	 * @param ctx the parse tree
	 */
	void exitLike(@NotNull TQLParser.LikeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code in}
	 * labeled alternative in {@link TQLParser#term_expr}.
	 * @param ctx the parse tree
	 */
	void enterIn(@NotNull TQLParser.InContext ctx);
	/**
	 * Exit a parse tree produced by the {@code in}
	 * labeled alternative in {@link TQLParser#term_expr}.
	 * @param ctx the parse tree
	 */
	void exitIn(@NotNull TQLParser.InContext ctx);
	/**
	 * Enter a parse tree produced by the {@code count}
	 * labeled alternative in {@link TQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCount(@NotNull TQLParser.CountContext ctx);
	/**
	 * Exit a parse tree produced by the {@code count}
	 * labeled alternative in {@link TQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCount(@NotNull TQLParser.CountContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#field_access}.
	 * @param ctx the parse tree
	 */
	void enterField_access(@NotNull TQLParser.Field_accessContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#field_access}.
	 * @param ctx the parse tree
	 */
	void exitField_access(@NotNull TQLParser.Field_accessContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#define_sensor_collections}.
	 * @param ctx the parse tree
	 */
	void enterDefine_sensor_collections(@NotNull TQLParser.Define_sensor_collectionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#define_sensor_collections}.
	 * @param ctx the parse tree
	 */
	void exitDefine_sensor_collections(@NotNull TQLParser.Define_sensor_collectionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#column_alias}.
	 * @param ctx the parse tree
	 */
	void enterColumn_alias(@NotNull TQLParser.Column_aliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#column_alias}.
	 * @param ctx the parse tree
	 */
	void exitColumn_alias(@NotNull TQLParser.Column_aliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#group_by}.
	 * @param ctx the parse tree
	 */
	void enterGroup_by(@NotNull TQLParser.Group_byContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#group_by}.
	 * @param ctx the parse tree
	 */
	void exitGroup_by(@NotNull TQLParser.Group_byContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fields}
	 * labeled alternative in {@link TQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFields(@NotNull TQLParser.FieldsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fields}
	 * labeled alternative in {@link TQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFields(@NotNull TQLParser.FieldsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code aggr}
	 * labeled alternative in {@link TQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAggr(@NotNull TQLParser.AggrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code aggr}
	 * labeled alternative in {@link TQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAggr(@NotNull TQLParser.AggrContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#define_observation_streams}.
	 * @param ctx the parse tree
	 */
	void enterDefine_observation_streams(@NotNull TQLParser.Define_observation_streamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#define_observation_streams}.
	 * @param ctx the parse tree
	 */
	void exitDefine_observation_streams(@NotNull TQLParser.Define_observation_streamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#sensor_collection_name}.
	 * @param ctx the parse tree
	 */
	void enterSensor_collection_name(@NotNull TQLParser.Sensor_collection_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#sensor_collection_name}.
	 * @param ctx the parse tree
	 */
	void exitSensor_collection_name(@NotNull TQLParser.Sensor_collection_nameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logic_parentheses}
	 * labeled alternative in {@link TQLParser#logic_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogic_parentheses(@NotNull TQLParser.Logic_parenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logic_parentheses}
	 * labeled alternative in {@link TQLParser#logic_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogic_parentheses(@NotNull TQLParser.Logic_parenthesesContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#define_observation_stream}.
	 * @param ctx the parse tree
	 */
	void enterDefine_observation_stream(@NotNull TQLParser.Define_observation_streamContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#define_observation_stream}.
	 * @param ctx the parse tree
	 */
	void exitDefine_observation_stream(@NotNull TQLParser.Define_observation_streamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literal}
	 * labeled alternative in {@link TQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(@NotNull TQLParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literal}
	 * labeled alternative in {@link TQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(@NotNull TQLParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negative}
	 * labeled alternative in {@link TQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNegative(@NotNull TQLParser.NegativeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negative}
	 * labeled alternative in {@link TQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNegative(@NotNull TQLParser.NegativeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code not}
	 * labeled alternative in {@link TQLParser#logic_expr}.
	 * @param ctx the parse tree
	 */
	void enterNot(@NotNull TQLParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code not}
	 * labeled alternative in {@link TQLParser#logic_expr}.
	 * @param ctx the parse tree
	 */
	void exitNot(@NotNull TQLParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#any_name}.
	 * @param ctx the parse tree
	 */
	void enterAny_name(@NotNull TQLParser.Any_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#any_name}.
	 * @param ctx the parse tree
	 */
	void exitAny_name(@NotNull TQLParser.Any_nameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code and}
	 * labeled alternative in {@link TQLParser#logic_expr}.
	 * @param ctx the parse tree
	 */
	void enterAnd(@NotNull TQLParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code and}
	 * labeled alternative in {@link TQLParser#logic_expr}.
	 * @param ctx the parse tree
	 */
	void exitAnd(@NotNull TQLParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#where}.
	 * @param ctx the parse tree
	 */
	void enterWhere(@NotNull TQLParser.WhereContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#where}.
	 * @param ctx the parse tree
	 */
	void exitWhere(@NotNull TQLParser.WhereContext ctx);
	/**
	 * Enter a parse tree produced by the {@code term}
	 * labeled alternative in {@link TQLParser#logic_expr}.
	 * @param ctx the parse tree
	 */
	void enterTerm(@NotNull TQLParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code term}
	 * labeled alternative in {@link TQLParser#logic_expr}.
	 * @param ctx the parse tree
	 */
	void exitTerm(@NotNull TQLParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#column_list}.
	 * @param ctx the parse tree
	 */
	void enterColumn_list(@NotNull TQLParser.Column_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#column_list}.
	 * @param ctx the parse tree
	 */
	void exitColumn_list(@NotNull TQLParser.Column_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#select_stream_stmt}.
	 * @param ctx the parse tree
	 */
	void enterSelect_stream_stmt(@NotNull TQLParser.Select_stream_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#select_stream_stmt}.
	 * @param ctx the parse tree
	 */
	void exitSelect_stream_stmt(@NotNull TQLParser.Select_stream_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#table}.
	 * @param ctx the parse tree
	 */
	void enterTable(@NotNull TQLParser.TableContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#table}.
	 * @param ctx the parse tree
	 */
	void exitTable(@NotNull TQLParser.TableContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#observation_stream_name}.
	 * @param ctx the parse tree
	 */
	void enterObservation_stream_name(@NotNull TQLParser.Observation_stream_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#observation_stream_name}.
	 * @param ctx the parse tree
	 */
	void exitObservation_stream_name(@NotNull TQLParser.Observation_stream_nameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code or}
	 * labeled alternative in {@link TQLParser#logic_expr}.
	 * @param ctx the parse tree
	 */
	void enterOr(@NotNull TQLParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code or}
	 * labeled alternative in {@link TQLParser#logic_expr}.
	 * @param ctx the parse tree
	 */
	void exitOr(@NotNull TQLParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#agg_func}.
	 * @param ctx the parse tree
	 */
	void enterAgg_func(@NotNull TQLParser.Agg_funcContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#agg_func}.
	 * @param ctx the parse tree
	 */
	void exitAgg_func(@NotNull TQLParser.Agg_funcContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#define_sensor_collection}.
	 * @param ctx the parse tree
	 */
	void enterDefine_sensor_collection(@NotNull TQLParser.Define_sensor_collectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#define_sensor_collection}.
	 * @param ctx the parse tree
	 */
	void exitDefine_sensor_collection(@NotNull TQLParser.Define_sensor_collectionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code is_null}
	 * labeled alternative in {@link TQLParser#term_expr}.
	 * @param ctx the parse tree
	 */
	void enterIs_null(@NotNull TQLParser.Is_nullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code is_null}
	 * labeled alternative in {@link TQLParser#term_expr}.
	 * @param ctx the parse tree
	 */
	void exitIs_null(@NotNull TQLParser.Is_nullContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#stream_table}.
	 * @param ctx the parse tree
	 */
	void enterStream_table(@NotNull TQLParser.Stream_tableContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#stream_table}.
	 * @param ctx the parse tree
	 */
	void exitStream_table(@NotNull TQLParser.Stream_tableContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#column_name}.
	 * @param ctx the parse tree
	 */
	void enterColumn_name(@NotNull TQLParser.Column_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#column_name}.
	 * @param ctx the parse tree
	 */
	void exitColumn_name(@NotNull TQLParser.Column_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#result_column}.
	 * @param ctx the parse tree
	 */
	void enterResult_column(@NotNull TQLParser.Result_columnContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#result_column}.
	 * @param ctx the parse tree
	 */
	void exitResult_column(@NotNull TQLParser.Result_columnContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(@NotNull TQLParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(@NotNull TQLParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#alias_name}.
	 * @param ctx the parse tree
	 */
	void enterAlias_name(@NotNull TQLParser.Alias_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#alias_name}.
	 * @param ctx the parse tree
	 */
	void exitAlias_name(@NotNull TQLParser.Alias_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#field_name}.
	 * @param ctx the parse tree
	 */
	void enterField_name(@NotNull TQLParser.Field_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#field_name}.
	 * @param ctx the parse tree
	 */
	void exitField_name(@NotNull TQLParser.Field_nameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link TQLParser#term_expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(@NotNull TQLParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link TQLParser#term_expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(@NotNull TQLParser.BooleanContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#function_name}.
	 * @param ctx the parse tree
	 */
	void enterFunction_name(@NotNull TQLParser.Function_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#function_name}.
	 * @param ctx the parse tree
	 */
	void exitFunction_name(@NotNull TQLParser.Function_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#stream_window}.
	 * @param ctx the parse tree
	 */
	void enterStream_window(@NotNull TQLParser.Stream_windowContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#stream_window}.
	 * @param ctx the parse tree
	 */
	void exitStream_window(@NotNull TQLParser.Stream_windowContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#order_by}.
	 * @param ctx the parse tree
	 */
	void enterOrder_by(@NotNull TQLParser.Order_byContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#order_by}.
	 * @param ctx the parse tree
	 */
	void exitOrder_by(@NotNull TQLParser.Order_byContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#select_stmt}.
	 * @param ctx the parse tree
	 */
	void enterSelect_stmt(@NotNull TQLParser.Select_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#select_stmt}.
	 * @param ctx the parse tree
	 */
	void exitSelect_stmt(@NotNull TQLParser.Select_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TQLParser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void enterParameter_list(@NotNull TQLParser.Parameter_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link TQLParser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void exitParameter_list(@NotNull TQLParser.Parameter_listContext ctx);
}