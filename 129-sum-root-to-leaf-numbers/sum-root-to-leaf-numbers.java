
class Solution {
    public void fun(TreeNode root,List<String> temp,List<List<String>>ans){
        if(root==null){
            return;
        }
        temp.add(root.val+"");
        if(root.left==null&&root.right==null){
            ans.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
            return;
        }
        fun(root.left,temp,ans);
        fun(root.right,temp,ans);
        temp.remove(temp.size()-1);

    }
    public int sumNumbers(TreeNode root) {
        List<List<String>>ans=new ArrayList<>();
        List<String> temp=new ArrayList<>();
        fun(root,temp,ans);
        int total=0;
        for (List<String> list : ans) {
            String s = "";
            for (String x : list) {
                s += x;
            }
            if(!s.equals(""))total += Integer.parseInt(s);
        }
        return total;
    }
}