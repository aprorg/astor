java -cp astor.jar fr.inria.main.evolution.AstorMain \
-location /Users/cuong/IdeaProjects/jrelifix/BugsDataset \
-dependencies /Users/cuong/IdeaProjects/jrelifix/BugsDataset/target/dependency \
-faultfile /Users/cuong/IdeaProjects/jrelifix/SusFiles/PerfectFL/Bears-116.txt \
-mode jmutrepair \
-srcjavafolder /src \
-srctestfolder /test \
-binjavafolder /target/classes \
-bintestfolder /target/test-classes \
-stopfirst true