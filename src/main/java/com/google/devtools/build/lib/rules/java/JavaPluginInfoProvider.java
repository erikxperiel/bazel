// Copyright 2014 The Bazel Authors. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.devtools.build.lib.rules.java;

import com.google.common.collect.ImmutableList;
import com.google.devtools.build.lib.actions.Artifact;
import com.google.devtools.build.lib.analysis.TransitiveInfoProvider;
import com.google.devtools.build.lib.collect.nestedset.NestedSet;
import com.google.devtools.build.lib.concurrent.ThreadSafety.Immutable;

/**
 * Provider for users of Java plugins.
 */
@Immutable
public final class JavaPluginInfoProvider implements TransitiveInfoProvider {

  private final ImmutableList<String> processorClasses;
  private final NestedSet<Artifact> processorClasspath;

  public JavaPluginInfoProvider(ImmutableList<String> processorClasses,
      NestedSet<Artifact> processorClasspath) {
    this.processorClasses = processorClasses;
    this.processorClasspath = processorClasspath;
  }

  /**
   * Returns the class that should be passed to javac in order
   * to run the annotation processor this class represents.
   */
  public ImmutableList<String> getProcessorClasses() {
    return processorClasses;
  }

  /**
   * Returns the artifacts to add to the runtime classpath for this plugin.
   */
  public NestedSet<Artifact> getProcessorClasspath() {
    return processorClasspath;
  }
}
