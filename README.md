# Caliper

> **NOTICE:** The Caliper web application that was at
> microbenchmarks.appspot.com was shut down on August 15, 2022.

Caliper is a tool for measuring Java code performance, primarily focused on
microbenchmarks.

## Prefer [JMH] or [Jetpack Microbenchmark]

For new benchmarks, we recommend using a tool other than Caliper:

- For JVM benchmarks, use [JMH], which generally provides
[more accurate results](https://groups.google.com/g/mechanical-sympathy/c/m4opvy4xq3U/m/7lY8x8SvHgwJ)
than Caliper.
- For Android benchmarks, use the [Jetpack Microbenchmark] library.

## Building

To build the JVM version of Caliper (the only supported version at the moment),
run:

```shell
mvn clean install -am -pl caliper
```

### Android

Caliper currently has a number of artifacts related to Android. These are in
a transitional state and no easy way to run Caliper benchmarks on Android is
currently available.

If you are interested in building the Android artifacts for any reason, you can
run:

```shell
mvn clean install -am -pl caliper-android
```

Note that for these artifacts to build, you must have an `ANDROID_HOME`
environment variable set to the location of an Android SDK containing the file
`platforms/android-25/android.jar`. Alternatively, you can pass
`-Dandroid.home=<path>` to your `mvn` command to set the Android SDK directory
that way, and/or `-Dandroid.sdk.version=<version>` to specify a version other
than `25` (but note that the build may not work with a version lower than `25`).

[JMH]: https://openjdk.java.net/projects/code-tools/jmh/
[Jetpack Microbenchmark]: https://developer.android.com/topic/performance/benchmarking/microbenchmark-overview
