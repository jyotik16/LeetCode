package com;

import java.awt.font.FontRenderContext;
import java.util.*;
import java.util.stream.Collectors;

public class ArraysQ {
    public static void main(String[] args) {
        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
        // System.out.println(maxSubArray(nums));
        int [][] matrix = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5 } };
        // setZeroes(matrix);
        int [] a = {1,3,4,2,2};
      //  int [] nums2 = {1,2,3,4};
      //  printTargetSumSubsetWithoutRepeatition(nums2,0,0,5,"");
        System.out.println();
      //  printTargetSumSubsetWithRepeatition(nums2,0,0,5,"");
       int[] nums1 = {1,4,7,8,10,0,0,0}; int[] nums2 = {2,3,9};
        int m = 5; //we ingonore the 0 value in nums1
        int n = 3;
       // merge(nums1,m,nums2,n);
       // mergeArray();
       // findDuplicate2(a);
        int [] ar2 = {3,1,2,5,3};
      //  find(ar2);
        int [][] matrix2 = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60 } };
       // searchMatrix(matrix2,166);
       // System.out.println(myPow(2.0,-4));
       // System.out.println(Integer.MAX_VALUE);
      //  System.out.println(uniquePaths(3,2));
        int [] nums4 = {0,3,7,2,8,4,6,0,1};
      //  printLongestConsecutiveSequence(nums4);
      //  System.out.println(countAndSay2(5));;—
        int [][] matrix3 = {
                {3,3,1,3},
                {2,2,1,2},
                {1,1,1,2}
        };
       // diagonalSort2(matrix3);
       // displayMatrix(matrix3);
        int []nums5 = {3,2,4};
      //  int[] res = twoSum2(nums5,6);
      //  displayArr(res);
        int [] nums6 = {-1,0,1,2,-1,-4};
        Arrays.sort(nums6);
        int [] nums7={1000000000,1000000000,1000000000,1000000000};
      //  List<List<Integer>> res = kSum_(nums7,-294967296,0,4);
       // for (List<Integer> rr:res){System.out.println(rr);}
       // System.out.println(Integer.MAX_VALUE+" "+Integer.MIN_VALUE);
        //threeSum(nums6);
       // System.out.println(search("for","forxxorfxdofr"));
        int [] heights = {4,2,0,3,2,5};
       // System.out.println(trap(heights));
        int [] arrays = {-1,1,2,-4};
      //  System.out.println(threeSumClosest(arrays,1));
        List<Integer> list = Arrays.stream(arrays).boxed().collect(Collectors.toList()); //convert array into List
        System.out.println();
        int [] nums8 = {5,7,7,8,8,10};
       // searchRange(nums8,8);
        int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
       // System.out.println(minJumps(arr));
        int [] books={12 ,34, 67, 90};
       // System.out.println(findPages(books,books.length,5));
        int num = Integer.MAX_VALUE;
        reverse(num);
    }

    //
    public static int reverse(int n) {
        int rem=0; int sum=0;
        while(n!=0) {
            rem=n%10;
            n=n/10;
            if(sum>Integer.MAX_VALUE/10 || (sum==Integer.MAX_VALUE/10 && rem>7)) {
                return 0;
            }
            if(sum<Integer.MIN_VALUE/10 || (sum==Integer.MIN_VALUE/10 && rem<-8)) {
                return 0;
            }
            sum=sum*10+rem;
        }
        return sum;
    }

    //Allocate minimum number of pages
    public static int findPages(int[]books,int N,int nos) {
        //N ->no of books //nos-> no of students
        if (N < nos)
            return -1;
        int lb = books[N-1];  int ub=0;
        for (int i=0;i<N;i++) ub+=books[i];
        int ans = -1;

        while (lb<=ub){
            int mid = lb+(ub-lb)/2;
            if(isValid(books,N,mid,nos)){
                ans = mid;
                ub = mid-1;
            }else {
                lb = mid+1;
            }
        }
        return ans;
    }
    static boolean isValid(int [] books,int N,int mid,int nos){
        int c=1; int curr_sum=0;
        for (int i = 0; i < N; i++) {
            if(curr_sum+books[i]<=mid){
                curr_sum += books[i];
            }else{
                c++;
                curr_sum = books[i];
                if (c>nos) return false;
            }
        }
        return c<=nos;
    }
    //https://leetcode.com/discuss/general-discussion/1302335/aggressive-cows
    int aggressiveCows(int[] stalls, int noc) { //noc->no of cows
        int lb = 1; int ub = stalls.length;
        int ans = 0;
        Arrays.sort(stalls);
        while(lb<=ub){
            int mid = (lb+ub)/2;
            if(isPossible(stalls,noc,mid)){
                ans = mid;
                lb = mid + 1;
            }else {
                ub = mid - 1;
            }
        }

        return ans;
    }
    private boolean isPossible(int[] stalls, int noc,int mid) {
        int prev = stalls[0]; int cows=1;
        for (int i=1;i<stalls.length;i++){
            if(stalls[i]-prev>=mid){
                cows++;
                prev = stalls[i];
                if(cows==noc) return true;
            }
        }
        return false;
    }

    //309 best time to buy stock and sell buy sell cool kro
    public int maxProfit_309(int[] price) {
        int pibt = -price[0]; // pibt -> profit if buy today
        int pist = 0; // initially 0, pist-> profit if sell today
        int pwcd = 0; // pwcd -> profit with cooldown
        for(int i = 1; i < price.length; i++) {
            int new_pibt = Math.max(pibt, pwcd - price[i]);
            pwcd = pist;
            int new_pist = Math.max(pist, price[i] + pibt);
            pibt = new_pibt;
            pist = new_pist;
        }
        // System.out.println(pist);
        return pist;
    }
    //174 best time to buy stock and sell
    public int maxProfit_174(int[] prices, int fee) {
            int pist = 0; //profit if sell today
            int pibt = -prices[0];
            for (int i =1;i<prices.length;i++){
                int new_pibt = Math.max(pibt,pist-prices[i]);
                int new_pist = Math.max(pist,pibt+prices[i]-fee);
                pist = new_pist;
                pibt = new_pibt;
            }
            return pist;
    }
    //122 best time to buy stock and sell
    public int maxProfit_122(int[] price) {
        int bd = 0;
        int sd = 0;
        int profit = 0;

        for(int i = 1; i < price.length; i++) {
            if(price[i] > price[i - 1]) {
                sd++;
            } else {
                profit += price[sd] - price[bd];
                // reset bd and sd
                bd = i;
                sd = i;
            }
        }
        // is peak is present in price int end of days
        profit += price[sd] - price[bd];
        //System.out.println(profit);
        return profit;
    }
    //121  best time to buy stock and sell
    public int maxProfit_121(int[] stocks) {
        int oprofit = 0; // overall profit
        int min = Integer.MAX_VALUE;
        for(int d = 0; d < stocks.length; d++) {
            int price = stocks[d];
            min = Math.min(min, price);
            oprofit = Math.max(oprofit, price - min);
        }
        return oprofit;
    }
    //Minimum number of jumps O(n)
    public static int minJumps2(int arr[]) {
            if (arr.length <= 1) return 0;
            if (arr[0] == 0)  return -1;
            int maxReach = arr[0];
            int step = arr[0];
            int jump = 1;
            for (int i = 1; i < arr.length; i++) {
                if (i == arr.length - 1)
                    return jump;
                maxReach = Math.max(maxReach, i + arr[i]);
                step--;
                if (step == 0) {
                    jump++;
                    // Check if the current  index/position or lesser index
                    // is the maximum reach point from the previous indexes
                    if (i >= maxReach)
                        return -1;
                    step = maxReach - i;
                }
            }
              return -1;
        }
    //Minimum number of jumps  O(n2) TLE
    public static int minJumps(int arr[]) {
        int n = arr.length;
        int [] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i=1;i<n;i++){
            for (int j=0;j<i;j++){
                if(dp[j]!=Integer.MAX_VALUE && arr[j] + j>=i){ //kya mai vha tak puach sakta hu?
                    if(dp[j]+1<dp[i]){ //agr puach sakta  hu toh jump compare kro
                        dp[i] = dp[j]+1;
                    }
                }
            }
        }
        return dp[n-1] != Integer.MAX_VALUE?dp[n-1]:-1;
    }
    //34
    public static int[] searchRange(int[] nums, int target) {
        int [] ans = new int[2];
        if(nums.length == 1){
            if(nums[0] == target){
                return ans;
            }
        }
        int firstIndex = searchForFirst(nums,target);
        int lastIndex = searchForLast(nums,target);

        ans[0] = firstIndex; ans[1] = lastIndex;
        System.out.println(firstIndex+" "+lastIndex);
        return ans;
    }
    private static int searchForLast(int[] nums, int target) {
        int l = 0; int r = nums.length-1; int ans = -1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid] == target){
                ans = mid;
                l = mid+1;
            }else if(nums[mid] < target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return ans;
    }
    private static int searchForFirst(int[] nums, int target) {
        int l = 0; int r = nums.length-1; int ans = -1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid] == target){
                ans = mid;
                r = mid-1;
            }else if(nums[mid] < target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return ans;
    }
    //11
    public int maxArea(int[] hieght) {
        int n = hieght.length;
        int i=0;
        int j= hieght.length-1;
        int water=0;
        while(i<j){
            int width = j-i;
            int ht = Math.min(hieght[i],hieght[j]);
            water = Math.max(water,width*ht);
            if(hieght[i]<hieght[j]){
                i++;
            }else{
                j--;
            }
        }
        return water;
    }
    //498
    public int[] findDiagonalOrder2(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Input matrix is null");
        }
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] result = new int[rows * cols];
        int r = 0;
        int c = 0;

        for (int i = 0; i < result.length; i++) {
            result[i] = matrix[r][c];
            if ((r + c) % 2 == 0) { // Move Up
                if (c == cols - 1) {
                    // Reached last column. Now move to below cell in the same column.
                    // This condition needs to be checked first due to top right corner cell.
                    r++;
                } else if (r == 0) {
                    // Reached first row. Now move to next cell in the same row.
                    c++;
                } else {
                    // Somewhere in middle. Keep going up diagonally.
                    r--;
                    c++;
                }
            } else { // Move Down
                if (r == rows - 1) {
                    // Reached last row. Now move to next cell in same row.
                    // This condition needs to be checked first due to bottom left corner cell.
                    c++;
                } else if (c == 0) {
                    // Reached first columns. Now move to below cell in the same column.
                    r++;
                } else {
                    // Somewhere in middle. Keep going down diagonally.
                    r++;
                    c--;
                }
            }
        }

        return result;
    }
    //498
    public int[] findDiagonalOrder(int[][] nums) {
        if(nums==null || nums.length==0) return null;

        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        int count=nums.length*nums[0].length;

        for(int i=nums.length-1;i>=0;i--){
            for(int j=0;j<nums[i].length;j++){
                if(!map.containsKey(i+j)){
                    map.put(i+j,new ArrayList<Integer>());
                }
                map.get(i+j).add(nums[i][j]);
            }
        }

        int size=map.size();
        int mapIndex=0;
        int arrIndex=0;

        int arr[]=new int[count];

        while(mapIndex<size){
            if(mapIndex%2==0){
                for(int i:map.get(mapIndex)){
                    arr[arrIndex++]=i;
                }
                mapIndex++;
            }else{
                for(int i=map.get(mapIndex).size()-1;i>=0;i--){
                    arr[arrIndex++]=map.get(mapIndex).get(i);
                }
                mapIndex++;
            }
        }
        return arr;
    }
    //factorial of larger number
    static ArrayList<Integer> factorial(int N){
        ArrayList<Integer> al  = new ArrayList<>();
        al.add(1);
        for(int i =2;i<=N;i++){
            ArrayList<Integer> newL= new ArrayList<>();
            int l = al.size()-1;
            int carry = 0;
            int ans = 0;
            while(l>=0 ){
                ans = i*al.get(l)+carry;
                int num = ans%10;
                carry= ans/10;
                newL.add(0,num);
                l--;
            }
            while(carry!=0) {
                newL.add(0, carry % 10);
                carry /= 10;
            }
            al = newL;
        }
        return al;
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closetSum = Integer.MAX_VALUE;
        for (int k=0;k<nums.length-2;k++){
            int i = k+1;
            int j = nums.length-1;
            int sum = 0;
            while(i<j){
                sum = nums[k] + nums[i] + nums[j];
             if(Math.abs(target-sum)<Math.abs(target-closetSum)){
                 closetSum = sum;
             }
             if(sum<target){
                 i++;
             }else{
                 j--;
             }
            }
        }
        return closetSum;
    }
    //S:(n) T:(n)
    public int trap3(int[] heights){
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<heights.length;i++){
           while(st.size()>0 && heights[st.peek()]<heights[i]){
               int rm = i;
               int curr = heights[st.pop()];
               if (st.size() == 0) break;
               int lm = st.peek();
               int width = rm-lm-1;
               ans += (Math.min(heights[rm],heights[lm])-curr)*width;
           }
           st.push(i);
        }
        return ans;
    }
    //42  S:(1) T:(n)
    public int trap2(int[] heights) {
        if(heights.length<3){
            return 0;
        }
        int n = heights.length;
        int leftmax = heights[0];
        int rightmax = heights[n-1];

        int trappedWater = 0;

        int lp = 1; int rp = n-2;
        while(lp<=rp) {
            if(leftmax<rightmax) {
                if(heights[lp]>=leftmax) {
                    leftmax = heights[lp];
                }else {
                    trappedWater += leftmax - heights[lp];
                }
                lp++;
            }else {
                if(heights[rp]>=rightmax) {
                    rightmax = heights[rp];
                }else {
                    trappedWater += rightmax - heights[rp];
                }
                rp--;
            }

        }

        return trappedWater;

    }
   // S:(n) T:(n)
    public static int trap(int[] heights) {
        if(heights.length<3){
            return 0;
        }
        int n = heights.length;
        int[] leftmax = new int[n];
        int[] rightmax = new int[n];

        leftmax[0]  = 0;
        rightmax[n-1] = 0;

        int lmax= heights[0];
        int rmax = heights[n-1];

        // to find the leftmax
        for(int i=1;i<n;++i){
            leftmax[i] = lmax;
            lmax = Math.max(lmax,heights[i]);
        }

        //to find the right max
        for(int i=n-2;i>=0;--i){
            rightmax[i] = rmax;
            rmax = Math.max(rmax,heights[i]);
        }


        int trappedWater = 0;
        for(int i=1;i<n;i++){
            if(heights[i]<leftmax[i]  && heights[i]<rightmax[i]) {
                trappedWater += Math.min(leftmax[i],rightmax[i]) - heights[i];
                //System.out.println(trappedWater);
            }
        }
        return trappedWater;

    }
    //Count Occurrences of Anagrams
    static int search(String pat, String txt) {
        int count = 0;
        HashMap<Character,Integer> map  = new HashMap<>();
        for (int i = 0;i<pat.length();i++){
            char ch  = pat.charAt(i);
            if (map.containsKey(ch)){
                map.put(ch,map.getOrDefault(ch,0)+1);
            }else{
                map.put(ch,1);
            }
        }
        int k = pat.length(); int i=0;
        for (int j=0;j<txt.length();j++){
            char ch = txt.charAt(j);
            if (map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
            }
            if (j-i+1 == k){
                    if (countAllcharacters(map)){
                        count++;
                    }
                    i++;
                    char ch2 = txt.charAt(i);
                    if (map.containsKey(ch)){
                        map.put(ch,map.get(ch)+1);
                     }
            }
        }
        return count;
    }
    private static boolean countAllcharacters(HashMap<Character, Integer> map) {
        for (Character set:map.keySet()){
            if (map.get(set) != 0)
                return false;
        }
        return true;
    }
    //15
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int target = 0;
        List<List<Integer>> res = threeSum(nums,target,0,nums.length-1);
        for (List<Integer> rr:res){System.out.println(rr);}
        return threeSum(nums,target,0,nums.length-1);
    }
    //18
    private static List<List<Integer>> kSum_(int[] arr, long target, int si, int k) {
        if(k == 2) {
            return twoSum_(arr, si, arr.length - 1, target);
        }
        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i = si; i < n - (k - 1); i++) {
            if(i != si && arr[i] == arr[i - 1])
                continue;
            long val1 = arr[i];
            long targ = target - val1;
            List<List<Integer>> subres = kSum_(arr, targ, i + 1, k - 1);
                for (List<Integer> list : subres) {
                    list.add((int)val1);
                    res.add(list);
                }
        }
        return res;
    }
    private static List<List<Integer>> twoSum_(int[] arr, int st, int end, long target) {
        int left = st;
        int right = end;
        List<List<Integer>> res = new ArrayList<>();
        while(left < right) {
            if(left > st && arr[left] == arr[left - 1]) {
                left++;
                continue;
            }
            if(right >=0 && right<arr.length-1 && arr[right] == arr[right+1]) {
                right--;
                continue;
            }
            int sum = arr[left] + arr[right];
            if(sum == target) {
                List<Integer> subres = new ArrayList<>();
                subres.add(arr[left]);
                subres.add(arr[right]);
                res.add(subres);
                left++;
                right--;
            } else if(sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
    public static List<List<Integer>> threeSum(int[] nums, int target,int st,int end) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = st;i<nums.length-1;i++){
            if(i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int val1 = nums[i];
            List<List<Integer>> subList = twoSum(nums,target - val1,i+1,end);
                for (List<Integer> list:subList) {
                    list.add(val1);
                    res.add(list);
                }
        }
        return res;
    }
    public static List<List<Integer>> twoSum(int[] nums, int target,int st,int end) {
        int left = st,right = end;
        List<List<Integer>> res = new ArrayList<>();
        while(left<right){
            if(left!=st && nums[left]==nums[left-1]){
                left++; continue;
            }
            if(right>=0 && right<nums.length-1 && nums[right]==nums[right+1]){
                right--; continue;
            }
            if(nums[left] + nums[right] == target){
                List<Integer> ans = new ArrayList<>();
                ans.add(nums[left]); ans.add(nums[right]);
                res.add(ans);
                left++; right--;
                return res;
            }else if(nums[left] + nums[right] < target){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }
    //1 && 167
    public static int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
    //167 only in case of sorted array
    public static int[] twoSum(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        int[] ar = new int[2];
        while(left<right){
            if(left>0 && nums[left]==nums[left-1]){
                left++; continue;
            }
            if(nums[left] + nums[right] == target){
                ar[0] = left;
                ar[1] = right;
                left++; right--;
                return ar;
            }else if(nums[left] + nums[right] < target){
                left++;
            }else{
                right--;
            }
        }
        return ar;
    }
    //1329
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static int[][] diagonalSort2(int[][] mat){
            for (int i = 0; i < mat.length; i++) {
                loadQueue(mat, i, 0);
                loadDiagonal(mat, i, 0);
            }
            for (int i = 1; i < mat[0].length; i++) {
                loadQueue(mat, 0, i);
                loadDiagonal(mat, 0, i);
            }
            return mat;
    }
    private static void loadQueue(int[][] mat, int i, int j) {
            if (i == mat.length || j == mat[0].length) return;
            pq.add(mat[i][j]);
            loadQueue(mat, i + 1, j + 1);
        }
    private static void loadDiagonal(int[][] mat,  int i, int j) {
            if (pq.isEmpty()) return;
            mat[i][j] = pq.poll();
            loadDiagonal(mat, i + 1, j + 1);
        }
    //1329
    public static int[][] diagonalSort(int[][] mat) {

        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        //step 1
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                if(!map.containsKey((i-j))){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(mat[i][j]);
                    map.put((i-j),list);
                }
                else {
                    ArrayList<Integer> list = map.get((i-j));
                    list.add(mat[i][j]);
                    map.put((i-j),list);
                }
            }
        }
        //step 2 sort the elements in list
        for (Integer mm:map.keySet()){
            Collections.sort(map.get(mm));
        }
        for (Integer mm:map.keySet()){
            System.out.print(mm+"->");
            ArrayList<Integer> list = map.get(mm);
            System.out.println(list);
        }
        //step 3
            for(int i=mat.length-1;i>=0;i--){
                for(int j=mat[0].length-1;j>=0;j--){
                    ArrayList<Integer> list = map.get((i-j));
                    mat[i][j] = list.remove(list.size()-1);
                }
            }

            return mat;
        }
    //128
    public int longestConsecutive(int[] nums) {
        UF uf = new UF(nums.length);
        Map<Integer,Integer> map = new HashMap<Integer,Integer>(); // <value,index>
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                continue;
            }
            map.put(nums[i],i);
            if(map.containsKey(nums[i]+1)){
                uf.union(i,map.get(nums[i]+1));
            }
            if(map.containsKey(nums[i]-1)){
                uf.union(i,map.get(nums[i]-1));
            }
        }
        return uf.maxUnion();
    }
    class UF {
        private int[] list;

        public UF(int n) {
            list = new int[n];
            for (int i = 0; i < n; i++) {
                list[i] = i;
            }
        }

        private int root(int i) {
            while (i != list[i]) {
                list[i] = list[list[i]];
                i = list[i];
            }
            return i;
        }

        public boolean connected(int i, int j) {
            return root(i) == root(j);
        }

        public void union(int p, int q) {
            int i = root(p);
            int j = root(q);
            list[i] = j;
        }

        // returns the maxium size of union
        public int maxUnion() { // O(n)
            int[] count = new int[list.length];
            int max = 0;
            for (int i = 0; i < list.length; i++) {
                count[root(i)]++;
                max = Math.max(max, count[root(i)]);
            }
            return max;
        }
    }
    //128
    public static void printLongestConsecutiveSequence(int[] arr) {
        // 1. make a hashmap of presence
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int key : arr) {
            map.put(key, true);
        }

        // 2. make starting point of sequence
        for(int key : arr) {
            if(map.containsKey(key - 1) == true) {
                map.put(key, false);
            }
        }

        // 3. get length and starting point of sequnec
        int maxLength = 0;
        int starting  = 0;

        for(int key : arr) {
            if(map.get(key) == true) {
                int len = 1;
                int st = key;
                while(map.containsKey(key + len) == true) {
                    len++;
                }
                if(maxLength < len) {
                    maxLength = len;
                    starting = st;
                }
                map.put(st, false);
            }
        }
        // 4. print answer
        for(int i = 0; i < maxLength; i++) {
            System.out.print(starting+" ");
            starting++;
        }
    }
    //62
    int uniquePaths2(int m, int n) {
        int N = n + m - 2;
        int r = m - 1;
        double res = 1;

        for (int i = 1; i <= r; i++)
            res = res * (N - r + i) / i;
        return (int)res;
    }
    //62
    public static int uniquePaths(int m, int n) {
        int count = 0;
        count = mazePathDP(m,n);
        return count;
    }
    private static int mazePath(int cr,int cc,int m, int n, String asf,int count) {

        if(cr == m-1 && cc == n-1){
            System.out.println(asf+" "+count);
            return count = count+1;
        }
        if(cr+1<m)
            count = mazePath(cr + 1,cc,m,n,asf+"V",count);
        if(cc+1<n)
            count = mazePath(cr,cc + 1,m,n,asf+"H",count);
        return count;
    }
    private static int mazePathDP(int m, int n) {
        int[][]a=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0){
                    a[i][j]=1;
                }
                else{
                    a[i][j]=a[i-1][j]+a[i][j-1];
                }
            }
        }
        displayMatrix(a);
        return a[m-1][n-1];
    }
    static void  displayMatrix(int[][] ar){
        int m = ar.length; int n = ar[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                System.out.print(ar[i][j]+" ");
            }
            System.out.println();
            }
    }
    //50
    public double myPow2(double x, int n) {
        double ans = 1.0;
        long nn = n;
        if (nn < 0) nn = -1 * nn;
        while (nn > 0) {
            if (nn % 2 == 1) {
                ans = ans * x;
                nn = nn - 1;
            } else {
                x = x * x;
                nn = nn / 2;
            }
        }
        if (n < 0) ans = (double)(1.0) / (double)(ans);
        return ans;
    }
    //50
    public static double myPow(double x, int n) {
        if(n == 0) return 1.0;
        if(x==1.0  && (n == 2147483647 || n== -2147483648)) return 1.0;
        if(x==-1.0  && n == 2147483647) return -1.0;
        if(x<=-1.0  && n == -2147483648) return 1.0;
        if(n == 2147483647 || n == -2147483648) return 0.0;

        if(n<0){
            x = 1/x;
            n = -n;
        }
        return n%2==0? myPow(x*x,n/2): myPow(x*x,n/2)*x;
    }
    //240
    public boolean searchMatrixII(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        //O(m+n)
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;

    }
    //74
    public static boolean searchMatrix(int[][] matrix, int target) {

        int lo = 0; int hi = matrix.length-1;
        int row =  searchInrow(lo,hi,matrix,target);
        if(row  == -1) return false;
        int col =  binarySearch(row,matrix,target);
        //System.out.println(matrix[row][col] == target);
        return matrix[row][col] == target;
    }
    private static int binarySearch(int row, int[][] matrix,int target) {
        int lr = matrix.length-1; int lo = 0; int hi = matrix[0].length-1;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(target == matrix[row][mid]){
                return mid;
            } else if (target < matrix[row][mid]) {
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return -1;
    }
    private static int searchInrow(int lo, int hi, int[][] matrix,int target) {
        int lc = matrix[0].length-1;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(target >= matrix[mid][0] && target<=matrix[mid][lc]){
                return mid;
            } else if (target < matrix[mid][0]) {
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return -1;
    }
    //Finding missing and repeating number in array
    public static void find(int []A){
        missingNumAndRepeatingNum(A);
    }
        //O(N),O(1)  ->Math Logic
    private static void missingNumAndRepeatingNum(int[] A) {
        long len = A.length;
        long S = len*(len+1)/2;
        long P = (len *(len + 1)*(2*len+1))/6;
        long missingNum = 0,repeatedNum = 0;

        for(int i =0;i<len;i++){
            S = S - A[i];
            P = P - A[i]*A[i];
        }
        missingNum = (P/S + S)/2;
        repeatedNum = missingNum - S;
        System.out.println(missingNum+" "+repeatedNum);

    }
    //287  method-1 O(nlogn)
    public static int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1;i<nums.length;i++){
            if(nums[i-1] == nums[i])
                return nums[i];
        }
    return 0;
    }
    //287  linkedlist cycle method
    public static int findDuplicate2(int[] nums) {
        int slow = nums[0]; int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(fast != slow);

        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    //56  O(n)
    public static int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] newI:intervals){
            if (list.size() == 0){
                list.add(newI);
            }else{
                int [] prevI = list.get(list.size()-1);
                if(prevI[1]>=newI[0]){
                    prevI[1] = Math.max(prevI[1],newI[1]);
                }else{
                    list.add(newI);
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void mergeArray(){
        int arr1[] = {1,4,7,8,10};
        int arr2[] = {2,3,9};
        merge3(arr1, arr2, arr1.length, arr2.length);

    }
    static int findgap(int gap){
        if(gap<=1)
            return 0;
        return gap/2 + gap%2;
    }
    //91 O((m+n)log(n+m))
    static void merge3(int arr1[],int arr2[], int n, int m) {
            int gap = (n+m);
            int i,j;
            for(gap=findgap(gap);gap>0;gap=findgap(gap)){
                for(i=0;i+gap<n;++i){     // to mame swaps in only 1st array
                    if(arr1[i] > arr1[i+gap])
                        swapNum(arr1,i,arr1,i+gap);
                }
                for(j=0;i<n&&j<m;j++,i++){    // to make swaps in both array
                    if(arr1[i] > arr2[j])
                        swapNum(arr1,i,arr2,j);
                }
                for(;j<m;++j){    // to make swaps in only 2nd array
                    if((j-gap>=0) && arr2[j-gap] > arr2[j])
                        swapNum(arr2,j-gap,arr2,j);
                }
            }
        displayArr(arr1); displayArr(arr2);
    }
    //88 O(m+n) this sol only work if one array has element as Zero in the last
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1 , p2 = n-1 ,i = m+n-1;
        while(p2 >=0 ){
            if(p1 >=0 && nums1[p1] > nums2[p2]){
                nums1[i--] = nums1[p1--];
            }
            else{
                nums1[i--] = nums2[p2--];
            }
        }
    displayArr(nums1);
    }
    //O(m*n)
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = 0,k=0;
       for(i=0;i<m;i++){
            int d1 = nums1[i];
            int d2 = nums2[0];
           if(d1>d2){
                swapNum(nums1,i,nums2,0);
            }

           int first = nums2[0];
           for (k = 1; k < n && nums2[k] < first; k++) {
               nums2[k - 1] = nums2[k];
           }
           if(k-1 < nums2.length)
                nums2[k-1] = first;
        }
        displayArr(nums1);
        displayArr(nums2);
        int p = 0;
        for(int j=m;j<nums1.length && p<n ;j++){
            if(nums1[j] == 0){
                nums1[j] = nums2[p++];
            }
        }
        System.out.println();
        displayArr(nums1);
    }
    private static void displayArr(int[] nums1) {
        for(int i:nums1){
            System.out.print(i+" ");
        }
    }
    private static void swapNum(int[] nums1, int i, int[] nums2, int j) {
        int temp = nums1[i];
       nums1[i] = nums2[j];
       nums2[j] = temp;
    }
    public static void printTargetSumSubsetWithoutRepeatition(int[] arr, int indx, int ssf, int targ, String asf) {
        if(indx == arr.length) {
            if(targ == ssf) {
                System.out.println(asf + ".");
            }
            return;
        }
        // yes call
        if(ssf + arr[indx] <= targ) {
            printTargetSumSubsetWithoutRepeatition(arr, indx+1 , ssf + arr[indx], targ, asf + arr[indx] + ", ");
        }
        // no call
        printTargetSumSubsetWithoutRepeatition(arr, indx + 1, ssf, targ, asf);
    }
    public static void printTargetSumSubsetWithRepeatition(int[] arr, int indx, int ssf, int targ, String asf) {
        if(indx == arr.length) {
            if(targ == ssf) {
                System.out.println(asf + ".");
            }
            return;
        }
        // yes call
        if(ssf + arr[indx] <= targ) {
            printTargetSumSubsetWithRepeatition(arr, indx, ssf + arr[indx], targ, asf + arr[indx] + ", ");
        }
        // no call
        printTargetSumSubsetWithRepeatition(arr, indx + 1, ssf, targ, asf);
    }
    static void swap2(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    //75
    public static void sortColors(int[] nums) {
        int i =0; int j = 0; int k = nums.length-1;
        while(i<nums.length && j<nums.length && k>=i){
            if(nums[i] == 1){
                i++;
            }else if(nums[i] == 0){
                swap2(nums,i,j);
                i++;
                j++;
            }else if(nums[i] == 2){
                swap2(nums,i,k);
                k--;
            }
        }
    }
    //73
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int [] a1 = new int[m];
        int [] a2 = new int[matrix[0].length];
        for(int i=0;i<m;i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0){
                    a1[i] = 1; a2[j] = 1;
                }
            }
        }
        for(int i=0;i<m;i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(a1[i] == 1 || a2[j] == 1)
                    matrix[i][j] = 0;
            }
        }
        for(int i=0;i<m;i++){
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        /*List<int []> list = new ArrayList<>();
            for(int i=0;i<m;i++){
                for(int j=0;j<matrix[i].length;j++){
                    if(matrix[i][j] == 0){
                        int [] ar = new int[2];
                        ar[0] = i; ar[1] = j;
                        list.add(ar);
                    }
                }
            }

        list.stream().forEach(EasyStringsQ::display);*/



    }
    //53
    public static int maxSubArray(int[] nums) {
        int osum =0,csum=0;
        for(int i=0;i<nums.length;i++){

            if(csum + nums[i] > nums[i]){ //or csum>=0
                csum += nums[i];
            }else{
                csum = nums[i];
            }
            osum = Math.max(osum,csum);
        }
        return osum;
    }

    public static int maxSubArrayLen(int[] arr) {
        int psum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = 0;
        map.put(0, -1);
        for(int i = 0; i < arr.length; i++) {
            int val = arr[i];
            psum += val;
            if(map.containsKey(psum) == false) {
                map.put(psum, i);
            } else {
                len = Math.max(len, i - map.get(psum));
            }
        }
        return len;
    }

}
