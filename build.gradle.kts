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
    compileOnly ("org.projectlombok:lombok:1.18.20")
    annotationProcessor ("org.projectlombok:lombok:1.18.20")


    implementation("jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api:3.0.0")
    implementation("org.glassfish.web:jakarta.servlet.jsp.jstl:3.0.1")
    implementation("org.postgresql:postgresql:42.6.0")

    testCompileOnly ("org.projectlombok:lombok:1.18.20")
    testAnnotationProcessor ("org.projectlombok:lombok:1.18.20")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.war {
    webAppDirectory.set(file("src/main/webapp"))
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

tasks.test {
    useJUnitPlatform()
}