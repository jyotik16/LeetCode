package com;

import java.util.*;

public class BinarySearch {

    public static void main(String[] args) {
        int [] ar = {2,3,3,3,4,4,4,4,4,6,8,9};
        int n = ar.length;
        int target = 3;
       //   findUniqueElement();
       //   findtargetElementIndexLogN();
       //   findFirstIndexOfElement(ar,target);
       //   findLastIndexOfElement(ar,target);
       // findMaximumLengthOfSubarrayWhoseSumEqualtoTarget();
        int A[] = {1,2,2,1}; int []B ={2,2};
       // intersection(A,B);
       // findKRotation();
       // searchInRotatedArray();
    }

    private static void searchInRotatedArray() {
        int [] ar = {7,6,1,2,3,4,5}; int target = 4;
        int pivot = findPivot(ar);
        int idx = binarysearch(ar,0,pivot-1,target);
        if (idx != -1) System.out.println("target found at:"+idx);

        idx = binarysearch(ar,pivot,ar.length-1,target);
        System.out.println("target found at:"+idx);
    }
    private static int binarysearch(int[] ar,int l,int r,int target){

        while(l<=r){
            int mid = (l+r)/2;
            if (ar[mid] == target){
               return mid;
            }else if (ar[mid] < target){
                l = mid + 1;
            } else if (ar[mid] > target) {
              r = mid - 1;
            }
        }
        return -1;
    }
    private static int findPivot(int[] ar) {
        int l = 0; int r = ar.length-1;
        while(l<r){
            int mid = l+(r-l)/2;
            if (ar[mid]>ar[r]){
                l = mid+1;
            }else{
                r=mid;
            }
        }
        System.out.println("pivot index:"+r);
        return r;
    }

