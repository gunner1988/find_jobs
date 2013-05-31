package jp.co.wap.exam;
import java.util.List;
import jp.co.wap.exam.lib.Interval;
import java.util.Arrays;
import java.util.Comparator;
public class Problem2 {
	private class BeginTimeComparator implements Comparator {
		public int compare(Object sr, Object dt) {
		    return ((Interval)sr).getBeginMinuteUnit()-((Interval)dt).getBeginMinuteUnit();
		  }
	}
	public int binarySearchFirstNotOverlap(int time,int[] beginTime,int start,int end){
		int mid=0;
		while(start<end){
			mid=(start+end)/2;
			if(time>=beginTime[mid])
				start=mid+1;
			else{
				end=mid-1;
			}
			
		}
		if(end<start)
			return end+1;
		else if(beginTime[end]>time)
			return end;
		else
			return end+1;
		//return 0;
	}
	public int getMaxWorkingTime(List<Interval> intervals){
		if(intervals==null)
			return 0;
		if(intervals.size()==0)
			return 0;
		Interval[] theIntervals=(Interval[])intervals.toArray();
		Arrays.sort(theIntervals,new BeginTimeComparator());
		int len=intervals.size();
		int[] beginTimeAscendOrder=new int[len];
		for(int i=0;i<len;i++){
			beginTimeAscendOrder[i]=theIntervals[i].getBeginMinuteUnit();
		}
		
		int[] maxWorkingTime=new int[len];
		maxWorkingTime[len-1]=theIntervals[len-1].getIntervalMinute();
		
		for(int i=len-2;i>=0;i--){
			//include theIntervals[i],then calculate maxWorkingTime[i];
			
			//use binary search find the first interval after theIntervals[i](theInterval[i+1,....len]) that has no overlap with it.
			int index=binarySearchFirstNotOverlap(theIntervals[i].getEndMinuteUnit(),beginTimeAscendOrder,i+1,len-1);
			int maxTimeHasI=0;
			if(index>len-1)
				maxTimeHasI=theIntervals[i].getIntervalMinute();
			else
			    maxTimeHasI=theIntervals[i].getIntervalMinute()+maxWorkingTime[index];
			int maxTimeNoI=maxWorkingTime[i+1];
			
			if(maxTimeNoI>maxTimeHasI)
				maxWorkingTime[i]=maxTimeNoI;
			else
				maxWorkingTime[i]=maxTimeHasI;
			
		}
		return maxWorkingTime[0];
	}
	public static void main(String[] args){
		Problem2 p=new Problem2();
		List<Interval> figure1=Arrays.asList(new Interval("09:30","12:30"),new Interval("12:30","15:31"));
		List<Interval> figure2=Arrays.asList(new Interval("08:00","10:30"),new Interval("09:00","12:30"),new Interval("12:30","12:40"),new Interval("12:00","14:30"),
				new Interval("10:00","12:30"),new Interval("11:00","12:30"));
		List<Interval> figure3=Arrays.asList(new Interval("06:00","08:30"),new Interval("09:00","11:30"),new Interval("12:30","14:00"));
		System.out.println(p.getMaxWorkingTime(figure1));
		System.out.println(p.getMaxWorkingTime(figure2));
		System.out.println(p.getMaxWorkingTime(figure3));
	}
}
