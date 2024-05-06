package art.aelaort;

import org.bytedeco.ffmpeg.ffmpeg;
import org.bytedeco.ffmpeg.ffprobe;
import org.bytedeco.javacpp.Loader;

public class FFmpegPaths {
	public final static String FFMPEG_PATH = Loader.load(ffmpeg.class);
	public final static String FFPROBE_PATH = Loader.load(ffprobe.class);
}