    private static void findKRotation() {
        int [] ar = {7,6,1,2,3,4,5};
        int l = 0; int r = ar.length-1;
        while(l<r){
            int mid = l+(r-l)/2;
            if (ar[mid]<ar[r]){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        System.out.println("rotation count:"+r);
    }


    //349
    static public int[] intersection(int[] A, int[] B) {
        Arrays.sort(A); Arrays.sort(B);
        //two pointer
        List<Integer> ans = new ArrayList<>();
        int i=0; int j=0;
        while(i<A.length && j<B.length){
        if(A[i]<B[j]){
            i++;
        }else if (A[i]>B[j]){
            j++;
        }else if(A[i] == B[j]){
            if (i==0 || j==0)
                ans.add(A[i]);
            if (i>0 && A[i]!=A[i-1])
                ans.add(A[i]);
           i++; j++;
        }
        }
       // Integer [] res = ans.toArray(new Integer[0]);
       System.out.println(ans);
        HashSet<Integer> set = new HashSet<>();
        for (int a=0;a<ans.size();a++){
            set.add(ans.get(a));
        }
        System.out.println(set);
        int[] res = new int[set.size()]; int k=0;
        for (Integer ele:set){
            res[k++] = ele;
        }
        return res;
    }

    private static void findMaximumLengthOfSubarrayWhoseSumEqualtoTarget() {
        int [] ar = {5,11,17,100};
        int n = ar.length;
        int target = 130;
        int[] prefixSums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSums[i] = prefixSums[i - 1] + ar[i - 1];
        }
        for (int i=0;i<prefixSums.length;i++){
            System.out.print(prefixSums[i]+" ");
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int end = binarySearch(i, n - 1, prefixSums, target);
            max = Math.max(max, end - i + 1);
        }
        System.out.println("maximum length :"+max);
    }

    private static int binarySearch(int start, int end, int[] prefixSums, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int sum = prefixSums[mid + 1] - prefixSums[start];
            if (sum <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }
    //sliding window
    public static int maximumValueOfK(int[] A, int B) {
        int n = A.length;
        int max = 0;
        int sum = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            sum += A[end];
            while (sum > B) {
                sum -= A[start];
                start++;
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }


    private static void findFirstIndexOfElement(int[] ar,int target) {
        int lo = 0; int hi = ar.length-1;
        while(lo<=hi){
            int mid = (hi+lo)/2;
            if (ar[mid] == target){
                hi = mid - 1;
            }else if (ar[mid] < target){
                lo = mid + 1;
            } else if (ar[mid] > target) {
                hi = mid - 1;
            }
        }
        System.out.println("first index:"+(hi+1));
    }

    private static void findLastIndexOfElement(int[] ar,int target) {
        int lo = 0; int hi = ar.length-1;
        while(lo<=hi){
            int mid = (hi+lo)/2;
            if (ar[mid] == target){
                lo = mid + 1;
            }else if (ar[mid] < target){
                lo = mid + 1;
            } else if (ar[mid] > target) {
                hi = mid - 1;
            }
        }
        System.out.println("first index:"+(hi));
    }

    static int findtargetElementIndex(int[] arr, int n, int K) {
        //O(n)
        for(int i = 0; i < n; i++)
            if (arr[i] == K)
                return i;

            else if (arr[i] > K)
                return i;
        return n;
    }
    //Leetcode 35
    private static void findtargetElementIndexLogN() {
        int [] ar = {2,3,4,6,8,9};
        int n = ar.length;
        int target = 6;
        int lo = 0; int hi = n-1; int ans=0;
        while(lo<=hi){
            int mid = (hi+lo)/2;
            if (ar[mid] == target){
                System.out.println("found:"+mid); break;
            }else if (ar[mid] < target){
                lo = mid + 1;
            } else if (ar[mid] > target) {
                hi = mid - 1;
            }
        }
        System.out.println("inserted position :"+(hi+1));
    }

    private static void findUniqueElement() {
        int [] ar = {2,2,3,3,4,4,5,5,6};
        int n = ar.length;
        int res = binarysearch(ar);
        System.out.println("unique element is: "+res);
    }
    private static int binarysearch(int [] arr){
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = (start + end) / 2;

            if (start == end) {
                return arr[start];

                //If mid is odd
            } else if (mid % 2 != 0) {

                /*
                  If value present at mid and mid-1
                  is equal then search at right half of the
                  array else left half of the array.
                */
                if (arr[mid - 1] == arr[mid]) {
                    start = mid + 1;

                } else {
                    end = mid - 1;
                }

            } else {

                //If mid is even
                if (arr[mid] == arr[mid + 1]) {
                    start = mid + 2;

                } else {
                    end = mid;
                }
            }
        }

        return -1;
    }
    //leetcode 2089
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int start = findFirstIndex(nums,target);
        int end = findLastIndex(nums,target);
        if (start == end){
            ans.add(start);
            return ans;
        }
        if (start > end){
            return ans;
        }
        for (int i=start;i<end;i++){
            ans.add(i);
        }
        return ans;
    }
    private static int findFirstIndex(int[] ar,int target) {
        int lo = 0; int hi = ar.length-1;
        while(lo<=hi){
            int mid = (hi+lo)/2;
            if (ar[mid] == target){
                hi = mid - 1;
            }else if (ar[mid] < target){
                lo = mid + 1;
            } else if (ar[mid] > target) {
                hi = mid - 1;
            }
        }
        System.out.println("first index:"+(hi+1));
        return hi+1;
    }
    private static int findLastIndex(int[] ar,int target) {
        int lo = 0; int hi = ar.length-1;
        while(lo<=hi){
            int mid = (hi+lo)/2;
            if (ar[mid] == target){
                lo = mid + 1;
            }else if (ar[mid] < target){
                lo = mid + 1;
            } else if (ar[mid] > target) {
                hi = mid - 1;
            }
        }
        System.out.println("last index:"+(hi));
        return hi;
    }
    //Leetcode 704
    public int search(int[] nums, int target) {
    int st = 0; int ed = nums.length-1;
    while(st<=ed){
        int mid = (st+ed)/2;
        if(nums[mid] == target){
            return mid;
        }else if(nums[mid]<target){
            st = mid+1;
        }else{
            ed = mid-1;
        }
        }
       return -1;
    }
}
