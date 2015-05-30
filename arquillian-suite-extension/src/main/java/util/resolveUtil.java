package util;
import java.io.File;

import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

public final class resolveUtil {

	public static void addDependencyPom(Archive<?> deploy, String dependency)	{
		Maven.resolver()
		.loadPomFromFile("pom.xml")
		.importCompileAndRuntimeDependencies()
		.resolve("org.hibernate:hibernate-core")
		.withTransitivity().as(JavaArchive.class);
	}

	public static void addDependencyPomAsJavaArchive(Archive<?> deploy, String dependency)	{
		JavaArchive[] dependencies = Maven.resolver()
			.loadPomFromFile("pom.xml")
			.resolve(dependency)
			.withTransitivity()
			.as(JavaArchive.class)
		;
		for (JavaArchive file : dependencies)	{
			deploy.merge(file);
		}
	}

	public static void addDependencyPomAsFileInWebArchive(WebArchive deploy, String dependency)	{
		File[] dependencies = Maven.resolver()
			.loadPomFromFile("pom.xml")
			.resolve(dependency)
			.withTransitivity().asFile()
		;
		deploy.addAsLibraries(dependencies);
	}

}
