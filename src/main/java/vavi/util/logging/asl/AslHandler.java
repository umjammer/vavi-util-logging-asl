/*
 * Copyright (c) 2022 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.util.logging.asl;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import vavi.util.logging.jna.asl.AslLibrary;


/**
 * AslHandler.
 * <p>
 * falls back to {@link ConsoleHandler} ({@code System.err}) when asl is not available (non-macOS).
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 2022-09-17 nsano initial version <br>
 */
public class AslHandler extends ConsoleHandler {

    /** null when falling back to the console */
    private AslOutputStream aslOutputStream;

    /**
     * Create a {@code ConsoleHandler} for {@code System.err}.
     * <p>
     * The {@code ConsoleHandler} is configured based on
     * {@code LogManager} properties (or their default values).
     */
    public AslHandler() {
        if (AslOutputStream.isAvailable()) {
            aslOutputStream = new AslOutputStream();
            setOutputStream(aslOutputStream);
        } else {
System.err.println("asl is not available, fall back to console");
        }
System.err.println("class: " + getClass());
System.err.println("level: " + getLevel());
System.err.println("formatter: " + getFormatter());
    }

    @Override
    public synchronized void publish(LogRecord record) {
        if (aslOutputStream != null && record != null) {
            aslOutputStream.setLevel(toAslLevel(record.getLevel()));
        }
        super.publish(record);
    }

    /** maps jul level to asl level */
    public static int toAslLevel(Level level) {
        int v = level.intValue();
        if (v >= Level.SEVERE.intValue()) {
            return AslLibrary.ASL_LEVEL_ERR;
        } else if (v >= Level.WARNING.intValue()) {
            return AslLibrary.ASL_LEVEL_WARNING;
        } else if (v >= Level.INFO.intValue()) {
            return AslLibrary.ASL_LEVEL_NOTICE;
        } else if (v >= Level.FINE.intValue()) {
            return AslLibrary.ASL_LEVEL_INFO;
        } else {
            return AslLibrary.ASL_LEVEL_DEBUG;
        }
    }
}
