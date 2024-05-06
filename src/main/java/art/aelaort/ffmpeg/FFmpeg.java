package art.aelaort.ffmpeg;

import art.aelaort.FFmpegPaths;
import art.aelaort.SystemCalls;
import lombok.Builder;
import lombok.Singular;

import java.util.ArrayList;
import java.util.List;

@Builder
public class FFmpeg {
	@Singular
	private final List<String> inputs;
	@Singular
	private final List<String> outputs;
	@Singular
	private final List<String> args;
	private boolean printOnlyError;

	private List<String> commandList() {
		List<String> finalArgs = new ArrayList<>(args.size() + 10);
		finalArgs.add(FFmpegPaths.FFMPEG_PATH);

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
