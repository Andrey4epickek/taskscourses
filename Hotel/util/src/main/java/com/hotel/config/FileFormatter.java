package com.hotel.config;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class FileFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        return ""+new Date(record.getMillis())+" - ["+record.getSourceClassName()+"] - "+record.getLevel()+" - "+record.getMessage()+"\n"+record.getThrown()+"\n";
    }
}
