class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>mp=new HashMap<>();
        for(int i=0;i<strs.length;i++){
        String str=fun(strs[i]);
        if(!mp.containsKey(str))
            mp.put(str,new ArrayList<>());
            mp.get(str).add(strs[i]);
        }
        List<List<String>>ans=new ArrayList<>();
        for(List<String> i: mp.values()){
            ans.add(i);
        }
        return ans;
    }
    public String fun(String str){
        char[] ch=str.toCharArray();
        Arrays.sort(ch);
        String ans=new String(ch);
        return ans;
    }
}