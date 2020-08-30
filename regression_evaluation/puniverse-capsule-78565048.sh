java -cp astor.jar fr.inria.main.evolution.AstorMain \
-location /Users/cuong/IdeaProjects/jrelifix/BugsDataset/capsule \
-dependencies /Users/cuong/IdeaProjects/jrelifix/BugsDataset/build/dependency-libs \
-faultfile /home/cuong/IdeaProjects/jrelifix/SusFiles/PerfectFL/puniverse-capsule-78565048.txt \
-mode jmutrepair \
-srcjavafolder /src/main/java \
-srctestfolder /src/test/java \
-binjavafolder /build/classes/java/main \
-bintestfolder /build/classes/java/test \
-stopfirst true
