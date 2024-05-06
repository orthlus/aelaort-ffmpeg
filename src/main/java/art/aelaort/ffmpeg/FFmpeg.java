package art.aelaort.ffmpeg;

import lombok.Builder;
import lombok.Singular;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static art.aelaort.FFmpegFactory.ffmpegPath;

@Builder
public class FFmpeg {
	@Singular
	private final List<String> inputs;
	@Singular
	private final List<String> outputs;
	@Singular
	private final List<String> args;
	private boolean printOnlyError;

	private String quotes(String s) {
		return "\"" + s + "\"";
	}

	public Process run() {
		List<String> finalArgs = new ArrayList<>(args.size() + 10);
		finalArgs.add(ffmpegPath());

		if (printOnlyError) {
			finalArgs.add("-v");
			finalArgs.add("error");
		}

		for (String input : inputs) {
			finalArgs.add("-i");
			finalArgs.add(quotes(input));
		}

		finalArgs.addAll(args);

		for (String output : outputs) {
			finalArgs.add(quotes(output));
		}

		return call(finalArgs);
	}

	private Process call(List<String> command) {
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
}
