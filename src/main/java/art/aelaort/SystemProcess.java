package art.aelaort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

class SystemProcess {
	public static Response callProcess(String command) {
		try {
			Process p = Runtime.getRuntime().exec(command);
//			p.waitFor(10, TimeUnit.MINUTES);

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

			return new Response(p.exitValue(), stdout.toString(), stderr.toString());
		} catch (Exception e) {
			return new Response(1, "thrown exception in java", e.getMessage());
		}
	}
}
