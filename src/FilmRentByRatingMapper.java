import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class FilmRentByRatingMapper extends Mapper<LongWritable, Text, Text, Text> {
	@Override
	protected void map(LongWritable linenumber, Text line, Mapper<LongWritable, Text, Text, Text>.Context context) 
			throws IOException, InterruptedException {
		String[] fields = line.toString().split(";");
		String movie = fields[17];
		String rating = fields[24];
		try {
			context.write(new Text(rating), new Text(movie));
		} catch (NumberFormatException e) {
			context.getCounter("Error", e.getMessage()).increment(1);
		}
		
	}

}
