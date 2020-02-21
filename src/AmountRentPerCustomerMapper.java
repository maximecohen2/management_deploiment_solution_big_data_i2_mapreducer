import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class AmountRentPerCustomerMapper extends Mapper<LongWritable, Text, Text, FloatWritable> {
	@Override
	protected void map(LongWritable linenumber, Text line, Mapper<LongWritable, Text, Text, FloatWritable>.Context context) 
			throws IOException, InterruptedException {
		String[] fields = line.toString().split(";");
		String email = fields[5].replaceAll("\"", "").toString();
		try {
			// int age = Integer.parseInt(fields[1]);
			// context.write(new Text(names[0]), new IntWritable(age));
			float amount = Float.parseFloat(fields[2]);
			context.write(new Text(email), new FloatWritable(amount));
		} catch (NumberFormatException e) {
			context.getCounter("Error", e.getMessage()).increment(1);
		}
		
	}
}
