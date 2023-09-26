plugins {
    id("java")
    war
}

group = "servlets"
version = ""

repositories {
    mavenCentral()
}

dependencies {
    providedCompile("javax.servlet:servlet-api:2.5")
    compileOnly("jakarta.servlet:jakarta.servlet-api:6.0.0")

    implementation("org.postgresql:postgresql:42.6.0")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.war {
    webAppDirectory.set(file("src/main/webapp"))
}

tasks.test {
    useJUnitPlatform()
}