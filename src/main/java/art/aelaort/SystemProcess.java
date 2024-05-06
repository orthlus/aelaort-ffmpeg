package art.aelaort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

class SystemProcess {
	public static Process callProcess(List<String> command) {
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

	private static Response response(String stdout, String stderr) {
		return new Response(stdout, stderr);
	}

	private static Response response(Process process, String stdout, String stderr) {
		try {
			int exitValue = process.exitValue();
			return new Response(exitValue, stdout, stderr);
		} catch (IllegalThreadStateException e) {
			return new Response(stdout, stderr);
		}
	}
}
