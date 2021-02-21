package com.github.homeant.yearning.database.dialects.mysql;

import com.github.homeant.yearning.Constants;
import com.github.homeant.yearning.Icons;
import com.intellij.database.Dbms;

import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentMap;
import com.intellij.util.ConcurrencyUtil;

public final class MysqlHolder {
    public static final Dbms DBMS;

    static {
        try {
            DBMS = Dbms.create(Constants.YEARNING_MY_SQL, Icons.LOGO);
            Field ourValuesField = Dbms.class.getDeclaredField("ourValues");
            ourValuesField.setAccessible(true);
            ConcurrentMap<String, Dbms> ourValues = (ConcurrentMap<String, Dbms>) ourValuesField.get(null);
            ConcurrencyUtil.cacheOrGet(ourValues, Constants.YEARNING_MY_SQL_UPPER_CASE, DBMS);
        } catch (NoSuchFieldException | IllegalAccessException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
}
