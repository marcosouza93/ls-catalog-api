import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.4.31"
	id("idea")
	jacoco
}

group = "br.com.mls.catalog.api"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
	jvmTarget = "11"
}

val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
	jvmTarget = "11"
}

allprojects {
	apply(plugin = "kotlin")
	apply(plugin = "jacoco")

	jacoco {
		toolVersion = "0.8.5"
		reportsDir = file("$buildDir/reports/jacoco")
	}

	repositories {
		mavenCentral()
	}
}

subprojects {

	dependencies {
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

		testImplementation("io.mockk:mockk:1.10.6")
		testImplementation("com.willowtreeapps.assertk:assertk-jvm:0.23.1")
		testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.2")

		testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.5.2")
	}

	java {
		sourceCompatibility = JavaVersion.VERSION_11
		targetCompatibility = JavaVersion.VERSION_11
	}

	tasks {
		withType<KotlinCompile> {
			kotlinOptions {
				jvmTarget = "11"
				freeCompilerArgs = listOf("-Xjsr305=strict")
			}
		}

		withType<Test> {
			this.environment("APPLICATION", "ls-catalog-api")
			useJUnitPlatform()
		}

		withType<JacocoReport> {
			val srcDirs = files(sourceSets["main"].allSource.srcDirs)
			val output = files(sourceSets["main"].output)

			additionalSourceDirs.from(srcDirs)
			sourceDirectories.from(srcDirs)
			classDirectories.from(output)

			reports {
				html.isEnabled = true
				xml.isEnabled = true
				csv.isEnabled = false
			}
		}
	}
}

dependencies {
	implementation(kotlin("stdlib-jdk8"))
}

tasks {
	val jacocoMerge by creating(JacocoMerge::class) {
		executionData = files(subprojects.map { File(it.buildDir, "/jacoco/test.exec") })
		doFirst {
			executionData = files(executionData.filter { it.exists() })
		}
	}

	val jacocoTestReport = this.getByName("jacocoTestReport")
	jacocoTestReport.dependsOn(subprojects.map { it.tasks["jacocoTestReport"] })
	jacocoMerge.dependsOn(jacocoTestReport)

	val jacocoRootReport by creating(JacocoReport::class) {
		description = "Generates an aggregate report from all subprojects"
		group = "verification"
		dependsOn(jacocoMerge, "copyJunitXml")

		sourceDirectories.setFrom(files(subprojects.flatMap { it.sourceSets["main"].allSource.srcDirs }))
		classDirectories.setFrom(files(subprojects.flatMap { it.sourceSets["main"].output }))

		executionData(jacocoMerge.destinationFile)

		reports {
			html.isEnabled = true
			html.destination = file("${buildDir}/reports/jacoco/test/html")

			xml.isEnabled = true
			xml.destination = file("${buildDir}/reports/jacoco/test/jacocoTestReport.xml")
		}

		afterEvaluate {
			val excludedClasses = listOf(
					"br/com/ls/catalog/api/Application**"
			)

			val classDirectoriesWithExcluded = files(classDirectories.files.map {
				fileTree(it).exclude(excludedClasses)
			})

			classDirectories.setFrom(classDirectoriesWithExcluded)
		}
	}

	register<Copy>("copyJunitXml") {
		from(subprojects.map { (it.tasks["test"] as Test).reports.junitXml.destination })
		include("**/*.xml")
		into("$buildDir/test-results/test")
	}

	jacocoTestReport.finalizedBy(jacocoRootReport)
}

task("bootJar").apply {
	group = "build"
	dependsOn(":application:bootJar")
}

task("bootRun").apply {
	group = "application"
	dependsOn(":application:bootRun")
}