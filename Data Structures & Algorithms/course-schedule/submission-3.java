class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        for (int m = 0; m < prerequisites.length; m++) {
            int prereq = prerequisites[m][0];
            if (!hm.containsKey(prereq)) {
                System.out.println(prereq);
                hm.put(prereq, new ArrayList<>());   
            }
            hm.get(prereq).add(prerequisites[m][1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!hm.containsKey(i)) hm.put(i, new ArrayList<>());
            if (!dfs(i, hm, new HashSet<>())) return false;
        }
        return true;
    }
    private boolean dfs(int course, HashMap<Integer, ArrayList<Integer>> hm, HashSet<Integer> visited) {
        if (visited.contains(course)) return false;

        if (!hm.containsKey(course) || hm.get(course).size()==0) {
            return true;
        }

        int size = hm.get(course).size();
        visited.add(course);
        
        for (int i = 0; i < size; i++) {
            if (!dfs(hm.get(course).get(0), hm, visited)) return false;
            hm.get(course).remove(0);
        }
        visited.remove(course);
        
        return true;
    }
}
