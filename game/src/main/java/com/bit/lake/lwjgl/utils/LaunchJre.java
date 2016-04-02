package com.bit.lake.lwjgl.utils;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by michael on 02.04.16.
 */
public class LaunchJre {

    private static boolean isWindows() {
        String os = System.getProperty("os.name");
        if (os == null) {
            throw new IllegalStateException("os.name");
        }
        os = os.toLowerCase();
        return os.startsWith("windows");
    }

    public static File getJreExecutable() throws FileNotFoundException {
        String jreDirectory = System.getProperty("java.home");
        if (jreDirectory == null) {
            throw new IllegalStateException("java.home");
        }
        File exe;
        if (isWindows()) {
            exe = new File(jreDirectory, "bin/java.exe");
        } else {
            exe = new File(jreDirectory, "bin/java");
        }
        if (!exe.isFile()) {
            throw new FileNotFoundException(exe.toString());
        }
        return exe;
    }

    public static Process launch(List<String> cmdarray) {
        ProcessBuilder processBuilder = new ProcessBuilder(cmdarray);
        processBuilder.redirectErrorStream(true);
        try {
            return processBuilder.start();
        } catch (IOException e) {
            Logger.getLogger(LaunchJre.class).error(e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            Runtime.getRuntime().exec("c:/");

            List<String> cmdarray = new ArrayList<String>();
            cmdarray.add(getJreExecutable().toString());
            cmdarray.add("-version");
            launch(cmdarray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}