package de.hsos.prog3.dokranke.ab03;

import java.util.Random;
import java.util.stream.IntStream;

public class Flugschreiber {

	private static void printRingpuffer(Ringpuffer ringpuffer) {
		if (!ringpuffer.isEmpty()) {
			ringpuffer.forEach(System.out::println);
		} else {
			System.out.println("LEER");
		}
	}

	public static void main(String[] args) {
		System.out.println("Flugschreiber (Cap 5, fixed, discarding)");
		Ringpuffer<String> flugschreiber = new Ringpuffer<>(5, true, true);
		Random random = new Random();

		System.out.println("Leer: ");
		printRingpuffer(flugschreiber);
		System.out.println();

		IntStream.rangeClosed(1, 5).forEach(i -> {
			String eintrag = String.format("%s. Geschwindigkeit: %s kmh, Höhe: %s m, Lat: %s, Long: %s", i,
					150 + random.nextInt(150),
					random.nextInt(3000),
					random.nextFloat(), random.nextFloat());
			flugschreiber.add(eintrag);
		});

		System.out.println("5 Elemente: ");
		printRingpuffer(flugschreiber);
		System.out.println();

		IntStream.rangeClosed(6, 9).forEach(i -> {
			String eintrag = String.format("%s. Geschwindigkeit: %s kmh, Höhe: %s m, Lat: %s, Long: %s", i,
					150 + random.nextInt(150),
					random.nextInt(3000),
					random.nextFloat(), random.nextFloat());
			flugschreiber.add(eintrag);
		});

		System.out.println("9 Elemente: ");
		printRingpuffer(flugschreiber);
		System.out.println();
	}
}

// Domenik Kranke <domenik@kranke.de>