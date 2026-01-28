class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String>ans=new ArrayList<>();
        HashMap<String,Integer>mp=new HashMap<>();
        for(int i=0;i<=s.length()-10;i++){
            StringBuilder str=new StringBuilder();
            for(int j=i;j<i+10;j++) str.append(s.charAt(j));
            String str1=str.toString();
            if(!mp.containsKey(str1))mp.put(str1,1);
            else mp.put(str1,mp.get(str1)+1);
            str.setLength(0);//to empty stringbuilder
            if(mp.get(str1)==2){
                ans.add(str1);
            }
        }
        return ans;
    }
}