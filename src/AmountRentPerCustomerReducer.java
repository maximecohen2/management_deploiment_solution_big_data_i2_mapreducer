import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AmountRentPerCustomerReducer extends Reducer<Text, FloatWritable, Text, FloatWritable> {
    @Override
    protected void reduce(Text email, Iterable<FloatWritable> amountList, Reducer<Text, FloatWritable, Text, FloatWritable>.Context context)
        throws IOException, InterruptedException
    {
        float amountSum = 0;

        for(FloatWritable amount : amountList) {
        	amountSum += amount.get();
        }
        context.write(email, new FloatWritable((float)(amountSum)));
    }
}