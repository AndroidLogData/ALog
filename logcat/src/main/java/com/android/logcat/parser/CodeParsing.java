package com.android.logcat.parser;

import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by Null on 2018-01-04.
 */

public class CodeParsing {
    public void parsing(Class clazz) {
        Class c = clazz;
        Method methlist[] = c.getDeclaredMethods();
        Field fieldList[] = c.getDeclaredFields();
        for (int i = 0; i < fieldList.length; i++) {
            Field f = fieldList[i];
            Log.i("name", f.getName());
            Log.i("DeclaringClass", f.getDeclaringClass().toString());
            Log.i("Type", f.getType().toString());
            Log.i("Modifiers", Modifier.toString(f.getModifiers()));
        }
        for (int i = 0; i < methlist.length; i++) {
            Method m = methlist[i];
            Log.i("name", m.getName());
            Log.i("DeclaringClass", m.getDeclaringClass().toString());
            Log.i("Type", m.getReturnType().toString());
            Log.i("Modifiers", Modifier.toString(m.getModifiers()));
            Class pvec[] = m.getParameterTypes();
            for (int j = 0; j < pvec.length; j++) {
                Log.i("param", j + " " + pvec[j]);
            }
            Class evec[] = m.getExceptionTypes();
            for (int j = 0; j < evec.length; j++) {
                Log.i("exc", j + " " + evec[j]);
            }
        }
    }
}

