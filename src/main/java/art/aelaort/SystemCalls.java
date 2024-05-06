package art.aelaort;

import org.jooq.lambda.tuple.Tuple2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
					System.err.println("STDERR: " + line);
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

			try (BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
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
			}

			return p;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static Tuple2<String, String> callTuple(List<String> command) {
		try {
			Process p = new ProcessBuilder(command)
					.inheritIO()
					.start();
			p.waitFor(2, TimeUnit.MINUTES);

			StringBuilder stdout = new StringBuilder();
			try (BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
				String line;
				while ((line = b.readLine()) != null) {
					stdout.append(line);
				}
			}

			StringBuilder stderr = new StringBuilder();
			try (BufferedReader b = new BufferedReader(new InputStreamReader(p.getErrorStream()))) {
				String line;
				while ((line = b.readLine()) != null) {
					stderr.append(line);
				}
			}

			return new Tuple2<>(stdout.toString(), stderr.toString());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
