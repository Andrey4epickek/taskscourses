package com.hotel.config;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class ConsoleFormatter extends Formatter {

    public String format(LogRecord record) {
        return ""+new Date(record.getMillis())+" - "+record.getLevel()+" - "+record.getMessage()+"\n";
    }
}
