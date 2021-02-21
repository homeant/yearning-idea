package com.github.homeant.yearning.sql.dialects.mysql;

import com.intellij.sql.dialects.SqlTypeSystem;

public class MysqlTypeSystem extends SqlTypeSystem {

    public static final MysqlTypeSystem INSTANCE = new MysqlTypeSystem();

    protected MysqlTypeSystem() {
        super(MysqlSqlDialect.INSTANCE);
    }
}
