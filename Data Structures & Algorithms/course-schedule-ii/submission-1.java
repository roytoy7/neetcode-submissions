class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            if (!hm.containsKey(course)) hm.put(course, new ArrayList<>());
            hm.get(course).add(prerequisites[i][1]);
        }
        ArrayList<Integer> res = new ArrayList<>();

        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, res, prerequisites, visited, hm)) return new int[0];
        }
        int[] resArr = new int[numCourses];
        for (int i = 0; i < numCourses; i++) resArr[i] = res.get(i);
        return resArr;
    }
    private boolean dfs(int course, ArrayList<Integer> res, int[][] prerequisites, int[] visited, HashMap<Integer, ArrayList<Integer>> hm) {
        if (visited[course]==1) return false;

        if (visited[course]==2) return true;

        visited[course] = 1;
        if (hm.containsKey(course)){
            int size = hm.get(course).size();

            for (int i = 0; i < size; i++) {
                if (!dfs(hm.get(course).get(i), res, prerequisites, visited, hm)) return false;
            }
        }
        
        res.add(course);
        visited[course] = 2;
        return true;
    }
}
