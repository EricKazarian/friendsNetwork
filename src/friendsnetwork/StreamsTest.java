package friendsnetwork;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;



record Bestand(String naam, String inhoud) {}
record Directory(String naam, List<Bestand> bestanden) {}
class StreamsTest{
		@Test
		void test() {
			List<Directory> directories = List.of(
						new Directory("Documenten", List.of(
							new Bestand("cursus_ogp.text", "cursus ogp bro"), 
							new Bestand("cursustxt_mi.txt", "cursus ml bro"), 
							new Bestand("bithass", "cursus ml bro")
						)),
						new Directory("Programma's", List.of( 
								new Bestand("eclipse", "machinecode for eclipse"), 
								new Bestand("java.exe", "machaine code van JVM")
								))
						);
					assertEquals(2.5, directories.stream().collect(Collectors.averagingDouble(d -> d.bestanden().size())));
					assertEquals("Documenten, Programma's", directories.stream().map(d -> d.naam()).collect(Collectors.joining(", ")));
					assertEquals(Optional.of(directories.get(0)), directories.stream().collect(Collectors.maxBy((d1, d2)-> d1.bestanden().size() - d2.bestanden().size())));
					assertEquals(Set.copyOf(directories), directories.stream().collect(Collectors.toSet()));
					assertEquals(Map.of("Documenten", directories.get(0),"Programma's", directories.get(1)), directories.stream().collect(Collectors.toMap(d -> d.naam(), d -> d)));
					assertEquals(List.of(directories.get(0)), directories.stream().filter(d -> d.naam().startsWith("D")).collect(Collectors.toList()));
					assertEquals(List.of(directories.get(0).bestanden()), directories.stream().flatMap(d -> 
							d.naam().startsWith("D") ? d.bestanden().stream() : Stream.<Bestand>empty())
							.collect(Collectors.toList()));
//					assertEquals(List.of(directories.get(0), directories.get(0), directories.get(1), directories.get(1)), directories.stream().flatMap(d->
//					Stream.of(null)


					

					
					


		}

}
