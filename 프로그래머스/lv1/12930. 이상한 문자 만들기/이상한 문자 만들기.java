class Solution {
    public String solution(String s) {
        s = s.toLowerCase();

        String[] chars = s.split("");

        boolean upper = true;
        StringBuilder builder = new StringBuilder();

        for (String c : chars) {
            if (upper) {
                builder.append(c.toUpperCase());
            } else {
                builder.append(c);
            }

            upper = !upper;
            if (c.equals(" ")) {
                upper = true;
            }
        }

        return builder.toString();
    }
}