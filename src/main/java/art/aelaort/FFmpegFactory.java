package art.aelaort;

import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;

import java.io.IOException;

public class FFmpegFactory {
	public static FFprobe ffprobe() {
		try {
			return new FFprobe(FFmpegPaths.FFPROBE_PATH);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static FFmpegProbeResult probe(String mediaPath) {
		try {
			return ffprobe().probe(mediaPath);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
