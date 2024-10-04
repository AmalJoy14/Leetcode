class Solution {
    public long dividePlayers(int[] skill) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < skill.length; i++) {
            int current = skill[i];
            if (current < min) {
                min = current;
            }
            if (current > max) {
                max = current;
            }
        }
        int sum = min + max;
        long prdt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < skill.length; i++) {
            int val = sum - skill[i];
            if (map.containsKey(val)) {
                map.put(val, map.get(val) - 1);
                if (map.get(val) == 0) {
                    map.remove(val);
                }
                prdt += val * skill[i];
            } else {
                map.put(skill[i], map.getOrDefault(skill[i], 0) + 1);
            }
        }

        if (!map.isEmpty()) {
            return -1;
        }
        return prdt;
    }
}
