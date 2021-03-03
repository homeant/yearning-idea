package com.github.homeant.yearning.jdbc.result;

import java.sql.SQLType;
import java.sql.Types;

public enum JdbcType implements SQLType {
    /**
     * BOOLEAN
     */
    BOOLEAN(                  Types.BOOLEAN),
    BYTE(                     Types.TINYINT),
    SHORT(                    Types.SMALLINT),
    INTEGER(                  Types.INTEGER),
    LONG(                     Types.BIGINT),
    DOUBLE(                   Types.DOUBLE),
    FLOAT(                    Types.REAL),
    HALF_FLOAT(               Types.FLOAT),
    SCALED_FLOAT(             Types.FLOAT),
    KEYWORD(                  Types.VARCHAR),
    TEXT(                     Types.VARCHAR),
    OBJECT(                   Types.STRUCT),
    NESTED(                   Types.STRUCT),
    BINARY(                   Types.VARBINARY),
    DATE(                     Types.DATE),
    TIME(                     Types.TIME),
    DATETIME(                 Types.TIMESTAMP);

    private final Integer type;

    JdbcType(Integer type){
        this.type = type;
    }

    /**
     * Returns the {@code SQLType} name that represents a SQL data type.
     *
     * @return The name of this {@code SQLType}.
     */
    @Override
    public String getName() {
        return name();
    }

    /**
     * Returns the name of the vendor that supports this data type. The value
     * returned typically is the package name for this vendor.
     *
     * @return The name of the vendor for this data type
     */
    @Override
    public String getVendor() {
        return "Yearning-MySQL";
    }

    /**
     * Returns the vendor specific type number for the data type.
     *
     * @return An Integer representing the vendor specific data type
     */
    @Override
    public Integer getVendorTypeNumber() {
        return type;
    }
}
