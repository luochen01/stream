// Generated from TQL.g4 by ANTLR 4.4

	package edu.uci.asterix.stream.parser.gen;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TQLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TQLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TQLParser#select}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect(@NotNull TQLParser.SelectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code not_null}
	 * labeled alternative in {@link TQLParser#term_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot_null(@NotNull TQLParser.Not_nullContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arithmetic}
	 * labeled alternative in {@link TQLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmetic(@NotNull TQLParser.ArithmeticContext ctx);
	/**
	 * Visit a parse tree produced by the {@code array_get_item}
	 * labeled alternative in {@link TQLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_get_item(@NotNull TQLParser.Array_get_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull TQLParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#time_interval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime_interval(@NotNull TQLParser.Time_intervalContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#table_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_name(@NotNull TQLParser.Table_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#from_stream}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrom_stream(@NotNull TQLParser.From_streamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cast}
	 * labeled alternative in {@link TQLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCast(@NotNull TQLParser.CastContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#literal_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_value(@NotNull TQLParser.Literal_valueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code function}
	 * labeled alternative in {@link TQLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(@NotNull TQLParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#limit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimit(@NotNull TQLParser.LimitContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#time_unit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime_unit(@NotNull TQLParser.Time_unitContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#from}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrom(@NotNull TQLParser.FromContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parentheses}
	 * labeled alternative in {@link TQLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentheses(@NotNull TQLParser.ParenthesesContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#having}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHaving(@NotNull TQLParser.HavingContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparison}
	 * labeled alternative in {@link TQLParser#term_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(@NotNull TQLParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code like}
	 * labeled alternative in {@link TQLParser#term_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLike(@NotNull TQLParser.LikeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code in}
	 * labeled alternative in {@link TQLParser#term_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIn(@NotNull TQLParser.InContext ctx);
	/**
	 * Visit a parse tree produced by the {@code count}
	 * labeled alternative in {@link TQLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCount(@NotNull TQLParser.CountContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#field_access}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField_access(@NotNull TQLParser.Field_accessContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#define_sensor_collections}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_sensor_collections(@NotNull TQLParser.Define_sensor_collectionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#column_alias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_alias(@NotNull TQLParser.Column_aliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#group_by}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup_by(@NotNull TQLParser.Group_byContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fields}
	 * labeled alternative in {@link TQLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFields(@NotNull TQLParser.FieldsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code aggr}
	 * labeled alternative in {@link TQLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggr(@NotNull TQLParser.AggrContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#define_observation_streams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_observation_streams(@NotNull TQLParser.Define_observation_streamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#sensor_collection_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSensor_collection_name(@NotNull TQLParser.Sensor_collection_nameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logic_parentheses}
	 * labeled alternative in {@link TQLParser#logic_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogic_parentheses(@NotNull TQLParser.Logic_parenthesesContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#define_observation_stream}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_observation_stream(@NotNull TQLParser.Define_observation_streamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literal}
	 * labeled alternative in {@link TQLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(@NotNull TQLParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negative}
	 * labeled alternative in {@link TQLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegative(@NotNull TQLParser.NegativeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code not}
	 * labeled alternative in {@link TQLParser#logic_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(@NotNull TQLParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#any_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAny_name(@NotNull TQLParser.Any_nameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code and}
	 * labeled alternative in {@link TQLParser#logic_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(@NotNull TQLParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#where}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhere(@NotNull TQLParser.WhereContext ctx);
	/**
	 * Visit a parse tree produced by the {@code term}
	 * labeled alternative in {@link TQLParser#logic_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(@NotNull TQLParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#column_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_list(@NotNull TQLParser.Column_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#select_stream_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_stream_stmt(@NotNull TQLParser.Select_stream_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable(@NotNull TQLParser.TableContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#observation_stream_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObservation_stream_name(@NotNull TQLParser.Observation_stream_nameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code or}
	 * labeled alternative in {@link TQLParser#logic_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(@NotNull TQLParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#agg_func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgg_func(@NotNull TQLParser.Agg_funcContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#define_sensor_collection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine_sensor_collection(@NotNull TQLParser.Define_sensor_collectionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code is_null}
	 * labeled alternative in {@link TQLParser#term_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIs_null(@NotNull TQLParser.Is_nullContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#column_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_name(@NotNull TQLParser.Column_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#result_column}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResult_column(@NotNull TQLParser.Result_columnContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(@NotNull TQLParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#alias_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlias_name(@NotNull TQLParser.Alias_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#field_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField_name(@NotNull TQLParser.Field_nameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link TQLParser#term_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(@NotNull TQLParser.BooleanContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#function_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_name(@NotNull TQLParser.Function_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#stream_window}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStream_window(@NotNull TQLParser.Stream_windowContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#order_by}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrder_by(@NotNull TQLParser.Order_byContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#select_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_stmt(@NotNull TQLParser.Select_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link TQLParser#parameter_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_list(@NotNull TQLParser.Parameter_listContext ctx);
}