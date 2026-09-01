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



        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(0);
            ListNode temp = head;

            int carry = 0;

            while(l1!=null || l2!=null || carry!=0){
                int n1 = (l1!=null)? l1.val : 0;
                int n2 = (l2!=null) ? l2.val:0;

                int sum = n1+n2+carry;
                int rem = sum % 10;
                carry = sum/10;
                temp.next= new ListNode(rem);
                temp=temp.next;

                l1 = (l1!=null)? l1.next:null ;
                l2 = (l2!=null)? l2.next:null ;
            }

            return head.next;
        }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode temp = head;

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        int carry = 0;

        while(l1!=null){
            s1.push(l1.val);
            l1=l1.next;
        }

        while(l2!=null){
            s2.push(l2.val);
            l2=l2.next;
        }

        while(!s1.isEmpty() || !s2.isEmpty() || carry!=0){
            int n1 = (!s1.isEmpty())? s1.pop() : 0;
            int n2 = (!s2.isEmpty())? s2.pop() : 0;

            int sum = n1+n2+carry;
            int rem = sum % 10;
            carry = sum/10;
            temp = new ListNode(rem);
            temp.next = head;
            head=temp;

        }

        return head;
    }


}