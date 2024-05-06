package art.aelaort.ffprobe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Map;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Stream {
	public enum CodecType {
		video,
		audio,
		subtitle,
		data,
		attachment
	}

	@JsonProperty
	private int index;
	@JsonProperty("codec_name")
	private String codecName;
	@JsonProperty("codec_long_name")
	private String codecLongName;
	@JsonProperty
	private String profile;
	@JsonProperty("codec_type")
	private CodecType type;
	@JsonProperty("codec_time_base")
	private String codecTimeBase;
	@JsonProperty("codec_tag_string")
	private String codecTagString;
	@JsonProperty("codec_tag")
	private String codecTag;
	@JsonProperty
	private int width;
	@JsonProperty
	private int height;
	@JsonProperty("has_b_frames")
	private int hasBFrames;
	@JsonProperty("sample_aspect_ratio")
	private String sampleAspectRatio;
	@JsonProperty("display_aspect_ratio")
	private String displayAspectRatio;
	@JsonProperty("pix_fmt")
	private String pixFmt;
	@JsonProperty
	private int level;
	@JsonProperty("chroma_location")
	private String chromaLocation;
	@JsonProperty
	private int refs;
	@JsonProperty("is_avc")
	private String isAvc;
	@JsonProperty("nal_length_size")
	private String nalLengthSize;
	@JsonProperty("r_frame_rate")
	private String rFrameRate;
	@JsonProperty("avg_frame_rate")
	private String avgFrameRate;
	@JsonProperty("time_base")
	private String timeBase;
	@JsonProperty("start_pts")
	private long startPts;
	@JsonProperty("start_time")
	private double startTime;
	@JsonProperty("duration_ts")
	private long durationTs;
	@JsonProperty
	private double duration;
	@JsonProperty("bit_rate")
	private long bitRate;
	@JsonProperty("max_bit_rate")
	private long maxBitRate;
	@JsonProperty("bits_per_raw_sample")
	private int bitsPerRawSample;
	@JsonProperty("bits_per_sample")
	private int bitsPerSample;
	@JsonProperty("nb_frames")
	private long nbFrames;
	@JsonProperty("sample_fmt")
	private String sampleFmt;
	@JsonProperty("sample_rate")
	private int sampleRate;
	@JsonProperty
	private int channels;
	@JsonProperty("channel_layout")
	private String channelLayout;
	@JsonProperty
	private Disposition disposition;
	@JsonProperty
	private Map<String, String> tags;
	@JsonProperty("side_data_list")
	private SideData[] sideDataList;

	public String getLanguage() {
		return tags.get("language");
	}

	public double getRFrameRate() {
		if (rFrameRate.contains("/")) {
			String[] split = rFrameRate.split("/");
			return Double.parseDouble(split[0])/Double.parseDouble(split[1]);
		} else {
			return Double.parseDouble(rFrameRate);
		}
	}

	@Getter
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class SideData {
		@JsonProperty("side_data_type")
		private String sideDataType;
		@JsonProperty
		private String displaymatrix;
		@JsonProperty
		private int rotation;
	}
}
