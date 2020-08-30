java -cp astor.jar fr.inria.main.evolution.AstorMain \
-location /Users/cuong/IdeaProjects/jrelifix/BugsDataset \
-dependencies /Users/cuong/IdeaProjects/jrelifix/BugsDataset/target/dependency \
-faultfile /Users/cuong/IdeaProjects/jrelifix/SusFiles/PerfectFL/uwescience-myria-122377299.txt \
-mode jgenprog \
-srcjavafolder /src \
-srctestfolder /test \
-binjavafolder /build/main \
-bintestfolder /build/test \
-stopfirst true