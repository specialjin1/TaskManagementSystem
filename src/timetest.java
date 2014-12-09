
public class timetest {
	public static void main(String[] args)
	{
		long now_time = System.currentTimeMillis()/1000;
		long year = 1970+now_time/(365*86400);
		long month = month_get(year,(now_time%(365*86400))/86400);
		long day = day_get(year,month-1,((now_time)%(365*86400))/86400);
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
	}
	public static int month_get(long year,long month_days)
	{
		int count=0;
		while(month_days>=0)
		{
			if(count%2==1) month_days-=31;
			else if(count==2) {
				if( (year%4==0 && year%100 != 0) || year%400==0 )
					month_days -= 29;
				else month_days -= 28;
			}
			else if(count%2==0) month_days-=30;
			count++;
		}
		return count;
	}
	public static long day_get(long year,long month,long days)
	{
		while(month>=1)
		{
			if(month%2==1) days-=31;
			else if(month==2) {
				if( (year%4==0 && year%100 != 0) || year%400==0 )
					days -= 29;
				else days -= 28;
			}
			else if(month%2==0) days-=30;
			month--;
		}
		return days;
	}
}
