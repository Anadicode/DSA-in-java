class Arrays{

    //Longest Consecutive Sequence in an Array
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        if(n==0)return 0;

        int longest = 1;
        Set<Integer> st = new HashSet<>();

        for(int e:nums){
            st.add(e);
        }

        for(int e:st){
            if(!st.contains(e-1)){
                int count = 1;
                int elem = e;

                while(st.contains(elem+1)){
                    count+=1;
                    elem=elem+1;
                }

                longest = Math.max(count,longest);
            }
        }

        return longest;
    }
}