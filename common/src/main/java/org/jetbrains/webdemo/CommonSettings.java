/*
 * Copyright 2000-2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.webdemo;

import java.io.*;

/**
 * Created by Semyon.Atamas on 2/13/2015.
 */
public class CommonSettings {
    public static boolean IS_TEST_VERSION = true;
    public static String KOTLIN_VERSION = loadKotlinVersion();

    public static String HELP_DIRECTORY = "help";
    public static String LOGS_DIRECTORY = "logs";

    private static String loadKotlinVersion() {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(CommonSettings.class.getResourceAsStream("/kotlin-build.txt")))){
            return reader.readLine();
        } catch (IOException e) {
            ErrorWriter.ERROR_WRITER.writeExceptionToExceptionAnalyzer(e, "", "", "Can't load kotlin version");
            return null;
        }
    }
}
