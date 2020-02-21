import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class FilmRentByRatingReducer extends Reducer<Text, Text, Text, IntWritable>{
	@Override
	protected void reduce(Text rating, Iterable<Text> filmList, Reducer<Text, Text, Text, IntWritable>.Context context) 
			throws IOException, InterruptedException {
		long filmCounter = 0;
		for (Iterator<Text> iterator = filmList.iterator(); iterator.hasNext();) {
			iterator.next();
			++filmCounter;
		}
		context.write(rating, new IntWritable((int)filmCounter));
	}
}