import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class AgeAvgByFirstNameReducer extends Reducer<Text, IntWritable, Text, IntWritable>{
	@Override
	protected void reduce(Text firstName, Iterable<IntWritable> ageList, Reducer<Text, IntWritable, Text, IntWritable>.Context context) 
			throws IOException, InterruptedException {
		long ageSum = 0;
		long ageNum = 0;
		for (IntWritable age : ageList) {
			ageSum += age.get();
			ageNum ++;
		}
		context.write(firstName, new IntWritable((int)(ageSum/ageNum)));
	}

}
