import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class LocationAmountByEmailReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    @Override
    protected void reduce(Text email, Iterable<IntWritable> locationAmountList, Reducer<Text, IntWritable, Text, IntWritable>.Context context)
        throws IOException, InterruptedException
    {
        long locationAmountSum = 0;

        for(IntWritable locationAmount : locationAmountList) {
            locationAmountSum += locationAmount.get();
        }
        context.write(email, new IntWritable((int)(locationAmountSum)));
    }
}