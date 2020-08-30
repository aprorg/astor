java -Xmx6g -cp astor.jar fr.inria.main.evolution.AstorMain \
-location /Users/cuong/IdeaProjects/jrelifix/BugsDataset/common \
-dependencies /Users/cuong/IdeaProjects/jrelifix/BugsDataset/common/target/dependency:/Users/cuong/IdeaProjects/jrelifix/BugsDataset/navigation-formats/target/dependency:/Users/cuong/IdeaProjects/jrelifix/BugsDataset/navigation-formats/target/classes \
-faultfile /Users/cuong/IdeaProjects/jrelifix/SusFiles/PerfectFL/Bears-203.txt \
-mode jmutrepair \
-srcjavafolder /src/main/java \
-srctestfolder /../navigation-formats/src/test/java \
-binjavafolder /target/classes \
-bintestfolder /../navigation-formats/target/test-classes \
-stopfirst true
