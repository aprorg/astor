java -cp astor.jar fr.inria.main.evolution.AstorMain \
-location /Users/cuong/IdeaProjects/jrelifix/BugsDataset/stagemonitor-core \
-dependencies /Users/cuong/IdeaProjects/jrelifix/BugsDataset/stagemonitor-core/build/libs/lib \
-faultfile /home/cuong/IdeaProjects/jrelifix/SusFiles/PerfectFL/stagemonitor-stagemonitor-145477129.txt \
-mode jmutrepair \
-srcjavafolder /src/main/java \
-srctestfolder /src/test/java \
-binjavafolder /build/classes/main \
-bintestfolder /build/classes/test \
-stopfirst true
