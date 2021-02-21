package com.github.homeant.yearning.database.dialects.mysql;

import com.intellij.database.Dbms;
import com.intellij.database.dialects.base.AbstractDatabaseDialect;
import com.intellij.database.model.DasObject;
import com.intellij.database.model.DasRoutine;
import com.intellij.database.util.DbImplUtil;
import com.intellij.database.util.DdlBuilder;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.openapi.util.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MysqlDialect extends AbstractDatabaseDialect {

    private final Dbms dbms;

    public MysqlDialect(Dbms dbms){
        super(new MysqlTypeHelper());
        this.dbms = dbms;
    }


    @Override
    public @NotNull DdlBuilder qualifiedIdentifier(DdlBuilder ddlBuilder, @NotNull String s, @Nullable DasObject dasObject, @NotNull DasObject dasObject1) {
        return ddlBuilder;
    }

    @Override
    public @NotNull DdlBuilder sqlDropSequence(@NotNull DdlBuilder ddlBuilder, @NotNull DasObject dasObject, boolean b) {
        return ddlBuilder;
    }

    @Override
    public @Nullable Pair<String, DbImplUtil.ConcatenationProps> sqlViewDefinition(@NotNull DasObject dasObject) {
        return null;
    }

    @Override
    public @NotNull Pair<String, DbImplUtil.ConcatenationProps> sqlProcedureDefinition(@NotNull DasRoutine dasRoutine) {
        return null;
    }

    @Override
    public @NotNull Dbms getDbms() {
        return this.dbms;
    }

    @Override
    public @NlsSafe @NotNull String getDisplayName() {
        return "Yearning SQL";
    }

    @Override
    public boolean supportsEmptyTables() {
        return false;
    }

    @Override
    public boolean supportsViewDefinition() {
        return false;
    }

    @Override
    public boolean supportsProcedureDefinition() {
        return false;
    }

    @Override
    public boolean supportsCommonTableExpression() {
        return false;
    }
}
