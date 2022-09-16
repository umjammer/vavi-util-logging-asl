/*
 * Copyright (c) 2022 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.util.logging.asl;

import java.util.logging.ConsoleHandler;


/**
 * AslHandler.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 2022-09-17 nsano initial version <br>
 */
public class AslHandler extends ConsoleHandler {

    /**
     * Create a {@code ConsoleHandler} for {@code System.err}.
     * <p>
     * The {@code ConsoleHandler} is configured based on
     * {@code LogManager} properties (or their default values).
     *
     */
    public AslHandler() {
        super();
        setOutputStream(new AslOutputStream());
System.err.println("class: "+ getClass());
System.err.println("level: "+ getLevel());
System.err.println("formatter: "+ getFormatter());
    }
}
