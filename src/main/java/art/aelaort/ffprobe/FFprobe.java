package art.aelaort.ffprobe;

import art.aelaort.FFmpegPaths;
import art.aelaort.SystemResponse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class FFprobe {
	public static SystemResponse probe(String mediaPath) {
		List<String> command = List.of(
				FFmpegPaths.FFPROBE_PATH,
				"-v", "quiet",
				"-output_format", "json",
				"-show_error",
				"-show_format",
				"-show_streams",
				"-show_chapters",
				mediaPath
		);
		return call(command);
	}

	private static SystemResponse call(List<String> command) {
		try {
			Process p = new ProcessBuilder(command).start();

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

			p.waitFor();

			return new SystemResponse(stdout.toString(), stderr.toString());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
