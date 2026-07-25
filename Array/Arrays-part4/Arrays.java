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

    //Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer>mp=new HashMap<>();
        int max=0;

        int l=0,r=0;
        while(r<s.length()){
            if(mp.containsKey(s.charAt(r))){
                if(l>mp.get(s.charAt(r))){
                    mp.put(s.charAt(r),r);

                }
                else{
                    l=mp.get(s.charAt(r))+1;
                    mp.put(s.charAt(r),r);

                }
            }
            else{
                mp.put(s.charAt(r),r);

            }
            max=Math.max(max,(r-l)+1);
            r++;
        }


        return max;
    }
}