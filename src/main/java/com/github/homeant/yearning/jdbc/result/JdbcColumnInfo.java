package com.github.homeant.yearning.jdbc.result;


import java.io.Serializable;


/**
 * @author huangtianhui
 */
public class JdbcColumnInfo implements Serializable {
    public final String catalog;
    public final String schema;
    public final String table;
    public final String label;
    public final String name;
    public final int length;
    public final int scale;
    public final JdbcType jdbcType;

    public JdbcColumnInfo(String name, JdbcType jdbcType, String catalog, String schema, String table, String label, int length, int scale) {
        this.name = name;
        this.jdbcType = jdbcType;
        this.catalog = catalog;
        this.schema = schema;
        this.table = table;
        this.label = label;
        this.length = length;
        this.scale = scale;
    }

    public JdbcColumnInfo(String name, JdbcType jdbcType, String catalog, String schema, String table, String label, int length) {
        this(name, jdbcType, catalog, schema, table, label, length, 0);
    }

    public JdbcColumnInfo(String name, JdbcType jdbcType, String label, int length) {
        this(name, jdbcType, null, null, null, label, length, 0);
    }

    public JdbcColumnInfo(String name, JdbcType jdbcType, String label, int length, int scale) {
        this(name, jdbcType, null, null, null, label, length, scale);
    }

    public JdbcColumnInfo(String name, JdbcType jdbcType, int length) {
        this(name, jdbcType, null, null, null, null, length, 0);
    }

    public JdbcColumnInfo(String name, JdbcType jdbcType, int length,int scale) {
        this(name, jdbcType, null, null, null, null, length, scale);
    }

    public JdbcColumnInfo(String name, JdbcType jdbcType) {
        this(name, jdbcType, null, null, null, null, 0, 0);
    }
}
