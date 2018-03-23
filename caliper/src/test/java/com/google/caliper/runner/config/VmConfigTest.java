/*
 * Copyright (C) 2012 Google Inc.
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

package com.google.caliper.runner.config;

import static org.junit.Assert.assertTrue;

import com.google.caliper.runner.platform.JvmPlatform;
import java.io.File;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests {@link VmConfig}.
 *
 * @author gak@google.com (Gregory Kick)
 */
@RunWith(JUnit4.class)
public class VmConfigTest {


  @Test
  public void testExecutable() {
    JvmPlatform platform = new JvmPlatform();
    VmConfig config =
        VmConfig.builder()
            .name("foo")
            .platform(platform)
            .type(platform.vmType())
            .home(System.getProperty("java.home"))
            .build();
    File javaExecutable = config.platform().vmExecutable(new File(config.home().get()));
    assertTrue("Could not find: " + javaExecutable, javaExecutable.exists());
    assertTrue(javaExecutable + " is not a file", javaExecutable.isFile());
  }
}
