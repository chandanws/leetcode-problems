// Problem link: https://leetcode.com/problems/find-duplicate-file-in-system/description/
// Status: Accepted

import java.util.*;

class Solution {
    private String retrieveFileContents(String file) {
        int o = file.indexOf("("), c = file.indexOf(")");
        return file.substring(o, c + 1);
    }
    private String retrieveFilePath(String file, String directory) {
        int o = file.indexOf("(");
        StringBuilder filePath = new StringBuilder(directory);
        filePath.append("/");
        filePath.append(file.substring(0, o));
        return filePath.toString();
    }
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> hm = new HashMap<String, List<String>>();
        for(String path : paths) {
            String [] files = path.split(" ");
            int numOfFiles = files.length;
            for(int i = 1; i < numOfFiles; i++) {
                String content = retrieveFileContents(files[i]);
                String filePath = retrieveFilePath(files[i], files[0]);
                List<String> l = hm.getOrDefault(content, new ArrayList<>());
                l.add(filePath);
                hm.put(content, l);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> l : hm.values()) if(l.size() > 1) res.add(l);
        return res;
    }
}
