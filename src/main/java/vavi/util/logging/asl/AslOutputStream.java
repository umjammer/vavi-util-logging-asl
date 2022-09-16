/*
 * Copyright (c) 2022 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.util.logging.asl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import vavi.util.logging.rococoa.asl.AslLibrary;


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
    private ByteArrayOutputStream baos = new ByteArrayOutputStream();

    @Override
    public void write(int b) throws IOException {
        baos.write(b);
    }

    @Override
    public void flush() throws IOException {
        String message = baos.toString();
        AslLibrary.INSTANCE.asl_log(null, null, AslLibrary.ASL_LEVEL_NOTICE, message);
System.err.print(message);
        baos.reset();
    }
}
