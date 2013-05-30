package jp.co.wap.exam;
import java.util.Arrays;
import java.util.List;
import jp.co.wap.exam.lib.Interval;
public class Problem1 {
	
	/*public int getMaxIntervalOverlapCount(List<Interval> intervals){
		//1441个元素的数组法
		int[] minuteCounter=new int[1441];
		for(int i=0;i<1441;i++)
			minuteCounter[i]=0;
		for(int i=0;i<intervals.size();i++)
		{
			Interval temp=intervals.get(i);
			for(int j=temp.getBeginMinuteUnit();j<=temp.getEndMinuteUnit();j++)
			{
			    minuteCounter[j]++;
			}
		}
		int maxCount=-1;
		for(int i=0;i<1441;i++){
			if(minuteCounter[i]>maxCount)
				maxCount=minuteCounter[i];
		}
		if(maxCount==1) return 0;
		return maxCount;
	}*/
	public int getMaxIntervalOverlapCount(List<Interval> intervals){
		if(intervals.size()==0||intervals==null){
			return 0;
		}
		int[] beginTimeMinuteUnitCount =new int[1441];
		//beginTimeMinuteUnitCount[i] indicates the number of intervals ,their begin time is  i .
		int[] endTimeMinuteUnitCount =new int[1441];
		//endTimeMinuteUnitCount[i] indicates the number of intervals ,their end time is i;
		for(int i=0; i<1441;i++){
			beginTimeMinuteUnitCount[i]=0;
			endTimeMinuteUnitCount[i]=0;
		}
		for(int i=0; i<intervals.size();i++)
		{
		     Interval temp=intervals.get(i);
		     beginTimeMinuteUnitCount[temp.getBeginMinuteUnit()]+=1;
		     endTimeMinuteUnitCount[temp.getEndMinuteUnit()]+=1;
		}
		int currentOverlapCount=0;
		int maxOverlapCount=0;
		for(int i=0; i<1441;i++)
		{
			    if(beginTimeMinuteUnitCount[i]>0){
			    	currentOverlapCount+=beginTimeMinuteUnitCount[i];
					if(currentOverlapCount>maxOverlapCount)
						maxOverlapCount=currentOverlapCount;
			    }
				
				currentOverlapCount-=endTimeMinuteUnitCount[i];
		}
		return maxOverlapCount;
		
		
	}
	public static void main(String args[]){
		Problem1 p=new Problem1();
		Interval interval1=new Interval("24:00","24:00");
		Interval interval2=new Interval("12:01","13:00");
		Interval interval3=new Interval("13:00","15:00");
		List<Interval> figure1=Arrays.asList(interval1,interval2,interval3);
		System.out.println(p.getMaxIntervalOverlapCount(figure1));
		List<Interval> figure2=Arrays.asList(new Interval("08:00","10:30"),new Interval("09:00","12:30"),new Interval("12:30","12:40"),new Interval("12:00","14:30"),
				new Interval("10:00","12:30"),new Interval("11:00","12:30"));
		System.out.println(p.getMaxIntervalOverlapCount(figure2));
	}

}
