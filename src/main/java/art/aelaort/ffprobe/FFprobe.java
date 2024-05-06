package art.aelaort.ffprobe;

import art.aelaort.FFmpegPaths;
import art.aelaort.SystemCalls;
import art.aelaort.ffprobe.models.FFprobeResult;

import java.util.List;

public class FFprobe {
	public static FFprobeResult probe(String mediaPath) {
		List<String> command = List.of(
				FFmpegPaths.FFPROBE_PATH,
				"-v", "quiet",
				"-print_format", "json",
				"-show_error",
				"-show_format",
				"-show_streams",
				"-show_chapters",
				mediaPath
		);
		Process process = SystemCalls.callPrintableDebug(command);
		try {
			process.waitFor();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
}
