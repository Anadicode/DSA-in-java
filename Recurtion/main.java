
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


public class Main{

}