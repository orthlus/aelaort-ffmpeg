package art.aelaort;

import net.bramp.ffmpeg.builder.FFmpegBuilder;
import net.bramp.ffmpeg.job.FFmpegJob;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import net.bramp.ffmpeg.progress.ProgressListener;

import java.io.IOException;

// TODO some impl of ProgressListener
public class FFmpegRunUtils {
	public static FFmpegJob run(FFmpegBuilder builder) {
		return FFmpegFactory.ffmpegExecutor().createJob(builder);
	}

	public static FFmpegJob run(FFmpegBuilder builder, ProgressListener listener) {
		return FFmpegFactory.ffmpegExecutor().createJob(builder, listener);
	}

	public static FFmpegProbeResult probe(String mediaPath) {
		try {
			return FFmpegFactory.ffprobe().probe(mediaPath);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
