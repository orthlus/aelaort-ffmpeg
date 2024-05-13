package art.aelaort.ffmpeg;

import art.aelaort.FFmpegPaths;
import art.aelaort.SystemCalls;
import lombok.Builder;
import lombok.Singular;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Builder
public class FFmpeg {
	private final List<String> args;
	@Singular
	private final List<String> inputs;
	@Singular
	private final List<String> outputs;
	private boolean printOnlyError;
	private String inputDuration;
	private String outputDuration;
	@Singular
	private final List<String> preInputArgs;

	public static class FFmpegBuilder {
		public FFmpegBuilder map(String arg) {
			return args("-map", arg);
		}

		public FFmpegBuilder args(String... args) {
			if (this.args == null) {
				this.args = new ArrayList<>();
			}

			this.args.addAll(Arrays.asList(args));

			return this;
		}
	}

	private List<String> commandList() {
		List<String> finalArgs = new ArrayList<>(args.size() + 10);
		finalArgs.add(FFmpegPaths.FFMPEG_PATH);

		if (printOnlyError) {
			finalArgs.add("-v");
			finalArgs.add("error");
		}

		finalArgs.addAll(preInputArgs);

		if (inputDuration != null) {
			finalArgs.add("-t");
			finalArgs.add(inputDuration);
		}

		for (String input : inputs) {
			finalArgs.add("-i");
			finalArgs.add(quotes(input));
		}

		finalArgs.addAll(args);

		if (outputDuration != null) {
			finalArgs.add("-t");
			finalArgs.add(outputDuration);
		}

		for (String output : outputs) {
			finalArgs.add(quotes(output));
		}

		return finalArgs;
	}

	public String command() {
		return String.join(" ", commandList());
	}

	public Process run() {
		return SystemCalls.callPrintable(commandList());
	}

	private String quotes(String s) {
		return "\"" + s + "\"";
	}
}
