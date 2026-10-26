/*
 * Copyright (c) 2022 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.util.logging.asl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import vavi.util.logging.jna.asl.AslLibrary;


/**
 * AslOutputStream.
 *
 * ASL_LEVEL_INFO and ASL_LEVEL_DEBUG are hidden by default on recent macOS.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 2022-09-17 nsano initial version <br>
 */
public class AslOutputStream extends OutputStream {

    /** */
    private final ByteArrayOutputStream baos = new ByteArrayOutputStream();

    /** asl level for the next flush */
    private int level = AslLibrary.ASL_LEVEL_NOTICE;

    /** @param level asl level for messages flushed after this */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * @return true when the native asl library is available on this platform
     */
    public static boolean isAvailable() {
        try {
            return AslLibrary.INSTANCE != null;
        } catch (LinkageError e) { // UnsatisfiedLinkError, ExceptionInInitializerError, NoClassDefFoundError
            return false;
        }
    }

    @Override
    public void write(int b) throws IOException {
        baos.write(b);
    }

    @Override
    public void flush() throws IOException {
        if (baos.size() == 0) {
            return; // StreamHandler also flushes when nothing is written (head, close etc.)
        }
        String message = baos.toString();
        baos.reset();
        // message must not be a format string, '%' in it crashes the native side
        int r = AslLibrary.INSTANCE.asl_log(null, null, level, "%s", message);
        if (r != 0) throw new IOException("code: " + r);
System.err.print(message);
    }
}
