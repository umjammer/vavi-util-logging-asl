/*
 * Copyright (c) 2022 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

import java.util.logging.Level;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import vavi.util.Debug;
import vavi.util.logging.asl.AslHandler;
import vavi.util.logging.asl.AslOutputStream;
import vavi.util.logging.jna.asl.AslLibrary;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Test1.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 2022-09-07 nsano initial version <br>
 */
class Test1 {

    @Test
    @EnabledOnOs(OS.MAC)
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

    @Test
    void test2() throws Exception {
        assertEquals(OS.current() == OS.MAC, AslOutputStream.isAvailable());
    }

    @Test
    void test3() throws Exception {
        assertEquals(AslLibrary.ASL_LEVEL_ERR, AslHandler.toAslLevel(Level.SEVERE));
        assertEquals(AslLibrary.ASL_LEVEL_WARNING, AslHandler.toAslLevel(Level.WARNING));
        assertEquals(AslLibrary.ASL_LEVEL_NOTICE, AslHandler.toAslLevel(Level.INFO));
        assertEquals(AslLibrary.ASL_LEVEL_INFO, AslHandler.toAslLevel(Level.CONFIG));
        assertEquals(AslLibrary.ASL_LEVEL_INFO, AslHandler.toAslLevel(Level.FINE));
        assertEquals(AslLibrary.ASL_LEVEL_DEBUG, AslHandler.toAslLevel(Level.FINER));
        assertEquals(AslLibrary.ASL_LEVEL_DEBUG, AslHandler.toAslLevel(Level.FINEST));
    }
}
