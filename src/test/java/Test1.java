/*
 * Copyright (c) 2022 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import vavi.util.Debug;
import vavi.util.logging.rococoa.asl.AslLibrary;


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

    @Test
    void test1() throws Exception {
        for (int i = 0; i < 20; i++) {
            Debug.printf("[%d] %s", i, "Hello Vavi " + i);
        }
Debug.println("done");
    }
}