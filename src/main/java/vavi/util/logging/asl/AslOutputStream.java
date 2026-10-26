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
 * TODO ASL_LEVEL_INFO doesn't show message, ASL_LEVEL_NOTICE works.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 2022-09-17 nsano initial version <br>
 */
public class AslOutputStream extends OutputStream {

    /** */
    private final ByteArrayOutputStream baos = new ByteArrayOutputStream();

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
        int r = AslLibrary.INSTANCE.asl_log(null, null, AslLibrary.ASL_LEVEL_NOTICE, "%s", message);
        if (r != 0) throw new IOException("code: " + r);
System.err.print(message);
    }
}
