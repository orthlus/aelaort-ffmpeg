package art.aelaort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class SystemCalls {
	public static Process callPrintableDebug(List<String> command) {
		try {
			Process p = new ProcessBuilder(command)
					.inheritIO()
					.start();

			try (BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
				String line;
				while ((line = b.readLine()) != null) {
					System.out.println("STDOUT: " + line);
				}
			}

			try (BufferedReader b = new BufferedReader(new InputStreamReader(p.getErrorStream()))) {
				String line;
				while ((line = b.readLine()) != null) {
					System.out.println("STDERR: " + line);
				}
			}

			return p;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static Process callPrintable(List<String> command) {
		try {
			Process p = new ProcessBuilder(command)
					.inheritIO()
					.start();

			/*try (BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
				String line;
				while ((line = b.readLine()) != null) {
					System.out.println(line);
				}
			}

			try (BufferedReader b = new BufferedReader(new InputStreamReader(p.getErrorStream()))) {
				String line;
				while ((line = b.readLine()) != null) {
					System.err.println(line);
				}
			}*/

			return p;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
