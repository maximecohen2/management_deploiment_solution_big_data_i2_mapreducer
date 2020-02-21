import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class FilmRentByRatingReducer extends Reducer<Text, Text, Text, IntWritable>{
	@Override
	protected void reduce(Text movie, Iterable<Text> ratingList, Reducer<Text, Text, Text, IntWritable>.Context context) 
			throws IOException, InterruptedException {
		long ageSum = 0;
		long movieNum = 0;
		for (Text rating : ratingList) {
			ageSum += age.get();
			movieNum++;
		}
		context.write(movie, new IntWritable((int)(ageSum/movieNum)));
	}
}