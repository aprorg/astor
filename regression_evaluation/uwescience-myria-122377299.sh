java -cp astor.jar fr.inria.main.evolution.AstorMain \
-location /Users/cuong/IdeaProjects/jrelifix/BugsDataset \
-dependencies /Users/cuong/IdeaProjects/jrelifix/BugsDataset/target/dependency \
-faultfile /home/cuong/IdeaProjects/jrelifix/SusFiles/PerfectFL/uwescience-myria-122377299.txt \
-mode jmutrepair \
-srcjavafolder /src \
-srctestfolder /test \
-binjavafolder /build/main \
-bintestfolder /build/test \
-stopfirst true