package art.aelaort.ffprobe;

import java.util.Map;

public class Format {
  public String filename;
  public int nb_streams;
  public int nb_programs;

  public String format_name;
  public String format_long_name;
  public double start_time;

  /** Duration in seconds */
  // TODO Change this to java.time.Duration
  public double duration;

  /** File size in bytes */
  public long size;

  /** Bitrate */
  public long bit_rate;

  public int probe_score;

  public Map<String, String> tags;
}
