package de.hsos.prog3.dokranke.ab03;

import java.util.stream.IntStream;

public class Beispiele {

	private static void printRingpuffer(Ringpuffer ringpuffer) {
		if (!ringpuffer.isEmpty()) {
			ringpuffer.forEach(System.out::println);
		} else {
			System.out.println("LEER");
		}
	}

	public static void main(String[] args) {
		System.out.println("FIFO: Durchlauflager (Cap 5, fixed)");
		Ringpuffer<String> durchlauflager = new Ringpuffer<>(5, true, false);

		IntStream.rangeClosed(1, 5).forEach(i -> durchlauflager.add("Artikel" + i));
		printRingpuffer(durchlauflager);

		try {
			durchlauflager.add("Artikel 6");
		} catch (IllegalStateException e) {
			System.err.println("Fehler beim Lagern: Das Lager ist voll!");
		}
		System.out.println();

		System.out.println("LIFO: Dokumentenstapel (Cap 5, dynamic)");
		Ringpuffer<String> dokumentenstapel = new Ringpuffer<>(5, false, false);

		IntStream.rangeClosed(1, 10).forEach(i -> dokumentenstapel.add("Dokument " + i));
		printRingpuffer(dokumentenstapel);
	}
}

// Domenik Kranke <domenik@kranke.de>