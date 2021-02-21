package com.github.homeant.yearning.sql.dialects.mysql;

import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.sql.dialects.base.SqlElementFactory;
import com.intellij.sql.dialects.base.SqlParserDefinitionBase;
import com.intellij.sql.dialects.mysql.MysqlDialect;
import com.intellij.sql.psi.stubs.SqlFileElementType;
import org.jetbrains.annotations.NotNull;

public class MysqlParserDefinition extends SqlParserDefinitionBase {

    private static final IFileElementType MYSQL_SQL_FILE;

    static {
        MYSQL_SQL_FILE = new SqlFileElementType("YEARNING_SQL_FILE", MysqlDialect.INSTANCE);
    }

    private com.intellij.sql.dialects.mysql.MysqlParserDefinition mysqlParserDefinition = new com.intellij.sql.dialects.mysql.MysqlParserDefinition();

    @Override
    protected SqlElementFactory createElementFactory() {
        return mysqlParserDefinition.getElementFactory();
    }

    @Override
    public @NotNull Lexer createLexer(Project project) {
        return mysqlParserDefinition.createLexer(project);
    }

    @Override
    public PsiParser createParser(Project project) {
        return mysqlParserDefinition.createParser(project);
    }

    @Override
    public IFileElementType getFileNodeType() {
        return MYSQL_SQL_FILE;
    }
}