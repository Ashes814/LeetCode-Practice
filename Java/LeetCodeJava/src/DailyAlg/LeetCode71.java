package DailyAlg;

import java.util.ArrayList;
import java.util.LinkedList;

public class LeetCode71 {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home//foo/"));
    }
    public static String simplifyPath(String path) {
        if (path.isEmpty()) {
            return "";
        }

        String[] splitedPath = path.split("/");
        LinkedList<String> res = new LinkedList<>();

        for (int i = 0; i < splitedPath.length; i++) {
            if (splitedPath[i].equals("")) {
                continue;
            } else if (splitedPath[i].equals(".")) {
                continue;
            } else if (splitedPath[i].equals("..")) {
                if (res.isEmpty()) {
                    continue;
                } else {
                    res.removeLast();
                }

                continue;
            }

            res.add(splitedPath[i]);
        }

        if (res.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : res) {
            sb.append("/");
            sb.append(s);
        }
        return sb.toString();
    }
}
