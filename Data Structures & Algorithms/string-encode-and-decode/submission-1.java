class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s:strs){
            // start with length of string, add #, then string
            sb.append(s.length()+"#"+s);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> sList = new ArrayList<>();
        int i = 0;
        while(i<str.length()) {
            int hashLoc = str.indexOf('#', i);
            int len = Integer.parseInt(str.substring(i,hashLoc));
            System.out.println(hashLoc + " " + len);
            sList.add(str.substring(hashLoc+1,hashLoc+1+len));
            i=hashLoc+len+1;
            System.out.println(i + " " + str.length());
        }
        return sList;
    }
}
