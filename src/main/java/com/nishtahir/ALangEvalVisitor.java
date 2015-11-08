package com.nishtahir;

import com.nishtahir.evaluator.Operation;
import com.nishtahir.evaluator.ValueEvaluator;
import com.nishtahir.exception.UnknownOperationException;
import com.nishtahir.utils.StringUtils;
import com.nishtahir.utils.ValueUtils;
import com.nishtahir.value.BooleanValue;
import com.nishtahir.value.IntegerValue;
import com.nishtahir.value.StringValue;
import com.nishtahir.value.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nish on 11/8/15.
 */
public class ALangEvalVisitor extends ALangBaseVisitor<Value> {
    Logger log = LoggerFactory.getLogger(ALangEvalVisitor.class);

    /**
     * Table containing tokens and their reference values
     */
    private static Map<String, Value> tokenValueMap = new HashMap<>();


    @Override
    public Value visitAssignment(ALangParser.AssignmentContext ctx) {
        String id = ctx.Identifier().getText();
        Value value = this.visit(ctx.expression());
        return tokenValueMap.put(id, value);
    }

    @Override
    public Value visitExprAddSub(ALangParser.ExprAddSubContext ctx) {
        Value lhs = this.visit(ctx.expression(0));
        Value rhs = this.visit(ctx.expression(1));

        switch (ctx.op.getType()) {
            case ALangParser.ADD:
                return ValueEvaluator.evaluate(lhs, rhs, Operation.Add);
            case ALangParser.SUB:
                return ValueEvaluator.evaluate(lhs, rhs, Operation.Sub);
            default:
                throw new UnknownOperationException("unknown operator: " + ALangParser.tokenNames[ctx.op.getType()]);
        }
    }

    @Override
    public Value visitExprBoolean(ALangParser.ExprBooleanContext ctx) {
        Value lhs = this.visit(ctx.expression(0));
        Value rhs = this.visit(ctx.expression(1));

        switch (ctx.op.getType()) {
            case ALangParser.GTR:
                return ValueEvaluator.evaluate(lhs, rhs, Operation.Greater);
            case ALangParser.LESS:
                return ValueEvaluator.evaluate(lhs, rhs, Operation.Less);
            case ALangParser.EQL:
                return ValueEvaluator.evaluate(lhs, rhs, Operation.Equal);
            case ALangParser.NEQL:
                BooleanValue value = (BooleanValue) ValueEvaluator.evaluate(lhs, rhs, Operation.Equal);
                value.setValue(!value.getValue());
                return value;
            default:
                throw new UnknownOperationException("unknown operator: " + ALangParser.tokenNames[ctx.op.getType()]);
        }
    }

    @Override
    public Value visitLiteralIdentifier(ALangParser.LiteralIdentifierContext ctx) {
        String identifier = ctx.getText();
        Value value = tokenValueMap.get(identifier);
        if (value == null) {
            throw new RuntimeException(identifier + " was not declared");
        }
        return value;
    }

    @Override
    public Value visitLiteralString(ALangParser.LiteralStringContext ctx) {
        return new StringValue(StringUtils.clean(ctx.getText()));
    }

    @Override
    public Value visitLiteralNumber(ALangParser.LiteralNumberContext ctx) {
        return new IntegerValue(ctx.getText());
    }

    @Override
    public Value visitPrint(ALangParser.PrintContext ctx) {
        System.out.print(this.visit(ctx.parameter()));
        return super.visitPrint(ctx);
    }

    @Override
    public Value visitPrintLine(ALangParser.PrintLineContext ctx) {
        System.out.println(this.visit(ctx.parameter()));
        return super.visitPrintLine(ctx);
    }

    @Override
    public Value visitForLoop(ALangParser.ForLoopContext ctx) {
        String identifier = ctx.Identifier().getText();

        ALangParser.RangeContext rangeCtx = ctx.range();
        IntegerValue lhs = ValueUtils.checkAsInt(this.visit(rangeCtx.expression(0)));
        IntegerValue rhs = ValueUtils.checkAsInt(this.visit(rangeCtx.expression(1)));

        IntegerValue loopCounter = new IntegerValue(lhs.getValue());
        tokenValueMap.put(identifier, loopCounter);

        if (lhs.compareTo(rhs) < 0) {
            for (int i = lhs.getValue(); i <= rhs.getValue(); i++){
                loopCounter.setValue(i);
                tokenValueMap.put(identifier, loopCounter);
                this.visit(ctx.statements());
            }
        } else if (lhs.compareTo(rhs) > 0) {
            for (int i = lhs.getValue(); i >= rhs.getValue(); i--) {
                loopCounter.setValue(i);
                tokenValueMap.put(identifier, loopCounter);
                this.visit(ctx.statements());
            }
        } else {
            this.visit(ctx.statements());
        }

        tokenValueMap.remove(identifier);
        return null;
    }

    @Override
    public Value visitIfStatement(ALangParser.IfStatementContext ctx) {

        BooleanValue condition = (BooleanValue) this.visit(ctx.expression());
        if(condition.getValue()){
            return this.visitStatements(ctx.statements(0));
        } else {
            return this.visitStatements(ctx.statements(1));
        }
    }

    @Override
    public Value visitRange(ALangParser.RangeContext ctx) {
        Value lhs = this.visit(ctx.expression(0));
        Value rhs = this.visit(ctx.expression(1));

        return ValueEvaluator.evaluate(lhs, rhs, Operation.Sub);
    }
}
