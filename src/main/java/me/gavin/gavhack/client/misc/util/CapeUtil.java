package me.gavin.gavhack.client.misc.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashSet;
import java.util.UUID;

// Cape / uuid system from gamesense
// https://github.com/IUDevman/gamesense-client/blob/master/src/main/java/com/gamesense/api/util/render/CapeUtil.java
public class CapeUtil {

    private HashSet<UUID> uuids = new HashSet<>();

    public CapeUtil() {
        getCapes();
    }

    private void getCapes() {
        try {
            URL githubFile = new URL("https://raw.githubusercontent.com/Gav06/gavhack-capes/main/cape_uuids.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(githubFile.openStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                uuids.add(UUID.fromString(line));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean hasCape(UUID uuid) {
        return uuids.contains(uuid);
    }
}
