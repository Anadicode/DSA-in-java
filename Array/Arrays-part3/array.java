class array{
        // Majority element2
        public List<Integer> majorityElement(int[] nums) {
            int apper = nums.length/3;

            List<Integer> l = new ArrayList<>();
             HashMap<Integer, Integer> frequency = new HashMap<>();
             for(int n:nums){
                 if(frequency.get(n)!=null){
                     frequency.put(n,frequency.get(n)+1);
                 }
                 else{
                     frequency.put(n,1);
                 }
             }

             for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {

                    int key = entry.getKey();
                    if(frequency.get(key)>apper){
                        l.add(key);
                    }

             }

            return l;

        }

}