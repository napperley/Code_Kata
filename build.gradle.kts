group = "org.example"
version = "0.1-SNAPSHOT"

buildscript {
    extra["kotlin-ver"] = "1.1.2-4"
    extra["junit-ver"] = "4.12"

    repositories {
        jcenter()
    }

    dependencies {
        classpath(kotlinModule("gradle-plugin", version = extra["kotlin-ver"] as String))
    }
}

apply {
    plugin("kotlin")
    plugin("application")
}

configure<ApplicationPluginConvention> {
    mainClassName = "org.example.codekata.MainKt"
}

repositories {
    jcenter()
}

dependencies {
    compile(kotlinModule("stdlib-jre8", version = extra["kotlin-ver"] as String))
    testCompile("junit:junit:${extra["junit-ver"]}")
}