
//77 combination
class Solution {

    private void combination(int idx,int n,int k,List<List<Integer>>ans,List<Integer>l){
        if(l.size() == k){
            ans.add(new ArrayList<>(l));
            return ;
        }
        if(idx>n)return ;

        // take
        l.add(idx);
        combination(idx+1,n,k,ans,l);
        l.remove(l.size()-1);

        // dont take
        combination(idx+1,n,k,ans,l);


    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        combination(1,n,k,ans,l);
        return ans;
    }
}

//46 Parmutation
class Solution1 {

    private void parmutation(int [ ] nums,boolean [] used,List<List<Integer>>ans,List<Integer>l){
        if(l.size() == nums.length){
            ans.add(new ArrayList<>(l));
            return ;
        }

        for(int i=0;i<nums.length;i++){
            if(used[i])continue;

            //pick
            l.add(nums[i]);
            used[i]=true;

            //recurtion
            parmutation(nums,used,ans,l);

            // backtracking
            l.remove(l.size()-1);
            used[i]=false;

        }
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        boolean [] used = new boolean[nums.length];
        parmutation(nums,used,ans,l);
        return ans;
    }
}


// 78 subset1
class Solution2 {
    private void solve(int idx, int [] nums, List<List<Integer>> ans , List<Integer>l){
        if(idx==nums.length){
            ans.add(new ArrayList<>(l));
            return ;

        }


        //pick
        l.add(nums[idx]);
        solve(idx + 1,nums,ans,l);

        //backtrack
        l.remove(l.size()-1);

        //not pick
        solve(idx + 1,nums,ans,l);


    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> l = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        solve(0,nums,ans,l);

        return ans;
    }
}


public class Main{

}