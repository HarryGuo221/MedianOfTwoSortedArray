
public class MedianOfTwoSortedArrays {
	
	public static double findMedianSortedArrays(int A[], int B[]) {	
	int total = A.length + B.length;
	int m = A.length;
	int n = B.length;
	if(total%2 != 0){
	    return find(A,m, B, n, total/2+1);
	}
	else 
	    return (find(A, m, B, n, total/2) + find(A, m, B, n, total/2 +1))/2;
	}
	
	public static double find(int A[],int m,int B[],int n,int r)
    {
        if(m>n)
        	return find(B, n, A, m, r);
        if(m==0)
        	return B[r-1];
        if(r==1)
        	return Math.min(A[0],B[0]);
        /*
         * Divide
         */
        int temp=r/2;			
        if(Math.min(m,n)<temp)  //make sure temp is not out of any of those arrays' bounds
        	temp=Math.min(m,n);
        /*
         * Conquer
         */
        /*
         * delete the small one before A[temp](A[temp]-1)
         */
        if(A[temp-1]>=B[temp-1]){
        	int[] p_B = new int[B.length-temp];
        	for(int i = temp, j = 0; i<B.length && j<B.length-temp; i++, j++){
        			p_B[j] = B[i];
        	}
        	return find(A,m,p_B,n-temp,r-temp);
        }
        else {
        	int[] p_A = new int[A.length-temp];
        	for(int i = temp, j = 0 ; i<A.length && j<A.length-temp; i++, j++){
        			p_A[j] = A[i];
        	}
        	return find(p_A,m-temp,B,n,r-temp);
        }
    }
	
	public static void main(String[] argStrings){
		int[] a1 = {1,1,3,3};
		int[] b1 = {1,1,3,3};
		double median = findMedianSortedArrays(a1, b1);
		System.out.print(median);
	}
}
