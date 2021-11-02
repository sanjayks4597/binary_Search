
public class BinarySearch1 {
	
	public static int binary_searchI(int arr[],int target) {
		int low=0,high=arr.length-1,mid;
		while(low<=high)
		{
			mid=(low+high)/2;
			if(arr[mid]==target)
			{
				return mid;
			}
			if(arr[mid]>target)
			{
				high=mid-1;
			}
			else
				low=mid+1;
		}
		return -1;
	}

	public static int bSearchR(int arr[],int low,int high,int target) {
		if(low>high)
			return -1;
		int mid=(low+high)/2;
		if(arr[mid]==target)
			return mid;
		else if(arr[mid]>target)
			return bSearchR(arr,low,mid-1,target);
		else {
			return bSearchR(arr,mid+1,high,target);
		}
	}
	
	public static int firstOccuranceR(int arr[],int low,int high,int target)
	{
		if(low>high)
			return -1;
			
		int mid=(low+high)/2;
		if(arr[mid]>target)
		{
			return firstOccuranceR(arr, low, mid-1, target);
		}
		else if(arr[mid]<target)
			return firstOccuranceR(arr, mid+1, high, target);
		
		else 
		{
			if(arr[mid]==0 || arr[mid-1] != arr[mid]) {
				return mid;
			}
			else {
				return firstOccuranceR(arr, low, mid-1, target);
			}
		}
		
	}
	
	public static int firstOccuranceI(int arr[],int target) {
		
		int low=0,high=arr.length,mid;
		while(low<high)
		{
			mid=(low+high)/2;
			if(arr[mid]>target)
			{
				high=mid-1;
			}
			else if(arr[mid]<target)
			{
				low=mid+1;
			}
			else
			{
				if(mid==0 || arr[mid-1]!=arr[mid])
				{
					return mid;
				}
				else
					high=mid-1;
			}
		}
		return -1;
	}
	
	public static int lastOccuranceR(int arr[],int low,int high,int target)
	{
		if(low>high)
			return -1;
		int mid=(low+high)/2;
		if(arr[mid]>target)
		{
			return lastOccuranceR(arr, low, mid-1, target);
		}
		else if(arr[mid]<target) {
			return lastOccuranceR(arr, mid+1, high, target);
		}
		else
		{
			if(mid == 0 || arr[mid] != arr[mid+1])
			{
				return mid;
			}
			else
			{
				return lastOccuranceR(arr, mid+1, high, target);
			}
		}
		
	}
	
	public static int lastOccuranceI(int arr[],int target) {
		int low=0,high=arr.length-1,mid;
		int n=arr.length;
		while(low<=high)
		{
			mid=(low+high)/2;
			if(arr[mid]>target)
			{
				high=mid-1;
			}
			else if(arr[mid]<target)
			{
				low=mid+1;
			}
			else
			{
				if(mid==n-1 || arr[mid]!=arr[mid+1])
				{
					return mid;
				}
				else
					low=mid+1;
			}
		}
		return -1;
	}
	
	public static int countOccuranceI(int arr[],int target) {
		int firstOcc=firstOccuranceI(arr, target);
		int lastOcc=lastOccuranceI(arr, target);
		if(firstOcc==-1)
		{
			return 0;
		}
		else 
		{
			return (lastOcc-firstOcc+1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]= {2,4,4,4,4,5,6,7,9,9,9,9,11,14,23,45};
		int target=9;
		int low=0,high=arr.length;
		System.out.println(countOccuranceI(arr,target));

	}

}
