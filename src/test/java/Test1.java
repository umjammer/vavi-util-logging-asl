/*
 * Copyright (c) 2022 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

import org.junit.jupiter.api.Test;
import vavi.util.Debug;
import vavi.util.logging.jna.asl.AslLibrary;


/**
 * Test1.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 2022-09-07 nsano initial version <br>
 */
class Test1 {

    @Test
    void test0() throws Exception {
        AslLibrary.INSTANCE.asl_log(null, null, AslLibrary.ASL_LEVEL_NOTICE, "Hello %s", "ASL");
Debug.println("done");
    }

    /**
     * logging.properties:
     * <pre>
     * handlers=vavi.util.logging.asl.AslHandler
     * </pre>
     */
    @Test
    void test1() throws Exception {
        for (int i = 0; i < 400; i++) {
            Debug.printf("[%d] %s", i, "Hello Vavi " + i);
        }
        Debug.printf("漢字");
Debug.println("done");
    }
}
